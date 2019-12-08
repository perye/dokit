package com.perye.dokit.service;

import com.perye.dokit.dto.JobQueryCriteria;
import com.perye.dokit.dto.QuartzJobQueryCriteria;
import com.perye.dokit.entity.QuartzJob;
import com.perye.dokit.entity.QuartzLog;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface QuartzJobService {


    Object queryAll(QuartzJobQueryCriteria criteria, Pageable pageable);

    List<QuartzJob> queryAll(JobQueryCriteria criteria);

    Object queryAllLog(QuartzJobQueryCriteria criteria, Pageable pageable);

    List<QuartzLog> queryAllLog(JobQueryCriteria criteria);

    QuartzJob create(QuartzJob resources);

    void update(QuartzJob resources);

    void delete(QuartzJob quartzJob);

    QuartzJob findById(Long id);

    /**
     * 更改定时任务状态
     * @param quartzJob /
     */
    void updateIsPause(QuartzJob quartzJob);

    /**
     * 立即执行定时任务
     * @param quartzJob /
     */
    void execution(QuartzJob quartzJob);

    void download(List<QuartzJob> queryAll, HttpServletResponse response) throws IOException;

    void downloadLog(List<QuartzLog> queryAllLog, HttpServletResponse response) throws IOException;
}

