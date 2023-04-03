package br.edu.ifpb.dac.gerenciadorSenha.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
}
