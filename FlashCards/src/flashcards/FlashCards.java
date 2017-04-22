/**
 *Multiplication Flash Cards Assignment
 *created for CSCI 111
 *last modified December 1, 7:00 PM
 *@author Leo Vergnetti
 */
package flashcards;

import javax.swing.JFrame;

/**
 * FlashCards is the entry point for a flash cards game.  Two integers are randomly
 * selected, and the user is asked to multiply them.  This is checked, if the user is correct
 * green text will display a correct message and a new problem will be displayed.
 * if the user's answer is wrong, red text will  display an incorrect message. 
 * and the user will be prompted with another problem.
 * if the user enters something other than an integer, 
 * an error message is displayed (courtesy of a try-catch block) in red, and the user 
 * will be asked to enter an acceptable answer.  This will continue until the user
 * quits the program
 */
public class FlashCards {

    public static void main(String[] args) {
        FlashCardsFrame flashFrame = new FlashCardsFrame();
        flashFrame.setTitle("Multiplication Quiz");
        flashFrame.setSize(320, 120);
        flashFrame.setLocation(200, 100);
        flashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flashFrame.setVisible(true);
        flashFrame.nextProblem(); 
        
    }
    
}//end class FlashCards

