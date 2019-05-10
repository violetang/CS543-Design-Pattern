
public class EditPacket implements EditPacketIF{
    Packet packet;

    public EditPacket(Packet p){
        packet = p;
    }

    @Override
    //increase baseSlary, postion, stock, bonus(automatic increase by 5%)
    public void editBase(double salary, int position, int stock){

        packet.increaseBonus();
        packet.updateSalary(salary);
        packet.updateStock(stock);
        packet.updatePosition(position);

    }

    @Override
    public void editCaseInvolve(TaskIF c) {
        packet.addCase(c);
    }
}
