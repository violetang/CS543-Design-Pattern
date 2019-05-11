
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
}
