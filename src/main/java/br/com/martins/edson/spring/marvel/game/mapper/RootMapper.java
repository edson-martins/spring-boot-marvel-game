package br.com.martins.edson.spring.marvel.game.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import br.com.martins.edson.spring.marvel.game.dto.RootDTO;
import br.com.martins.edson.spring.marvel.game.model.Root;

/**
* Interface  : RootMapper
* Description: MapStruct mapper from Root to RootDTO model.
*
* @author Edson Martins
*/
@Mapper(componentModel = "spring")
@Component
public interface RootMapper {
	public static final RootMapper INSTANCE = Mappers.getMapper(RootMapper.class);
	RootDTO toRootDTO(Root root);
}