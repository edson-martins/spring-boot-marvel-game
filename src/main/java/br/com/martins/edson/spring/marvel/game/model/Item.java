package br.com.martins.edson.spring.marvel.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
* Class      : Item
* Description: Marvel Item child element from Comic, Serie, Story, Event model entities
*
* @author Edson Martins
*/
@Getter
@Setter
@AllArgsConstructor
public class Item {
	private String resourceURI;
	private String name;
	private String type;
}
