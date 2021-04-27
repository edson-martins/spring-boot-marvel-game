package br.com.martins.edson.spring.marvel.game.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
* Class      : Event
* Description: Marvel Event child element from Result model entity
*
* @author Edson Martins
*/
@Getter
@Setter
@AllArgsConstructor
public class Event {
	private int available;
	private String collectionURI;
	private List<Item> items;
	private int returned;
}
