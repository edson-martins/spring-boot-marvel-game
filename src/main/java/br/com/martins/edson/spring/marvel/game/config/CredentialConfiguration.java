package br.com.martins.edson.spring.marvel.game.config;

import java.util.Map;

//-- --------------------------------------------------------------------------
//
//Class:            CredentialConfiguration
//Date:             April 15, 2021
//Last Modified on: April 15, 2021
//
//Author:           Edson Martins Copyright (2021). All rights reserved.
// Description:     Configuration class used to retrieve the credentials of
//                  the HashiCorp Vault Server.
//-- --------------------------------------------------------------------------

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import br.com.martins.edson.spring.marvel.game.exception.CredentialNullPointerExceptionDetail;
import br.com.martins.edson.spring.marvel.game.model.Credential;
import lombok.RequiredArgsConstructor;

/**
* Class      : CredentialConfiguration
* Description: This class is used to create the Vault Configuration used to load the secret
*              keys from HashiCorp Vault Server
*
* <p>http://vaultproject.io
*
* @author Edson Martins
*/
@RequiredArgsConstructor
@Configuration 
public class CredentialConfiguration {

	private final VaultTemplate vaulTemplate;
	
	private VaultResponse response;
	private Credential credential;

	
	public Credential getCredential() {
		return credential;
	}
	
	public VaultResponse getVaultResponse() {
		return response;
	}
	
	@Bean
	public void build() throws CredentialNullPointerExceptionDetail {

		VaultKeyValueOperations vaul = (null != vaulTemplate) ? vaulTemplate.opsForKeyValue("secret", KeyValueBackend.KV_2) : null;
			
		response = (null != vaul) ? vaul.get("marvel") : null;
		if (null != response && null != response.getData()) {
				
			Map<String, Object> data = response.getData();
				
			credential = Credential.builder()
								   .privateKey((null != data) ? data.get("private_key").toString() : null)
								   .publicKey ((null != data) ? data.get("public_key").toString()  : null)
								   .build();		
		}
		if (null == credential && null == response)
			throw new CredentialNullPointerExceptionDetail(
				"Something is wrong with Vault server. Take a look your secret key");
	}

}
