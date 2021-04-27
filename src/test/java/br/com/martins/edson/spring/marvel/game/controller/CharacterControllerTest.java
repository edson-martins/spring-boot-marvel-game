package br.com.martins.edson.spring.marvel.game.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.martins.edson.spring.marvel.game.dto.RootDTO;
import br.com.martins.edson.spring.marvel.game.service.impl.CharacterServiceImpl;
import br.com.martins.edson.spring.marvel.game.test.util.CharacterCreator;

@ExtendWith(SpringExtension.class)
class CharacterControllerTest {
	
	@InjectMocks
	private CharacterController characterController;

	@Mock
	private CharacterServiceImpl characterServiceMock;
	
	@BeforeEach
	void setupCharactersDataForControllerTest() {
		
		//-- ----------------------------------------------------------
		// fetchAllCharacters
		//-- ----------------------------------------------------------
		BDDMockito.when(characterServiceMock.fetchAllCharacters())
				  .thenReturn(CharacterCreator.retrieveAllCharacters());
		//-- ----------------------------------------------------------
		// retrieveAllCharactersById
		//-- ----------------------------------------------------------
		BDDMockito.when(characterServiceMock.findCharacterById(1011334L))
				  .thenReturn(CharacterCreator.retrieveCharactersById());
	}
	
	@Test
	@DisplayName("Fetch All Characters from External API (Marvel API)")
	void fetchAllCharacters() {
		
		RootDTO characters = characterController.fetchAllCharacters().getBody();
		
		Assertions.assertThat(characters).isNotNull();
		Assertions.assertThat(characters.getData()).isNotNull();
		Assertions.assertThat(characters.getData().getResults()).isNotEmpty();
	}
	
	@Test
	@DisplayName("Fetch All Characters from External API (Marvel API) by id")
	void retrieveAllCharactersById() {
		
		RootDTO characters = characterController.findCharacterById(1011334L).getBody();
		
		Assertions.assertThat(characters).isNotNull();
		Assertions.assertThat(characters.getData()).isNotNull();
		Assertions.assertThat(characters.getData().getResults()).isNotEmpty();
		Assertions.assertThat(characters.getData().getResults()[0].getId()).isEqualByComparingTo(1011334);
	}
}
