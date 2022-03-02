package br.com.kleryton.bankingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kleryton.bankingsystem.models.CardModel;

@Repository
public interface CardReposytory extends JpaRepository<CardModel, Long> {

//	boolean existsByNumberCard(String numberCard);
}
