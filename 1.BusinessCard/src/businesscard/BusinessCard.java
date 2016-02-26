
package businesscard;

/*
 *Simple Business Card Application
 *created for CSCI 111
 *last modified September 12, 9:00 AM
 *@author Leo Vergnetti
 */

public class BusinessCard {

    /**
     * main method will use a mix of print and println commands to print
     * a formatted business card to the console
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //output name to console
        System.out.print("Leo ");
        System.out.println("Vergnetti");
        
        //output major to console
        System.out.println("Computer Science Major");
        
        //output school to console
        System.out.println("Community College of Philadelphia");
        
        //output city, state and zip separately to console
        System.out.print("Philadelphia, ");
        System.out.print("PA ");
        System.out.println("19130");
                
        //output email to console
        System.out.println("lvergnetti@gmail.com");
        
    } //end of main method
   
    
}//end of BusinessCard class
