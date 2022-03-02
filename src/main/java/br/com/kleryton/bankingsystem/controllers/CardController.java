package br.com.kleryton.bankingsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kleryton.bankingsystem.dtos.CardDto;
import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.models.CardModel;
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
	public ResponseEntity <Object> saveCard(@RequestBody @Valid CardDto cardDto, @PathVariable Long idAccount) {
		
		 var cardModel = new CardModel();
		 BeanUtils.copyProperties(cardDto, cardModel);
		 AccountModel accountModel = cardService.createCardAccount(cardDto, idAccount);
		return ResponseEntity.status(HttpStatus.CREATED).body(new CardDto(cardService.save(cardModel)));
	}

}
