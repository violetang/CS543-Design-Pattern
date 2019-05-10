
/**
 *
 * @author jayxu
 */
public class Packet {
    private int baseSalary;
    private int position;
    private int bonus;
    private int stock;
    private People p;
    
    public Packet(People p, int baseSalary, int position, int bonus, int stock){
        this.p = p;
        this.baseSalary = baseSalary;
        this.position = position;
        this.bonus = bonus;
        this.stock = stock;
    }
    
    public int getSalary(){
        return this.baseSalary;
    }
    public void setSalary(int salary){
        this.baseSalary = salary;
    }
    public void setPosition(int position){
        this.position = position;
    }
    public int getPosition(){
        return this.position;
    }
}
