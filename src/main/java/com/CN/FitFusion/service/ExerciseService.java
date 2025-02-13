package com.CN.FitFusion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CN.FitFusion.dto.ExerciseDto;
import com.CN.FitFusion.exception.ExerciseNotFoundException;
import com.CN.FitFusion.model.Exercise;
import com.CN.FitFusion.model.User;
import com.CN.FitFusion.repository.ExerciseRepository;
import com.CN.FitFusion.repository.UserRepository;

@Service
public class ExerciseService {

	@Autowired
	ExerciseRepository exerciseRepository;
	

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

	
	public List<Exercise> getAllExercise() {
		// TODO Auto-generated method stub
		return exerciseRepository.findAll();
	}

	public Exercise getExerciseById(Long id) {
		// TODO Auto-generated method stub
		return exerciseRepository.findById(id).orElseThrow(()-> new ExerciseNotFoundException("exercise not found"));
	}

	public void createExercise(ExerciseDto exerciseDto, Long userId) {
		// TODO Auto-generated method stub
		Exercise exercise = Exercise.builder()
				.name(exerciseDto.getName())
				.description(exerciseDto.getDescription())
				.sets(exerciseDto.getSets())
				.reps(exerciseDto.getReps())
				.build();
		
		   User user = userService.getUserById(userId);
	        user.getExerciseList().add(exercise);
	      
		exerciseRepository.save(exercise);
		  userRepository.save(user);
	}
	
    public void updateExercise(ExerciseDto exerciseDto, Long id) {
        Exercise existingExercise = getExerciseById(id);
        existingExercise.setName(exerciseDto.getName());
        existingExercise.setDescription(exerciseDto.getDescription());
        existingExercise.setSets(exerciseDto.getSets());
        existingExercise.setReps(exerciseDto.getReps());
        exerciseRepository.save(existingExercise);
    }

	public void deleteExercise(Long id) {
		// TODO Auto-generated method stub
		exerciseRepository.deleteById(id);
		
	}

}
