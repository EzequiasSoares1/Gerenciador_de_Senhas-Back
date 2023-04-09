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

	public Data() {}
	
	public Data(String nameServer, String password, String email, String observation) {
		this.nameServer = nameServer;
		this.password = password;
		this.email = email;
		this.observation = observation;
	}
	
	
	public String toString() {
		return " NOME DO SERVIÇO: " + nameServer + "\n SERVIÇO TIPO: " + observation.toString() + "\n EMAIL: " + email + "\n SENHA: " + password + " \n";	
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, observation, nameServer);
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
				&& observation == other.observation && Objects.equals(nameServer, other.nameServer);
	}
	
}
