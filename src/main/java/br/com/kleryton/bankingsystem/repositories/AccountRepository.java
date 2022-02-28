package br.com.kleryton.bankingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kleryton.bankingsystem.models.AccountModel;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long> {
	
	boolean existsByRegisterId(String registerId);

}
