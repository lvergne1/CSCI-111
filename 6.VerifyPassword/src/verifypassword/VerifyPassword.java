
package verifypassword;

import java.util.Scanner;
/*
 *Verify Password
 *created for CSCI 111
 *last modified November 4, 7:00 PM
 *@author Leo Vergnetti
 */
public class VerifyPassword {
    
    
    /* This class contains several methods. the main method begins a loop. it asks user to enter password twice.
    *it then validates password by using the validate password method. it exits 
    *if user enters a valid password or if user quits. 
    */
    public static void main(String[] args) {   
        //vars
        Scanner kb = new Scanner(System.in); 
        String password1;
        String password2;
        boolean passwordValidated = false;
        boolean exitProgram = false;
        String userChoice;
        
        /*Begins to loop and continues while the password is not valid and the user
        *hasn't opted to quit. asks for the users password twice using prompt and captures.
        *then calls the validatePassword method with the two passwords as arguments. if 
        *true is returned, the password is valid, displays a message and exits the loop.
        *if false is returned, informs the user, and prompts the user to try again or press 1 
        *to quit. if 1 is entered, the while loop exits */
        while (!passwordValidated && !exitProgram){
            System.out.println("Enter your password: ");
            password1 = kb.nextLine();
            System.out.println("Re-Enter your password: ");
            password2 = kb.nextLine();
            passwordValidated = validatePassword(password1, password2);
            if (passwordValidated){ //if password is valid, inform the user, the while loop will exit at next test
                System.out.println("Password Accepted"); 
            }
        
            else{
                //prompts user to either enter 1 to quit or to try another password.  
                //if 1 is entered, exitProgram is set to true, and the loop will exit at next test
                System.out.println("Invalid entry, press 1 to exit or any other key to try again"); 
                userChoice = kb.nextLine();
                if ( userChoice.compareTo("1") == 0){
                    exitProgram = true;
                    
                }
            }
       }
       kb.close(); // close scanner
    }// ends main method
    
    
    
    
    
    
    /*
     * method to validate two password using boolean flags.  First all flags
     * are set to false. As the testing begins, flags are adjusted accordingly.
     * at end of method, all flags are checked, if all are passed, then password
     * is accepted. 
     */
    static boolean validatePassword(String password1, String password2){
        boolean validPassword = false; // returned at end of method
        boolean areEqual = false; 
        boolean hasLength = false;
        boolean hasLetter = false;
        boolean hasNumber = false;
        boolean hasNonAlphaNum = false;
        boolean hasSpace = false;
        boolean hasIllegal = false;
        boolean hasRepeat = false;
        boolean hasIllegalFirst = false;
        
        // if passwords are the same, set areEqual to true and continue, else 
        // stop testing. the areEqual, hasLength, and hasIllegalFirst booleans are
        // somewhat redundant seeing as the testing only continues if they do pass,
        // however i kept them in for consistency in the final test at the end of the
        // method
        if (password1.compareTo(password2) == 0){
            areEqual = true;
            //if password is at least 8 characters, haslength is set to true and 
            //testing continues, otherwise stop testing.
            if (password1.length() > 7){
                hasLength = true;
                //checks that first character is not ! or ?
                if (password1.charAt(0) != '!' && password1.charAt(0) != '?'){
                    hasIllegalFirst = false;
                    //begins a count controlled loop to test each char in the string. 
                    //uses boolean helper methods to determine specific kind of char.
                    //then the appropriate flag is set to true;
                    for (int i = 0; i < password1.length(); i++){
                        //sets char c to the character at index i.
                        char c = password1.charAt(i);
                    
                        if (isRepeat(i, password1)){
                        hasRepeat = true; // if the current character equals the character before and after, then it is repeated at least 3 times, hasRepeat is set to true.
                        }
                        if (isLetter(c)){
                        hasLetter = true; // if the character is an alpha character, hasAlpha = true;
                        }
                        else if (isNumber(c)){
                        hasNumber = true; // if the character is a number character, hasNumber = true
                        }
                        else if (isNonAlphaNum(c)){
                        hasNonAlphaNum = true; // if the character is a non alphanumeric character has nonAlpha = true;
                        }
                        else if (isSpace(c)){
                        hasSpace = true; // if the character is a space, hasSpace = true;
                        }
                        else {
                        hasIllegal = true; // if the character was none of the above, it is an illegal character. 
                        }
                    }//ends for statement
                }
            }
        }
        //checks flags if all are correct, then the password is valid and true is returned.
        // if not then false is returned.
        if (areEqual && hasLength && hasLetter && hasNumber && hasNonAlphaNum
                 && !hasIllegalFirst && !hasSpace && !hasIllegal && !hasRepeat){
            validPassword = true; 
        }
        return validPassword;
    }//ends validate password method
    
    
    /*
     *Below are helper methods with boolean returns that determine type of char
     *returns true if parameter is type, false otherwise. These use their unicode 
     *values as markers between them
     */
    static boolean isLetter(char c){
        return (c > 64 && c < 91) || (c > 96 && c < 123);
    }
    
    static boolean isNumber(char c){
        return c > 47 && c < 58;
    }
    
    static boolean isNonAlphaNum(char c){
        return (c > 32 && c < 48) || (c > 57 && c < 65) || 
                (c > 90 && c < 97) || (c > 122 && c < 127);
    }
    
    static boolean isSpace(char c){
        return c == 32;
    }
    
    //accepts an int index and a string as parameters. checks whether the character
    //before the index and the character after the index are equal. if so returns true.
    static boolean isRepeat(int i, String password){
        boolean repeated = false;
        if (i > 0 && i < password.length()-1){ // this checks that it is either the 2nd character or 2nd to last character
            if ((password.charAt(i) == password.charAt(i-1)) 
                && password.charAt(i) == password.charAt(i+1)){
                repeated = true;
            }
        }
        return repeated;
    }//is repeat
}
