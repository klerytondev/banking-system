package br.com.kleryton.bankingsystem.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeCard extends JpaRepository<TypeCard, UUID>{
	

}
