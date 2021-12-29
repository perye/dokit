package com.perye.dokit.service.impl;

import com.perye.dokit.dto.JobDTO;
import com.perye.dokit.exception.BadRequestException;
import com.perye.dokit.exception.EntityExistException;
import com.perye.dokit.query.JobQueryCriteria;
import com.perye.dokit.entity.Job;
import com.perye.dokit.mapstruct.JobMapper;
import com.perye.dokit.repository.DeptRepository;
import com.perye.dokit.repository.JobRepository;
import com.perye.dokit.repository.UserRepository;
import com.perye.dokit.service.JobService;
import com.perye.dokit.utils.*;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "job")
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    private final JobMapper jobMapper;

    private final RedisUtils redisUtils;

    private final UserRepository userRepository;

    @Override
    public Map<String, Object> queryAll(JobQueryCriteria criteria, Pageable pageable) {
        Page<Job> page = jobRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(jobMapper::toDto).getContent(), page.getTotalElements());
    }

    @Override
    public List<JobDTO> queryAll(JobQueryCriteria criteria) {
        List<Job> list = jobRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder));
        return jobMapper.toDto(list);
    }


    @Override
    @Cacheable(key = "'id:' + #p0")
    public JobDTO findById(Long id) {
        Job job = jobRepository.findById(id).orElseGet(Job::new);
        ValidationUtil.isNull(job.getId(), "Job", "id", id);
        return jobMapper.toDto(job);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Job resources) {
        Job job = jobRepository.findByName(resources.getName());
        if (job != null) {
            throw new EntityExistException(Job.class, "name", resources.getName());
        }
        jobRepository.save(resources);
    }

    @Override
    @CacheEvict(key = "'id:' + #p0.id")
    @Transactional(rollbackFor = Exception.class)
    public void update(Job resources) {
        Job job = jobRepository.findById(resources.getId()).orElseGet(Job::new);
        Job old = jobRepository.findByName(resources.getName());
        if (old != null && !old.getId().equals(resources.getId())) {
            throw new EntityExistException(Job.class, "name", resources.getName());
        }
        ValidationUtil.isNull(job.getId(), "Job", "id", resources.getId());
        resources.setId(job.getId());
        jobRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        jobRepository.deleteAllByIdIn(ids);
        // 删除缓存
        redisUtils.delByKeys("job::id:", ids);
    }

    @Override
    public void download(List<JobDTO> jobDTOs, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (JobDTO jobDTO : jobDTOs) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("岗位名称", jobDTO.getName());
            map.put("岗位状态", jobDTO.getEnabled() ? "启用" : "停用");
            map.put("创建日期", jobDTO.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    @Override
    public void verification(Set<Long> ids) {
        if (userRepository.countByJobs(ids) > 0) {
            throw new BadRequestException("所选的岗位中存在用户关联，请解除关联再试！");
        }
    }
}
