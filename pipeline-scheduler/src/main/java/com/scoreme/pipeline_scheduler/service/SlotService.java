package com.scoreme.pipeline_scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoreme.pipeline_scheduler.entity.Slot;
import com.scoreme.pipeline_scheduler.repository.SlotRepository;

@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    public Slot saveSlot(Slot slot) {

        validateSlot(slot);

        return slotRepository.save(slot);
    }

    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    public Slot getSlotById(int slotId) {

        return slotRepository.findById(slotId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Slot not found: " + slotId));
    }

    public Slot updateSlot(int slotId, Slot updatedSlot) {

        Slot existingSlot = getSlotById(slotId);

        existingSlot.setCpuCapacity(updatedSlot.getCpuCapacity());
        existingSlot.setRamCapacity(updatedSlot.getRamCapacity());
        existingSlot.setGpuCapacity(updatedSlot.getGpuCapacity());
        existingSlot.setNetworkCapacity(updatedSlot.getNetworkCapacity());

        validateSlot(existingSlot);

        return slotRepository.save(existingSlot);
    }

    public void deleteSlot(int slotId) {

        if (!slotRepository.existsById(slotId)) {
            throw new RuntimeException(
                    "Slot not found: " + slotId);
        }

        slotRepository.deleteById(slotId);
    }

    private void validateSlot(Slot slot) {

        if (slot.getCpuCapacity() < 0 ||
            slot.getRamCapacity() < 0 ||
            slot.getGpuCapacity() < 0 ||
            slot.getNetworkCapacity() < 0) {

            throw new IllegalArgumentException(
                    "Capacity values cannot be negative");
        }
    }
}