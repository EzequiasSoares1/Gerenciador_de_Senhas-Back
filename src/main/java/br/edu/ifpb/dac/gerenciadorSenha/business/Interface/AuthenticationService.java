package br.edu.ifpb.dac.gerenciadorSenha.business.Interface;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;

@Service

public interface AuthenticationService {
	
	public String login(String username,String password);	
	public User getLoggedUser();

}
