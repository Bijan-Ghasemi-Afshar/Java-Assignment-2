/*
 * The Policy List; Represents a list of policy objects
 */
package insurance.company;

import java.util.ArrayList;

/**
 * 13/02/2016
 * @author Bijan 
 */
public class PolicyList {
        
    // Creating a variable of Policy Array List type
    private ArrayList<Policy> policyList;
    
    
    /**
     * Creates a list of policy objects and assigns them to the above variable
     */
    public PolicyList(){        
        policyList = new ArrayList<Policy>();        
    }
    
    
    /**     
     * @param newPolicy         Adds a new Policy to the list
     * @throws insurance.company.IllegalPolicyException     Shows an error message
     *                                                      if there is a double 
     *                                                      of one policy type
     */
    public void addAPolicy(Policy newPolicy) throws IllegalPolicyException{
        if(!isDoublePolicy(newPolicy))
            policyList.add(newPolicy);        
        else
            throw new IllegalPolicyException("A client cannot hold more than"
                    + " one of each  policy type");
                    
    }
    
    
    /**     
     * @return      The number of objects in the list
     */
    public int getTheListSize(){        
        return policyList.size();        
    }
    
    /**
     * Checks for double policy type
     * @param newPolicy     The policy to be added
     * @return              True if there is a double for a policy type; false
     *                      Otherwise
     */
    private boolean isDoublePolicy(Policy newPolicy){
        
        char policyType = newPolicy.getPolicyNumber().charAt(0);
        
        boolean isdoublePolicy = false;
        
        for(Policy eachPolicy: policyList){
         
            if(eachPolicy.getPolicyNumber().charAt(0) == policyType)
                isdoublePolicy = true;                      
        }        
        return isdoublePolicy;
    }
    
    
    /**    
     * @return      A list of policy objects with policy number and the year of issue
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        int counter = 0;
        for(Policy eachPolicy: policyList)
        {            
            counter++;
            str.append("\n\tPolicy ").append(counter).append(". Policy Number: ")
                    .append(eachPolicy.getPolicyNumber())
                    .append(", Year of Issue: ").append(eachPolicy.getYearOfIssue())
                    .append(", The Premium: ").append(eachPolicy.getPremium())
                    .append("\n");            
        }
        return str.toString();
    }            
}
