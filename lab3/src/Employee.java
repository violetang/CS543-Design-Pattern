class Employee extends People {
    private int performanceScale;
    private int salary;

    Employee(String n, int p){
        super(n,p);
    }

    public void setSalary(int sal) {
        this.salary = sal;
    }

    public int getSalary(){
        return salary;
    }

    public void setPerformanceScale(int grade){
        performanceScale = grade;
    }
}
