package com.CN.FitFusion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CN.FitFusion.dto.DietDto;
import com.CN.FitFusion.exception.DietNotFoundException;
import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.model.User;
import com.CN.FitFusion.repository.DietRepository;
import com.CN.FitFusion.repository.UserRepository;

@Service
public class DietService {

	@Autowired
	DietRepository dietRepository;
	
	@Autowired
    private UserRepository userRepository;
	
    @Autowired
    private UserService userService;
	
	public List<Diet> getAllDiet() {
		// TODO Auto-generated method stub
		return dietRepository.findAll();
	}

	public Diet getDietById(Long id) {
		// TODO Auto-generated method stub
		return dietRepository.findById(id).orElseThrow(()->new DietNotFoundException("diet not found"));
	}

	public void createDiet(DietDto dietDto, Long id) {
		// TODO Auto-generated method stub
		Diet diet = Diet.builder()
				.name(dietDto.getName())
				.description(dietDto.getDescription())
				.build();
		User user = userService.getUserById(id);
		user.getDiets().add(diet);
		dietRepository.save(diet);
		userRepository.save(user);
	}

	public void updateDiet(DietDto dietDto, Long id) {
		// TODO Auto-generated method stub
		Diet existingDiet = this.getDietById(id);
		existingDiet.setDescription(dietDto.getDescription());
		existingDiet.setName(dietDto.getName());
		
		dietRepository.save(existingDiet);
	}

	public void deleteDiet(Long id) {
		// TODO Auto-generated method 
		dietRepository.deleteById(id);
	}

}
