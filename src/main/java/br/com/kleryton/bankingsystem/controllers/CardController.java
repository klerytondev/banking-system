package br.com.kleryton.bankingsystem.controllers;

import java.util.Set;

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
import br.com.kleryton.bankingsystem.models.CardModel;
import br.com.kleryton.bankingsystem.requestDto.CardRequestDto;
import br.com.kleryton.bankingsystem.services.AccountService;
import br.com.kleryton.bankingsystem.services.CardService;

@RestController
@RequestMapping("/system-banking/cards")
public class CardController {

	//TODO verificar injeções necessárias
	@Autowired
	AccountService accountService;

	@Autowired
	CardService cardService;

	//Create Card
	@PostMapping("/{idAccount}")
	public ResponseEntity<AccountModel> createCard(@RequestBody @Valid CardRequestDto cardRequestDto,
			@PathVariable Long idAccount) {
		AccountModel accountModel = cardService.createCardAccount(cardRequestDto, idAccount);
		return ResponseEntity.status(HttpStatus.CREATED).body(accountModel);
	}
//TODO corrigir erro

	//Read All
	@GetMapping("/{idAccount}")
	public ResponseEntity<Set<CardModel>> getAllCardsToAccount(@PathVariable Long idAccount) {
		Set<CardModel> cardModels = cardService.getAllCardsToAccountById(idAccount);
		return ResponseEntity.status(HttpStatus.OK).body(cardModels);
	}
	
	//Delete One By id
	@DeleteMapping("/delete")
	public ResponseEntity<Object> DeletecardModel(@PathParam("id") Long id) {
		Boolean cardDelete = cardService.deleteCard(id);
		if (cardDelete == true) {
			return ResponseEntity.status(HttpStatus.OK).body("Card deleted successfully");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Could not delete card");
	}
	
	//Update By id
	@PutMapping("/update")
	public ResponseEntity<CardModel> updateCardModel(@PathParam("id") Long id,
			@RequestBody @Valid CardRequestDto cardRequestDto) {
		CardModel cardModel = cardService.updateCard(id, cardRequestDto);

		return ResponseEntity.status(HttpStatus.OK).body(cardModel);
	}

}
