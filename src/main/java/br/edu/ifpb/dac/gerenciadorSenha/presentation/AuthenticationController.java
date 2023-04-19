package br.edu.ifpb.dac.gerenciadorSenha.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import br.edu.ifpb.dac.gerenciadorSenha.business.Interface.AuthenticationService;
import br.edu.ifpb.dac.gerenciadorSenha.business.Interface.TokenService;
import br.edu.ifpb.dac.gerenciadorSenha.model.Interface.UserService;
import br.edu.ifpb.dac.gerenciadorSenha.presentation.dto.ConverterDTO;
import br.edu.ifpb.dac.gerenciadorSenha.presentation.dto.LoginDto;
import br.edu.ifpb.dac.gerenciadorSenha.presentation.dto.TokenDto;
import br.edu.ifpb.dac.gerenciadorSenha.presentation.dto.UserDTO;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;

@RestController
@RequestMapping("/api")
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private ConverterDTO userConverterService;
	@Autowired
	private UserService userService;
	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginDto dto) {
		try {
			String token = authenticationService.login(dto.getUsername(), dto.getPassword()); 
			
			User entity = userService.findByUserName(dto.getUsername());
					
			UserDTO user = userConverterService.userToDto(entity); 
			
			TokenDto tokenDto = new TokenDto(token, user);
			
			return new ResponseEntity(tokenDto, HttpStatus.OK);
			
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/isValidToken")
	public ResponseEntity isValidToken(@RequestBody TokenDto tokenDto) {

		try {
			boolean isValidToken = tokenService.isValid(tokenDto.getToken());

			return new ResponseEntity(isValidToken, HttpStatus.OK);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
