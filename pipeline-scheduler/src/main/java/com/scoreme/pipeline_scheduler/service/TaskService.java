package com.scoreme.pipeline_scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoreme.pipeline_scheduler.entity.Task;
import com.scoreme.pipeline_scheduler.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task) {

        validateTask(task);

        return taskRepository.save(task);
    }

    
    public Task updateTask(String taskId, Task updatedTask) {

        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new RuntimeException("Task not found: " + taskId));

        existingTask.setWeight(updatedTask.getWeight());
        existingTask.setStartSlot(updatedTask.getStartSlot());
        existingTask.setEndSlot(updatedTask.getEndSlot());

        existingTask.setCpu(updatedTask.getCpu());
        existingTask.setRam(updatedTask.getRam());
        existingTask.setGpu(updatedTask.getGpu());
        existingTask.setNetwork(updatedTask.getNetwork());

        validateTask(existingTask);

        return taskRepository.save(existingTask);
    }
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(String taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found: " + taskId));
    }

    public void deleteTask(String taskId) {

        if (!taskRepository.existsById(taskId)) {
            throw new RuntimeException("Task not found: " + taskId);
        }

        taskRepository.deleteById(taskId);
    }

    private void validateTask(Task task) {

        if (task.getTaskId() == null || task.getTaskId().isBlank()) {
            throw new IllegalArgumentException("Task Id cannot be empty");
        }

        if (task.getWeight() <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }

        // SLA Validation (F3)
        if (task.getStartSlot() > task.getEndSlot()) {
            throw new IllegalArgumentException(
                    "Start slot cannot be greater than end slot");
        }

        if (task.getStartSlot() < 1) {
            throw new IllegalArgumentException(
                    "Start slot must be greater than 0");
        }

        // Resource Validation (F2)
        if (task.getCpu() < 0 ||
            task.getRam() < 0 ||
            task.getGpu() < 0 ||
            task.getNetwork() < 0) {

            throw new IllegalArgumentException(
                    "Resource values cannot be negative");
        }
    }
}