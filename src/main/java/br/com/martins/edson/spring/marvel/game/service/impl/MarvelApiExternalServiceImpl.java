package br.com.martins.edson.spring.marvel.game.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.martins.edson.spring.marvel.game.model.Root;
import br.com.martins.edson.spring.marvel.game.service.ApiExternalService;
import br.com.martins.edson.spring.marvel.game.util.ApiHelper;
import lombok.RequiredArgsConstructor;

/**
* Class      : MarvelApiExternalServiceImpl
* Interface  : ApiExternalService
* Description: Implementation of ApiExternalService interface.
*
* @author Edson Martins
*/
@Service
@RequiredArgsConstructor
public class MarvelApiExternalServiceImpl implements ApiExternalService {
	
	private final ApiHelper helper;
	private final RestTemplate restTemplate;
	
	@Value("${arena.api.url}")
	String url;

	@Override
	public Root findRootObjectByName(String name) {	
		return restTemplate.getForObject(helper.generateUrl(System.currentTimeMillis()) + "&name=" + name, Root.class);
	}

	@Override
	public Root findRootObjectById(Long id) {
		return restTemplate.getForObject(helper.generateUrl(System.currentTimeMillis()) + "&characterId=" + id, Root.class);
	}
	
	@Override
	public Root fetchAllRootObject() {
		return restTemplate.getForObject(helper.generateUrl(System.currentTimeMillis()),Root.class);
	
	}
}
