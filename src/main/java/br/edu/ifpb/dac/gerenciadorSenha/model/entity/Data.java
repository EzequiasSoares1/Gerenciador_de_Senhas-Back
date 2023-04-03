package br.edu.ifpb.dac.gerenciadorSenha.model.entity;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Data{
	@Id     
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
	@Column(nullable = false)
	private String nameServer;
	private String password;
	private String email;
	
	@Column(name = "SERVICE")
	@Enumerated(EnumType.STRING)
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

	public Data() {}
	
	public Data(String nameServer, String password, String email, Services service) {
		this.nameServer = nameServer;
		this.password = password;
		this.email = email;
		this.service = service;
	}
	
	
	public String toString() {
		return " NOME DO SERVIÇO: " + nameServer + "\n SERVIÇO TIPO: " + service.toString() + "\n EMAIL: " + email + "\n SENHA: " + password + " \n";	
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, service, nameServer);
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
				&& service == other.service && Objects.equals(nameServer, other.nameServer);
	}
	
}
