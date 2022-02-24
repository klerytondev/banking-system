package br.com.kleryton.bankingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeCard {
	
	public interface ITypeCardRepository extends JpaRepository<TypeCard, Long> {

	}

}
