package application;

import java.io.FileNotFoundException;
import java.util.Scanner;

import model.MorseMessageDecoder;
import model.MorseMessageEncoder;

/**
 * Main entry point into Assignment 4
 * @authors Ethan Koop and Christopher Nottingham
 *
 */
public class MCodeApp {
  /**
   * This is the main entry point for the user.
   * It gives the user a choice to either:
   * Decode a Morse code message into English, or
   * Encode an English message into Morse Code.
   * The scanner then reads the users input, and either encodes or decodes the message, depending on their choice. 
   * @throws FileNotFoundException
   */
  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(System.in);
    MorseMessageDecoder decoder = new MorseMessageDecoder();
    MorseMessageEncoder encoder = new MorseMessageEncoder();
    String message;
    char choice = ' ';

    do {
      System.out.print("Enter E (encode), D (decode) or Q(quit): ");
      try {
        choice = in.nextLine().toUpperCase().charAt(0);
        switch (choice) {
          case 'D':
            System.out.println("Enter the message you'd like to decode from Morse Code");
            message = in.nextLine();
            System.out.println(decoder.decodeMessage(message));
            break;
          case 'E':
            System.out.println("Enter the message you'd like to encode into Morse Code");
            message = in.nextLine();
            System.out.println(encoder.encode(message));
          default:
        }
      } catch (StringIndexOutOfBoundsException e) {
        System.out.println("Invalid entry - try again");
      }
    } while (choice != 'Q');
  }
}
