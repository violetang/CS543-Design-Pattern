
import static java.lang.System.exit;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*=========== 1. Create the company, business, department ===========*/
        Company techCom = new Company("TechCom", "1234 Twin Peaks R, San Marocs, 92069 ");

        //Create 4 plan for its app development business : Plan A, Plan B, Plan C
        PlanIF a = techCom.createService('A');
        PlanIF b = techCom.createService('B');
        PlanIF c = techCom.createService('C');


        //create 4 departments: Marketing, Technology, HR, Finance
        Department marketing = new Department("Marketing");
        Department technology = new Department("Technology");
        Department HR = new Department("HR");
        Department finance = new Department("Finance");


        /*=========== 2. build Packet Standard ===========*/
        /*
           Leader:              baseSalary - 500000, Position - Level 7, Bonus - 30%, stock: 1000

           Manager level range (5 - 6)
           Marketing Manager:   baseSalary - 150000, Position - Level 5, Bonus - 15%, stock: 600
           Tech Manager:        baseSalary - 200000, Position - Level 5, Bonus - 15%, stock: 600
           HR Manager:          baseSalary - 120000, Position - Level 5, Bonus - 15%, stock: 600
           Finance Manager:     baseSalary - 120000, Position - Level 5, Bonus - 15%, stock: 600

           Worker level range (1 - 4)
           Marketing Worker:    baseSalary - 50000,  Position - Level 1, Bonus - 5%, stock: 50
           Tech Worker:         baseSalary - 100000, Position - Level 1, Bonus - 5%, stock: 50
           HR:                  baseSalary - 38000,  Position - Level 1, Bonus - 5%, stock: 50
           Finance:             baseSalary - 38000,  Position - Level 1, Bonus - 5%, stock: 50
         */
        //Leader's Packet: CEO, CFO, CTO
        Packet leaderP = new Packet(500000,7, 0.1, 1000);
        EditPacket LP = new EditPacket(leaderP);
        EditPacketProtectionProxy leader_packet = new EditPacketProtectionProxy(LP);

        //Marketing Manager
        Packet Marketing_M = new Packet(150000,5, 0.15, 600);
        EditPacket MM = new EditPacket(Marketing_M);
        EditPacketProtectionProxy MarketingManager_packet = new EditPacketProtectionProxy(MM);

        //tech Manager
        Packet Tech_M = new Packet(200000,5, 0.15, 600);
        EditPacket TM = new EditPacket(Tech_M);
        EditPacketProtectionProxy TechManager_packet = new EditPacketProtectionProxy(TM);

        //HR & Finance Manager
        Packet HR_Fin_M = new Packet(120000,5, 0.15, 600);
        EditPacket HFM = new EditPacket(HR_Fin_M);
        EditPacketProtectionProxy HR_Fin_Manager_packet = new EditPacketProtectionProxy(HFM);

        //Marketing Worker
        Packet Marketing_W = new Packet(50000,1, 0.05, 50);
        EditPacket MW = new EditPacket(Marketing_W);
        EditPacketProtectionProxy MarketingWorker_packet = new EditPacketProtectionProxy(MW);

        //Tech Worker
        Packet Tech_W = new Packet(100000,1, 0.05, 50);
        EditPacket TW = new EditPacket(Tech_W);
        EditPacketProtectionProxy TechWorker_packet = new EditPacketProtectionProxy(TW);

        //HR & Finance Worker
        Packet HR_Fin_W = new Packet(38000,1, 0.05, 50);
        EditPacket HRW = new EditPacket(HR_Fin_W);
        EditPacketProtectionProxy HR_Fin_Worker_packet = new EditPacketProtectionProxy(HRW);


        /*=========== build employee system ===========*/

        //Leaders: CEO, CFO, CTO
        Leader ceo = new CEO(1,"Zuck", 2000, "Male", marketing, leader_packet, true);
        Leader cfo = new CFO(2, "Matt", 2003, "Female", finance, leader_packet, true);
        Leader cto = new CTO(3, "Hook", 2005, "Male", technology, leader_packet, true);
        techCom.addEmployee(ceo);
        techCom.addEmployee(cfo);
        techCom.addEmployee(cto);

        //Two managers for Marketing department
        Manager yusuf = new MarketingManager(4, "Yusuf", 2010, "Male", marketing, MarketingManager_packet, false);
        techCom.addEmployee(yusuf);
        Manager anahi = new MarketingManager(5, "Anahi", 2012, "Female", marketing, MarketingManager_packet, false);
        techCom.addEmployee(anahi);
        ((CEO) ceo).addManager((MarketingManager) yusuf);
        ((CEO) ceo).addManager((MarketingManager) anahi);


        //four workers for Marketing department
        Worker jack = new MarketingWorker(6,"Jack", 2016, "Male", marketing, MarketingWorker_packet, false);
        techCom.addEmployee(jack);
        ((MarketingManager)yusuf).addWorker((MarketingWorker) jack);

        Worker sophia = new MarketingWorker(7,"Sophia", 2016, "Female", marketing, MarketingWorker_packet, false);
        techCom.addEmployee(sophia);
        ((MarketingManager)yusuf).addWorker((MarketingWorker) sophia);

        Worker allen = new MarketingWorker(8,"Allen", 2016, "Male", marketing, MarketingWorker_packet, false);
        techCom.addEmployee(allen);
        ((MarketingManager)anahi).addWorker((MarketingWorker) allen);

        Worker denis = new MarketingWorker(9,"Denis", 2014, "Male", marketing, MarketingWorker_packet, false);
        techCom.addEmployee(denis);
        ((MarketingManager)anahi).addWorker((MarketingWorker) denis);

        //Two managers for Tech department
        Manager jerry = new TechManager(10, "jerry", 2010, "Male", technology, TechManager_packet, false);
        techCom.addEmployee(jerry);

        Manager henry = new TechManager(11, "henry", 2010, "Male", technology, TechManager_packet, false);
        techCom.addEmployee(henry);


        //four workers for Tech department
        Worker frank = new TechWorker(12,"frank", 2016, "Male", technology, TechWorker_packet, false);
        techCom.addEmployee(frank);
        ((TechManager)jerry).addWorker((TechWorker) frank);

        Worker joey = new TechWorker(13,"joey", 2014, "Female", technology, TechWorker_packet, false);
        techCom.addEmployee(joey);
        ((TechManager)jerry).addWorker((TechWorker) joey);

        Worker jay = new TechWorker(14,"jay", 2014, "Female", technology, TechWorker_packet, false);
        techCom.addEmployee(jay);
        ((TechManager)henry).addWorker((TechWorker) jay);

        Worker chris = new TechWorker(15,"Chris", 2014, "Female", technology, TechWorker_packet, false);
        techCom.addEmployee(chris);
        ((TechManager)henry).addWorker((TechWorker) chris);


        //Two managers for HR department + workers

        //Two managers for Finance department + workers

        /*=========== test employee system ===========*/
        /*
        for(EmployeeIF e: techCom.getEmployee()){
            System.out.println(e.getName() +"   "+ e.getDept() + "  " + e.getPosition()+ "\n");
        }

        for(EmployeeIF e: ((MarketingManager) yusuf).getTeam()){
            System.out.println(e.getName() +"   "+ e.getDept() + "  " + e.getPosition()+ "\n");
        }

        for(EmployeeIF e: ((TechManager) henry).getTeam()){
            System.out.println(e.getName() +"   "+ e.getDept() + "  " + e.getPosition()+ "\n");
        }

        yusuf.editBase(2, 7, 1000);
        */

        /*=========== Start to run the system ===========*/

        //todo: could use a while loop, for user iteraction

        //1. Print out plan Menu:
        System.out.println("\n");
        System.out.println("/*=========== Welcome to " + techCom.getName()+" ===========*/");
        System.out.println("Our company provides following Software development plans: \n");
        System.out.println("********************************");
        System.out.println(c.getName()+ "   Price:  $" + c.getPrice()+ " \nincluding:");
        String[] temp = c.getContext();
        for(int i = 0 ; i < temp.length; i++){
            System.out.println(i+ " - "+temp[i]);
        }
        System.out.println("********************************");
        System.out.println(b.getName()+ "   Price:  $" + b.getPrice()+ " \nincluding:");
        temp = b.getContext();
        for(int i = 0 ; i < temp.length; i++){
            System.out.println(i+ " - "+temp[i]);
        }
        System.out.println("********************************");
        System.out.println(a.getName()+ "   Price:  $" + a.getPrice()+ " \nincluding:");
        temp = a.getContext();
        for(int i = 0 ; i < temp.length; i++){
            System.out.println(i+ " - "+temp[i]);
        }
        System.out.println("********************************");
        System.out.println("Additional function: $ 10 k per each");
        System.out.println("********************************");


        //2. assume client choose Plan A, Budget 80k;
        //todo: let client input
        Client clientA = new Client("clientA", 500000, 'A');

        //Create the case of client A and assign a marketing worker for it.
        Case caseOfClientA = new Case("CaseOfClientA", clientA, a,(CEO)ceo,(CFO)cfo,(CTO)cto);
        caseOfClientA.caseStart();

        //client do the survey
        caseOfClientA.grade(100);

        //hr + financce




    }



    //create a client
    //company shows/print out our serveices: Plan A, Plan B, Plan C.
    //client show their choice
    //base on client's choice to create a task
    //start the task
    //6 months, employee performance evaluation
    //hr start to evaluate and print out the results.
}
