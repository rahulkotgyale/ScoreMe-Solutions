package com.scoreme.pipeline_scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoreme.pipeline_scheduler.entity.Assignment;
import com.scoreme.pipeline_scheduler.entity.Task;
import com.scoreme.pipeline_scheduler.repository.AssignmentRepository;
import com.scoreme.pipeline_scheduler.repository.TaskRepository;

@Service
public class SchedulerService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    public void scheduleTasks() {

        List<Task> tasks = taskRepository.findAll();

        int slot = 1;

        for (Task task : tasks) {

            Assignment assignment = new Assignment();

            assignment.setTaskId(task.getTaskId());
            assignment.setSlotId(slot);

            assignmentRepository.save(assignment);

            slot++;
        }
    }
}