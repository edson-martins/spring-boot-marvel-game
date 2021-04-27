package br.com.martins.edson.spring.marvel.game.dto;

import java.util.List;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

/**
* Class      : ArenaDTO
* Description: DTO model of Arena payload.
*
* @author Edson Martins
*/
@Data
public class ArenaDTO {

	@Range(min = 1, max = 10, message = "The seed value must be between 1-10.")
	private int seed;
	private List<SuperHeroDTO> superheros;
}
