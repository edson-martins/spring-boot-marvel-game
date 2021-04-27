package br.com.martins.edson.spring.marvel.game.test.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import br.com.martins.edson.spring.marvel.game.dto.DataDTO;
import br.com.martins.edson.spring.marvel.game.dto.ResultDTO;
import br.com.martins.edson.spring.marvel.game.dto.RootDTO;
import br.com.martins.edson.spring.marvel.game.dto.ThumbnailDTO;

public class CharacterCreator {

	public static RootDTO retrieveAllCharacters() {
		
		return new RootDTO(/* code */            0, 
		 		           /* status */          "Ok", 
		 		           /* copyright */       "© 2021 MARVEL", "Data provided by Marvel. © 2021 MARVEL", 
		 		           /* attributionText */ "<a href=\"http://marvel.com\">Data provided by Marvel. © 2021 MARVEL</a>", 
		 		           /* attributionHTML */ "413b4ca08ac5c89f64f1a4d2b9b6e864c811daac",
		 		           /* data */ new DataDTO(/* offset */  0,
                                                  /* limit */   20, 
                                                  /* total */   1493, 
                                                  /* count */   20, 
                                                  /* results */ new ResultDTO[] { new ResultDTO(/* id */          1011334, 
                         		   		 				                                        /* name */        "A-Bomb (HAS)",
                         		   		 				                                        /* description */ "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! ", 
                         		   		 				                                        /* modified */    Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)), 
                         		   		 				                                        /* thumbnail */   new ThumbnailDTO(/* path */      "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784", 
                         		   		 						   		                                                           /* extension */ "jpg")),
                                                		                          new ResultDTO(/* id */          1009144, 
                                                		                        		  	    /* name */        "A.I.M.",
                                                		                        		  	    /* description */ "AIM is a terrorist organization bent on destroying the world.", 
                                                		                        		  	    /* modified */    Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)), 
                                                		                        		  	    /* thumbnail */   new ThumbnailDTO(/* path */      "http://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec", 
	   		 						   		                                                                                       /* extension */ "jpg"))}));
	}
	
	public static RootDTO retrieveCharactersById() {
		
		return new RootDTO(/* code */            0, 
				 		   /* status */          "Ok", 
				 		   /* copyright */       "© 2021 MARVEL", "Data provided by Marvel. © 2021 MARVEL", 
				 		   /* attributionText */ "<a href=\"http://marvel.com\">Data provided by Marvel. © 2021 MARVEL</a>", 
				 		   /* attributionHTML */ "413b4ca08ac5c89f64f1a4d2b9b6e864c811daac",
				 		   /* data */ new DataDTO(/* offset */  0,
                                                  /* limit */   20, 
                                                  /* total */   1493, 
                                                  /* count */   20, 
                                                  /* results */ new ResultDTO[] { new ResultDTO(/* id */          1011334, 
                                    		   		 				                            /* name */        "A-Bomb (HAS)",
                                    		   		 				                            /* description */ "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! ", 
                                    		   		 				                            /* modified */    Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)), 
                                    		   		 				                            /* thumbnail */   new ThumbnailDTO(/* path */      "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784", 
                                    		   		 						   		                                               /* extension */ "jpg"))}));
	}
}
