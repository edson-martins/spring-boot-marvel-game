package br.com.martins.edson.spring.marvel.game.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.martins.edson.spring.marvel.game.dto.ArenaDTO;
import br.com.martins.edson.spring.marvel.game.dto.WinnerDTO;
import br.com.martins.edson.spring.marvel.game.mapper.ArenaMapper;
import br.com.martins.edson.spring.marvel.game.mapper.WinnerMapper;
import br.com.martins.edson.spring.marvel.game.test.util.GameCreator;
import br.com.martins.edson.spring.marvel.game.test.util.RootCreator;

@ExtendWith(SpringExtension.class)
class GameServiceImplTest {

	@InjectMocks
	private GameServiceImpl gameService;

	@Mock
	private MarvelApiExternalServiceImpl marvelApiMock;

	@Spy
	private ArenaMapper arenaMapper = Mappers.getMapper(ArenaMapper.class);

	@Spy
	private WinnerMapper winnerMapper = Mappers.getMapper(WinnerMapper.class);
	
	@BeforeEach
	void setGameServiceTestUsingOneFakeMarvelHero() throws Exception {

		// -- ----------------------------------------------------------
		// fetchAllCharacters
		// -- ----------------------------------------------------------
		BDDMockito.when(marvelApiMock.findRootObjectByName(ArgumentMatchers.any())).thenReturn(RootCreator.findAllAndReturnOneNullResultData());
	}
	
	@Test
	@DisplayName("Find the winner calling the api with a non marvel hero, and then two non marvel hero.")
	void findAllAndReturnOneNullResultData() {
		ArenaDTO arena = GameCreator.createArenaWithOneNonMarvelHero();
		WinnerDTO winner = gameService.findWinner(arena);
		Assertions.assertThat(winner).isNotNull();
		
		BDDMockito.when(marvelApiMock.findRootObjectByName(ArgumentMatchers.any())).thenReturn(RootCreator.findAllAndReturnTwoNullResultData());
		arena = GameCreator.createArenaWithTwoNonMarvelHero();
		winner = gameService.findWinner(arena);
		Assertions.assertThat(winner).isNull();
	}
}
