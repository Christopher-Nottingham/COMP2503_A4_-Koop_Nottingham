package model;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Iterator;

/**
 * This class is intended to take morse code and convert it to readable English.
 * 
 * 
 * @author Christopher Nottingham
 *
 */
public class MorseDecoder {

  private final String DB_PATH = "res/codes.txt";

  private File DB;

  private Scanner in;


  private BinaryTree<Character> decodeTree;

  private char theReturn;

  /**
   * The main constructor that builds fills the objects and creates a tree
   * 
   * @throws FileNotFoundException
   */
  public MorseDecoder() throws FileNotFoundException {
    DB = new File(DB_PATH);
    in = new Scanner(DB);
    decodeTree = new BinaryTree<>(null);


  }

  /**
   * Prints the tree using the in-order transversal with the help of the iterator method
   */
  public void print() {
    Iterator<Character> iterator = decodeTree.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
  }

  /**
   * Fills the tree and recursively places alphabet characters in correct nodes
   * 
   * @param fileName The file with morse code
   * @throws FileNotFoundException throws exeception if their is no such file in fileName
   */
  public void build(String fileName) throws FileNotFoundException {
    Scanner in = new Scanner(new File(fileName));
    char letter;
    String symbol;

    while (in.hasNextLine()) {
      letter = in.next().charAt(0);
      symbol = in.next();
      letterPositioning(decodeTree, letter, symbol);
    }
    in.close();

  }

  /**
   * Method decides where to place the letter in binary tree If it is a dot it goes to the left,
   * else if it is a dash it goes to the right
   * 
   * @param passingTree the subtree that will be used to decide where the letter goes
   * @param letter the alphabetic representation of morse code
   * @param symbol the morse code This code is from Tutorial_11_16 but has been modified to
   *        correctly make Binary Morse Tree
   */
  public void letterPositioning(BinaryTree<Character> passingTree, char letter, String symbol) {
    // Base case for dot
    if (symbol.equals(".")) {
      BinaryTree<Character> n = new BinaryTree<>(letter);
      passingTree.setLeft(n);
    }
    // Base case for dash
    else if (symbol.equals("-")) {
      BinaryTree<Character> n = new BinaryTree<>(letter);
      passingTree.setRight(n);
    }
    // Recursive case
    else {
      char letterInCode = symbol.charAt(0);
      symbol = symbol.substring(1);
      if (letterInCode == '.')
        letterPositioning(passingTree.getLeft(), letter, symbol);
      else {
        letterPositioning(passingTree.getRight(), letter, symbol);
      }
    }

  }


  /**
   * Uses a string parameter and uses a recursive method to solve a return the the English
   * translation of morse code.
   * 
   * @param code The morse code
   * @return the English equivalent of a single morse symbol
   */
  public char decode(String code) {
    return decodeMsg(decodeTree, code);
  }

  /**
   * Traverse throught the tree to get the English letter equivalent
   * @param m the morse tree
   * @param morseCode the individual morse symbol
   * @return the letter equivalent of the morseCode parameter
   */
  public char decodeMsg(BinaryTree<Character> m, String morseCode) {

    // Base case for dot
    if (morseCode.equals(".")) {

      setTheReturn(m.getLeft().getRootElement());

    } else if (morseCode.equals("-")) {

      setTheReturn(m.getRight().getRootElement());

    } else {
      char letterInCode = morseCode.charAt(0);

      morseCode = morseCode.substring(1);

      if (letterInCode == '.') {
        decodeMsg(m.getLeft(), morseCode);
      } else {
        decodeMsg(m.getRight(), morseCode);
      }

    }

    return getTheReturn();

  }

  /**
   * Getter method for the return variable 
   * @return the variable assignment in char form
   */
  public Character getTheReturn() {
    return theReturn;
  }
  
  /**
   * Setter method for the return variable
   * @param theReturn the new return
   */
  public void setTheReturn(char theReturn) {
    this.theReturn = theReturn;
  }
}
