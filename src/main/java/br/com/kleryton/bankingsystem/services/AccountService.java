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
import br.com.kleryton.bankingsystem.requestDto.AccountRequestDto;
import br.com.kleryton.bankingsystem.responseDto.AccountResponseDto;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CardReposytory cardReposytory;

	@Transactional
	public AccountModel create(AccountModel account) {
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
	
	// Converters

		// Coverte uma account em uma response DTO

		public AccountResponseDto convertModelToDTO(AccountModel accountModel) {

			AccountResponseDto accountResponseDto = new AccountResponseDto(accountModel);
			accountModel.setCard(accountModel.getCard());
			
			return accountResponseDto;
		}
		
		// Coverte um response DTO em account

		public AccountModel convertDtoToModel(AccountRequestDto accountRequestDto) {

			AccountModel accountModel = new AccountModel();
			accountModel.setNameOwner(accountRequestDto.getNameOwner());
			accountModel.setAgencyCode(accountModel.getAgencyCode());
			accountModel.setAccountCode(accountRequestDto.getAccountCode());
			accountModel.setVerificationDigital(accountRequestDto.getVerificationDigital());
			accountModel.setRegisterId(accountRequestDto.getRegisterId());
			accountModel.setCard(accountRequestDto.getCardModel());
			
			return accountModel;
		}

}
