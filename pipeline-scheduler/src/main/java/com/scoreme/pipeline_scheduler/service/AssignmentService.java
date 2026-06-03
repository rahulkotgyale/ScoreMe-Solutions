package com.scoreme.pipeline_scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoreme.pipeline_scheduler.entity.Assignment;
import com.scoreme.pipeline_scheduler.repository.AssignmentRepository;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment saveAssignment(Assignment assignment) {

        validateAssignment(assignment);

        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAllAssignments() {

        return assignmentRepository.findAll();
    }

    public Assignment getAssignmentById(Long id) {

        return assignmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Assignment not found with id: " + id));
    }

    public Assignment updateAssignment(Long id,
                                       Assignment updatedAssignment) {

        Assignment existingAssignment =
                assignmentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Assignment not found with id: " + id));

        existingAssignment.setTaskId(
                updatedAssignment.getTaskId());

        existingAssignment.setSlotId(
                updatedAssignment.getSlotId());

        validateAssignment(existingAssignment);

        return assignmentRepository.save(existingAssignment);
    }

    public void deleteAssignment(Long id) {

        if (!assignmentRepository.existsById(id)) {
            throw new RuntimeException(
                    "Assignment not found with id: " + id);
        }

        assignmentRepository.deleteById(id);
    }

    private void validateAssignment(
            Assignment assignment) {

        if (assignment.getTaskId() == null
                || assignment.getTaskId().isBlank()) {

            throw new IllegalArgumentException(
                    "Task Id cannot be empty");
        }

        if (assignment.getSlotId() <= 0) {

            throw new IllegalArgumentException(
                    "Slot Id must be greater than 0");
        }
    }
}