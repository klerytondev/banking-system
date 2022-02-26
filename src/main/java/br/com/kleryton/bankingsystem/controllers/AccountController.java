package br.com.kleryton.bankingsystem.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.RestController;

import br.com.kleryton.bankingsystem.dtos.AccountDto;
import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.services.AccountService;

@RestController
@RequestMapping("/system-banking")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	

	@PostMapping
	public ResponseEntity<Object> saveAccount(@RequestBody @Valid AccountDto accountDto) {
		if (accountService.existsByRegisterId(accountDto.getRegister_id())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Register id is already in use!");
		}

		var accountModel = new AccountModel();
		BeanUtils.copyProperties(accountDto, accountModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(accountModel));
	}

	@GetMapping
	public ResponseEntity<List<AccountModel>> getAllAccountModel() {
		return ResponseEntity.status(HttpStatus.OK).body(accountService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneAccountModel(@PathVariable(value = "id") UUID id) {
		Optional<AccountModel> accountModelOptional = accountService.findById(id);
		if (!accountModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(accountModelOptional.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAccountModel(@PathVariable(value = "id") UUID id) {
		Optional<AccountModel> accountModelOptional = accountService.findById(id);
		if (!accountModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
		}
		accountService.delete(accountModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Account deleted successfully.");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAccountModel(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid AccountDto accountDto) {
		Optional<AccountModel> accountModelOptional = accountService.findById(id);
		if (!accountModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
		}
		var accountModel = new AccountModel();
		BeanUtils.copyProperties(accountDto, accountModel);
		accountModel.setId(accountModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(accountService.save(accountModel));
	}

}
