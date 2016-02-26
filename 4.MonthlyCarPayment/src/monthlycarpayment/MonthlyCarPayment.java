
package monthlycarpayment;

import java.util.Scanner;
/*
 *Monthly Car Payment Calculator
 *created for CSCI 111
 *last modified October 22, 7:00 PM
 *@author Leo Vergnetti
 */
public class MonthlyCarPayment {

    /* This class will calculate monthly payments on loan using three user
     * defined methods.  It asks for the loan amount, and annual interest rate,
     * and number of months,and outputs the amount borrowed, the annual interest 
     * rate, the number of months, and the monthly repayment
     */
    public static void main(String[] args) {
        //declare vars
        double loanAmount;
        double annualRate;
        double numberMonths;
        double monthlyRate;
        double monthlyPayment;
        Scanner kb = new Scanner(System.in);
        
        //get loan amount and interest rate
        System.out.println("What is the loan amount?");
        loanAmount = kb.nextDouble();
        System.out.println("what is the annual interest rate?");
        annualRate = kb.nextDouble();
        //get number of months 
        System.out.println("How many months will you take to pay it?");
        numberMonths = kb.nextDouble();
        kb.close(); // close scanner
        
        //get monthly interest rate
        monthlyRate = calculateMonthlyRate(annualRate);
        //get monthly payment
        monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyRate, numberMonths);
        //print payment
        printStatement(loanAmount, annualRate, numberMonths, monthlyPayment);
    }
    //method to calc and return monthly interest rate (annualrate/12)
    /*
     * Method accepts an annual interest rate.  It will divide that rate by
     * 12 and return the monthly interest rate.
     */
    static double calculateMonthlyRate(double annualRate){
        double monthlyRate;
        monthlyRate = annualRate/12.0;
        return monthlyRate;
    }//end method
    

    /*
     * This method accepts the number of months the user wishes to pay off 
     * loan, the monthly interest rate and loan amount as parameters.
     * Returns monthly payment using formula
     * M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1]
     */
     static double calculateMonthlyPayment(double loanAmount, double monthlyRate, double numberMonths){
        
        double monthlyPayment;
        monthlyPayment = loanAmount*(monthlyRate* Math.pow(1.0+monthlyRate,numberMonths)) 
                        /((Math.pow(1.0+monthlyRate, numberMonths)-1.0));
        return monthlyPayment;
     }//end method
     
     
    //method to print output statement
     /*
      * This method prints a formatted statement containing the loan amount, yearly rate, 
      * number of months, and monthly payment.
      */
    static void printStatement(double loanAmount, double annualRate, double numberMonths, double monthlyPayment){
    
    System.out.printf("%-20s%11.2f%n", "Principal Balance $", loanAmount);
    System.out.printf("%-20s%11.4f%n", "Annual Rate ", annualRate);
    System.out.printf("%-20s%11.0f%n", "Number of Months  ", numberMonths);
    System.out.printf("%-20s%11.2f%n", "Monthly Payment $", monthlyPayment);
    }//END method
}//end class
