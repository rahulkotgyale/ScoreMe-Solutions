package com.scoreme.pipeline_scheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.scoreme.pipeline_scheduler.service.SchedulerService;

@RestController
@RequestMapping("/api/scheduler")
public class SchedulerController {

    @Autowired
    private SchedulerService schedulerService;

    @PostMapping("/run")
    public String scheduleTasks() throws Exception {

        try {
            schedulerService.scheduleTasks();
            return "Tasks scheduled successfully";

        } catch (Exception e) {
            System.err.println("Scheduling Error : " + e.getMessage());
            throw e;

        } finally {
            System.out.println("scheduleTasks() executed");
        }
    }
    
    
    
}

