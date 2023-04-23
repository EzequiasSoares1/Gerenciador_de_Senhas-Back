package br.edu.ifpb.dac.gerenciadorSenha.model.entity;
import java.util.Collection;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "Client")
public class User implements UserDetails{
	private static final long serialVersionUID = 1L;
	private String login;
	@Id
	private String name;
	private String password;
	private String telephone;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> role;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="USERDATA_FK")
	private Set<Data> dataService = new HashSet<>();

	public User() {
	}
	
	public User(String name, String password, String loginUser,String telephone, Set<Data> dataService) {
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

	public String toString() {
		return "NOME: " + name +  " LOGIN: " + login + " SENHA: " + password + "\n"
				+ "\n SERVIÇO: \n" + dataService + " \n";	
	}
	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> roles) {
		this.role = roles;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataService, login, name, password);
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
		return Objects.equals(dataService, other.dataService) && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return role;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
