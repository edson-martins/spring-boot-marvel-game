package br.com.martins.edson.spring.marvel.game.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.martins.edson.spring.marvel.game.config.CredentialConfiguration;
import lombok.RequiredArgsConstructor;

/**
 * Class : ApiHelper Description: Helper class providing functionalities to the
 * API interaction.
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
	 * 
	 * @param timestamp with milliseconds value
	 * @return hash string
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public String generateHash(long timestamp)  {
		return generateHash(timestamp, credentials.getCredential().getPrivateKey(), credentials.getCredential().getPublicKey());
	}

	/**
	 * Method generateUrl used to generate the api url with credentials, and hash
	 * key
	 * 
	 * @param timestamp with the current time in milliseconds
	 * @return url string
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public String generateUrl(long timestamp)  {
		return url + "?ts=" + timestamp + "&apikey=" + credentials.getCredential().getPublicKey() + "&hash=" + generateHash(timestamp);
	}

	/**
	 * Private method with the logic used to generate the hash key
	 * 
	 * @param timestamp  with the current time in milliseconds
	 * @param privateKey is the private key stored in the vault server
	 * @param publicKey  is the public key stored in the vault server
	 * @return hash string
	 * 
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException 
	 */
	private String generateHash(long timestamp, String privateKey, String publicKey)  {
		String password = timestamp + privateKey + publicKey;

		MessageDigest md5;
		StringBuffer sb;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] digest = md5.digest(password.getBytes("UTF-8"));
			sb = new StringBuffer();
			for (byte b : digest)
	            sb.append(String.format("%02x", b & 0xff));
			
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			return "";
		} catch (UnsupportedEncodingException e) {
			return "";
		}	
	}
}
