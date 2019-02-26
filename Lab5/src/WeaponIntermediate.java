public class WeaponIntermediate extends WeaponAbstract implements WeaponIF {
    private final int grade = 3;

    WeaponIntermediate(String n) {
        super(n);
    }

    @Override
    public String getDescription(){
        decription = "Intermediate Weapon, Name: " + getName() + "Grade: "+ grade + "\n";
        return decription;
    }
}
