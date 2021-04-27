package br.com.martins.edson.spring.marvel.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//-- --------------------------------------------------------------------------
//
//Class:            SpringMarvelGameApplication
//Date:             April 15, 2021
//Last Modified on: April 15, 2021
//
//Author:           Edson Martins Copyright (2021). All rights reserved.
//
//Description:      This is a simple Marvel Superhero arena game using the 
//                 Marvel API’s available at https://developer.marvel.com. 
//            
//Logic:            1. Read  2 JSON superhero names and a seed value between  
//                    1-10.
//
//                 2. Retrieve the "description" of each hero from the 
//                    "character" endpoint of the api. An example of the 
//                    endpoint is:
//                    http://gateway.marvel.com/v1/public/characters?name=Spider-Man 
//                    (Note: This link will not work as written, you will need to 
//                    supply your authentication parameters described in the 
//                    Authentication documentation.)
//
//                 3. Find the word in the position of the description corresponding 
//                    to the seed value. As an example, if the provided seed value 
//                    were 3, you would choose the 3rd word in the description for 
//                    each character.
//
//                 4. The hero with the most characters in their word at that position 
//                    is the winner, but if the word is either "gamma" or "radioactive" 
//                    that character automatically wins.
//
//                 5. Return the Winner Json payload.
//
//-- --------------------------------------------------------------------------
@SpringBootApplication
public class SpringMarvelGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMarvelGameApplication.class, args);
	}

}
