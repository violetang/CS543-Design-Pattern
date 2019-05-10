
/**
 *
 * @author jayxu
 */
public class CTO extends Leader {

    public CTO(String name, int ID) {
        super(name, ID);
    }
    
    public void assignDevolopTask(Manager m, Case c){
        m.assignTask(c);
    }
}
