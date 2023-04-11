package br.edu.ifpb.dac.gerenciadorSenha.business.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Data;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;
@Service
public class CheckerDataAndUser {
	
	public static void checkerUser(User user) throws Exception{
		if(user.getLogin() == null || user.getPassword() == null || user.getLogin().equals("") || user.getPassword().equals("")) {
			throw new Exception("CHECK THE USER DATA");
		}
	}
	
	@SuppressWarnings("unused")
	public static void checkerDataList(Set<Data> data) throws Exception {
		  for(Data u: data) {
			  checkerData(u);
		  }	
	}
	public static void checkerData(Data data) throws Exception{
		if(data  == null || data.getNameService() == null ||  data.getPassword() == null
			|| data.getNameService().equals("") || data.getPassword() .equals("")) {
			
			throw new Exception("CHECK THE DATA");
		}
	}
}
