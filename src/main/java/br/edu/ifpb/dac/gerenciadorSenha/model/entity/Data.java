package br.edu.ifpb.dac.gerenciadorSenha.model.entity;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Data{
	@Id     
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
	@Column(nullable = false)
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

	public Data() {}
	
	public Data(String nameService, String password, String email, String observation) {
		this.nameService = nameService;
		this.password = password;
		this.email = email;
		this.observation = observation;
	}
	
	
	public String toString() {
		return " NOME DO SERVIÇO: " + nameService + "\n SERVIÇO TIPO: " + observation.toString() + "\n EMAIL: " + email + "\n SENHA: " + password + " \n";	
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, observation, nameService);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(password, other.password)
				&& observation == other.observation && Objects.equals(nameService, other.nameService);
	}
	
}
