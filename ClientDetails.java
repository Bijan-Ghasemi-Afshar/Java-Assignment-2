/*
 * The Client Details Class; Represents details of an individual client
 */
package insurance.company;

/**
 * 13/02/2016
 * @author Bijan G.A
 */
public class ClientDetails {
   
    // Declaring Variables
    private String ClientID;
    private Name fullName;
    private Address fullAddress;
    private PolicyList policiesHeld;
    
    
    /**
     * Creates an instance of a client
     * @param ClientID      The client's ID
     * @param fullName      The full name of the client
     * @param fullAddress   The full address of the client
     * @param policiesHeld  The policies that are held by the client
     * @throws insurance.company.IllegalPolicyException
     */
    public ClientDetails(String ClientID, Name fullName, Address fullAddress,
            PolicyList policiesHeld)throws IllegalPolicyException{
        if(policiesHeld.getTheListSize() <= 4){
            this.ClientID = ClientID;
            this.fullName = fullName;
            this.fullAddress = fullAddress;
            this.policiesHeld = policiesHeld;
        } else {                        
            throw new IllegalPolicyException("A client cannot hold more than one"
                    + "of each policy");
        }        
    }
    
    
    /**     
     * @return      The client's ID
     */
    public String getClientID() {
        return ClientID;
    }
    
    
    /**     
     * @return      The full name of the client
     */
    public Name getFullName() {        
        return fullName;
    }
    
    
    /**     
     * @return      The full address of the client
     */
    public Address getFullAddress() {                
        return fullAddress;
    }
    
    
    /**     
     * @return      The policies that are held by the client
     */
    public PolicyList getPoliciesHeld() {
        return policiesHeld;
    }
    
    
    /**     
     * @param ClientID      Resets the client's ID
     */
    public void setClientID(String ClientID) {
        this.ClientID = ClientID;
    }
    
    
    /**
     * @param fullName      Resets the client's full name
     */
    public void setFullName(Name fullName) {
        this.fullName = fullName;
    }
    
    
    /**     
     * @param fullAddress       Resets the client's full address
     */
    public void setFullAddress(Address fullAddress) {
        this.fullAddress = fullAddress;
    }
    
    
    /**     
     * @param policiesHeld      Resets the policies that are held by the client
     */
    public void setPoliciesHeld(PolicyList policiesHeld) {
        this.policiesHeld = policiesHeld;
    }
    
        
    /**     
     * @return      The fields and their value of this class
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Client ID: \n\t").append(ClientID)
                .append("\n\nClient's full name: ").append(fullName)
                .append("\n\nClient's full address: ").append(fullAddress)
                .append("\n\nClient's policies: ").append(policiesHeld);
        return str.toString();
    }            
}
