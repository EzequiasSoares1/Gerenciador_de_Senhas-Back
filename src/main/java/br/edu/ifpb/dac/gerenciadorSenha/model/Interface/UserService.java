package br.edu.ifpb.dac.gerenciadorSenha.model.Interface;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;

@Service
public interface UserService extends UserDetailsService {

	public User save(User user);
	public void update(User user);
	public void delete(String login);
	public User findByUser(String login);
	public User findByUserName(String username);
	public List<User>getAllUser();
}