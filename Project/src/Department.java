import java.util.ArrayList;

public class Department {

    private String name;
    private Leader leader;

    public Department(String name) {
        this.name = name;
    }

    public String returnDepartmentName(){
        return name;
    }
    
}
