
import static java.lang.System.exit;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Create the company
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

        /* Packet Standard:
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
        //create basic packet
        Packet leaderP = new Packet(500000,7, 0.1, 1000);
        EditPacket LP = new EditPacket(leaderP);
        EditPacketProtectionProxy leader_packet = new EditPacketProtectionProxy(LP);

        Packet Marketing_M = new Packet(150000,5, 0.15, 600);
        EditPacket MM = new EditPacket(Marketing_M);
        EditPacketProtectionProxy MarketingManager_packet = new EditPacketProtectionProxy(MM);

        Packet Tech_M = new Packet(200000,5, 0.15, 600);
        EditPacket TM = new EditPacket(Tech_M);
        EditPacketProtectionProxy TechManager_packet = new EditPacketProtectionProxy(TM);

        Packet HR_Fin_M = new Packet(120000,5, 0.15, 600);
        EditPacket HFM = new EditPacket(HR_Fin_M);
        EditPacketProtectionProxy HR_Fin_Manager_packet = new EditPacketProtectionProxy(HFM);

        Packet Marketing_W = new Packet(50000,1, 0.05, 50);
        EditPacket MW = new EditPacket(Marketing_W);
        EditPacketProtectionProxy MarketingWorker_packet = new EditPacketProtectionProxy(MW);

        Packet Tech_W = new Packet(100000,1, 0.05, 50);
        EditPacket TW = new EditPacket(Tech_W);
        EditPacketProtectionProxy TechWorker_packet = new EditPacketProtectionProxy(TW);

        Packet HR_Fin_W = new Packet(38000,1, 0.05, 50);
        EditPacket HRW = new EditPacket(HR_Fin_W);
        EditPacketProtectionProxy HR_Fin_Worker_packet = new EditPacketProtectionProxy(HRW);


        //build employee system
        Leader ceo = new CEO(001,"Zuck", 2000, "Male", marketing, leader_packet, true);
        Leader cfo = new CFO(002, "Matt", 2003, "Female", finance, leader_packet, true);
        Leader cto = new CTO(003, "Hook", 2005, "Male", technology, leader_packet, true);





        //Start to wrong business
        //todo: could use a while loop, for user iteraction

        //1. Print out plan Menu:


        //2. assume client choose Plan A, Budget 80k;
        Client clientA = new Client("clientA", 80000, 'A');

        //a marketing worker make a decision

        //client decide to do , and sign the contract
        clientA.sign(1);

        //Create a case
        //case start to run

        //case finish

        //client do the survey




    }



    //create a client
    //company shows/print out our serveices: Plan A, Plan B, Plan C.
    //client show their choice
    //base on client's choice to create a task
    //start the task
    //6 months, employee performance evaluation
    //hr start to evaluate and print out the results.
}
