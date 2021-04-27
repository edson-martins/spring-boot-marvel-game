package br.com.martins.edson.spring.marvel.game.test.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Date;

import br.com.martins.edson.spring.marvel.game.dto.ArenaDTO;
import br.com.martins.edson.spring.marvel.game.dto.SuperHeroDTO;
import br.com.martins.edson.spring.marvel.game.dto.ThumbnailDTO;
import br.com.martins.edson.spring.marvel.game.dto.WinnerDTO;

public class GameCreator {

	public static ArenaDTO createArena() {
		
		
		SuperHeroDTO firstHero = new SuperHeroDTO();
		firstHero.setName("A-Bomb (HAS)");
		
		SuperHeroDTO secondHero = new SuperHeroDTO();
		secondHero.setName("A.I.M.");
		
		ArenaDTO arena = new ArenaDTO();
		arena.setSeed(1);
		arena.setSuperheros(Arrays.asList(firstHero, secondHero));
		
		return arena;
	}
	
	public static WinnerDTO createWinner() {

		WinnerDTO winner = new WinnerDTO(1009144, 
				                         "A.I.M.", 
				                         "AIM is a terrorist organization bent on destroying the world.", 
				                         Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)), 
				                         new ThumbnailDTO("http://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec", 
				                        		          "jpg"));
		winner.setWord("AIM");
		
		return winner;
	}
	
	public static ArenaDTO createArenaWithOneNonMarvelHero() {
		
		SuperHeroDTO firstHero = new SuperHeroDTO();
		firstHero.setName("Fake Marvel Hero");
		
		SuperHeroDTO secondHero = new SuperHeroDTO();
		secondHero.setName("A-Bomb (HAS)");
		
		ArenaDTO arena = new ArenaDTO();
		arena.setSeed(1);
		arena.setSuperheros(Arrays.asList(firstHero, secondHero));
		
		return arena;
	}
	
	public static ArenaDTO createArenaWithTwoNonMarvelHero() {
		
		SuperHeroDTO firstHero = new SuperHeroDTO();
		firstHero.setName("Fake Marvel Hero 1");
		
		SuperHeroDTO secondHero = new SuperHeroDTO();
		secondHero.setName("Fake Marvel Hero 2");
		
		ArenaDTO arena = new ArenaDTO();
		arena.setSeed(1);
		arena.setSuperheros(Arrays.asList(firstHero, secondHero));
		
		return arena;
	}
}
