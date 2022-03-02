package br.com.kleryton.bankingsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kleryton.bankingsystem.dtos.CardDto;
import br.com.kleryton.bankingsystem.models.CardModel;
import br.com.kleryton.bankingsystem.services.AccountService;
import br.com.kleryton.bankingsystem.services.CardService;

@RestController
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	CardService cardService;
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/addCard")
	public ResponseEntity <Object> saveCard(@RequestBody @Valid CardDto cardDto) {
//		if (cardService.existsByNumberCard(cardDto.getNumber())) {
//			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Number Card is already in use!");
//		}
		var cardModel = new CardModel();
		BeanUtils.copyProperties(cardDto, cardModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(new CardDto(cardService.save(cardModel)));
	}

}
