package br.edu.ifpb.dac.gerenciadorSenha.presentation.dto;

import java.io.Serializable;

public class DataDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;	

	private String nameServer;
	private String password;
	private String email;
	private String observation;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameServer() {
		return nameServer;
	}
	public void setNameServer(String nameServer) {
		this.nameServer = nameServer;
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
	
	public DataDTO(String nameServer, String password, String email,String observation) {
		this.nameServer = nameServer;
		this.password = password;
		this.email = email;
		this.observation = observation;
	}
}
