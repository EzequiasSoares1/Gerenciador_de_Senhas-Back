package br.edu.ifpb.dac.gerenciadorSenha.presentation.dto;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Services;

public class DataDTO{

	private long id;	

	private String nameServer;
	private String password;
	private String email;
	private Services service;
	
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
	public Services getService() {
		return service;
	}
	public void setService(Services service) {
		this.service = service;
	}
	
	public DataDTO(String nameServer, String password, String email, Services service) {
		this.nameServer = nameServer;
		this.password = password;
		this.email = email;
		this.service = service;
	}
}
