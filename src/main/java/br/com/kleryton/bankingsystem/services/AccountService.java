package br.com.kleryton.bankingsystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Transactional
	public AccountModel save(AccountModel account) {
		return accountRepository.save(account);
	}

	public List<AccountModel> findAll() {
		return accountRepository.findAll();
	}

	public Optional<AccountModel> findById(Long id) {
		return accountRepository.findById(id);
	}

	@Transactional
	public void delete(AccountModel account) {
		accountRepository.delete(account);
	}

	public boolean existsByRegisterId(String register_id) {
		return accountRepository.existsByRegisterId(register_id);
	}

		

}
