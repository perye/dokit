package com.perye.dokit.service.impl;

import com.perye.dokit.dto.ServerDeployDto;
import com.perye.dokit.dto.ServerDeployQueryCriteria;
import com.perye.dokit.entity.ServerDeploy;
import com.perye.dokit.mapper.ServerDeployMapper;
import com.perye.dokit.repository.ServerDeployRepository;
import com.perye.dokit.service.ServerDeployService;
import com.perye.dokit.utils.PageUtil;
import com.perye.dokit.utils.QueryHelp;
import com.perye.dokit.utils.ValidationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ServerDeployServiceImpl implements ServerDeployService {

    private ServerDeployRepository serverDeployRepository;

    private ServerDeployMapper serverDeployMapper;

    public ServerDeployServiceImpl(ServerDeployRepository serverDeployRepository,ServerDeployMapper serverDeployMapper){
        this.serverDeployRepository = serverDeployRepository;
        this.serverDeployMapper = serverDeployMapper;
    }

    @Override
    public Object queryAll(ServerDeployQueryCriteria criteria, Pageable pageable){
        Page<ServerDeploy> page = serverDeployRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(serverDeployMapper::toDto));
    }

    @Override
    public Object queryAll(ServerDeployQueryCriteria criteria){
        return serverDeployMapper.toDto(serverDeployRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ServerDeployDto findById(Long id) {
        ServerDeploy server = serverDeployRepository.findById(id).orElseGet(ServerDeploy::new);
        ValidationUtil.isNull(server.getId(),"ServerDeploy","id",id);
        return serverDeployMapper.toDto(server);
    }

    @Override
    public ServerDeployDto findByIp(String ip) {
        ServerDeploy deploy = serverDeployRepository.findByIp(ip);
        return serverDeployMapper.toDto(deploy);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServerDeployDto create(ServerDeploy resources) {
        return serverDeployMapper.toDto(serverDeployRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ServerDeploy resources) {
        ServerDeploy serverDeploy = serverDeployRepository.findById(resources.getId()).orElseGet(ServerDeploy::new);
        ValidationUtil.isNull( serverDeploy.getId(),"ServerDeploy","id",resources.getId());
        serverDeploy.copy(resources);
        serverDeployRepository.save(serverDeploy);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        serverDeployRepository.deleteById(id);
    }
}
