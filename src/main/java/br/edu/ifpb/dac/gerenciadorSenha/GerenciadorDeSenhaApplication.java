package br.edu.ifpb.dac.gerenciadorSenha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.edu.ifpb.dac.gerenciadorSenha.presentation.ApiControllerData;
import br.edu.ifpb.dac.gerenciadorSenha.presentation.ApiControllerUser;
@SuppressWarnings("unused")
@EntityScan("br.edu.ifpb.dac.gerenciadorSenha.model.entity")
@EnableJpaRepositories(basePackages = "br.edu.ifpb.dac.gerenciadorSenha.model.repository")
@ComponentScan({"br.edu.ifpb.dac.gerenciadorSenha.presentation","br.edu.ifpb.dac.gerenciadorSenha.business.service",
"br.edu.ifpb.dac.gerenciadorSenha.presentation.dto","br.edu.ifpb.dac.gerenciadorSenha.model.dtoService"})

@SpringBootApplication
public class GerenciadorDeSenhaApplication implements CommandLineRunner{
	
	@Autowired
	private ApiControllerUser controllerUser;
	@Autowired
	private ApiControllerData controllerData;
	
	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDeSenhaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	
	}

}
