package br.com.kleryton.bankingsystem.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kleryton.bankingsystem.models.AccountModel;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, UUID> {
	
	boolean existsByRegisterId(String registerId);

}
