package com.scoreme.pipeline_scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scoreme.pipeline_scheduler.entity.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Integer> {

}