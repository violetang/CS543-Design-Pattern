public class WeaponBeginner extends WeaponAbstract implements WeaponIF{

    private final int grade = 1;

    WeaponBeginner(String n) {
        super(n);
    }

    @Override
    public String getDescription(){
        decription = "Beginner Weapon, Name: " + getName() + "Grade: "+ grade + "\n";
        return decription;
    }


}
