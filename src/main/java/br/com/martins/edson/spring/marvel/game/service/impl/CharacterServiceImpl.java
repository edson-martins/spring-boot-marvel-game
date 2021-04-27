package br.com.martins.edson.spring.marvel.game.service.impl;

import org.springframework.stereotype.Service;

import br.com.martins.edson.spring.marvel.game.dto.RootDTO;
import br.com.martins.edson.spring.marvel.game.mapper.RootMapper;
import br.com.martins.edson.spring.marvel.game.service.CharacterService;
import lombok.RequiredArgsConstructor;

/**
* Class      : CharacterServiceImpl
* Interface  : CharacterService
* Description: Implementation of CharacterService interface.
*
* @author Edson Martins
*/
@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

	private final RootMapper rootMapper;
	private final MarvelApiExternalServiceImpl marvelApi;
	
	@Override
	public RootDTO fetchAllCharacters() {
		return rootMapper.toRootDTO(marvelApi.fetchAllRootObject());
	}

	@Override
	public RootDTO findCharacterById(Long id) {
		return rootMapper.toRootDTO(marvelApi.findRootObjectById(id));
	}	
}