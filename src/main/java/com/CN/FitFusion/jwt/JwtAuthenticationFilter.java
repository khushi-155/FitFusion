package com.CN.FitFusion.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
     
	String secret = "thisisdfrewqacvbgtyuomnhtredcvgtewaxxzminhkrdsfremlowertmlkitresaqwertyuiopmnjasdfghjklazxcvbnmlkjhgfdsaqwer";
	@Autowired
	JwtAuthenticationHelper jwtAuthenticationHelper;
	
	@Autowired
	UserDetailsService userDetailsService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String header = request.getHeader("Authorization");
		
		String userName = null;
		String token = null;
		
		if(header!=null&&header.startsWith("Bearer")) {
			
			token = header.substring(7);
			
			userName = jwtAuthenticationHelper.getUsername(token);
			
			UserDetails userDetail = userDetailsService.loadUserByUsername(userName);
			
			   if(!jwtAuthenticationHelper.isTokenExpired(token)) {
				
			         if(userDetail!=null&&SecurityContextHolder.getContext().getAuthentication()==null) {
			    	  
				          UsernamePasswordAuthenticationToken userNamePasswordAuthentication = new UsernamePasswordAuthenticationToken(token, null,userDetail.getAuthorities());
				      
				          userNamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				          
				           SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthentication);
			}
		}
		
}
		
		filterChain.doFilter(request, response);
	}

}
