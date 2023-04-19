package br.edu.ifpb.dac.gerenciadorSenha.presentation.dto;
public class TokenDto {
	
	private String token;
	private UserDTO user;
	
	public TokenDto() {
		// TODO Auto-generated constructor stub
	}
	public TokenDto(String token, UserDTO user) {
		this.token =token;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Username: "+user.getName();
	}
}
