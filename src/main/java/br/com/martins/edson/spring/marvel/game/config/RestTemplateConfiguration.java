package br.com.martins.edson.spring.marvel.game.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
* Class      : RestTemplateConfiguration
* Description: This class is used to configure the Rest Template to make call to
*              Marvel API.
*
* <p>https://developer.marvel.com
*
* @author Edson Martins
*/
@Configuration
public class RestTemplateConfiguration {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}

}
