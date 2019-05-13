public class planB implements PlanIF {

    int cost = 500000;
    int price = 1500000;
    String[] context = {"Consulting", "System Design", "Development", "Testing", "Deployment"};

    public planB(){

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
