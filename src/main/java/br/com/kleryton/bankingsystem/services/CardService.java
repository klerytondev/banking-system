package br.com.kleryton.bankingsystem.services;

import java.util.HashSet;
import java.util.List;
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

	/*
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query
	 * -methods
	 */

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

	public Optional<CardModel> findById(Long id) {
		return cardReposytory.findById(id);
	}

	@Transactional
	public void delete(CardModel card) {
		cardReposytory.delete(card);
	}

	@Transactional
	public AccountModel createCardAccount(CardModel cardModel, Long id) {

		Set<CardModel> listCards = new HashSet<>();
		AccountModel accountModelPersist;
		Optional<AccountModel> accountOptional = accountRepository.findById(id);
		accountOptional.orElseThrow(() -> new RuntimeException("Conta bancária não encontrada"));

		cardModel.setAccount(accountOptional.get());
		listCards.add(cardModel);
		accountOptional.get().setCard(listCards);
		accountModelPersist = accountRepository.save(accountOptional.get());

		return accountModelPersist;
	}

	@Transactional
	public Set<CardModel> getAllCardsDeUmaAccountById(Long id) {

		AccountModel accountModel;

		try {
			accountModel = getAccountModelById(id);
		} catch (Exception e) {
			throw new RuntimeException("Não há cliente cadastrado com este id");
		}

		Set<CardModel> cards = accountModel.getCard();

		if (cards.isEmpty())
			throw new RuntimeException("Não há endereços cadastrados para este cliente");

		return cards;
	}

//	public boolean existsByNumberCard(String numberCard) {
//		return cardReposytory.existsByNumberCard(numberCard);
//	}

}
