package br.com.martins.edson.spring.marvel.game.service;

import br.com.martins.edson.spring.marvel.game.dto.ArenaDTO;
import br.com.martins.edson.spring.marvel.game.dto.WinnerDTO;

/**
* Interface  : CharacterService
* Description: Interface exposing methods to find the winner (game) based in the Arena
*              payload (ArenaDTO) and convert to the WinnerDTO model.
*
* @author Edson Martins
*/
public interface GameService {
	WinnerDTO findWinner(ArenaDTO arena);
}
