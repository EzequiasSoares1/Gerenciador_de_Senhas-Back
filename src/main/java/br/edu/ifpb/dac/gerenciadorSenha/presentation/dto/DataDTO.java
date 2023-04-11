package br.edu.ifpb.dac.gerenciadorSenha.presentation.dto;

import java.io.Serializable;

public class DataDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;	

	private String nameService;
	private String password;
	private String email;
	private String observation;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameService() {
		return nameService;
	}
	public void setNameService(String nameService) {
		this.nameService = nameService;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public DataDTO() {}
	
	public DataDTO(String nameService, String password, String email,String observation) {
		this.nameService = nameService;
		this.password = password;
		this.email = email;
		this.observation = observation;
	}
}
