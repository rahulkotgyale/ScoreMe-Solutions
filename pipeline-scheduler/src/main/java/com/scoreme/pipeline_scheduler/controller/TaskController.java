package com.scoreme.pipeline_scheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.scoreme.pipeline_scheduler.entity.Task;
import com.scoreme.pipeline_scheduler.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task saveTask(@RequestBody Task task) throws Exception {
        try {
            return taskService.saveTask(task);
        } catch (Exception e) {
            System.err.println("Error saving task: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("saveTask() executed");
        }
    }
    
    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable String taskId,
                           @RequestBody Task task) throws Exception {
        try {
            return taskService.updateTask(taskId, task);
        } catch (Exception e) {
            System.err.println("Error updating task: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("updateTask() executed");
        }
    }

    @GetMapping
    public List<Task> getAllTasks() throws Exception {
        try {
            return taskService.getAllTasks();
        } catch (Exception e) {
            System.err.println("Error fetching tasks: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("getAllTasks() executed");
        }
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId) throws Exception {
        try {
            return taskService.getTaskById(taskId);
        } catch (Exception e) {
            System.err.println("Error fetching task: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("getTask() executed");
        }
    }
    
    

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId) throws Exception {
        try {
            taskService.deleteTask(taskId);
            return "Task deleted successfully";
        } catch (Exception e) {
            System.err.println("Error deleting task: " + e.getMessage());
            return "Failed to delete task";
        } finally {
            System.out.println("deleteTask() executed");
        }
    }
}