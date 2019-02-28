package game;
/**
 * WeaponIntermediate implements WeaponIF to create a WeaponIntermediate object
 * @Group: 7
 */
public class WeaponIntermediate implements WeaponIF {
    
    private String name;

    @Override
    public void addWeapon(String n){
        this.name = n;
    }

    @Override
    public String getWeapon(){
        return "The weapon of this character is " + this.name;
    }
}
