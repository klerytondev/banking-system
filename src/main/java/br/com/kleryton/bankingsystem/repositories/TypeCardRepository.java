package br.com.kleryton.bankingsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kleryton.bankingsystem.models.TypeCardModel;

@Repository
public interface TypeCardRepository extends JpaRepository<TypeCardModel, Long>{
	
	//Metodo de consulta ao banco de dados pelo name
	Optional<TypeCardModel> findByName(String name);

}
