package game;
/**
 * WeaponAdvanced implements WeaponIF to create a WeaponAdvanced object
 * @Group: 7
 */
public class WeaponAdvanced implements WeaponIF {
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
