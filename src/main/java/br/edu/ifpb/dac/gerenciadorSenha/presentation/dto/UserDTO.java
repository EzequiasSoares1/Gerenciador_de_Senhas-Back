package br.edu.ifpb.dac.gerenciadorSenha.presentation.dto;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Data;

public class UserDTO{
	
	private String login;
	private String name;
	private String password;

	private Set<Data> dataSever = new HashSet<>();

	
	public UserDTO(String name, String password, String loginUser,Set<Data> dataSever) {
		this.name = name;
		this.password = password;
		this.login = loginUser;
		this.dataSever = dataSever;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Data> getDataSever() {
		return dataSever;
	}

	public void setDataSever(Set<Data> dataSever) {
		this.dataSever = dataSever;
	}

}
