package br.com.kleryton.bankingsystem.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.kleryton.bankingsystem.requestDto.TypeCardRequestDto;
import br.com.kleryton.bankingsystem.responseDto.TypeCardResponseDto;
import br.com.kleryton.bankingsystem.services.TypeCardService;

@RestController
@RequestMapping("/system-banking/type_card")
public class TypeCardController {

	@Autowired
	TypeCardService typeCardService;

	//Create Type Card
	@PostMapping
	public ResponseEntity<TypeCardResponseDto> createTypeCard(@RequestBody TypeCardRequestDto typeCardRequestDto) {
		TypeCardResponseDto typeCardResponseDto = typeCardService.createTypeCard(typeCardRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(typeCardResponseDto);
	}

	//Read All
	@GetMapping("/all")
	public ResponseEntity<List<TypeCardResponseDto>> getAll() {
		List<TypeCardResponseDto> typeCardResponseDtos = typeCardService.getAll();
		return ResponseEntity.ok().body(typeCardResponseDtos);
	}

	//Read One by Id
	@GetMapping("/{idCard}")
	public ResponseEntity<TypeCardResponseDto> getById(@PathVariable Long idCard) {
		return ResponseEntity.ok(typeCardService.getById(idCard));
	}

	//Update By Name
	@PutMapping("/update")
	public ResponseEntity<TypeCardResponseDto> updateByName(@PathParam("name") String name,
			@RequestBody TypeCardRequestDto requestDTO) {
		TypeCardResponseDto typeCardResponseDto = typeCardService.updateByName(name, requestDTO);
		return ResponseEntity.ok().body(typeCardResponseDto);
	}

	//Delete One by Name
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteByName(@PathParam("name") String name) {
		typeCardService.deleteByName(name);
		return ResponseEntity.ok().body(name + " successfully deleted");
	}

}
