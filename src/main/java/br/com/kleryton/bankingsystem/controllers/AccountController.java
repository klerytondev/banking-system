package br.com.kleryton.bankingsystem.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.requestDto.AccountRequestDto;
import br.com.kleryton.bankingsystem.responseDto.AccountResponseDto;
import br.com.kleryton.bankingsystem.services.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/v1/system-banking")
@Api(value="Banking System - API Restful")
@CrossOrigin(origins="*")
public class AccountController {

	@Autowired
	AccountService accountService;

	// SaveAccount
	@ApiOperation(value="Salva uma nova conta no banco de dados")
	@PostMapping("/account/add")
	public ResponseEntity<Object> saveAccount(@RequestBody @Valid AccountRequestDto accountRequestDto) {
		AccountModel accountModel = accountService.create(accountRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(accountModel);
	}

	// Read All
	@ApiOperation(value="Retorna todas contas salvas no banco de dados")
	@GetMapping("/account/all")
	public ResponseEntity<List<AccountModel>> getAllAccountModel() {
		return ResponseEntity.status(HttpStatus.OK).body(accountService.findAll());
	}

	// Read One by Id
	@ApiOperation(value="Retorna uma conta de acordo com o id passado")
	@GetMapping("/account/{id}")
	public ResponseEntity<Object> getOneAccountModel(@PathVariable(value = "id") Long id) {
		Optional<AccountModel> accountModelOptional = accountService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new AccountRequestDto(accountModelOptional.get()));
	}

	// Delete One by id
	@ApiOperation(value="Deleta uma conta de acordo com o id passado")
	@DeleteMapping("/account/{id}")
	public ResponseEntity<Object> deleteAccountModel(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(accountService.delete(id));
	}

	// Update by id
	@ApiOperation(value="Atualiza uma conta de acordo com o id passado")
	@PutMapping("/account/update")
	public ResponseEntity<AccountResponseDto> updateAccountModel(@RequestParam("id") Long id,
			@RequestBody @Valid AccountRequestDto accountRequestDto) {
		AccountResponseDto accountResponseDto = accountService.updateAcoount(id, accountRequestDto);
		return ResponseEntity.status(HttpStatus.OK).body(accountResponseDto);
	}

}
