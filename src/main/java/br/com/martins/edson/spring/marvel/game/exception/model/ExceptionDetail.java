package br.com.martins.edson.spring.marvel.game.exception.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
* Class      : ExceptionDetail
* Description: Custom exception model.
*
* @author Edson Martins
*/
@Data
@SuperBuilder
public class ExceptionDetail {
	
	protected String title;
	protected int status;
	protected String details;
	protected String developerMessage;
	protected LocalDateTime timestamp;
}