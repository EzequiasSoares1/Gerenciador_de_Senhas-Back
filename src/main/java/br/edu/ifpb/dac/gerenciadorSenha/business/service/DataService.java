package br.edu.ifpb.dac.gerenciadorSenha.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Data;
import br.edu.ifpb.dac.gerenciadorSenha.model.repository.DataRepository;

@Service
public class DataService {
	
	@Autowired	
	private DataRepository dataRepository;
	
	public void save(Data ls) {
		dataRepository.save(ls);
	}
	public void update(Data ls) {
		save(ls);
	}
	public void delete(long ls) {
		dataRepository.deleteById(ls);
	}
	public Data findByData(long id) {
		return dataRepository.findById(id).get();
	}
	public List<Data> getAllData() {
		return dataRepository.findAll();
	}
}
