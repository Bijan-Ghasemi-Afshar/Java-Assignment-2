/*
 * The MAIN method class; Simulates data from an insurance company
 */
package insurance.company;

import static insurance.company.InputData.readFile;
import java.io.File;
import java.io.IOException;

/**
 * 11/02/2016
 * @author Bijan G.A
 */
public class InsuranceCoDemo {
    
    public static void main(String[] args) throws IllegalPolicyException, IOException {
        
        
        /**
         * Reading the text file as input
         */
//        String fileLocation = "Input Sheet.txt";
//        File textFile = new File(fileLocation);    
//        System.out.println(readFile( textFile ));
                        
        
        
        /**
         * Testing the Classes during the development 
         */
        
        System.out.println("_____________________Policies_____________________");
        BuildingPolicy building1 = new BuildingPolicy(150, 0.3, "B23226528", 2010);        
        System.out.println(building1);
        
        ContentPolicy content1 = new ContentPolicy(342, 0, "C23058275", 1997);        
        System.out.println(content1);
        
        CarPolicy car1 = new CarPolicy(2000, 20, 2, 0, "V92740284", 2000);
        System.out.println(car1);
        
        LifePolicy life1 = new LifePolicy(27, 2000, 3, "L93847520", 2007);
        System.out.println(life1);
        
        
        /**
         * For testing the isDoublePolicy method in PolicyList
         */
//        CarPolicy car2 = new CarPolicy(2300, 25, 1, 0,"V93735752", 2002);
//        System.out.println(car2);
        
        System.out.println("_____________________Policy List_____________________");
        PolicyList list1 = new PolicyList();
        list1.addAPolicy(building1);
        list1.addAPolicy(content1);
        PolicyList list2 = new PolicyList();
        list2.addAPolicy(car1);
        list2.addAPolicy(life1);
        
        /**
         * For testing the isDoublePolicy method in PolicyList
         */
//        list2.addAPolicy(car2);
        
        System.out.println("List 1\n"+list1);
        System.out.println("List 2\n"+list2);
        
        
                
        System.out.println("________________________Name______________________\n");        
        Name clientName = new Name("MR", "B", "AFSHAR");
        System.out.println(clientName);
        Name clientName2 = new Name("MR", "A", "AFSHAR");
        
        System.out.println("________________________Address______________________\n");
        // Attention to client's street
        Address clientAddress = new Address("University Dillage", "Norwich",
                "NR4 7TJ");
        System.out.println(clientAddress);
        Address clientAddress2 = new Address("University Village", "Norwich",
                "NR4 7TJ");
        
        System.out.println("________________________Client______________________\n");
        String clientID = "IDN-342214342";
        String clientID2 = "INF-4342428720";
        
        ClientDetails newClient = new ClientDetails(clientID, clientName, 
                clientAddress,list1);
        System.out.println(newClient);
        ClientDetails newClient2 = new ClientDetails(clientID2, clientName2, 
                clientAddress2,list2);                

        
        System.out.println("______________________Client List________________________\n");
        ClientDetailsList listOfClients = new ClientDetailsList();
        listOfClients.addClient(newClient);
        listOfClients.addClient(newClient2);
        
        System.out.println(listOfClients);
        
        System.out.println("______________________Client List SAME ADDRESS________________________\n");
        // Changing the given client's address to be equal to the other client's
        clientAddress.setStreet("University Village");
        newClient.setFullAddress(clientAddress);
        System.out.println("Given client: \n"+newClient);
        System.out.println("Found client: \n"+listOfClients.sameAddressCheck(newClient));
        
        
        System.out.println("______________________Client List CLIENT DETAILS___________________\n");
        
        System.out.println(listOfClients.getClientDetails("IDN-342214342"));

        
        System.out.println("______________________Client List FIND CLIENT________________________\n");
        
        System.out.println(listOfClients.findClient("AFSHAR", "NR4 7TJ"));
                        
    }    
}
