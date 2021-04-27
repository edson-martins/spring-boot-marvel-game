package br.com.martins.edson.spring.marvel.game.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import br.com.martins.edson.spring.marvel.game.dto.WinnerDTO;
import br.com.martins.edson.spring.marvel.game.model.Result;

/**
* Interface  : WinnerMapper
* Description: MapStruct mapper from Result to WinnerDTO model.
*
* @author Edson Martins
*/
@Mapper(componentModel = "spring")
@Component
public interface WinnerMapper {
	public static final WinnerMapper INSTANCE = Mappers.getMapper(WinnerMapper.class);
	
	@Mapping(target = "word", ignore = true)
	WinnerDTO toWinnerDTO(Result result);
}
