package br.com.martins.edson.spring.marvel.game.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import br.com.martins.edson.spring.marvel.game.dto.ArenaDTO;
import br.com.martins.edson.spring.marvel.game.model.Game;

/**
* Interface  : ArenaMapper
* Description: MapStruct mapper from ArenaDTO to Game model.
*
* @author Edson Martins
*/
@Mapper(componentModel = "spring")
@Component
public interface ArenaMapper {
	
	public static final ArenaMapper INSTANCE = Mappers.getMapper(ArenaMapper.class);
	Game toGame(ArenaDTO arena);
}
