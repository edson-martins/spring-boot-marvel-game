package br.com.martins.edson.spring.marvel.game.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
* Class      : ThumbnailDTO
* Description: DTO model of Thumbnail payload.
*
* @author Edson Martins
*/
@Data
@AllArgsConstructor
public class ThumbnailDTO {
	private String path;
	private String extension;
}
