package br.com.martins.edson.spring.marvel.game.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.martins.edson.spring.marvel.game.config.CredentialConfiguration;
import lombok.RequiredArgsConstructor;

/**
* Class      : ApiHelper
* Description: Helper class providing functionalities to the API interaction.
*
* @author Edson Martins
*/
@Component
@RequiredArgsConstructor
public class ApiHelper {
	
	@Value("${arena.api.url}")
	String url;
	
	private final CredentialConfiguration credentials;

	/**
     * Method generateHash used to generate a hash key
     * @param timestamp with milliseconds value
     * @return hash string
     */
    public String generateHash(long timestamp) {
    	return generateHash(timestamp, credentials.getCredential().getPrivateKey(), credentials.getCredential().getPublicKey());
    }
    
    /**
     * Method generateUrl used to generate the api url with credentials, and hash key
     * @param timestamp with the current time in milliseconds
     * @return url string
     */
    public String generateUrl(long timestamp) {
        return url + "?ts=" + timestamp + "&apikey=" + credentials.getCredential().getPublicKey() + "&hash=" + generateHash(timestamp);
    }
    
    /**
     * Private method with the logic used to generate the hash key
     * @param timestamp  with the current time in milliseconds
     * @param privateKey is the private key stored in the vault server
     * @param publicKey  is the public key stored in the vault server
     * @return hash string
     */
    private String generateHash(long timestamp, String privateKey, String publicKey) {
        String password = timestamp + privateKey + publicKey;
        return DigestUtils.md5Hex(password);
    }

}
