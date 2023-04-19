package br.edu.ifpb.dac.gerenciadorSenha.business.service;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.gerenciadorSenha.business.Interface.PasswordEncoderService;
import br.edu.ifpb.dac.gerenciadorSenha.business.Interface.SystemRoleService;
import br.edu.ifpb.dac.gerenciadorSenha.model.Interface.UserService;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Role;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;
import br.edu.ifpb.dac.gerenciadorSenha.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired	
	private UserRepository userRepository;
	@Autowired
	private SystemRoleService roleService;
	@Autowired
	private PasswordEncoderService passwordEnconderService;
	
	public User save(User user) {
		passwordEnconderService.encryptPassword(user);
		
		List<Role> roles = new ArrayList<>();
		roles.add(roleService.findDefault());
		user.setRole(roles);
		
		userRepository.save(user);
		return user;
	
	}
	
	@Override
	public void update(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void delete(String Login) {
		userRepository.deleteById(Login);
	}

	@Override
	public User findByUser(String login) {
		return userRepository.findByLogin(login);
	}
	@Override
	public User findByUserName(String username) {
		User optional = userRepository.findByName(username); 
		return optional != null? optional: null;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Could not find any user with username %s", username));
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}	
}
