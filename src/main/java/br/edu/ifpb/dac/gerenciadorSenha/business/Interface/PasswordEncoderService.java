package br.edu.ifpb.dac.gerenciadorSenha.business.Interface;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;

@Service
public interface PasswordEncoderService extends PasswordEncoder{
	void encryptPassword(User user);
}
