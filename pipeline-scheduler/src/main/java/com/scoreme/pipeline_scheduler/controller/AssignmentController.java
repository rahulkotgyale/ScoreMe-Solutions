package com.scoreme.pipeline_scheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.scoreme.pipeline_scheduler.entity.Assignment;
import com.scoreme.pipeline_scheduler.service.AssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping
    public Assignment saveAssignment(
            @RequestBody Assignment assignment) throws Exception {

        try {
            return assignmentService.saveAssignment(assignment);

        } catch (Exception e) {
            System.err.println("Error saving assignment: "
                    + e.getMessage());
            throw e;

        } finally {
            System.out.println("saveAssignment() executed");
        }
    }

    @GetMapping
    public List<Assignment> getAllAssignments() throws Exception {

        try {
            return assignmentService.getAllAssignments();

        } catch (Exception e) {
            System.err.println("Error fetching assignments: "
                    + e.getMessage());
            throw e;

        } finally {
            System.out.println("getAllAssignments() executed");
        }
    }
}