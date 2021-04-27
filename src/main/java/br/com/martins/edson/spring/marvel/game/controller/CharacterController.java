package br.com.martins.edson.spring.marvel.game.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.martins.edson.spring.marvel.game.dto.RootDTO;
import br.com.martins.edson.spring.marvel.game.service.impl.CharacterServiceImpl;
import lombok.AllArgsConstructor;

/**
* This is the controller exposing the endpoint /v1/arena/characters that will retrieve
* character(s) data from Marvel API
*
* <p>https://developer.marvel.com
*
* @author Edson Martins
*/
@RestController
@RequestMapping("/v1/arena/characters")
@AllArgsConstructor
public class CharacterController {
	
	private final CharacterServiceImpl characterService;
	
	/**
	* Entry point used to fetch all characters from Marvel API.
	*
	* @endpoint /all
	* @return ResponseEntity<RootDTO> including the HTTP status and the payload
	* based in the RootDTO model with character content found.
	*/
	@GetMapping("/all")
	public ResponseEntity<RootDTO> fetchAllCharacters() {
		return ResponseEntity.ok(characterService.fetchAllCharacters());
	}
	
	/**
	* Entry point used to find and retrieve a character based in the ID from Marvel API.
	*
	* @endpoint /{id}
	* @return ResponseEntity<RootDTO> including the HTTP status and the payload
	* based in the RootDTO model with character content found.
	*/
	@GetMapping("/{id}")
	public ResponseEntity<RootDTO> findCharacterById(Long id) {
		return ResponseEntity.ok(characterService.findCharacterById(id));
	}
}
