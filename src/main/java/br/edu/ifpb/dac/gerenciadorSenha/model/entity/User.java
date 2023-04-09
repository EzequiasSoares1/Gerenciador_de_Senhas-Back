package br.edu.ifpb.dac.gerenciadorSenha.model.entity;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Client")
public class User{
	@Id
	private String login;
	private String name;
	private String password;
	private String telephone;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="USERDATA_FK")
	private Set<Data> dataSever = new HashSet<>();

	public User() {
	}
	
	public User(String name, String password, String loginUser,String telephone, Set<Data> dataSever) {
		this.name = name;
		this.password = password;
		this.login = loginUser;
		this.telephone = telephone;
		this.dataSever = dataSever;
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

	public Set<Data> getDataSever() {
		return dataSever;
	}

	public void setDataSever(Set<Data> dataSever) {
		this.dataSever = dataSever;
	}

	public String toString() {
		return "NOME: " + name +  " LOGIN: " + login + " SENHA: " + password + "\n"
				+ "\n SERVIÇO: \n" + dataSever + " \n";	
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataSever, login, name, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(dataSever, other.dataSever) && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}
}
