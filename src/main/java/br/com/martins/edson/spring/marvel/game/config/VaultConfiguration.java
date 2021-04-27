package br.com.martins.edson.spring.marvel.game.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.vault.support.SslConfiguration;

/**
* Class      : VaultConfiguration
* SuperClass : AbstractVaultConfiguration
* Description: This class is used to make a connection to the vault server. When connected, is possible
*              to query the secret key and get the keys used to call the Marvel API
*
* <p>http://vaultproject.io
*
* @author Edson Martins
*/
@Configuration
public class VaultConfiguration extends AbstractVaultConfiguration {
	
	@Value("${spring.cloud.vault.token}")
	String token;
	
	@Value("${spring.cloud.vault.host}")
	String uriVaultServer;

	@Value("${spring.cloud.vault.port}")
	int portVaultServer;
	
	@Override
	public VaultEndpoint vaultEndpoint() {
		VaultEndpoint vaultEndpoint = VaultEndpoint.create(uriVaultServer, portVaultServer);
		vaultEndpoint.setScheme("http");
		return vaultEndpoint;
	}

	@Override
	public ClientAuthentication clientAuthentication() {
		return new TokenAuthentication(token);
	}

	@Override
	public SslConfiguration sslConfiguration() {
		return SslConfiguration.unconfigured();
	}
}

