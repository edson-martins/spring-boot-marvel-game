package br.com.martins.edson.spring.marvel.game.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Credential {
	private String publicKey;
	private String privateKey;
}
