package br.com.martins.edson.spring.marvel.game.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
* Class      : ResultDTO
* Description: DTO model of Result payload.
*
* @author Edson Martins
*/
@Data
@AllArgsConstructor
public class ResultDTO {
	private int id;
	private String name;
	private String description;
	private Date modified;
	private ThumbnailDTO thumbnail;
}
