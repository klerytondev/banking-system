package br.com.kleryton.bankingsystem.services;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.kleryton.bankingsystem.models.CardModel;
import br.com.kleryton.bankingsystem.repositories.CardReposytory;

public class CardService {

	final CardReposytory cardReposytory;

	public CardService(CardReposytory cardReposytory) {
		this.cardReposytory = cardReposytory;
	}

	@Transactional
	public CardModel save(CardModel card) {
		return cardReposytory.save(card);
	}

	public Page<CardModel> findAll(Pageable pageable) {
		return cardReposytory.findAll(pageable);
	}

	public Optional<CardModel> findById(UUID id) {
		return cardReposytory.findById(id);
	}

	@Transactional
	public void delete(CardModel card) {
		cardReposytory.delete(card);
	}

}
