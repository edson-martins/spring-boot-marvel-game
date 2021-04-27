package br.com.martins.edson.spring.marvel.game.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
* Class      : Comic
* Description: Marvel Comic child element from Result model entity
*
* @author Edson Martins
*/
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comic {
	private int available;
	private String collectionURI;
	private List<Item> items;
	private int returned;
}
