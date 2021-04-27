package br.com.martins.edson.spring.marvel.game.service;

import br.com.martins.edson.spring.marvel.game.dto.RootDTO;

/**
* Interface  : CharacterService
* Description: Interface exposing methods to find, fetch and map the API entities to DTO model.
*
* @author Edson Martins
*/
public interface CharacterService {
	RootDTO fetchAllCharacters();
	RootDTO findCharacterById(Long id);
}
