public class planA implements PlanIF {
    String name = "Plan A";
    int cost = 300000;
    int price = 1000000;
    String[] context = {"Development", "Testing", "Deployment"};

    public planA(){

    }

    @Override
    public String getName() {
        return name;
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
