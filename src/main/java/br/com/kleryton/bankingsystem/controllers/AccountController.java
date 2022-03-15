package br.com.kleryton.bankingsystem.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
import br.com.kleryton.bankingsystem.services.AccountService;

@RestController
@RequestMapping("/system-banking/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	// S- saveAccount
	@PostMapping("/add")
	public ResponseEntity<Object> saveAccount(@RequestBody @Valid AccountRequestDto accountDto) {
		if (accountService.existsByRegisterId(accountDto.getRegisterId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Register id is already in use!");
		}

		var accountModel = new AccountModel();
		BeanUtils.copyProperties(accountDto, accountModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(new AccountRequestDto(accountService.create(accountModel)));
	}
	
	// R - Read All
	@GetMapping("/all")
	public ResponseEntity<List<AccountModel>> getAllAccountModel() {
		return ResponseEntity.status(HttpStatus.OK).body(accountService.findAll());
	}

	// R - Read One by Id
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneAccountModel(@PathVariable(value = "id") Long id) {
		Optional<AccountModel> accountModelOptional = accountService.findById(id);
		if (!accountModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(new AccountRequestDto(accountModelOptional.get()));
	}

	// D - Delete One by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAccountModel(@PathVariable Long id) {
		Optional<AccountModel> accountModelOptional = accountService.findById(id);
		if (!accountService.findById(id).get().getCard().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The account has cards. Unable to delete!");
		}
		if (!accountModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
		}
		accountService.delete(accountModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Account deleted successfully.");
	}

	// U - Update One by id
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAccountModel(@PathVariable(value = "id") Long id,
			@RequestBody @Valid AccountRequestDto accountDto) {
		Optional<AccountModel> accountModelOptional = accountService.findById(id);
		if (!accountModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
		}
		var accountModel = new AccountModel();
		BeanUtils.copyProperties(accountDto, accountModel);
		accountModel.setId(accountModelOptional.get().getId());
		accountModel.setCard(accountModelOptional.get().getCard());
		return ResponseEntity.status(HttpStatus.OK).body(new AccountRequestDto(accountService.create(accountModel)));
	}

}
