package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is intended for encoding an english message to morse code
 * @author Ethan Koop
 *
 */
public class MorseMessageEncoder
{
    /**
     * Constructor
     * @param message passed from the user
     */
    public MorseMessageEncoder(String message) {
    	
    	encode(message);
    }
    
  
    
    /**
     * Reads the english message from the user, and returns the corresponding morse code
     * @param message passed from the user
     * @return corresponding morse code
     */
    public String encode (String message) {
    	

    		
    		String alphabet = "abcdefghijklmnopqrstuvwxyz";
    		

    		
    		String[] encode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",  
    		              "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", 
    		              "...-", ".--", "-..-", "-.--", "--.."};
    		
    		for (char alphabetCharacter : message.toCharArray()) {
    			
    			int index = -1;
    			String letter = " ";
    			
    				for (int i = 0; i < alphabet.length(); i++) {
    					if (alphabet.charAt(i) == alphabetCharacter) {
    						index = i;
    					}
    				}
    			if (index >= 0) {
    				
    				letter = encode[index];
    			}
    			
    			message += letter + " ";
    			
    		}
    	
    	
    		return message;
    	
    	
    	
    	
    }
    
    
}