package br.com.martins.edson.spring.marvel.game.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
* Class      : Result
* Description: Marvel Result child element from Root model entity
*
* @author Edson Martins
*/
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	private int id;
	private String name;
	private String description;
	private Date modified;
	private Thumbnail thumbnail;
	private String resourceURI;
	private Comic comics;
	private Serie series;
	private Story stories;
	private Event events;
	private List<Url> urls;
}
