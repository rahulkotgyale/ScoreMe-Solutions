package com.scoreme.pipeline_scheduler.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.scoreme.pipeline_scheduler.entity.Conflict;
import com.scoreme.pipeline_scheduler.service.ConflictService;

@RestController
@RequestMapping("/api/conflicts")
public class ConflictController {

    @Autowired
    private ConflictService conflictService;

    @PostMapping
    public Conflict saveConflict(@RequestBody Conflict conflict)
            throws Exception {

        try {
            return conflictService.saveConflict(conflict);

        } catch (Exception e) {
            System.err.println("Error saving conflict: "
                    + e.getMessage());
            throw e;

        } finally {
            System.out.println("saveConflict() executed");
        }
    }

    @GetMapping
    public List<Conflict> getAllConflicts() throws Exception {

        try {
            return conflictService.getAllConflicts();

        } catch (Exception e) {
            System.err.println("Error fetching conflicts: "
                    + e.getMessage());
            throw e;

        } finally {
            System.out.println("getAllConflicts() executed");
        }
    }
}