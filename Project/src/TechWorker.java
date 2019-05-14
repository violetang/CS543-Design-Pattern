public class TechWorker extends Worker {

    public TechWorker(int i, String n, int y, String sex, Department d, EditPacketIF p, boolean permi, Company cc) {
        super(i, n, y, sex, d, p, permi,cc);
    }

    public void development(Case c){
        System.out.println("Developer "+getName()+" is developing the software for "+ c.client.name);
    }
}
