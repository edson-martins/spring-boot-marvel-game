package br.com.martins.edson.spring.marvel.game.exception;

/**
* Class      : CredentialNullPointerExceptionDetail
* Superclass : Exception
* Description: Custom exception used during the credential load process.
*
* @author Edson Martins
*/
public class CredentialNullPointerExceptionDetail extends Exception {

	private static final long serialVersionUID = 1L;
	public CredentialNullPointerExceptionDetail(String message) {
		super(message);
	}
	
	
}
