package br.com.martins.edson.spring.marvel.game.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.martins.edson.spring.marvel.game.dto.WinnerDTO;
import br.com.martins.edson.spring.marvel.game.service.impl.GameServiceImpl;
import br.com.martins.edson.spring.marvel.game.test.util.GameCreator;

@ExtendWith(SpringExtension.class)
class GameControllerTest {

	@InjectMocks
	private GameController gameController;
	
	@Mock
	private GameServiceImpl gameServiceMock;
	
	@BeforeEach
	void setUp() throws Exception {
		
		BDDMockito.when(gameServiceMock.findWinner(ArgumentMatchers.any())).thenReturn(GameCreator.createWinner());
	}

	@Test
	@DisplayName("Play the game passing the seed value and two heros")
	void play() {
		
		WinnerDTO winner = gameController.play(null).getBody();
		
		Assertions.assertThat(winner).isNotNull();
		Assertions.assertThat(winner.getWord()).isEqualTo("AIM");
	}

}
