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

import com.CN.FitFusion.dto.DietDto;
import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.service.DietService;

@RestController
@RequestMapping("/diet")
public class DietController {
	
     @Autowired
     DietService dietService;
     
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('TRAINER')")
	public List<Diet>getAllDiet(){
		return dietService.getAllDiet();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('TRAINER')")
	public Diet getDietById(@PathVariable Long id) {
		return dietService.getDietById(id);
	}
	
	@PreAuthorize("hasRole('TRAINER')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/{id}")
	public void createDiet(@RequestBody DietDto dietDto, @PathVariable Long id) {
		dietService.createDiet(dietDto,id);
	}
	
	@PreAuthorize("hasRole('TRAINER')")
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public void updateDiet(@RequestBody DietDto dietDto, @PathVariable Long id) {
		dietService.updateDiet(dietDto,id);
	}
	@PreAuthorize("hasRole('TRAINER')")
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/{id}")
	public void deleteDiet(@PathVariable Long id) {
		dietService.deleteDiet(id);
	}	
}
