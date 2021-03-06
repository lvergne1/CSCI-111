/* Monopoly.java
 * 
 * CSCI 111 Fall 2013 
 * last edited November 2, 2013 by C. Herbert
 * 
 * This package contains code that can be used as the basis of a monopoly game
 * It has a class of BoardSquares for the board squares in a Monopoly game,
 * and a main program that puts the squares into an array.
 * 
 * The main method has code to test the program by printing the data from the array
 * 
 * This is for teaching purposes only. 
 * Monopoly and the names and images used in Monopoly are 
 * registered trademarks of Parker Brothers, Hasbro, and others.
 */

package monopoly;

import java.util.*;

/*
 *Monopoly
 *created for CSCI 111
 *last modified November 24, 7:00 PM
 *@author Leo Vergnetti
 */
public class Monopoly {

    /**
     * This class will simulate a monopoly game.  It will create an instance of the player class
     * and add it to the board. It then begins rolling the dice and moving around the board
     * until the player is bankrupt. 
     */
    public static void main(String[] args) throws Exception 
    {
        Player player1 = new Player("Leo", "battleship", 0, 1500);
        BoardSquare[] square = new BoardSquare[40]; // array of 40 monopoly squares
        int die1;
        int die2;
        int newSquare;
        String userInput;
        Scanner kb = new Scanner(System.in);
        
        
        // call the method to load the array
        loadArray(square);
        
        while(player1.getBalance() > 0){
            
            //roll both die
            die1 = rollDie();
            die2 = rollDie();
            
            //move player to square, if end of board, go to beginning
            newSquare = player1.getLocation() + die1 + die2;
            if (newSquare > 39){
                newSquare = newSquare -40;
            }
            player1.setLocation(newSquare);
            
            //deduct rent from player
            player1.setBalance(player1.getBalance() - square[newSquare].getRent());
            
            //output player name, token, the dice, square, rent, and newbalance
            System.out.println(player1.getName() + "'s " + player1.getToken() + 
                    " is at " + square[newSquare].getName()+ "  Rolled a "+ 
                    die1 +" and a " +die2 + " The rent is $" +square[newSquare].getRent() + 
                    ". New Balance :$" + player1.getBalance());
            //press enter to continue
            System.out.println("Press enter to continue");
            userInput = kb.nextLine();
            //
        }
        kb.close();
    }//end main
    //***********************************************************************
    
    
    
    //method to simulate die roll, returns the roll
    public static int rollDie(){
        Random randomGen = new Random();
        return (randomGen.nextInt(6)+1);
    }
    //************************************************************************
    



    // method to load the BoardSquare array from a data file
    public static void loadArray(BoardSquare[] square) throws Exception
    {
        int i; // a loop counter
        
        // declare temporary variables to hold BoardSquare properties read from a file
        String inName;    
        String inType;
        int inPrice;
        int inRent;
        String inColor;
        
        // Create a File class object linked to the name of the file to be read
        java.io.File squareFile = new java.io.File("squares.txt");

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(squareFile);

        
        /* This loop reads data into the square array.
         * Each item of data is a separate line in the file.
         * There are 40 sets of data for the 40 squares.
         */
        for( i=0; i<40; i++)
        {
            // read data from the file into temporary variables
            // read Strings directly; parse integers
            inName  = infile.nextLine(); 
            inType  = infile.nextLine(); 
            inPrice = Integer.parseInt( infile.nextLine() );
            inRent  = Integer.parseInt( infile.nextLine() );;
            inColor = infile.nextLine(); 
         
            // intialze each square with the BoardSquare constructor
            square[i] = new BoardSquare(inName, inType, inPrice, inRent, inColor);
        } // end for
        infile.close();

    } // endLoadArray
    //***********************************************************************

} // end class Monopoly
//***************************************************************************


/* code for a class of Monopoly squares
 * 
 * CSCI 111 Fall 2013 
 * last edited November 2, 2013 by C. Herbert
 * Each object in this class is a square for the board game Monopoly.
 * 
 * This is for teaching purposes only. 
 * Monopoly and the names and images in the game are 
 * registered trademarks of Parker Brothers, Hasbro, and others.
 */
class BoardSquare 
{

    private String name;    // the name of the square
    private String type;    // property, railroad, utility, plain, tax, or  toJail 
    private int price;      // cost to buy the square; zero means not for sale
    private int rent;       // rent paid by a player who lands on the square 
    private String color;   // many are null; this is not the Java Color class

    // constructors
    public BoardSquare() 
    {
        name = "";
        type = "";
        price = 0;
        rent = 0;
        color = "";
    } // end Square()

    public BoardSquare(String name, String type, int price, int rent, String color) 
    {
        this.name = name;
        this.type = type;
        this.price = price;
        this.rent = rent;
        this.color = color;
    } // end Square((String name, String type, int price, int rent, String color)

    // accesors for each property
    public String getName() 
    {
        return name;
    } //end  getName()

    public String getType() 
    {
        return type;
    } //end  getType()

    public int getPrice() 
    {
        return price;
    } //end  getPrice()

    public int getRent() 
    {
        return rent;
    } //end  getRent()

    public String getColor() 
    {
        return color;
    } //end  getColor()
        
    // a method to return the BoardSquare's data as a String
    public String toString() 
    {
    String info;
    info = (name +", "+type+", "+price + ", "+ rent+ ", "+color);
    return info;    
    } //end  toString()
    
} // end class BoardSquare
//***************************************************************************

