package br.com.martins.edson.spring.marvel.game.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

/**
* Class      : DateHelper
* Description: Helper class providing functionalities to manage dates.
*
* @author Edson Martins
*/
@Component
public class DateHelper {
	
	/**
     * Method formatLocalDateTimeToDatabaseStyle used to convert date time to database format.
     * @param localDateTime is the date and time from the local machine.
     * @return string date in the database format.
     */
	public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
	}
}
