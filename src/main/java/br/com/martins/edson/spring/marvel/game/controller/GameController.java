package br.com.martins.edson.spring.marvel.game.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.martins.edson.spring.marvel.game.dto.ArenaDTO;
import br.com.martins.edson.spring.marvel.game.dto.WinnerDTO;
import br.com.martins.edson.spring.marvel.game.service.impl.GameServiceImpl;
import lombok.AllArgsConstructor;

/**
* This is the controller exposing the endpoint /v1/arena/games that will start
* the game. Basically the game start with a payload:
* {
*    seed: <value between 1-10> - this seed will be used to look at word position
*    							  from character description by the Marvel API.
*    superheros: [
*      {
*        "name": <hero name 1>
*      },
*      {
*        "name": <hero name 2>
*      }
*    ]
* }
*
* <p>https://developer.marvel.com
*
* @author Edson Martins
*/

@RestController
@RequestMapping("/v1/arena/games")
@AllArgsConstructor
public class GameController {

	private final GameServiceImpl gameService;
	
	/**
	* Entry point used to start the arena game.
	*
	* @endpoint /play
	* @param  ArenaDTO arena with the payload including seed and super hero names.
	* @return ResponseEntity<WinnerDTO> including the HTTP status and the payload
	* based in the WinnerDTO with the winner information. 
	*/
	@GetMapping("/play")
	public ResponseEntity<WinnerDTO> play(@Valid @RequestBody ArenaDTO arena) {
		return ResponseEntity.ok(gameService.findWinner(arena));
	}
}
