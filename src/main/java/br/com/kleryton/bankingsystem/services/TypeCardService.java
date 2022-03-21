package br.com.kleryton.bankingsystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kleryton.bankingsystem.models.TypeCardModel;
import br.com.kleryton.bankingsystem.repositories.TypeCardRepository;
import br.com.kleryton.bankingsystem.requestDto.TypeCardRequestDto;
import br.com.kleryton.bankingsystem.responseDto.TypeCardResponseDto;
import br.com.kleryton.bankingsystem.services.exceptions.ConflictDeDadosException;
import br.com.kleryton.bankingsystem.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class TypeCardService {

	@Autowired
	TypeCardRepository typeCardRepository;

	// CreateTypeCard
	@Transactional
	public TypeCardResponseDto createTypeCard(TypeCardRequestDto typeCardRequestDto) {

		Optional<TypeCardModel> typeCardModelOptional = typeCardRepository
				.findByName(convertDtoToModel(typeCardRequestDto).getName());

		// Verifica se já existe um typeCard no banco de dados antes de criar um novo
		// tipo
		if (typeCardModelOptional.isPresent()) {
			throw new ConflictDeDadosException("Card type already exists.");
		}

		TypeCardModel typeCardModelPersisted = typeCardRepository.save(convertDtoToModel(typeCardRequestDto));
		return convertModelToDTO(typeCardModelPersisted);

	}

	// Read All com List
	@Transactional
	public List<TypeCardResponseDto> getAll() {

		List<TypeCardResponseDto> ListTypeCards = new ArrayList<>();
		for (TypeCardModel type : typeCardRepository.findAll()) {
			ListTypeCards.add(convertModelToDTO(type));
		}
		return ListTypeCards;
	}

	// Read One by Id
	@Transactional
	public TypeCardResponseDto getById(Long id) {

		// Verifica se existe um typeCard no banco de acordo com o id passado
		Optional<TypeCardModel> typeCardModelOptional = typeCardRepository.findById(id);
		typeCardModelOptional.orElseThrow(() -> new ObjetoNaoEncontradoException("Type Card not found."));

		return convertModelToDTO(typeCardModelOptional.get());
	}

	// Update by Name
	@Transactional
	public TypeCardResponseDto updateByName(String name, TypeCardRequestDto typeCardRequestDto) {

		Optional<TypeCardModel> typeCarModelOptional = typeCardRepository.findByName(name);
		typeCarModelOptional.orElseThrow(() -> new ObjetoNaoEncontradoException("Type Card not found"));

		// TODO validação pra nao deixar entrar duplicado
		// java.sql.SQLIntegrityConstraintViolationException
		typeCarModelOptional.get().setName(typeCardRequestDto.getName());
		return convertModelToDTO(typeCardRepository.save(typeCarModelOptional.get()));
	}

	// Delete By Name
	@Transactional
	public void deleteByName(String name) {

		Optional<TypeCardModel> typeCardModel = typeCardRepository.findByName(name);
		typeCardModel.orElseThrow(() -> new ObjetoNaoEncontradoException("Type Card not found"));

		typeCardRepository.deleteById(typeCardModel.get().getId());

	}

	// Converters

	// Coverte uma TypeCard em uma response DTO

	private TypeCardResponseDto convertModelToDTO(TypeCardModel typeCardModel) {

		TypeCardResponseDto typeCardResponseDto = new TypeCardResponseDto();
		typeCardResponseDto.setId(typeCardModel.getId());
		typeCardResponseDto.setName(typeCardModel.getName());

		return typeCardResponseDto;
	}

	// Coverte response DTO em um typeCard

	private TypeCardModel convertDtoToModel(TypeCardRequestDto typeCardRequestDto) {

		TypeCardModel typeCardModel = new TypeCardModel();
		typeCardModel.setName(typeCardRequestDto.getName());

		return typeCardModel;
	}

}
