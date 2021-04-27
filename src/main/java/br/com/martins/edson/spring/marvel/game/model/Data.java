package br.com.martins.edson.spring.marvel.game.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
* Class      : Root
* Description: Marvel Data child element from Root model entity
*
* @author Edson Martins
*/
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	private int offset;
	private int limit;
	private int total;
	private int count;
	private List<Result> results;
}
