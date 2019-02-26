public class WeaponIntermediate implements WeaponIF {
    private String name;
    private int grade;
    private String decription;

    WeaponIntermediate(String n, int g){
        name = n;
        grade = g;
    }

    @Override
    public String getDescription(){
        decription = "Name: " + name + "Grade: "+ grade + "\n";
        return decription;
    }
}
