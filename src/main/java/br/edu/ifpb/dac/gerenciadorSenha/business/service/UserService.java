package br.edu.ifpb.dac.gerenciadorSenha.business.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;
import br.edu.ifpb.dac.gerenciadorSenha.model.repository.UserRepository;

@Service
public class UserService {
	@Autowired	
	private UserRepository userRepository;
	
	public void save(User ls) {
		userRepository.save(ls);
	}
	public void update(User ls) {
		save(ls);
	}
	public void delete(String ls) {
		userRepository.deleteById(ls);
	}
	public User findByUser(String login) {
		return userRepository.findByLogin(login);
	}
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
}
