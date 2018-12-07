package com.cookrecipe.binghao.cookrecipe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookrecipe.binghao.cookrecipe.dto.StepDTO;
import com.cookrecipe.binghao.cookrecipe.entity.Step;
import com.cookrecipe.binghao.cookrecipe.repository.StepRepository;



/**
 * The class of step services.
 * @author Lim Bing Hao
 *
 */
@Service
public class StepService {

	/**
	 * Autowired the step repository from stepRepository.java
	 */
	@Autowired
	StepRepository stepRepository;

	/**
	 * This service is design to get all the steps of recipe from repository.
	 * stepList has been created to add all the steps from repository.
	 * and all of these steps will be pass into the stepdtoList for the use of 
	 * transfer data between software application subsystems.
	 * @return the stepdtoList.
	 */
	public List<StepDTO> getAllSteps() {

		List<Step> stepList = new ArrayList<>();
		stepRepository.findAll().forEach(stepList::add);

		List<StepDTO> stepdtoList = new ArrayList<>();
		for (Step step : stepList) {
			StepDTO stepdto = new StepDTO();

			stepdto.setsID(step.getSID());
			stepdto.setStepDescription(step.getStepDescription());

			stepdtoList.add(stepdto);
		}

		return stepdtoList;

	}

	/**
	 * This service is use to delete the step inside repository
	 * based on the step sid pass in from front end application by user.
	 * @param sid the parameter of deleteStep service.
	 */
	public void deleteStep(int sid) {
		stepRepository.delete(sid);
	}

}
