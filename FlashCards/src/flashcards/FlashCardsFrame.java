/**
 *Multiplication Flash Cards Assignment
 *created for CSCI 111
 *last modified December 1, 7:00 PM
 *@author Leo Vergnetti
 */
package flashcards;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *FlashCardsFrame inherits from JFrame.  It is the GUI class for a flash cards 
 * application. called from FlashCards class main method.  Once an instance of 
 * FlashCardsFrame is created, it takes control of the application functionality
 */
public class FlashCardsFrame extends JFrame{
    
    private JPanel topPanel;//panel for first row of components
    private JPanel lowPanel;//panel for second row of components
    private JLabel problemStatement;//label where the problem will be displayed
    private JTextField answerBox;//textfield where the answer will be entered 
    private JButton button;//multipurpose button to submit answer or generate next question
    private JLabel directionsLabel;//label with directions/ info for user

    private int correctAnswer; //will contain correct answer for randomly generated integers
    private final int QUESTION_MODE = 1; //determines button functionality when asking question
    private final int ANSWER_MODE = 2;//determines button functionality when making new question
    private int mode; // will be checked in nested class for button functionality 
    
    Random randomGen = new Random(); //factory to generate random integers
    /**
     *Constructor. Set's a centered flow layout. Initializes and adds components
     * to the frame. Question mode is selected.
     */
    public FlashCardsFrame(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel = new JPanel();
        lowPanel = new JPanel();
        lowPanel = new JPanel();
        problemStatement = new JLabel();
        answerBox = new JTextField(2);
        button = new JButton();
        Listener listener = new Listener(); //create instance of listener
        button.addActionListener(listener);//listener is added to button
        answerBox.addActionListener(listener);//listener is added to answer box for enter key
        directionsLabel = new JLabel();
        topPanel.add(problemStatement);
        topPanel.add(answerBox);
        topPanel.add(button);
        lowPanel.add(directionsLabel);
        add(topPanel);
        add(lowPanel);
        mode = QUESTION_MODE;//begins in question mode
    }//end constructor
    
    /*
     * method sets the GUI up for a new problem. It generates two random integers
     * and displays a multiplication problem on the problemStatement label.  Then
     * correct answer is updated for checking.  answerBox is given focus for cursor
     */
    public void nextProblem(){
        answerBox.requestFocusInWindow();
        int first = randomGen.nextInt(10);
        int second = randomGen.nextInt(10);
        correctAnswer = first*second;
        problemStatement.setText("" + first + " x " + second + " = ");
        answerBox.setText("");
        button.setText("Check Answer!");
        directionsLabel.setText("Enter your answer and click the button!");
        directionsLabel.setForeground(Color.BLACK);
    }
    
    /*
     * Method gets the user's answer from the answerBox textfield and updates 
     * the GUI.  If the answer is correct, a green message is displayed.  If the 
     * answer is wrong a red message is displayed.  Due to the potential for error
     * in parsing the input String to an integer user Answer options are placed
     * in a try-catch block.
     */
    public void checkAnswer(){
        try{
            int userAnswer = Integer.parseInt(answerBox.getText());
            button.setText("Next Question!"); //change button's message
            answerBox.requestFocusInWindow();
            if (userAnswer == correctAnswer){
                directionsLabel.setForeground(new Color(35,134,51));//green text with better visibility against background
                directionsLabel.setText("CORRECT! The answer is " + correctAnswer +"!");
            }
            else {
                directionsLabel.setForeground(Color.RED); //red text for error
                directionsLabel.setText("OOPS! Sorry the answer was " + correctAnswer +"!");
            }
        }//end try 
       catch(Exception e){
           //catch a parse error.  Return to QUESTION_MODE to allow user to answer.
           directionsLabel.setText("The answer must be an integer");
           directionsLabel.setForeground(Color.RED);//red text for error
           mode = QUESTION_MODE; //return to question mode
           answerBox.setText("");
           answerBox.requestFocusInWindow();//so that user may optionally use return key instead of button 
       }//close catch block
    }//ends checkAnswer
    
    
    /**
     *Listener is an inner class which uses the ActionListener interface. When a 
     *button is pressed, it checks to see whether the Program is waiting for an
     *answer or checking an answer. It changes the current mode and calls the 
     *appropriate method.
     */
    class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if (mode == QUESTION_MODE){
                mode = ANSWER_MODE;
                checkAnswer();
            }
            else if (mode == ANSWER_MODE){
                mode = QUESTION_MODE;
                nextProblem();
            }
        }//close actionPerformed
    }//closes Listener class
}//closes FlashCardFrame class
