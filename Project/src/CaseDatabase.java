import java.util.ArrayList;

public class CaseDatabase {

    private ArrayList<CaseForDatabase> database;

    public CaseDatabase(){
        database = new ArrayList<>();
    }


    public void addCase(CaseForDatabase c){
        database.add(c);

    }

    public ArrayList<CaseForDatabase> returnDatabase(){
        return database;
    }

    public void print(){
        System.out.println("CaseName     Client      Plan        Year        Profit      Grade");
        for(CaseForDatabase C : database){
            System.out.println(C.getCaseName() + "      " + C.getClient() + "      "+ C.getPlan()+ "       "+ C.getYear() + "      "+ C.getProfit() + "     "+ C.getGrade());
        }
    }

}
