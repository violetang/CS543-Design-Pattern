package company;

/**
 * abstract People class to define a people 
 * @author Jiali Tang and Runyu Xu
 */
public abstract class People{
    //variable field
    private String name; // name of a people
    private int phone; // phone number of a people
    
    //Constructor 
    People(String n, int p){
        name = n;
        phone = p;   
    }
    
    //getters to get basic info
    public String getName(){
        return name;
    }

    //get worker's phone number
    public int getPhone(){
        return phone;
    }
}