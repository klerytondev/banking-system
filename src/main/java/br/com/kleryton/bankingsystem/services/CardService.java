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

@Service
public class CardService {

	@Autowired
	CardReposytory cardReposytory;

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountService accountService;

	@Autowired
	TypeCardRepository typeCardRepository;

	@Transactional
	public AccountModel createCardAccount(CardRequestDto cardRequestDto, Long id) {
		
		// Verifica se a account existe no banco
		Optional<AccountModel> accountOptional = accountRepository.findById(id);
		accountOptional.orElseThrow(() -> new RuntimeException("Account not found."));
		
		// verificar se type Card existe no banco
		Optional<TypeCardModel> typeCarModelOptional = typeCardRepository
				.findByName(cardRequestDto.getTypeCard().getName());
		typeCarModelOptional.orElseThrow(() -> new RuntimeException("Type Card not found."));
		
		//Seta o typeCard em um cardRequestDto
		cardRequestDto.setTypeCard(typeCarModelOptional.get());
		//Converte o cardRequestDto em um CardModel
		CardModel cardModelPersist = new CardModel();
		cardModelPersist = convertDtoToModel(cardRequestDto);
		//Seta um card em conta 
		accountOptional.get().setCardList(cardModelPersist);
		
		AccountModel accountModelPersist;
		
		accountModelPersist = accountRepository.save(accountOptional.get());
		
		return accountModelPersist; 
	}
	
	@Transactional
	public AccountModel getAccountModelById(Long id) {
		Optional<AccountModel> accountOptional = accountRepository.findById(id);
		accountOptional.orElseThrow(() -> new RuntimeException("Account not found."));

		return accountOptional.get();
	}

	@Transactional
	public void delete(CardModel card) {
		cardReposytory.delete(card);
	}

	public Optional<CardModel> findById(Long id) {
		return cardReposytory.findById(id);
	}


	@Transactional
	public Set<CardModel> getAllCardsDeUmaAccountById(Long id) {

		AccountModel accountModel;

		try {
			accountModel = getAccountModelById(id);
		} catch (Exception e) {
			throw new RuntimeException("Não há contas cadastradas com este id");
		}

		Set<CardModel> cards = accountModel.getCard();

		if (cards.isEmpty())
			throw new RuntimeException("Não há cartões cadastrados para esta conta");

		return cards;
	}

	public CardModel save(CardModel cardModel) {
		return cardReposytory.save(cardModel);
	}

	// Converters

	// Coverte um card em uma response DTO

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
