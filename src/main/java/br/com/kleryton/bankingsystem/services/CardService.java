package br.com.kleryton.bankingsystem.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public CardModel save(CardModel card) {
		return cardReposytory.save(card);
	}

	public Page<CardModel> findAll(Pageable pageable) {
		return cardReposytory.findAll(pageable);
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
	
//	public boolean existsByNumberCard(String numberCard) {
//		return cardReposytory.existsByNumberCard(numberCard);
//	}

}
