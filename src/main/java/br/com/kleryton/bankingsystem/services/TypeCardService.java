package br.com.kleryton.bankingsystem.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kleryton.bankingsystem.models.TypeCardModel;
import br.com.kleryton.bankingsystem.repositories.TypeCardRepository;

@Service
public class TypeCardService {
	
	@Autowired
	TypeCardRepository typeCardRepository;
	
	@Transactional
    public TypeCardModel createTypeCard(TypeCardModel typeCardModel) {
        return typeCardRepository.save(typeCardModel);
	}
}
