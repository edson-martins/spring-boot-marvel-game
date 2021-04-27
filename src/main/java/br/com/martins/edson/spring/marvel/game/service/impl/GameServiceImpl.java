package br.com.martins.edson.spring.marvel.game.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.martins.edson.spring.marvel.game.dto.ArenaDTO;
import br.com.martins.edson.spring.marvel.game.dto.WinnerDTO;
import br.com.martins.edson.spring.marvel.game.mapper.ArenaMapper;
import br.com.martins.edson.spring.marvel.game.mapper.WinnerMapper;
import br.com.martins.edson.spring.marvel.game.model.Game;
import br.com.martins.edson.spring.marvel.game.model.Hero;
import br.com.martins.edson.spring.marvel.game.model.Result;
import br.com.martins.edson.spring.marvel.game.model.Root;
import br.com.martins.edson.spring.marvel.game.service.GameService;
import lombok.RequiredArgsConstructor;

/**
* Class      : GameServiceImpl
* Interface  : GameService
* Description: Implementation of GameService interface.
*
* @author Edson Martins
*/
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

	@Value("${arena.api.url}")
	String arenaApiUrl;

	private final ArenaMapper arenaMapper;
	private final WinnerMapper winnerMapper;
	private final MarvelApiExternalServiceImpl marvelApi;

	@Override
	public WinnerDTO findWinner(ArenaDTO arena) {

		Game game = arenaMapper.toGame(arena);
		return isWinner(game.getSuperheros(), game.getSeed());
	}

	private WinnerDTO isWinner(List<Hero> heros, int seed) {

		WinnerDTO winnerDTO  = null;
		String[] description = null;
		int wordLength = -1;

		for (Hero hero : CollectionUtils.emptyIfNull(heros)) {

			Root root = marvelApi.findRootObjectByName(hero.getName());

			if (null != root) {
				
				for (Result result : root.getData().getResults()) {
					
					description = (null != result) ? result.getDescription().split(" ") : new String[] {""};

					if (description.length > 1 && seed <= description.length
							&& description[seed - 1].length() > wordLength) {

						winnerDTO = mountWinner(result, description, seed);
						wordLength = description[seed - 1].length();
					}

				}
				if (null != description && description[seed - 1].matches("gamma|radioactive")) {
					break;
				}
			}
		}

		return winnerDTO;
	}

	private WinnerDTO mountWinner(Result result, String[] description, int seed) {

		WinnerDTO winnerDTO = winnerMapper.toWinnerDTO(result);
		winnerDTO.setWord(description[seed - 1]);
		return winnerDTO;

	}

}
