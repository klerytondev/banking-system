package br.com.kleryton.bankingsystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.repositories.AccountRepository;
import br.com.kleryton.bankingsystem.repositories.CardReposytory;
import br.com.kleryton.bankingsystem.requestDto.AccountRequestDto;
import br.com.kleryton.bankingsystem.responseDto.AccountResponseDto;
import br.com.kleryton.bankingsystem.services.exceptions.ConflictDeDadosException;
import br.com.kleryton.bankingsystem.services.exceptions.IntegridadeDeDadosException;
import br.com.kleryton.bankingsystem.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CardReposytory cardReposytory;

	@Transactional
	// Create account
	public AccountModel create(AccountRequestDto accountRequestDto) {

		AccountModel accountModel = convertDtoToModel(accountRequestDto);

		// Verifica se accountCode ou RegisteId já está em uso no banco
		try {
			accountRepository.save(accountModel);
		} catch (DataIntegrityViolationException e) {
			throw new ConflictDeDadosException("accoundCode or RegisterId is already in use!");
		}
		return accountModel;
	}

	// Read All
	@Transactional
	public List<AccountModel> findAll() {

		// Verifica se existe contas no banco, caso contrario retorna exception
		if (accountRepository.findAll().isEmpty()) {
			throw new ObjetoNaoEncontradoException("Accounts not found!");
		}
		// Salva accounts existentes no banco de dados em uma lista de accounts
		List<AccountModel> accountModelList = new ArrayList<>();
		for (AccountModel accountModel : accountRepository.findAll()) {
			accountModelList.add(accountModel);
		}
		return accountModelList;
	}

	// Read One by Id
	@Transactional
	public Optional<AccountModel> findById(Long id) {

		// Verifica se a account existe no banco
		Optional<AccountModel> accountOptional = accountRepository.findById(id);
		accountOptional.orElseThrow(() -> new ObjetoNaoEncontradoException("Account not found."));

		return accountRepository.findById(id);
	}

	// Update by id
	@Transactional
	public AccountResponseDto updateAcoount(Long id, AccountRequestDto accountRequestDto) {

		// Busca no banco de dados se existe account com o id passado
		Optional<AccountModel> accountModelOptional = accountRepository.findById(id);
		accountModelOptional.orElseThrow(() -> new ObjetoNaoEncontradoException("Account not found."));

		// Atualiza os campos da account existentes

		accountModelOptional.get().setNameOwner(accountRequestDto.getNameOwner());
		accountModelOptional.get().setAgencyCode(accountRequestDto.getAgencyCode());
		accountModelOptional.get().setAccountCode(accountRequestDto.getAccountCode());
		accountModelOptional.get().setVerificationDigital(accountRequestDto.getVerificationDigital());
		accountModelOptional.get().setRegisterId(accountRequestDto.getRegisterId());

		// Verifica se accountCode ou RegisteId já está em uso no banco
		try {
			accountRepository.save(accountModelOptional.get());
		} catch (Exception e) {
			throw new DataIntegrityViolationException("accoundCode or RegisterId is already in use!");
		}

		AccountResponseDto accountResponseDto = convertModelToDTO(accountModelOptional.get());

		return accountResponseDto;

	}

	// Delete by id
	@Transactional
	public String delete(Long id) {

		Optional<AccountModel> accountModelOptional = accountRepository.findById(id);

		// Verifica se account existe
		if (!accountModelOptional.isPresent()) {
			throw new ObjetoNaoEncontradoException("Account not found.");
		}
		// Só é possivel excluir uma account se não existir nenhuma card associado a
		// account
		// Verifica se existe uma card associado a uma account
		else if (!(accountModelOptional.get().getCard() == null || accountModelOptional.get().getCard().isEmpty())) {
			throw new IntegridadeDeDadosException("The account has cards. Unable to delete!");
		}

		accountRepository.deleteById(id);
		return "Account deleted successfully.";
	}

	// Converters

	// Coverte uma account em uma response DTO
	public AccountResponseDto convertModelToDTO(AccountModel accountModel) {

		AccountResponseDto accountResponseDto = new AccountResponseDto(accountModel);
		accountModel.setCard(accountModel.getCard());

		return accountResponseDto;
	}

	// Coverte um request DTO em account
	public AccountModel convertDtoToModel(AccountRequestDto accountRequestDto) {

		AccountModel accountModel = new AccountModel();
		accountModel.setNameOwner(accountRequestDto.getNameOwner());
		accountModel.setAgencyCode(accountRequestDto.getAgencyCode());
		accountModel.setAccountCode(accountRequestDto.getAccountCode());
		accountModel.setVerificationDigital(accountRequestDto.getVerificationDigital());
		accountModel.setRegisterId(accountRequestDto.getRegisterId());
		accountModel.setCard(accountRequestDto.getCardModel());

		return accountModel;
	}

}
