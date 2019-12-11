package com.perye.dokit.service.impl;

import cn.hutool.core.util.IdUtil;
import com.perye.dokit.dto.ServerAccountDTO;
import com.perye.dokit.dto.ServerAccountQueryCriteria;
import com.perye.dokit.entity.ServerAccount;
import com.perye.dokit.mapper.ServerAccountMapper;
import com.perye.dokit.repository.ServerAccountRepository;
import com.perye.dokit.service.ServerAccountService;
import com.perye.dokit.utils.PageUtil;
import com.perye.dokit.utils.QueryHelp;
import com.perye.dokit.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ServerAccountServiceImpl implements ServerAccountService {

    @Autowired
    private ServerAccountRepository serverAccountRepository;

    @Autowired
    private ServerAccountMapper serverAccountMapper;

    @Override
    public Object queryAll(ServerAccountQueryCriteria criteria, Pageable pageable){
        Page<ServerAccount> page = serverAccountRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(serverAccountMapper::toDto));
    }

    @Override
    public Object queryAll(ServerAccountQueryCriteria criteria){
        return serverAccountMapper.toDto(serverAccountRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ServerAccountDTO findById(String id) {
        Optional<ServerAccount> ServerAccount = serverAccountRepository.findById(id);
        ValidationUtil.isNull(ServerAccount,"ServerAccount","id",id);
        return serverAccountMapper.toDto(ServerAccount.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServerAccountDTO create(ServerAccount resources) {
        resources.setId(IdUtil.simpleUUID());
        return serverAccountMapper.toDto(serverAccountRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ServerAccount resources) {
        Optional<ServerAccount> optionalServerAccount = serverAccountRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalServerAccount,"ServerAccount","id",resources.getId());
        ServerAccount ServerAccount = optionalServerAccount.get();
        ServerAccount.copy(resources);
        serverAccountRepository.save(ServerAccount);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        serverAccountRepository.deleteById(id);
    }
}
