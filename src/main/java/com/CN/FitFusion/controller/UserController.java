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

import com.CN.FitFusion.dto.UserDto;
import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.model.Exercise;
import com.CN.FitFusion.model.User;
import com.CN.FitFusion.service.ExerciseService;
import com.CN.FitFusion.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    
    @Autowired
    ExerciseService exerciseService;
    
	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<User>getAllUser(){
		return userService.getAllUser();
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public void updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
		userService.updateUser(userDto,id);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	@GetMapping("/exercise/{id}")
	@PreAuthorize("hasRole('CUSTOMER')")
	@ResponseStatus(HttpStatus.OK)
	public List<Exercise>getAllExerciseById(@PathVariable Long id){
		return userService.getAllExerciseById(id);
	}
	@GetMapping("/diet/{id}")
	@PreAuthorize("hasRole('CUSTOMER')")
	@ResponseStatus(HttpStatus.OK)
	public List<Diet>getAllDietById(@PathVariable Long id){
		return userService.getAllDietById(id);
	}
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public void registerUser(@RequestBody UserDto userDto) {
		userService.registerUser(userDto);
	}
	
	
}
