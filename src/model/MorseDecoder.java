package model;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Iterator;

public class MorseDecoder {

  private final String DB_PATH = "res/codes.txt";

  private File DB;

  private Scanner in;


  private BinaryTree<Character> decodeTree;

  private char theReturn;

  public MorseDecoder() throws FileNotFoundException {
    DB = new File(DB_PATH);
    in = new Scanner(DB);
    decodeTree = new BinaryTree<>(null);


  }

  /**
   * 
   */
  public void print() {
    Iterator<Character> iterator = decodeTree.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
  }

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



  public void decode(String code) {
    //System.out.println(decodeMsg(decodeTree, code));
    decodeMsg(decodeTree,code);
    
  }


  public char decodeMsg(BinaryTree <Character> m, String morseCode) {
   
    // Base case for dot

int counter = 1;
    if (morseCode.equals(".")) {
      BinaryTree<Character> n = new BinaryTree<Character>(charToPlace);
      setTheReturn(decodeTree.getLeft().getRootElement());
      System.out.println(decodeTree.getLeft().getRootElement());
    } else if (morseCode.equals("-")) {
      BinaryTree<Character> n = new BinaryTree<Character>();
      setTheReturn(decodeTree.getRight().getRootElement());
      System.out.println(decodeTree.getRight().getRootElement());
    } else {
      char letterInCode = morseCode.charAt(0);
      
      morseCode = morseCode.substring(1);
      System.out.println(morseCode);
      if (letterInCode == '.') {
        decodeMsg(m.getLeft(),morseCode);
      }
      else {
        decodeMsg(m.getRight(), morseCode);
      }

    }
    
    return getTheReturn();

  }

  public Character getTheReturn() {
    return theReturn;
  }

  public void setTheReturn(char theReturn) {
    this.theReturn = theReturn;
  }
}
