package br.com.kleryton.bankingsystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.repositories.AccountRepository;
import br.com.kleryton.bankingsystem.repositories.CardReposytory;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CardReposytory cardReposytory;

	@Transactional
	public AccountModel save(AccountModel account) {
		return accountRepository.save(account);
	}

	public List<AccountModel> findAll() {
		
		List<AccountModel> accountModelList = new ArrayList<>();
		for (AccountModel accountModel : accountRepository.findAll()) {
			accountModelList.add(accountModel);
		}
		return accountModelList;
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
