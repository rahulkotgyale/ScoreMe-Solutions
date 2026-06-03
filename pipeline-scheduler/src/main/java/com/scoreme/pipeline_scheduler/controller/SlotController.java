package com.scoreme.pipeline_scheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.scoreme.pipeline_scheduler.entity.Slot;
import com.scoreme.pipeline_scheduler.service.SlotService;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    @Autowired
    private SlotService slotService;

    @PostMapping
    public Slot saveSlot(@RequestBody Slot slot)
            throws Exception {

        try {
            return slotService.saveSlot(slot);

        } catch (Exception e) {
            System.err.println("Error saving slot: "
                    + e.getMessage());
            throw e;

        } finally {
            System.out.println("saveSlot() executed");
        }
    }

    @GetMapping
    public List<Slot> getAllSlots()
            throws Exception {

        try {
            return slotService.getAllSlots();

        } catch (Exception e) {
            System.err.println("Error fetching slots: "
                    + e.getMessage());
            throw e;

        } finally {
            System.out.println("getAllSlots() executed");
        }
    }

    @GetMapping("/{slotId}")
    public Slot getSlot(@PathVariable int slotId)
            throws Exception {

        try {
            return slotService.getSlotById(slotId);

        } catch (Exception e) {
            System.err.println("Error fetching slot: "
                    + e.getMessage());
            throw e;

        } finally {
            System.out.println("getSlot() executed");
        }
    }

    @PutMapping("/{slotId}")
    public Slot updateSlot(
            @PathVariable int slotId,
            @RequestBody Slot slot)
            throws Exception {

        try {
            return slotService.updateSlot(slotId, slot);

        } catch (Exception e) {
            System.err.println("Error updating slot: "
                    + e.getMessage());
            throw e;

        } finally {
            System.out.println("updateSlot() executed");
        }
    }

    @DeleteMapping("/{slotId}")
    public String deleteSlot(
            @PathVariable int slotId)
            throws Exception {

        try {
            slotService.deleteSlot(slotId);
            return "Slot deleted successfully";

        } catch (Exception e) {
            System.err.println("Error deleting slot: "
                    + e.getMessage());
            throw e;

        } finally {
            System.out.println("deleteSlot() executed");
        }
    }
}