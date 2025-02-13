package com.CN.FitFusion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CN.FitFusion.dto.ExerciseDto;
import com.CN.FitFusion.model.Exercise;
import com.CN.FitFusion.service.ExerciseService;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
	
	@Autowired
	ExerciseService exerciseService;
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('TRAINER')")
	public List<Exercise>getAllExercise(){
		return exerciseService.getAllExercise();
	}
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('TRAINER')")
	public Exercise getExerciseById(@PathVariable Long id){
		return exerciseService.getExerciseById(id);
	}
	@PostMapping("/create/{userId}")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('TRAINER')")
	public void createExcercise(@RequestBody ExerciseDto exerciseDto, @PathVariable Long userId) {
		exerciseService.createExercise(exerciseDto,userId);
	}
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('TRAINER')")
	public void updateExercise(@RequestBody ExerciseDto exerciseDto, @PathVariable Long id) {
		exerciseService.createExercise(exerciseDto,id);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('TRAINER')")
	public void deleteExercise(@PathVariable Long id) {
		exerciseService.deleteExercise(id);
	}

}
