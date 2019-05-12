
public class EditPacketProtectionProxy implements EditPacketIF{
    private EditPacket e;

    public EditPacketProtectionProxy(EditPacket x){
        e = x;
    }

    @Override
    public void editBase(double salary, int position, int stock){
        if(Employee.hasPermission()){
            e.editBase(salary, position, stock);
        }else{
            System.out.println("No permission");
        }
   }

    @Override
    public void editCaseInvolve(TaskIF c) {
        if(Employee.hasPermission()){
            e.editCaseInvolve(c);
        }else{
            System.out.println("No permission");
        }
    }

    @Override
    public double getbonus() {
        return e.getbonus();
    }

    @Override
    public double getSalary() {
        return e.getSalary();
    }

    @Override
    public int getStock() {
        return e.getStock();
    }

    @Override
    public int getPosition() {
        return e.getPosition();
    }

    @Override
    public void getCase() {
        e.getCase();
    }
}
