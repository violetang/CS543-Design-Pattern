public class AppDevelopment implements ServiceFatory {

    public PlanIF createPlan(char c){
        switch (c) {
            case 'A':
                return new planC();
            case 'B':
                return new planB();
            case 'C':
                return new planA();
            default:
                throw new IllegalArgumentException("Plan type not supported.");
        }

    }
}
