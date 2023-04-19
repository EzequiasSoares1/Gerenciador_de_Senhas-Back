package br.edu.ifpb.dac.gerenciadorSenha.business.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.gerenciadorSenha.business.Interface.PasswordEncoderService;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;

@Service
public class PasswordEncoderServiceImpl extends BCryptPasswordEncoder implements PasswordEncoderService {


	public void encryptPassword(User user) {
		if(user.getPassword() != null) {
			String encripted = encode(user.getPassword());
			user.setPassword(encripted);
		}
	}

}
