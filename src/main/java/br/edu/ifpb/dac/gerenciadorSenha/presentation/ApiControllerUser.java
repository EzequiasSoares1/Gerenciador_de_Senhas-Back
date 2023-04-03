package br.edu.ifpb.dac.gerenciadorSenha.presentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;
import br.edu.ifpb.dac.gerenciadorSenha.presentation.dto.ConverterDTO;
import br.edu.ifpb.dac.gerenciadorSenha.presentation.dto.UserDTO;

@SuppressWarnings({"rawtypes","unchecked"})
@RestController
@RequestMapping("/api/user")
public class ApiControllerUser {	
	@Autowired
	private ControllerUser userController;
	@Autowired
	private ConverterDTO converte;	
	
	@PostMapping
	public ResponseEntity save(@RequestBody UserDTO userDto) {
		try {
			User client = converte.dtoToUser(userDto);
			find(client.getLogin());
			userController.saveUser(client);
			
			return new ResponseEntity(userDto, HttpStatus.CREATED);
			
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	@PutMapping("{login}")
	public ResponseEntity update(@PathVariable("login") String login, @RequestBody UserDTO userDTO) {
		try {
			userDTO.setLogin(login);
			User client = converte.dtoToUser(userDTO);
			userController.updateUser(client);
			return ResponseEntity.ok(userDTO);
			
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	@DeleteMapping("{login}")
	public ResponseEntity delete(@PathVariable("login") String login) {
		try {
			
			userController.deleteUser(login);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
	
	@GetMapping
	public ResponseEntity find(@RequestParam (value = "login", required = false) String login){
		try {
			UserDTO u= converte.userToDto(userController.findByUser(login));
			return  ResponseEntity.ok(u);
			
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	@GetMapping("/noData")
	public ResponseEntity find(@RequestParam (value = "login", required = false) String login, String noData){
		try {
			UserDTO u= converte.userToDtoNoData(userController.findByUser(login));
			return  ResponseEntity.ok(u);
			
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
}
