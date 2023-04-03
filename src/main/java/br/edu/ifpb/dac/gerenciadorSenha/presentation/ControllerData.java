package br.edu.ifpb.dac.gerenciadorSenha.presentation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.gerenciadorSenha.business.service.CheckerDataAndUser;
import br.edu.ifpb.dac.gerenciadorSenha.business.service.DataService;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Data;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;

@Controller 
public class ControllerData {
	@Autowired
	private DataService dataServe;
	
	public void saveData(Data data) throws Exception {
		try {
			
			CheckerDataAndUser.checkerData(data);
			dataServe.save(data);
			
		}catch(Exception e) {
			throw new Exception(e.getMessage().intern());
		}	
		
	}	
	public void updateData(Data data) throws Exception {
		try {
			
			Data u = findByData(data.getId());
			CheckerDataAndUser.checkerData(data);
			
			if( u == null) {
				throw new Exception("DATA NO FOUND");
			}
			
			u.setEmail(data.getEmail());
			u.setNameServer(data.getNameServer());
			u.setPassword(data.getPassword());
			u.setService(data.getService());
			dataServe.save(u);
			
		}catch(Exception e) {
			throw new Exception(e.getMessage().intern());
		}
	}	
	public void deleteData(Long id) throws Exception {
		try {
			
			dataServe.delete(id);
			
		}catch(Exception e) {
			throw new Exception("DATA NO FOUND");
		}
	}
	public Data findByData(Long id) throws Exception {
		try {
			
			Data data = dataServe.findByData(id);
			
			if(data == null) {
				throw new Exception("DATA NO FOUND");
			}
			
			return data;
			
		}catch(Exception e) {
			throw new Exception(e.getMessage().intern());
		}
	}
	
	public List<Data> getAllData() {
		return dataServe.getAllData();
	}
}
