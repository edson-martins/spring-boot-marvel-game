package br.com.martins.edson.spring.marvel.game.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
* Class      : Root
* Description: Marvel Root model entity
*
* @author Edson Martins
*/
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
	private int code;
	private String status;
	private String copyright;
	private String attributionText;
	private String attributionHTML;
	private String etag;
	private Data data;
	
}