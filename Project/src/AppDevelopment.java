public class AppDevelopment implements ServiceFatory {

    public PlanIF createPlan(char c){
        switch (c) {
            case 'A':
                return new planA();
            case 'B':
                return new planB();
            case 'C':
                return new planC();
            default:
                throw new IllegalArgumentException("Plan type not supported.");
        }

    }
}
