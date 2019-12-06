package com.perye.dokit.task;

import com.perye.dokit.service.VisitsService;
import org.springframework.stereotype.Component;

@Component
public class VisitsTask {

    private final VisitsService visitsService;

    public VisitsTask(VisitsService visitsService) {
        this.visitsService = visitsService;
    }

    public void run(){
        visitsService.save();
    }
}
