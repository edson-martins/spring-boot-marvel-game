package br.com.martins.edson.spring.marvel.game.service;

import br.com.martins.edson.spring.marvel.game.model.Root;

/**
* Interface  : ApiExternalService
* Description: Interface exposing methods to find and fetch Root Marvel entity.
*
* @author Edson Martins
*/
public interface ApiExternalService {
	Root findRootObjectByName(String name);
	Root findRootObjectById(Long id);
	Root fetchAllRootObject();
	
}
