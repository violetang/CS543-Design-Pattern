public class WeaponAdvanced extends WeaponAbstract implements WeaponIF {
    private final int grade = 3;

    WeaponAdvanced(String n) {
        super(n);
    }

    @Override
    public String getDescription(){
        decription = "Advanced Weapon, Name: " + getName() + "Grade: "+ grade + "\n";
        return decription;
    }
}
