package br.edu.ifpb.dac.gerenciadorSenha.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Role;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;

@Repository
public interface SystemRoleRepository extends JpaRepository<Role, String> {
	Role findByName(String name);
}
