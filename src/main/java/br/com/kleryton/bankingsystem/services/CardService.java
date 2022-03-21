package br.com.kleryton.bankingsystem.services;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.models.CardModel;
import br.com.kleryton.bankingsystem.models.TypeCardModel;
import br.com.kleryton.bankingsystem.repositories.AccountRepository;
import br.com.kleryton.bankingsystem.repositories.CardReposytory;
import br.com.kleryton.bankingsystem.repositories.TypeCardRepository;
import br.com.kleryton.bankingsystem.requestDto.CardRequestDto;
import br.com.kleryton.bankingsystem.responseDto.CardResponseDto;
import br.com.kleryton.bankingsystem.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class CardService {

	
	//TODO verificar necessidade de injeções
	@Autowired
	CardReposytory cardReposytory;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountService accountService;

	@Autowired
	TypeCardRepository typeCardRepository;

	//Create Card em uma account
	@Transactional
	public AccountModel createCardAccount(CardRequestDto cardRequestDto, Long id) {

		// Verifica se a account existe no banco
		Optional<AccountModel> accountOptional = accountRepository.findById(id);
		accountOptional.orElseThrow(() -> new ObjetoNaoEncontradoException("Account not found."));

		// verificar se type Card existe no banco
		Optional<TypeCardModel> typeCarModelOptional = typeCardRepository
				.findByName(cardRequestDto.getTypeCard().getName());
		typeCarModelOptional.orElseThrow(() -> new ObjetoNaoEncontradoException("Type Card not found."));

		// Seta o typeCard em um cardRequestDto
		cardRequestDto.setTypeCard(typeCarModelOptional.get());

		// Converte o cardRequestDto em um CardModel
		CardModel cardModelPersist = new CardModel();
		cardModelPersist = convertDtoToModel(cardRequestDto);

		// Seta um card em account
		accountOptional.get().setCardList(cardModelPersist);

		AccountModel accountModelPersist;

		accountModelPersist = accountRepository.save(accountOptional.get());

		return accountModelPersist;
	}

	//Read All
	@Transactional
	public Set<CardModel> getAllCardsToAccountById(Long id) {
		AccountModel accountModel;
		// Verifica se existe conta no banco de dados com o id passado
		try {
			accountModel = getAccountModelById(id);
		} catch (Exception e) {
			throw new ObjetoNaoEncontradoException("Account not found by id.");
		}
		// Seta cards da account passada em uma lista de cards
		Set<CardModel> cards = accountModel.getCard();
		if (cards.isEmpty())
			throw new ObjetoNaoEncontradoException("Card not found by account.");
		return cards;
	}

	//Update By id
	@Transactional
	public CardModel updateCard(Long id, CardRequestDto cardRequestDto) {

		// Busca no banco de dados se existe card com o id passado 
		Optional<CardModel> cardModelOptional = cardReposytory.findById(id);
		cardModelOptional.orElseThrow(() -> new ObjetoNaoEncontradoException("Card not found."));
		
		//Não é possivel alterar o number e nem o typeCard(regra de negócio)
		//Atualiza os campos da card existentes
		cardModelOptional.get().setNameCard(cardRequestDto.getNameCard());
		cardModelOptional.get().setDigitCode(cardRequestDto.getDigitCode());
		cardModelOptional.get().setFlag(cardRequestDto.getFlag());
		cardModelOptional.get().setLimitBalance(cardRequestDto.getLimitBalance());
//		cardModelOptional.get().setTypeCard(cardRequestDto.getTypeCard());
//		cardModelOptional.get().setNumber(cardRequestDto.getNumber());
		
		//Salva o card no banco de dados
		cardReposytory.save(cardModelOptional.get());
				
		return cardModelOptional.get();
	}
	
	//Delete One By id
	@Transactional
	public Boolean deleteCard(Long id) {

		// Verifica se existe card com o id passado no banco de dados
		Optional<CardModel> cardModelOptional = cardReposytory.findById(id);
		cardModelOptional.orElseThrow(() -> new RuntimeException("Card not found."));
		// Caso exista, o card é deletado
		cardReposytory.delete(cardModelOptional.get());
		return true;
	}
	
	@Transactional
	private AccountModel getAccountModelById(Long id) {
		
		//Verifica se existe uma account no banco de dados 
		Optional<AccountModel> accountOptional = accountRepository.findById(id);
		accountOptional.orElseThrow(() -> new ObjetoNaoEncontradoException("Account not found."));
		return accountOptional.get();
	}

	// Converters

	// Coverte um card em uma response DTO
	@SuppressWarnings("unused")
	private CardResponseDto convertModelToDTO(CardModel cardModel) {

		CardResponseDto cardResponseDto = new CardResponseDto();
		cardResponseDto.setId(cardModel.getId());
		cardResponseDto.setFlag(cardModel.getFlag());
		cardResponseDto.setTypeCardModel(cardModel.getTypeCard());

		return cardResponseDto;
	}

	// Coverte response DTO em um card
	private CardModel convertDtoToModel(CardRequestDto cardRequestDto) {

		CardModel cardModel = new CardModel();
		cardModel.setNameCard(cardRequestDto.getNameCard());
		cardModel.setFlag(cardRequestDto.getFlag());
		cardModel.setNumber(cardRequestDto.getNumber());
		cardModel.setDigitCode(cardRequestDto.getDigitCode());
		cardModel.setLimitBalance(cardRequestDto.getLimitBalance());
		cardModel.setTypeCard(cardRequestDto.getTypeCard());

		return cardModel;
	}

}
