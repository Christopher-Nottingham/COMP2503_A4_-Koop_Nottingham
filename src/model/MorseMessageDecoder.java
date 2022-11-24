package model;

import java.io.FileNotFoundException;


public class MorseMessageDecoder {

  private String returningMsg;
  private char decodedChar;
  private MorseDecoder morseDecoder;

  public MorseMessageDecoder() {
    try {
      morseDecoder = new MorseDecoder();
      morseDecoder.build("res/codes.txt");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


  public String decodeMessage(String message) {
    returningMsg = null;
    try {
      morseDecoder = new MorseDecoder();
      morseDecoder.build("res/codes.txt");
      String wordArray[] = message.split("       ");
      for (int i = 0; i < wordArray.length; i++) {
        String word = wordArray[i];
        String[] tempArrayOfLetters = word.split(" ");
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
