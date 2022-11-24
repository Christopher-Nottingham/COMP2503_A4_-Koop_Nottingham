package model;

import java.io.FileNotFoundException;

/**
 * This class intended to decode whole morse sentences
 * @author Christopher Nottingham
 *
 */
public class MorseMessageDecoder {

  private String returningMsg;
  private char decodedChar;
  private MorseDecoder morseDecoder;

  /**
   * Main constructor
   */
  public MorseMessageDecoder() {
    try {
      morseDecoder = new MorseDecoder();
      morseDecoder.build("res/codes.txt");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

/**
 * Takes whole morse sentence and returns it in to  
 * @param message the morse sentence
 * @return English representation of the morse sentence
 */
  public String decodeMessage(String message) {
    returningMsg = null;
    try {
      morseDecoder = new MorseDecoder();
      morseDecoder.build("res/codes.txt");
      String wordArray[] = message.split("       ");
      for (int i = 0; i < wordArray.length; i++) {
        String word = wordArray[i];
        String[] tempArrayOfLetters = word.split("   ");
        // System.out.println(Arrays.toString(tempArray));
        for (int j = 0; j < tempArrayOfLetters.length; j++) {
          if (tempArrayOfLetters[i] == "") {
          } else {
            decodedChar = morseDecoder.decode(tempArrayOfLetters[j]);
            returningMsg = returningMsg + decodedChar;
          }
        }
        returningMsg = returningMsg + " ";
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return returningMsg.substring(4);
  }


}
