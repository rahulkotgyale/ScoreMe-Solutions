package com.scoreme.pipeline_scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scoreme.pipeline_scheduler.entity.Conflict;

@Repository
public interface ConflictRepository extends JpaRepository<Conflict, Long> {

}