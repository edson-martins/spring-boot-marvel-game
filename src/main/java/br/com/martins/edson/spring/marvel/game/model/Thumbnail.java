package br.com.martins.edson.spring.marvel.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
* Class      : Thumbnail
* Description: Marvel Thumbnail child element from Result model entity
*
* @author Edson Martins
*/
@Getter
@Setter
@AllArgsConstructor
public class Thumbnail {
	private String path;
	private String extension;
}
