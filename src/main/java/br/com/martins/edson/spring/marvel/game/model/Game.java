package br.com.martins.edson.spring.marvel.game.model;

import java.util.List;

import lombok.Data;

@Data
public class Game {

	private int seed;
	private List<Hero> superheros;
}
