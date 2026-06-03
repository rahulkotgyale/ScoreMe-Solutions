package com.scoreme.pipeline_scheduler.entity;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchedulingResponse {

    private Map<String, Integer> assignment;
    private double penalty;
    private long runtimeMs;
    private boolean feasible;
    private String violationReason;
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
}