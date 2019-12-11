package com.perye.dokit.service.impl;

import cn.hutool.core.util.IdUtil;
import com.perye.dokit.dto.DatabaseDTO;
import com.perye.dokit.dto.DatabaseQueryCriteria;
import com.perye.dokit.entity.Database;
import com.perye.dokit.mapper.DatabaseMapper;
import com.perye.dokit.repository.DatabaseRepository;
import com.perye.dokit.service.DatabaseService;
import com.perye.dokit.utils.PageUtil;
import com.perye.dokit.utils.QueryHelp;
import com.perye.dokit.utils.ValidationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DatabaseServiceImpl implements DatabaseService {

    private DatabaseRepository databaseRepository;

    private DatabaseMapper databaseMapper;

    public DatabaseServiceImpl(DatabaseRepository databaseRepository,DatabaseMapper databaseMapper){
        this.databaseMapper = databaseMapper;
        this.databaseRepository = databaseRepository;
    }

    @Override
    public Object queryAll(DatabaseQueryCriteria criteria, Pageable pageable){
        Page<Database> page = databaseRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(databaseMapper::toDto));
    }

    @Override
    public Object queryAll(DatabaseQueryCriteria criteria){
        return databaseMapper.toDto(databaseRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public DatabaseDTO findById(String id) {
        Optional<Database> database = databaseRepository.findById(id);
        ValidationUtil.isNull(database,"Database","id",id);
        return databaseMapper.toDto(database.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DatabaseDTO create(Database resources) {
        resources.setId(IdUtil.simpleUUID());
        return databaseMapper.toDto(databaseRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Database resources) {
        Optional<Database> optionalDatabase = databaseRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalDatabase,"Database","id",resources.getId());
        Database database = optionalDatabase.get();
        database.copy(resources);
        databaseRepository.save(database);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        databaseRepository.deleteById(id);
    }
}
