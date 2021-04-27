package br.com.martins.edson.spring.marvel.game.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
* Class      : RootDTO
* Description: DTO model of Root payload.
*
* @author Edson Martins
*/
@Data
@AllArgsConstructor
public class RootDTO {
	private int code;
	private String status;
	private String copyright;
	private String attributionText;
	private String attributionHTML;
	private String etag;
	private DataDTO data;
}
