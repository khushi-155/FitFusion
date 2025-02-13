package com.CN.FitFusion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.CN.FitFusion.dto.JwtRequest;
import com.CN.FitFusion.dto.JwtResponse;
import com.CN.FitFusion.jwt.JwtAuthenticationHelper;


@Service
public class AuthService {
   
	@Autowired
	AuthenticationManager manager;
	
	@Autowired
	UserDetailsService userDetailService;
	
	@Autowired
	JwtAuthenticationHelper jwtHelper;
	
	public JwtResponse login(JwtRequest jwtRequest) {
		
		this.doAuthentication(jwtRequest.getUsername(),jwtRequest.getPassword());
		
		UserDetails userDetails = userDetailService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = jwtHelper.generateToken(userDetails);
		JwtResponse response = JwtResponse.builder().jwtToken(token).build();
		
		return response;
	}

	private void doAuthentication(String username, String password) {
		// TODO Auto-generated method stub
		UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(username,password);
		try {
			manager.authenticate(usernamePasswordAuthentication);
		}catch(BadCredentialsException e) {
			throw new BadCredentialsException("user credential is wrong");
		}
	}
		

    
}
