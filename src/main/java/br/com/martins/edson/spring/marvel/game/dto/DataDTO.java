package br.com.martins.edson.spring.marvel.game.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
* Class      : DataDTO
* Description: DTO model of Data payload.
*
* @author Edson Martins
*/
@Data
@AllArgsConstructor
public class DataDTO {
	private int offset;
	private int limit;
	private int total;
	private int count;
	private ResultDTO[] results;
}
