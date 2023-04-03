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

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Data;
import br.edu.ifpb.dac.gerenciadorSenha.presentation.dto.ConverterDTO;
import br.edu.ifpb.dac.gerenciadorSenha.presentation.dto.DataDTO;

@SuppressWarnings({"rawtypes","unchecked"})
@RestController
@RequestMapping("/api/data")
public class ApiControllerData {
	@Autowired
	private ControllerData dataController;
	@Autowired
	private ConverterDTO converte;
	
	@PostMapping
	public ResponseEntity save(@RequestBody DataDTO dataDto) {
		try {
			Data data = converte.dtoToData(dataDto);
			dataController.saveData(data);
			return new ResponseEntity(dataDto, HttpStatus.CREATED);
			
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody DataDTO dataDto) {
		try {
			dataDto.setId(id);
			Data data = converte.dtoToData(dataDto);
			dataController.updateData(data);
			return ResponseEntity.ok(dataDto);
			
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		try {
			
			dataController.deleteData(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
	
	@GetMapping
	public ResponseEntity find(@RequestParam (value = "id", required = false) Long id){
		try {
			DataDTO u= converte.dataToDto(dataController.findByData(id));
			return  ResponseEntity.ok(u);
			
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}

}
