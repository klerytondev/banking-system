package br.com.kleryton.bankingsystem.services;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.models.CardModel;
import br.com.kleryton.bankingsystem.repositories.AccountRepository;
import br.com.kleryton.bankingsystem.repositories.CardReposytory;

@Service
public class CardService {

	
	@Autowired
	CardReposytory cardReposytory;

	@Autowired
	AccountRepository accountRepository;

	@Transactional

	public AccountModel getAccountModelById(Long id) {
		Optional<AccountModel> accountOptional = accountRepository.findById(id);
		accountOptional.orElseThrow(() -> new RuntimeException("conta não encontrada"));

		return accountOptional.get();
	}
	
	@Transactional
	public void delete(CardModel card) {
		cardReposytory.delete(card);
	}

	@Transactional
	public AccountModel createCardAccount(CardModel cardModel, Long id) {

		AccountModel accountModelPersist;
		Optional<AccountModel> accountOptional = accountRepository.findById(id);
		accountOptional.orElseThrow(() -> new RuntimeException("Conta bancária não encontrada"));
		accountOptional.get().setCard(cardModel);
		accountModelPersist = accountRepository.save(accountOptional.get());
		return accountModelPersist;
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

//	public boolean existsByNumberCard(String numberCard) {
//		return cardReposytory.existsByNumberCard(numberCard);
//	}

}
