package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is intended for encoding an English message to morse code
 * 
 * @author Ethan Koop
 *
 */
public class MorseMessageEncoder {
  /**
   * Reads the English message from the user, and returns the corresponding morse code
   * 
   * @param message passed from the user
   * @return corresponding morse code
   */
  public String encode(String message) {

    String word = "";
    String alphabet = "abcdefghijklmnopqrstuvwxyz";



    String[] encode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
        ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
        "-.--", "--.."};


    for (char alphabetCharacter : message.toCharArray()) {

      int index = -1;
      String letter = "";

      for (int i = 0; i < alphabet.length(); i++) {
        if (alphabetCharacter == ' ') {
          word += letter + " ";
          break;
        }
        if (alphabet.charAt(i) == alphabetCharacter) {
          index = i;
          break;
        }
      }
      if (index >= 0) {

        letter = encode[index];
      }

      word += letter + "   ";


    }


    return word;



  }


}
