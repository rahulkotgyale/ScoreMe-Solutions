package com.scoreme.pipeline_scheduler.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

	@Id
    private String taskId;

    // Resource Requirements
    private double cpu;
    private double ram;
    private double gpu;
    private double network;

    private double weight;

    private int startSlot;

    private int endSlot;

	public Task(String taskId, double cpu, double ram, double gpu, double network, double weight, int startSlot,
			int endSlot) {
		super();
		this.taskId = taskId;
		this.cpu = cpu;
		this.ram = ram;
		this.gpu = gpu;
		this.network = network;
		this.weight = weight;
		this.startSlot = startSlot;
		this.endSlot = endSlot;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public double getCpu() {
		return cpu;
	}

	public void setCpu(double cpu) {
		this.cpu = cpu;
	}

	public double getRam() {
		return ram;
	}

	public void setRam(double ram) {
		this.ram = ram;
	}

	public double getGpu() {
		return gpu;
	}

	public void setGpu(double gpu) {
		this.gpu = gpu;
	}

	public double getNetwork() {
		return network;
	}

	public void setNetwork(double network) {
		this.network = network;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getStartSlot() {
		return startSlot;
	}

	public void setStartSlot(int startSlot) {
		this.startSlot = startSlot;
	}

	public int getEndSlot() {
		return endSlot;
	}

	public void setEndSlot(int endSlot) {
		this.endSlot = endSlot;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", cpu=" + cpu + ", ram=" + ram + ", gpu=" + gpu + ", network=" + network
				+ ", weight=" + weight + ", startSlot=" + startSlot + ", endSlot=" + endSlot + "]";
	}

    
    
}