
package monopoly;
/*
 *Player (for monopoly)
 *created for CSCI 111
 *last modified November 24, 7:00 PM
 *@author Leo Vergnetti
 */
public class Player {
    
    //data members
    private String name;
    private String token;
    private int location;
    private int balance;
    
    //member methods
    //default constructor
    public Player(){
    location = 0;
    balance = 1500;
    }
    
    //constructor, sets name token location and balance to input parameters
    public Player(String name, String token, int location, int balance){
        this.name = name;
        this.token = token;
        this.location = location;
        this.balance = balance;
    }
   
    //accessor methods for name, token, location, balance
    public String getName(){
    return name;
    }
    public String getToken(){
    return token;
    }
    public int getLocation(){
    return location;
    }
    public int getBalance(){
    return balance;
    }
    
    //mutator methods for name, token, location, balance
    public void setName(String name){
        this.name = name;
    }
    public void setToken(String token){
        this.token = token;
    }
    public void setLocation(int location){
        this.location = location;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    
    //return String of name, token, location, and balance
    @Override
    public String toString(){
        return("Player: " + name + " Token: " + token + " At Square: " + location + "Balance: " + balance);
    }
    
}
