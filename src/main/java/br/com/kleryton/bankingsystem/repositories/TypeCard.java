package br.com.kleryton.bankingsystem.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kleryton.bankingsystem.models.TypeCardModel;

@Repository
public interface TypeCard extends JpaRepository<TypeCardModel, UUID>{
	

}
