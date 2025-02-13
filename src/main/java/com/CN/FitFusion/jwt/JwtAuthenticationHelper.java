package com.CN.FitFusion.jwt;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtAuthenticationHelper {

	String secret = "thisisdfrewqacvbgtyuomnhtredcvgtewaxxzminhkrdsfremlowertmlkitresaqwertyuiopmnjasdfghjklazxcvbnmlkjhgfdsaqwer";
	private static final long JWT_TOKEN_VALIDITY = 60*60;	

	public String getUsername(String token) {
		// TODO Auto-generated method stub
		Claims claim = this.getClaims(token);
		return claim.getSubject();
	}
	public Claims getClaims(String token) {
		Claims claim = Jwts.parserBuilder()
				.setSigningKey(secret.getBytes())
				.build().parseClaimsJws(token).getBody();
		return claim;
	}
	public boolean isTokenExpired(String token) {
		// TODO Auto-generated method stub
		Claims claim = this.getClaims(token);
		Date date = claim.getExpiration();		
		return date.before(new Date());
	}
	public String generateToken(UserDetails userDetails) {
		// TODO Auto-generated method stub
		Map<String,Object>claims = new HashMap<>();
		
		return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000))
				.signWith(new SecretKeySpec(secret.getBytes(),SignatureAlgorithm.HS512.getJcaName()),SignatureAlgorithm.HS512).compact();
	}

}
