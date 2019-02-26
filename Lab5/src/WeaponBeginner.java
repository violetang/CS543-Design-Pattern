public class WeaponBeginner implements WeaponIF {

    private String name;
    private int grade;
    private String decription;

    WeaponBeginner(String n, int g){
        name = n;
        grade = g;
    }

    @Override
    public String getDescription(){
        decription = "Name: " + name + "Grade: "+ grade + "\n";
        return decription;
    }


}
