package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.TrainInfo;

@Repository
public interface TrainRepository extends JpaRepository<TrainInfo, Integer> {

	public TrainInfo findByTrainName(String trainName);
}
























