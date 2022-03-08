package br.com.kleryton.bankingsystem.controllers;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.models.CardModel;
import br.com.kleryton.bankingsystem.requestDto.CardRequestDto;
import br.com.kleryton.bankingsystem.responseDto.AccountResponseDto;
import br.com.kleryton.bankingsystem.responseDto.CardResponseDto;
import br.com.kleryton.bankingsystem.services.AccountService;
import br.com.kleryton.bankingsystem.services.CardService;

@RestController
@RequestMapping("/card")
public class CardController {

	@Autowired
	AccountService accountService;

	@Autowired
	CardService cardService;

	@PostMapping("/{idAccount}/cards")
	public ResponseEntity<AccountResponseDto> saveCard(@RequestBody @Valid CardRequestDto cardRequestDto,
			@PathVariable Long idAccount) {
		CardModel cardModel = new CardModel();
//		CardResponseDto cardResponseDto = new CardResponseDto();
		AccountModel accountModel = new AccountModel();
		BeanUtils.copyProperties(cardRequestDto, cardModel);
		accountModel = cardService.createCardAccount(cardModel, idAccount, cardRequestDto.getTypeCard());
		BeanUtils.copyProperties(cardModel, cardRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(new AccountResponseDto(accountModel, cardRequestDto));
	}

	@GetMapping("/{idAccount}/cards")
	public ResponseEntity<Set<CardResponseDto>> retornaTodosOsCardsDeUmCliente(@PathVariable Long idAccount) {
		cardService.getAllCardsDeUmaAccountById(idAccount);
		Set<CardModel> cardModels = cardService.getAllCardsDeUmaAccountById(idAccount);
		CardResponseDto cardResponseDto = new CardResponseDto();
		return ResponseEntity.status(HttpStatus.OK).body(cardResponseDto.convertToDto(cardModels));
	}
}
