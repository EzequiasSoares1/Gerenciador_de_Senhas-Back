package br.edu.ifpb.dac.gerenciadorSenha.presentation.dto;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Data;

public class UserDTO{
	
	
	private String login;
	private String name;
	private String password;
	private String telephone;
	

	private Set<Data> dataService = new HashSet<>();
	public UserDTO() {}
	
	public UserDTO(String name, String password, String loginUser, String telephone,Set<Data> dataService) {
		this.name = name;
		this.password = password;
		this.login = loginUser;
		this.telephone = telephone;
		this.dataService = dataService;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public Set<Data> getDataService() {
		return dataService;
	}

	public void setDataService(Set<Data> dataService) {
		this.dataService = dataService;
	}

}
