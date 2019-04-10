public class Main {

    public static void main(String[] args) {

        //create all the person and the manage structure

        //CEO
        Employee CEO = new CEO("Steve");

        //Two Manger
        Employee Rachel = new Manager("Rachel", CEO);
        Employee Bob = new Manager("Bob", CEO);
        String[] suggesionR = {"not used suggestion", "The city's environmental department is notified"};
        ((Manager) Rachel).suggestDecision(suggesionR);

        String[] suggestionB = { "evacute","not used suggestion"};
        ((Manager) Bob).suggestDecision(suggestionB);


        //Project leaders
        Employee Chuck = new Leader("Chuck", Rachel);
        Employee Denise = new Leader("Denise", Rachel);


        //supervisors
        Employee Jack = new Leader("Jack", Bob);
        Employee Jeff = new Leader("Jeff", Bob);


        //workers
        Employee Joe = new Worker("Joe", Chuck);
        Employee Frank = new Worker("Frank", Chuck);
        Employee Sam = new Worker("Sam", Chuck);
        Employee Greg = new Worker("Greg", Chuck);



        Employee Amy = new Worker("Amy", Denise);
        Employee Wil = new Worker("Wil", Denise);
        Employee Nancy = new Worker("Nancy", Denise);
        Employee Adam = new Worker("Adam", Denise);



        Employee John = new Worker("John", Jack);
        Employee Mary = new Worker("Mary", Jack);
        Employee Jane = new Worker("Jane", Jack);
        Employee Tom = new Worker("Tom", Jack);
        Employee Nick = new Worker("Nick", Jack);


        Employee Rob = new Worker("Rob", Jeff);
        Employee Ed = new Worker("Ed", Jeff);
        Employee Rick = new Worker("Rick", Jeff);
        Employee Michael = new Worker("Michael", Jeff);


        //build up the relations
        ((Leader) Jeff).addPeople(Rob);
        ((Leader) Jeff).addPeople(Ed);
        ((Leader) Jeff).addPeople(Rick);
        ((Leader) Jeff).addPeople(Michael);

        ((Leader) Jack).addPeople(John);
        ((Leader) Jack).addPeople(Mary);
        ((Leader) Jack).addPeople(Jane);
        ((Leader) Jack).addPeople(Tom);
        ((Leader) Jack).addPeople(Nick);

        ((Leader) Denise).addPeople(Amy);
        ((Leader) Denise).addPeople(Wil);
        ((Leader) Denise).addPeople(Nancy);
        ((Leader) Denise).addPeople(Adam);

        ((Leader) Chuck).addPeople(Joe);
        ((Leader) Chuck).addPeople(Frank);
        ((Leader) Chuck).addPeople(Sam);
        ((Leader) Chuck).addPeople(Greg);

        ((Manager) Bob).addPeople(Jack);
        ((Manager) Bob).addPeople(Jeff);

        ((Manager) Rachel).addPeople(Chuck);
        ((Manager) Rachel).addPeople(Denise);


        ((CEO) CEO).addPeople(Rachel);
        ((CEO) CEO).addPeople(Bob);

        //John observed a gas leak of big tank
        John.seeDanger();

    }
}
