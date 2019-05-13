public class planC implements PlanIF {
    int cost = 30000;
    int price = 500000;
    String[] context = {"Consulting", "System Design","Development", "Testing", "Deployment", "Maintenance"};

    public planC(){

    }

    public void consulting(){
        System.out.println("Start consulting");
    }

    public void systemDesign(){
        System.out.println("Start design system");
    }

    @Override
    public void development() {
        System.out.println("Start development");
    }

    @Override
    public void test() {
        System.out.println("Start test");
    }

    @Override
    public void deployment() {
        System.out.println("Start deployment");
    }

    public void maintenance(){
        System.out.println("Start maintenance");
    }


    public int getCost() {
        return cost;
    }

    public int getPrice() {
        return price;
    }

    public String[] getContext() {
        return context;
    }
}
