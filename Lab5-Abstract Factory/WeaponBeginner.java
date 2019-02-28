package game;
/**
 * WeaponBeginner implements WeaponIF to create a WeaponBeginner object
 * @Group: 7
 */
public class WeaponBeginner implements WeaponIF{
    
    //name of the weapon, in further may define as a weapon object
    private String name; 

    //add a weapon
    @Override
    public void addWeapon(String n){
        this.name = n;
    }

    //get this weapon
    @Override
    public String getWeapon(){
        return "The weapon of this character is " + this.name;
    }
}
