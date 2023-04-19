package br.edu.ifpb.dac.gerenciadorSenha.business.Interface;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Role;

public interface SystemRoleService {
	public enum AVAILABLE_ROLES{USER}

	void createDefaultValues();

	Role findByName(String name);

	Role findDefault();
}
