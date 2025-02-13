package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.TrainInfo;
import com.service.TrainService;

@RestController
@RequestMapping("irctc-service")
public class IRCTCCOntroller {

	@Autowired
	private TrainService service;
	
	@PostMapping("/")
	public TrainInfo saveTrain(@RequestBody TrainInfo info)
	{
		return service.saveTrain(info);
	}
	
	@GetMapping("/")
	public List<TrainInfo> getAllTrains()
	{
		return service.getAllTrains();
	}
	
	@GetMapping("/{trainNumber}")
	public TrainInfo getTrainByNumber(@PathVariable int trainNumber)
	{
		return service.getTrainByNumber(trainNumber);
	}
	
	@GetMapping("/getTrainByName/{trainName}")
	public TrainInfo getTrainByName(@PathVariable String trainName)
	{
		return service.getTrainByName(trainName);
	}
	
	@GetMapping("/getCurrentStation/{trainNumber}")
	public String getCurrentStation(@PathVariable int trainNumber)
	{
		return service.getCurrentStation(trainNumber);
	}
	
	@PutMapping("/{trainNumber}/{currentStation}")
    public TrainInfo updateCurrentStation(@PathVariable int trainNumber, @PathVariable String currentStation)
    {
    	return service.updateCurrentStation(trainNumber, currentStation);
    }
	
}

