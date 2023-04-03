package br.edu.ifpb.dac.gerenciadorSenha.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	 User findByLogin(String login);
}
