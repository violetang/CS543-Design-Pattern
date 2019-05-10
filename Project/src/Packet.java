import java.util.ArrayList;

public class Packet {
    private double baseSalary;
    private int position; // 1 = assistant ; 2 = regular; 3 = senior; 4 = staff
    private double bonus; // percentage: 10%, 15%, 20% ..., increase by 5 %;
    private int stock;
    private ArrayList<TaskIF> caseInvolved;
    
    public Packet(int baseSalary, int position, int bonus, int stock){
        this.baseSalary = baseSalary;
        this.position = position;
        this.bonus = bonus;
        this.stock = stock;
        caseInvolved = new ArrayList<TaskIF>();
    }

    // About salary
    public double getBaseSalary(){
        return this.baseSalary;
    }

    //todo: decrease salary
    public void updateSalary(double percentage){
        this.baseSalary = baseSalary * (1 + percentage);
    }


    // Aabout Position
    public void updatePosition(int position){
        this.position = position;
    }
    public int getPosition(){
        return this.position;
    }


    // About bonus;
    public double getBonus(){ return this.bonus; }

    public void increaseBonus() {
        bonus = bonus + 0.05;
    }

    // About stock;
    public int getStock(){return this.stock;}

    public void updateStock(int number){
        this.stock = this.stock + number;
    }

    //About cases;
    public int returnNumnberOfCase(){
        return caseInvolved.size();
    }

    public void addCase(TaskIF c){
        caseInvolved.add(c);
    }

    public void printCase(){
        int i = 0 ;
        for(TaskIF c : caseInvolved){
            Case temp = (Case)c;
            System.out.println(i + "---" + temp.returnClient()+ "\n");
            i++;
        }
    }


}
