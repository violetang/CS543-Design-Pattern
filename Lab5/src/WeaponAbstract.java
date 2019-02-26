public abstract class WeaponAbstract implements WeaponIF {
    private String name;
    public String decription;

    WeaponAbstract(String n){
        name = n;
    }

    public String getName() {
        return name;
    }
}
