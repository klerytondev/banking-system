package br.com.kleryton.bankingsystem.controllers;

import java.util.List;

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

import br.com.kleryton.bankingsystem.requestDto.TypeCardRequestDto;
import br.com.kleryton.bankingsystem.responseDto.TypeCardResponseDto;
import br.com.kleryton.bankingsystem.services.TypeCardService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/v1/system-banking")
public class TypeCardController {

	@Autowired
	TypeCardService typeCardService;

	//Create Type Card
	@ApiOperation(value="Cria um novo tipo de cartão")
	@PostMapping
	public ResponseEntity<TypeCardResponseDto> createTypeCard(@RequestBody TypeCardRequestDto typeCardRequestDto) {
		TypeCardResponseDto typeCardResponseDto = typeCardService.createTypeCard(typeCardRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(typeCardResponseDto);
	}

	//Read All
	@ApiOperation(value="Retorna todos os tipos de cartões salvos no banco")
	@GetMapping("/type_card/all")
	public ResponseEntity<List<TypeCardResponseDto>> getAll() {
		List<TypeCardResponseDto> typeCardResponseDtos = typeCardService.getAll();
		return ResponseEntity.ok().body(typeCardResponseDtos);
	}

	//Read One by Id
	@ApiOperation(value="Retorna um tipo de cartão de acordo com o id passado")
	@GetMapping("/type_card/{idCard}")
	public ResponseEntity<TypeCardResponseDto> getById(@PathVariable Long idCard) {
		return ResponseEntity.ok(typeCardService.getById(idCard));
	}

	//Update By Name
	@ApiOperation(value="Atualiza um tipo de cartão de acordo com o id passado")
	@PutMapping("/type_card/update")
	public ResponseEntity<TypeCardResponseDto> updateByName(@RequestParam("name") String name,
			@RequestBody TypeCardRequestDto requestDTO) {
		TypeCardResponseDto typeCardResponseDto = typeCardService.updateByName(name, requestDTO);
		return ResponseEntity.ok().body(typeCardResponseDto);
	}

	//Delete One by Name
	@ApiOperation(value="Deleta um tipo de cartão de acordo com o id passado")
	@DeleteMapping("/type_card/delete")
	public ResponseEntity<String> deleteByName(@RequestParam("name") String name) {
		typeCardService.deleteByName(name);
		return ResponseEntity.ok().body(name + ", successfully deleted");
	}

}
