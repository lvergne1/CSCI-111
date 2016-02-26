
package branchingproject;

import java.util.Scanner;
/*
 *Branching LabReports and Collaboration Programming Assignment
 *created for CSCI 111
 *last modified September 26, 7:00 PM
 *@author Leo Vergnetti
 */

public class BranchingProject {

    // main method will ask for a student's name and gpa and outputs name and grad status
    
    public static void main(String[] args) {
        //declare variables and declare and init constants
        String name;
        String gradStatus;
        double gpa;
        Scanner kb;
        final double SUMMA_CUM_LAUDE = 3.8;
        final double MAGNA_CUM_LAUDE = 3.6;
        final double CUM_LAUDE = 3.2;
        final double GRADUATE = 2.0;
       
        //open scanner on input
        kb = new Scanner(System.in);
        
        //prompt user for name, store to string
        System.out.println("What is your name?");
        name = kb.nextLine();
        
        //promt user for gpa, store to double, and close scanner
        System.out.println("What is your GPA?");
        gpa = kb.nextDouble();
        kb.close();
        
        //if else statements to determine status
        if(gpa >= SUMMA_CUM_LAUDE)
            gradStatus = " will graduate Summa Cum Laude!";
        else if (gpa >= MAGNA_CUM_LAUDE)
            gradStatus = " will graduate Magna Cum Laude!";
        else if (gpa >= CUM_LAUDE)
            gradStatus = " will graduate Cum Laude!";
        else if (gpa >= GRADUATE)
            gradStatus = " will graduate!";
        else
            gradStatus = " is not eligible to graduate!";
        
        //output name and grad status
        System.out.println(name + gradStatus);
        
    }//close main method
    
}//end class 
