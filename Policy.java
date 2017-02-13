/*
 * The Policy Class; represents the essentials of a Policy
 */
package insurance.company;

/**
 * 11/02/2016
 * @author Bijan G.A
 */
public abstract class Policy {
    
    
    private String policyNumber;
    private int yearOfIssue;    
    
    // The error message 
    protected String message = null;
    
    
    /**
     * Creates an instance of Policy 
     * @param policyNumber                  Policy number
     * @param yearOfIssue                   The year of issue of a policy
     * @throws IllegalPolicyException       throws invalid Year Of Issue of a 
     *                                       policy and invalid Policy Number
     */
    public Policy(String policyNumber, int yearOfIssue)
            throws IllegalPolicyException {
        
        if(yearOfIssue >= 1990 && yearOfIssue <= 2013 && 
                isValidPolicyNumber(policyNumber)){
            
            this.policyNumber = policyNumber;
            this.yearOfIssue = yearOfIssue;                        
            
        } else {
            
            if(!isValidPolicyNumber(policyNumber)){
                message = "The policy number is invalid";
                throw new IllegalPolicyException(message);
            } else {
                message = "The Year of issue is invalid";
                throw new IllegalPolicyException(message);
            }
            
            
        }
        
    }
    
       
    /**
     * @return      The policy number 
     */
    public String getPolicyNumber() {
        return policyNumber;
    }
    
    /**     
     * @return      The Year Of Issue of a policy 
     */
    public int getYearOfIssue() {
        return yearOfIssue;
    }
    
        
    /**     
     * @return      Represents the annual cost(premium) of a policy
     */
    public abstract double getPremium();
    
    
    /**
     * Checks the validity of a policy number
     * @param policyNumber      Gets a policy number to check
     * @return                  True if the policy number is valid  
     */
    private boolean isValidPolicyNumber(String policyNumber){
        
        // Declaring two variables for the First Character and the Remaining 
        // last 8 Characters
        String firstCharacter = policyNumber.substring(0,1);
        String remainingCharacters = policyNumber.substring(1,8);                                
        
        // Checking the length of the Policy Number (Must be 9 characters)
        if(policyNumber.length() != 9){
            
            message = "Your policy number does not have 9 characters";
            return false;
            
        } else
            // Checking the Type of the Policy Number
            if(!firstCharacter.matches("[B,C,V,L]")){
            
            message = "Your policy number does NOT include a type";
            return false;              
                        
        }else
                //Checking the Last 8 Characters (Must be decimal)
                if(!remainingCharacters.matches("[0-9]+")){
            
            message = "Your last 8 characters are NOT decimal numbers";
            return false;
            
        }else{
                       
            return true;
            
        }        
    }
    
    
    /**    
     * @return      The fields and their values of this class
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Policy{policyNumber=").append(policyNumber)
                .append(", yearOfIssue=").append(yearOfIssue).append('}');
        return str.toString();
    }           
}
