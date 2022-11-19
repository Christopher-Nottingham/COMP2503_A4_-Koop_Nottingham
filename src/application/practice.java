package application;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import model.MorseDecoder;

public class practice {
public static void main(String[] args) throws FileNotFoundException {
  MorseDecoder morseDecoder = new MorseDecoder();
  morseDecoder.build("res/codes.txt");
  morseDecoder.print();
  //morseDecoder.decode(".");
  String decodedMsg;
  //String message = ".... --- .-- .- .-. . -.-- --- ..-";
  String message = ".--";
 
  String[] theMsg = message.split(" ");
  
  
  
  
  
  
  System.out.println("\n"+Arrays.toString(theMsg));
morseDecoder.decode(".--");

  //morseDecoder.decode(message);
  for (int i = 0; i< message.length(); i++) {
    //morseDecoder.decode(theMsg[i].charAt(0));
  }
//  m.decode(theMsg[1].toString());
  //morseDecoder.decodeMessage(".");
  
}
public void decodeMessage(String message) throws FileNotFoundException {
  // TODO Auto-generated method stub
 
  //System.out.println(theMsg[1].trim().toString());
//  for (int i=0; i<= theMsg.length; i++ ) {
//    System.out.println(m.decode(theMsg));
//  }
  
  
}
}
