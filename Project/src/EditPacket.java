import java.util.ArrayList;

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
    public void editCaseInvolve(Case c) {
        packet.addCase(c);
    }

    @Override
    public double getbonus() {
        return packet.getBonus();
    }

    @Override
    public double getSalary() {
        return packet.getBaseSalary();
    }

    @Override
    public int getPosition() {
        return packet.getPosition();
    }

    @Override
    public int getStock() {
        return packet.getStock();
    }

    @Override
    public void getCase() {
        packet.printCase();
    }
}
