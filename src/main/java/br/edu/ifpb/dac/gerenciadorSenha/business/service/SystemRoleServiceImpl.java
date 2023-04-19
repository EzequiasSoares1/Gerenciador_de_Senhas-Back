package br.edu.ifpb.dac.gerenciadorSenha.business.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.gerenciadorSenha.business.Interface.SystemRoleService;
import br.edu.ifpb.dac.gerenciadorSenha.business.Interface.SystemRoleService.AVAILABLE_ROLES;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Role;
import br.edu.ifpb.dac.gerenciadorSenha.model.repository.SystemRoleRepository;

@Service
public class SystemRoleServiceImpl implements SystemRoleService{
	
	@Autowired
	private SystemRoleRepository repository;
	
	@Override
	public void createDefaultValues() {
		for(AVAILABLE_ROLES availableRole: AVAILABLE_ROLES.values()) {
			Role role = findByName(availableRole.name());
			if(role == null) {
				role = new Role();
				role.setName(availableRole.name());
				repository.save(role);
			}
		}
	}
	
	@Override
	public Role findByName(String name) {
		if(name == null) {
			throw new IllegalStateException("Name cannot be null");
		}
		Role optional = repository.findByName(name);
		
		return optional;
	}
	
	@Override
	public Role findDefault() {
		return findByName(AVAILABLE_ROLES.USER.name());
	}
}
