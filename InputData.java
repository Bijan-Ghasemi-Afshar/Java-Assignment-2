/*
 * The Input Data Class; Reads data from a text file
 */
package insurance.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 19/02/2016
 * @author Bijan 
 */
public class InputData {
    
    public static ClientDetailsList readFile( File inputFile )
            throws IOException, IllegalPolicyException{
        
        // Declaring a variable and creating objects in order to read the text file and use it to input data        
        Scanner scan = new Scanner(inputFile).useDelimiter("#");
        ClientDetailsList clientList = new ClientDetailsList();        
        String data = "";
        
        
        // Reading each client's data(Line)
        while(scan.hasNext()){
            
            data = scan.next().trim();
            PolicyList policyList = new PolicyList();
            
            Scanner client = new Scanner(data).useDelimiter("/");
            
            
            // Reading each data from the whole client's data                        
            String clientID = client.next();
            
            String clientTitle = client.next();
            String clientInitials = client.next();
            String clientSurname = client.next();
            // Making a name object for client
            Name clientName = new Name(clientTitle, clientInitials, clientSurname);
            
            String clientStreet = client.next();
            String clientTown = client.next();
            String clientPostCode = client.next();
            // Making an address object for client
            Address clientAddress = new Address(clientStreet, clientTown, clientPostCode);
            
            
            while(client.hasNext()){
               
                int policyYear = client.nextInt();
                
                String policyNumber = client.next();
                
                switch(policyNumber.charAt(0)){
                    
                    case 'B':                                                 
                        double rebuildCost = client.nextDouble();
                        double risk = client.nextDouble();
                        // Making a building policy
                        BuildingPolicy cBuilding = new BuildingPolicy(
                                rebuildCost,risk, policyNumber, policyYear);
                        // Adding the policy to the policy list
                        policyList.addAPolicy(cBuilding);
                            ;break;
                    
                    case 'C':
                        double contentVal = client.nextDouble();
                        double contentRisk = client.nextDouble();
                        // Making a content policy
                        ContentPolicy cContent = new ContentPolicy(contentVal,
                         contentRisk, policyNumber, policyYear);
                        // Adding the policy to the policy list
                        policyList.addAPolicy(cContent);
                        break;
                        
                    case 'V': 
                        double vehicleVal = client.nextDouble();
                        int driverAge = client.nextInt();
                        int yearsNoClaim = client.nextInt();
                        byte fComp = client.nextByte();
                        // Making a car policy
                        CarPolicy cCar = new CarPolicy(vehicleVal, driverAge,
                         yearsNoClaim, fComp, policyNumber, policyYear);
                        // Adding the policy to the policy list
                        policyList.addAPolicy(cCar);
                        break;
                        
                    case 'L':                        
                        int insAmount = client.nextInt();
                        int clientAge = client.nextInt();
                        double healthRisk = client.nextDouble();
                        // Making a life policy
                        LifePolicy cLife = new LifePolicy(clientAge, insAmount
                        , healthRisk, policyNumber, policyYear);
                        // Adding the policy to the policy list
                        policyList.addAPolicy(cLife);
                        break;
                }
            }
            // Making a client object
            ClientDetails newClient = new ClientDetails(clientID, clientName, 
                    clientAddress, policyList);
            // Adding the client to the client list            
            clientList.addClient(newClient);
        }
        
        scan.close();
        
        return clientList;
    }
}
