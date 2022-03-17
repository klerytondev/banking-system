package br.com.kleryton.bankingsystem.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
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

import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.requestDto.AccountRequestDto;
import br.com.kleryton.bankingsystem.responseDto.AccountResponseDto;
import br.com.kleryton.bankingsystem.services.AccountService;

//TODO Refatorar

@RestController
@RequestMapping(value="/v1/system-banking")
public class AccountController {

	@Autowired
	AccountService accountService;

	// SaveAccount
	@PostMapping("/account/add")
	public ResponseEntity<Object> saveAccount(@RequestBody @Valid AccountRequestDto accountRequestDto) {
		AccountModel accountModel = accountService.create(accountRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(accountModel);
	}

	// Read All
	@GetMapping("/account/all")
	public ResponseEntity<List<AccountModel>> getAllAccountModel() {
		return ResponseEntity.status(HttpStatus.OK).body(accountService.findAll());
	}

	// Read One by Id
	@GetMapping("/account/{id}")
	public ResponseEntity<Object> getOneAccountModel(@PathVariable(value = "id") Long id) {
		Optional<AccountModel> accountModelOptional = accountService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new AccountRequestDto(accountModelOptional.get()));
	}

	// Delete One by id
	@DeleteMapping("/account/{id}")
	public ResponseEntity<Object> deleteAccountModel(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(accountService.delete(id));
	}

	// Update by id
	@PutMapping("/account/update")
	public ResponseEntity<AccountResponseDto> updateAccountModel(@PathParam("id") Long id,
			@RequestBody @Valid AccountRequestDto accountRequestDto) {
		AccountResponseDto accountResponseDto = accountService.updateAcoount(id, accountRequestDto);
		return ResponseEntity.status(HttpStatus.OK).body(accountResponseDto);
	}

}
