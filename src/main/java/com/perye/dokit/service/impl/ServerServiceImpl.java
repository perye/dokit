package com.perye.dokit.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.perye.dokit.dto.ServerDto;
import com.perye.dokit.query.ServerQueryCriteria;
import com.perye.dokit.entity.Server;
import com.perye.dokit.mapper.ServerMapper;
import com.perye.dokit.repository.ServerRepository;
import com.perye.dokit.service.ServerService;
import com.perye.dokit.utils.PageUtil;
import com.perye.dokit.utils.QueryHelp;
import com.perye.dokit.utils.ValidationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 4:13 下午
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ServerServiceImpl implements ServerService {

    private final ServerRepository serverRepository;

    private final ServerMapper serverMapper;

    public ServerServiceImpl(ServerRepository serverRepository, ServerMapper serverMapper) {
        this.serverRepository = serverRepository;
        this.serverMapper = serverMapper;
    }

    @Override
    public Map<String,Object> queryAll(ServerQueryCriteria criteria, Pageable pageable){
        Page<Server> page = serverRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        page.forEach(server -> {
            try {
                server.setState("1");
                String url = String.format("http://%s:%d/api/serverMonitor",server.getAddress(),server.getPort());
                String res = HttpUtil.get(url,1000);
                JSONObject obj = JSONObject.parseObject(res);
                server.setCpuRate(obj.getDouble("cpuRate"));
                server.setCpuCore(obj.getInteger("cpuCore"));
                server.setMemTotal(obj.getDouble("memTotal"));
                server.setMemUsed(obj.getDouble("memUsed"));
                server.setDiskTotal(obj.getDouble("diskTotal"));
                server.setDiskUsed(obj.getDouble("diskUsed"));
                server.setSwapTotal(obj.getDouble("swapTotal"));
                server.setSwapUsed(obj.getDouble("swapUsed"));
            } catch (Exception e) {
                server.setState("0");
                e.printStackTrace();
            }
        });

        return PageUtil.toPage(page.map(serverMapper::toDto));
    }

    @Override
    public List<ServerDto> queryAll(ServerQueryCriteria criteria){
        return serverMapper.toDto(serverRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public ServerDto findById(Integer id) {
        Server server = serverRepository.findById(id).orElseGet(Server::new);
        ValidationUtil.isNull(server.getId(),"Server","id",id);
        return serverMapper.toDto(server);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServerDto create(Server resources) {
        return serverMapper.toDto(serverRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Server resources) {
        Server server = serverRepository.findById(resources.getId()).orElseGet(Server::new);
        ValidationUtil.isNull( server.getId(),"Server","id",resources.getId());
        server.copy(resources);
        serverRepository.save(server);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Integer> ids) {
        for (Integer id : ids) {
            serverRepository.deleteById(id);
        }
    }

}
