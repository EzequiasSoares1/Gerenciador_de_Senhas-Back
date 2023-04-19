package br.edu.ifpb.dac.gerenciadorSenha.business.service;

import java.time.Instant;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.gerenciadorSenha.business.Interface.TokenService;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class Token implements TokenService{
	
	public static final String CLAIM_USERID = "userId";
	public static final String CLAIM_USERNAME = "username";
	public static final String CLAIM_EXPIRATION = "expirationTime";
	
	@Value("${jwt.expiration}")
	private String expiration;
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Override
	public String generate(User user) {
		
		long expiration = Long.valueOf(this.expiration);
		
		LocalDateTime expirationLocalDateTime = LocalDateTime.now().plusMinutes(expiration);
		Instant expirationInstant = expirationLocalDateTime.atZone(ZoneId.systemDefault()).toInstant();
		Date expirationDate = Date.from(expirationInstant);
		
		String tokenExpiration = expirationLocalDateTime.toLocalTime()
				.format(DateTimeFormatter.ofPattern("HH:mm"));
		
		String token = Jwts
				.builder()
				.setExpiration(expirationDate)
				.setSubject(user.getLogin().toString())
				.claim(CLAIM_USERID, user.getLogin())
				.claim(CLAIM_USERNAME, user.getUsername())
				.claim(CLAIM_EXPIRATION, tokenExpiration)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
		return token;


	}
	@Override
	public Claims getClaims(String token) throws ExpiredJwtException {

		return Jwts
				.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();
	}


	
	
	@Override
	public boolean isValid(String token) {
		
		if(token == null) {
			return false;
		}

		
		try {
			Claims claims = getClaims(token);

			LocalDateTime expirationDate = claims.getExpiration().toInstant()
			.atZone(ZoneId.systemDefault()).toLocalDateTime();
			
			return !LocalDateTime.now().isAfter(expirationDate);
			
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getUsername(String token) {
		Claims claims = getClaims(token);
	
		return (String) claims.get(CLAIM_USERNAME);
	}

	@Override
	public String getUserId(String token) {
		Claims claims = getClaims(token);
		return claims.getSubject();
	}

	@Override
	public String get(HttpServletRequest request) {
		String authorization = request.getHeader("Authorization");
		
		if (authorization == null || !authorization.startsWith("Bearer")) {
			return null;
		}
		return authorization.split(" ")[1];
	}
	

}
