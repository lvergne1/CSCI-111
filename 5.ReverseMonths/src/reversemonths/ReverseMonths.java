
package reversemonths;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/*
 *Reverse The Order Of The Months
 *created for CSCI 111
 *last modified October 28, 8:00 PM
 *@author Leo Vergnetti
 */
public class ReverseMonths {
/*
 * This class reads input from a text document.  It stores the input to an array,
 * and then prints the information back to the document in reverse order. 
 */

    public static void main(String[] args) throws Exception {
        //Declare variables 
        String[] monthArray = new String[12]; //12 element array
        File monthsFile = new File("months.txt");// file that will be read
        File monthsReverseFile = new File("monthsreverse.txt");//file that will be created
        Scanner input = new Scanner(monthsFile);
        PrintWriter output = new PrintWriter(monthsReverseFile);
        
        //store months in array using for statement as index with the length of 
        //of the array being the upper bound
        for (int i = 0; i < monthArray.length;i++){
        monthArray[i] = input.nextLine();
        }//close for statement

        //write to new file using for statement as index with 0 being lower lower 
        //bound and beginning at the length of the array
        for (int i=monthArray.length-1; i>=0; i--){
            output.println(monthArray[i]);
        }//close for statement 
        
        //close scanner and printwriter
        output.close();
        input.close();
    }//ends main
}//ends class
