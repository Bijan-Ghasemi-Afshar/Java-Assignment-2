/*
* The Client Details List Class; Represents a collection of client details
*/
package insurance.company;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 17/02/2016
 * @author Bizhan
 */
public class ClientDetailsList {
    
    // Declaring Variables
    ArrayList<ClientDetails> listOfClients;
    
    
    /**
     * Creates a collection of clients details
     */
    public ClientDetailsList()
    {
        listOfClients = new ArrayList<>();        
    }
    
    
    /**
     * @param newClient         Adds a new client details to the collection
     */
    public void addClient(ClientDetails newClient)
    {
        listOfClients.add(newClient);
    }
    
    
    /**
     * @return      The size of the list of client details
     */
    public int numberOfClients()
    {
        return listOfClients.size();
    }
    
    
    /**
     * A method to determine whether or not a given person, identified by a
     * surname and a postcode is a client of the Insurance company.
     * If so, the client’s ID should be returned.
     * @param lastName the surname of the person to be searched for.
     * @param code the postcode of the address of the person to be
     * searched for.
     * @return the Client ID if the person has at least one policy
     * with the company, null otherwise.
     */
    public String findClient(String lastName, String code){
        
        Iterator<ClientDetails> it = listOfClients.iterator();
        
        while(it.hasNext()){
            
            ClientDetails cDetails = it.next();
            
            Name cFullName = cDetails.getFullName();
            String cSurname = cFullName.getSurname();
            
            Address cFullAddress = cDetails.getFullAddress();
            String cPostcode = cFullAddress.getPostcode();
            
            String cID = cDetails.getClientID();
            
            if(cPostcode.matches(code) && cSurname.matches(lastName))
            {
                return cID;
            }
        }
        return null;
    }
    
    
    /**
     * A method to get the client details corresponding to a given client ID
     *
     * @param givenID       The client ID whose details are required.    
     *
     * @return the required ClientDetails if found,
     * null otherwise.
     * Page 6 of 7 Submission instructions overleaf.
     */
    public ClientDetails getClientDetails(String givenID){
        
        Iterator<ClientDetails> it = listOfClients.iterator();
        
        while(it.hasNext()){
            
            ClientDetails cDetails = it.next();
            
            String cID = cDetails.getClientID();
            
            if(cID.matches(givenID))
            {
                return  cDetails;
            }
        }
        return null;
    }
    
    
    /**
     * A method to determine another client who has the same address as
     * the client whose details are given.
     *
     * @param cDetails the client details whose address is to be
     * searched for.
     * @return the ClientDetails of a client with the same
     * address if there is one, null otherwise.
     */
    public ClientDetails sameAddressCheck(ClientDetails cDetails){
        
        Iterator<ClientDetails> it = listOfClients.iterator();
        
        while(it.hasNext()){
            
            Address firstCAddress = cDetails.getFullAddress();
            
            ClientDetails newCDetails = it.next();                         
                        
            Address secondCAddress = newCDetails.getFullAddress();
            
            if(firstCAddress.compareTo(secondCAddress) == 0 &&
                    !cDetails.getClientID().equals(newCDetails.getClientID()))
            {
                return  newCDetails;
            } 
        }        
        return null;
        
    }
    
    
    /**
     * @return      The details of a client
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(ClientDetails eachClient: listOfClients)
        {
            str.append("\n___________________________________\nClient ID: \n\t")
                    .append(eachClient.getClientID()).append("\n")
                    .append("\nClient's Full Name: ")
                    .append(eachClient.getFullName()).append("\n")
                    .append("\nClient's Full Address: ")
                    .append(eachClient.getFullAddress()).append("\n")
                    .append("\nPolicies Held By The Client: ")
                    .append(eachClient.getPoliciesHeld());
        }
        return str.toString();
    }
}
