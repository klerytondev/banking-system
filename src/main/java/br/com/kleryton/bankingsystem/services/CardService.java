package br.com.kleryton.bankingsystem.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.kleryton.bankingsystem.models.CardModel;
import br.com.kleryton.bankingsystem.repositories.CardReposytory;

@Service
public class CardService {

	@Autowired
	 CardReposytory cardReposytory;

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
	
//	public boolean existsByNumberCard(String numberCard) {
//		return cardReposytory.existsByNumberCard(numberCard);
//	}

}
