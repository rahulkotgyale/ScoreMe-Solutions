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
@Table(name = "slots")
public class Slot {

    @Id
    private int slotId;

    private double cpuCapacity;

    private double ramCapacity;

    private double gpuCapacity;

    private double networkCapacity;

	public Slot(int slotId, double cpuCapacity, double ramCapacity, double gpuCapacity, double networkCapacity) {
		super();
		this.slotId = slotId;
		this.cpuCapacity = cpuCapacity;
		this.ramCapacity = ramCapacity;
		this.gpuCapacity = gpuCapacity;
		this.networkCapacity = networkCapacity;
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public double getCpuCapacity() {
		return cpuCapacity;
	}

	public void setCpuCapacity(double cpuCapacity) {
		this.cpuCapacity = cpuCapacity;
	}

	public double getRamCapacity() {
		return ramCapacity;
	}

	public void setRamCapacity(double ramCapacity) {
		this.ramCapacity = ramCapacity;
	}

	public double getGpuCapacity() {
		return gpuCapacity;
	}

	public void setGpuCapacity(double gpuCapacity) {
		this.gpuCapacity = gpuCapacity;
	}

	public double getNetworkCapacity() {
		return networkCapacity;
	}

	public void setNetworkCapacity(double networkCapacity) {
		this.networkCapacity = networkCapacity;
	}

	@Override
	public String toString() {
		return "Slot [slotId=" + slotId + ", cpuCapacity=" + cpuCapacity + ", ramCapacity=" + ramCapacity
				+ ", gpuCapacity=" + gpuCapacity + ", networkCapacity=" + networkCapacity + "]";
	}
    
    
}