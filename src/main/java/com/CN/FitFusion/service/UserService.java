package com.CN.FitFusion.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.CN.FitFusion.dto.UserDto;
import com.CN.FitFusion.exception.UserNotFoundException;
import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.model.Exercise;
import com.CN.FitFusion.model.Role;
import com.CN.FitFusion.model.User;
import com.CN.FitFusion.repository.DietRepository;
import com.CN.FitFusion.repository.ExerciseRepository;
import com.CN.FitFusion.repository.UserRepository;

@Service
public class UserService {
	
	 @Autowired
     UserRepository userRepository;
	 
	 @Autowired
	 ExerciseRepository exerciseRepository;
	 
	 @Autowired
	 DietRepository dietRepository;

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user not found"));
	}


	public void updateUser(UserDto userDto, Long id) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		User existingUser = this.getUserById(id);
		existingUser.setEmail(userDto.getEmail());
		existingUser.setAge(userDto.getAge());
		existingUser.setContactNo(userDto.getContactNo());
		existingUser.setGender(userDto.getGender());
		existingUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		//how to set role
		userRepository.save(existingUser);
	}


	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		  userRepository.deleteById(id);
	}


	public List<Exercise> getAllExerciseById(Long id) {
		// TODO Auto-generated method stub
		return getUserById(id).getExerciseList();
	}


	public List<Diet> getAllDietById(Long id) {
		// TODO Auto-generated method stub
		
		return getUserById(id).getDiets();
	}


	public void registerUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		User user  = User.builder()
				.age(userDto.getAge())
				.password(bCryptPasswordEncoder.encode(userDto.getPassword()))
				.gender(userDto.getGender())
				.contactNo(userDto.getContactNo())
				.email(userDto.getEmail())
				.build();
		Set<Role> roleList = new HashSet<>();
        Role role = new Role();
        if(userDto.getUserType()!=null && userDto.getUserType().contains("ADMIN")){
            role.setRoleName("ROLE_ADMIN");
            roleList.add(role);
            user.setRoles(roleList);
        }else if(userDto.getUserType()!=null && userDto.getUserType().contains("TRAINER")){
            role.setRoleName("ROLE_TRAINER");
            roleList.add(role);
            user.setRoles(roleList);
        } else{
            role.setRoleName("ROLE_CUSTOMER");
            roleList.add(role);
            user.setRoles(roleList);
        }
		//how to set role
		userRepository.save(user);
	}

}
