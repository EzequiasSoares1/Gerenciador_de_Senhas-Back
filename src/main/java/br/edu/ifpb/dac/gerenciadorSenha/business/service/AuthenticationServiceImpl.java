package br.edu.ifpb.dac.gerenciadorSenha.business.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import br.edu.ifpb.dac.gerenciadorSenha.business.Interface.AuthenticationService;
import br.edu.ifpb.dac.gerenciadorSenha.business.Interface.TokenService;
import br.edu.ifpb.dac.gerenciadorSenha.model.Interface.UserService;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	
	
	public String login(String username, String password) {
		Authentication authentication =  
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(username, password));
		User user = userService.findByUserName(username);
		return tokenService.generate(user);
	}
	
	
	@Override
	public User getLoggedUser() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		return (User) authentication.getPrincipal();
	}

}
