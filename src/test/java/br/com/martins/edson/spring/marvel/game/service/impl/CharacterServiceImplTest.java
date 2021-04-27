package br.com.martins.edson.spring.marvel.game.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.martins.edson.spring.marvel.game.dto.RootDTO;
import br.com.martins.edson.spring.marvel.game.mapper.RootMapper;
import br.com.martins.edson.spring.marvel.game.test.util.RootCreator;

@ExtendWith(SpringExtension.class)
class CharacterServiceImplTest {

	@InjectMocks
	private CharacterServiceImpl characterService;

	@Mock
	private MarvelApiExternalServiceImpl marvelApiMock;

	@Spy
	private RootMapper rootMapper = Mappers.getMapper(RootMapper.class);

	@BeforeEach
	void setupCharactersDataForServiceTest() throws Exception {

		// -- ----------------------------------------------------------
		// fetchAllCharacters
		// -- ----------------------------------------------------------
		BDDMockito.when(marvelApiMock.fetchAllRootObject()).thenReturn(RootCreator.retrieveAllRoot());
		// -- ----------------------------------------------------------
		// retrieveAllCharactersById
		// -- ----------------------------------------------------------
		BDDMockito.when(marvelApiMock.findRootObjectById(1009144L))
				.thenReturn(RootCreator.findRootDataById());
	}

	@Test
	@DisplayName("Return all characters")
	void fetchAllCharacters() {
		RootDTO root = characterService.fetchAllCharacters();
		
		Assertions.assertThat(root).isNotNull();
		Assertions.assertThat(root.getData()).isNotNull();
		Assertions.assertThat(root.getData().getResults()).isNotEmpty();
	}
	
	@Test 
	@DisplayName("Find character by ID")
	void findCharacterById() {
		RootDTO root = characterService.findCharacterById(1009144L);
		
		Assertions.assertThat(root).isNotNull();
		Assertions.assertThat(root.getData()).isNotNull();
		Assertions.assertThat(root.getData().getResults()).isNotEmpty();
		Assertions.assertThat(root.getData().getResults()[0].getId()).isEqualByComparingTo(1009144);
	}

}
