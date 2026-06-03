package com.scoreme.pipeline_scheduler.entity;

import java.util.List;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchedulingRequest {
	
	@Id
	private Long id;

    // Task IDs
    private List<String> tasks;

    // Conflict Graph
    private List<List<Integer>> conflicts;

    // Resource Requirements
    // [CPU, RAM, GPU, Network]
    private List<double[]> resources;

    // Slot Capacities
    // [CPU, RAM, GPU, Network]
    private List<double[]> capacities;

    // SLA Windows
    // [startSlot, endSlot]
    private List<int[]> windows;

    // Priority Weights
    private List<Double> weights;

    // Number of Slots
    private int k;

	public SchedulingRequest(List<String> tasks, List<List<Integer>> conflicts, List<double[]> resources,
			List<double[]> capacities, List<int[]> windows, List<Double> weights, int k) {
		super();
		this.tasks = tasks;
		this.conflicts = conflicts;
		this.resources = resources;
		this.capacities = capacities;
		this.windows = windows;
		this.weights = weights;
		this.k = k;
	}

	public List<String> getTasks() {
		return tasks;
	}

	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}

	public List<List<Integer>> getConflicts() {
		return conflicts;
	}

	public void setConflicts(List<List<Integer>> conflicts) {
		this.conflicts = conflicts;
	}

	public List<double[]> getResources() {
		return resources;
	}

	public void setResources(List<double[]> resources) {
		this.resources = resources;
	}

	public List<double[]> getCapacities() {
		return capacities;
	}

	public void setCapacities(List<double[]> capacities) {
		this.capacities = capacities;
	}

	public List<int[]> getWindows() {
		return windows;
	}

	public void setWindows(List<int[]> windows) {
		this.windows = windows;
	}

	public List<Double> getWeights() {
		return weights;
	}

	public void setWeights(List<Double> weights) {
		this.weights = weights;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	@Override
	public String toString() {
		return "SchedulingRequest [tasks=" + tasks + ", conflicts=" + conflicts + ", resources=" + resources
				+ ", capacities=" + capacities + ", windows=" + windows + ", weights=" + weights + ", k=" + k + "]";
	}
    
    
    
}