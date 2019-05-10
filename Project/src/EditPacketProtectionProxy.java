
/**
 *
 * @author jayxu
 */
public class EditPacketProtectionProxy implements EditPacketIF{
    private EditPacket e;
    @Override
    public void editPacket() {
        if(Employee.hasPermission()){
            e.editPacket();
        }else{
            System.out.println("No permission");
        }
   }
    
}
