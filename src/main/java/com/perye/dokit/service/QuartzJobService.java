package com.perye.dokit.service;

import com.perye.dokit.dto.QuartzJobQueryCriteria;
import com.perye.dokit.entity.QuartzJob;
import org.springframework.data.domain.Pageable;

public interface QuartzJobService {


    Object queryAll(QuartzJobQueryCriteria criteria, Pageable pageable);

    Object queryAllLog(QuartzJobQueryCriteria criteria, Pageable pageable);

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
}

