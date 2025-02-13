package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TrainInfo {

	@Id
	private int trainNumber;

	@Column(unique = true)
	private String trainName;
	private String trainSource;
	private String trainDesignation;
	private String currentStation;
	private double time;

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainSource() {
		return trainSource;
	}

	public void setTrainSource(String trainSource) {
		this.trainSource = trainSource;
	}

	public String getTrainDesignation() {
		return trainDesignation;
	}

	public void setTrainDesignation(String trainDesignation) {
		this.trainDesignation = trainDesignation;
	}

	public String getCurrentStation() {
		return currentStation;
	}

	public void setCurrentStation(String currentStation) {
		this.currentStation = currentStation;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "TrainInfo [trainNumber=" + trainNumber + ", trainName=" + trainName + ", trainSource=" + trainSource
				+ ", trainDesignation=" + trainDesignation + ", currentStation=" + currentStation + ", time=" + time
				+ "]";
	}

}
