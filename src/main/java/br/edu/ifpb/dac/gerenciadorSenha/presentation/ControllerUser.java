package br.edu.ifpb.dac.gerenciadorSenha.presentation;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.gerenciadorSenha.business.service.CheckerDataAndUser;
import br.edu.ifpb.dac.gerenciadorSenha.business.service.UserService;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Data;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;

@Controller 
public class ControllerUser {
	@Autowired
	private UserService userServe;
	
	public void saveUser(User user) throws Exception {
		try {
			
			CheckerDataAndUser.checkerUser(user);
			CheckerDataAndUser.checkerDataList(user.getDataService());
			User u = userServe.findByUser(user.getLogin());
			
			if(u == null) {
				userServe.save(user);
			}else {
				throw new Exception("USER ALREADY EXISTS");
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage().intern());
		}
	}	
	
	public void updateUser(User user) throws Exception {
		try {
			
			CheckerDataAndUser.checkerUser(user);
			User u = findByUser(user.getLogin());
			u.setLogin(user.getLogin());
			u.setName(user.getName());
			u.setPassword(user.getPassword());
			u.setTelephone(user.getTelephone());
			
			for(Data a: user.getDataService()) {
				u.getDataService().add(a);
			}
			
			userServe.save(u);
			
		}catch(Exception e) {
			throw new Exception(e.getMessage().intern());
		}
	}
	
	public void deleteUser(String login) throws Exception {
		try {
			userServe.delete(login);
			
		}catch(Exception e) {
			throw new Exception("CHECK THE USER DATA");
		}
	}
	public User findByUser(String login) throws Exception {
		try {
			
			User u = userServe.findByUser(login);
			if(u == null) {
				throw new Exception("USER NO FOUND");
			}
			return u;

		}catch(Exception e) {
			throw new Exception(e.getMessage().intern()); 
		}
	}
	public List<User> getAllUser() {
		return userServe.getAllUser();
	}
	
	public void addDataUser(Data data, User user) throws Exception{
		try {
			
			CheckerDataAndUser.checkerUser(user);
			CheckerDataAndUser.checkerData(data);
			User u = findByUser(user.getLogin());
			if(u == null) {
				throw new Exception(("USER NO FOUND"));
			}
			u.getDataService().add(data);
			userServe.save(u);

		}catch(Exception e) {
			throw new Exception(e.getMessage().intern()); 
		}
	}
	
}
