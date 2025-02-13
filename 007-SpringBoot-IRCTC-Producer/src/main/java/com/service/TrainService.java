package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TrainRepository;
import com.model.TrainInfo;

@Service
public class TrainService {

	@Autowired
	private TrainRepository repo;

	public TrainInfo saveTrain(TrainInfo info) {
		
		return repo.save(info);
	}

	public List<TrainInfo> getAllTrains() {
		
		return repo.findAll();
	}

	public TrainInfo getTrainByNumber(int trainNumber) {
		
		return repo.findById(trainNumber).get();
	}

	public TrainInfo getTrainByName(String trainName) {
		
		return repo.findByTrainName(trainName);
	}

	public String getCurrentStation(int trainNumber) {
		
		return repo.findById(trainNumber).get().getCurrentStation();
	}

	public TrainInfo updateCurrentStation(int trainNumber, String currentStation) {
		
		TrainInfo info = repo.findById(trainNumber).get();
		info.setCurrentStation(currentStation);
		return repo.save(info);
	}
	
	
}
