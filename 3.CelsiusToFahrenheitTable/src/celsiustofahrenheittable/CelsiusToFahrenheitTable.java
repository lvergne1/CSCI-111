package celsiustofahrenheittable;

import java.util.Scanner;
/*
 *Celsius to Fahrenheit Conversion Table
 *created for CSCI 111
 *last modified October 7, 11:25 AM
 *@author Leo Vergnetti
 */
public class CelsiusToFahrenheitTable {
    /*main method will accept a city and a starting temp as input. 
     *will print the city and a table of 40 temperature C values and 
     *temperature F values. 
     */
    public static void main(String[] args) {
        //Declare variables
        String city;
        double tempC;
        double tempF;
        Scanner kb = new Scanner(System.in);
        
        //Get city input
        System.out.println("What city are you in?");
        city = kb.nextLine();
        
        //get temperature input and close scanner
        System.out.println("Enter a starting temperature in \u00b0C");
        tempC = kb.nextDouble();
        kb.close();
        
       /* 
        * Use nested for statements to print decorative asterisks. The outer loop
        * will run 10 times.  While it runs the inner loop will run to print as 
        * many asterisks as the current iteration of the outer loop. This will
        * result in 10 rows of asterisks, with the number of asterisks equal to 
        * that row.  (row 1 has 1*, row 2 has 2*s...*
        */
        for(int i=0; i<10; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }//close inner loop with number of asterisks equal to outer loop
          System.out.println();//go to next line
        }//close outer loop
        
        //output city name and table header
        System.out.println(city);
        System.out.printf("%1s%5s%n", "\u00b0C", "\u00B0F");
        
        //start for loop to run 41 times
        for (int i=0; i<=40; i++){
            //convert to celsius
            tempF = ((9.0/5.0)*tempC) + 32;
            //format and print output to console to .1 degrees F
            System.out.printf("%2.0f%6.1f%n", tempC, tempF);
            //increment tempC
            tempC++;
        }//end conversion loop
        
        /*
         * This for statement will work similarly to the first for statement.
         * Instead of row 1 having 1, row 1 will have 10, row 2 will have 9...)
         */
        for(int i=0; i<10; i++){
            for (int j=10; j>i; j--){
                System.out.print("*"); 
            }//close inner loop
            System.out.println();
        }//close outer loop
    }//end main method    
}//end class
