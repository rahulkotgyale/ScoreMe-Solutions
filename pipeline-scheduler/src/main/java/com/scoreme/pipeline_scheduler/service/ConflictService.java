package com.scoreme.pipeline_scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoreme.pipeline_scheduler.entity.Conflict;
import com.scoreme.pipeline_scheduler.repository.ConflictRepository;

@Service
public class ConflictService {

    @Autowired
    private ConflictRepository conflictRepository;

    public Conflict saveConflict(Conflict conflict) {

        validateConflict(conflict);

        return conflictRepository.save(conflict);
    }

    public List<Conflict> getAllConflicts() {
        return conflictRepository.findAll();
    }

    private void validateConflict(Conflict conflict) {

        if (conflict.getTask1() == null
                || conflict.getTask1().isBlank()) {
            throw new IllegalArgumentException("Task1 cannot be empty");
        }

        if (conflict.getTask2() == null
                || conflict.getTask2().isBlank()) {
            throw new IllegalArgumentException("Task2 cannot be empty");
        }

        if (conflict.getTask1().equals(conflict.getTask2())) {
            throw new IllegalArgumentException(
                    "Task1 and Task2 cannot be same");
        }
    }
}