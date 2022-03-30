package br.com.kleryton.bankingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kleryton.bankingsystem.models.AccountModel;

//Cria um beans para persisti no banco
@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long> {
	
	//Metodo de consulta ao banco de dados pelo registerId
	Boolean existsByRegisterId(String registerId);

}
