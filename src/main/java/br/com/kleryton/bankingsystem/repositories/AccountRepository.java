package br.com.kleryton.bankingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kleryton.bankingsystem.models.Account;

public interface AccountRepository {
	public interface IClienteRepository extends JpaRepository<Account, Long> {

	}

}