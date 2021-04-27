package br.com.martins.edson.spring.marvel.game.dto;

import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
* Class      : WinnerDTO
* Description: DTO model of Winner payload.
*
* @author Edson Martins
*/
@Data
@RequiredArgsConstructor
public class WinnerDTO {
	
	private final int id;
	private final String name;
	private final String description;
	private final Date modified;
	private final ThumbnailDTO thumbnail;
	protected String word;

}
