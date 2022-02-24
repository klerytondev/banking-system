package br.com.kleryton.bankingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kleryton.bankingsystem.models.Card;

public interface CardReposytory {
	
	public interface ICardRepository extends JpaRepository<Card, Long> {
		
	}

}
