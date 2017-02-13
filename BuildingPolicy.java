/*
* The Building Policy Class; is a sub-class of Policy class
*/
package insurance.company;

/**
 * 12/02/2016
 * @author Bijan G.A
 */
public class BuildingPolicy extends Policy {
    
    
    private double estimatedCostOfRebuilding;
    private double riskOfInsuring;
    //the risk of insuring the property (e.g. risk from flood damage etc)
    //and should be a value between 0 and 1, inclusive. Here, 0 is lowest
    //risk and 1 is highest risk.
    private static final double REBUILD_FACTOR = Math.pow(10, -3);
    //is an appropriately set class constant (a typical value for this constan(might be 0.001).
    
    
    /**
     * Creates an instance of a Building Policy
     * @param estimatedCostOfRebuilding     The Estimated Cost Of Rebuilding
     * @param riskOfInsuring                The Risk Of Insuring the Property
     * @param policyNumber                  The Policy Number
     * @param yearOfIssue                   The Year of the Issue of a Policy
     * @throws IllegalPolicyException       Shows an error message if the estimated
     *                                      cost of rebuilding is 0 or the risk
     *                                      of insuring is NOT between 0 and 1
     */
    public BuildingPolicy(double estimatedCostOfRebuilding,
            double riskOfInsuring, String policyNumber, int yearOfIssue)
            throws IllegalPolicyException {
        
        super(policyNumber, yearOfIssue);
        
        if(policyNumber.charAt(0) == 'B'){
            
            if(estimatedCostOfRebuilding > 0 && riskOfInsuring >=0 && riskOfInsuring <= 1){
                this.estimatedCostOfRebuilding = estimatedCostOfRebuilding;
                this.riskOfInsuring = riskOfInsuring;
            } else {
                message = "The Estimated Cost Of Rebuilding does NOT have a value"
                        + "and The value of the risk of insuring MUST be between 0 and 1";
                throw new IllegalPolicyException(message);
            }
            
        } else {
            message = "The type of building policy Must be 'B'(The first character)";
            throw new IllegalPolicyException(message);
        }                
    }
    
    
    /**
     * @return      The Estimated Cost Of Rebuilding
     */
    public double getEstimatedCostOfRebuilding(){
        return estimatedCostOfRebuilding;
    }
    
    
    /**
     * @return      The Risk Of Insuring
     */
    public double getRiskOfInsuring() {
        return riskOfInsuring;
    }
    
    
    /**
     * @return      The Rebuild Factor which is a constant
     */
    public static double getREBUILD_FACTOR() {
        return REBUILD_FACTOR;
    }
    
    
    
    /**
     * @param estimatedCostOfRebuilding     Resets the Estimated Cost Of Rebuilding
     * @throws IllegalPolicyException       Shows an error message
     *                                      if the Estimated CostOf Rebuilding
     *                                      is 0 or negative
     */
    public void setEstimatedCostOfRebuilding(double estimatedCostOfRebuilding)
            throws IllegalPolicyException   {
        if(estimatedCostOfRebuilding > 0){
            this.estimatedCostOfRebuilding = estimatedCostOfRebuilding;
        } else {
            message = "The Estimated Cost Of Rebuilding MUST NOT be 0 or negative";
            throw new IllegalPolicyException(message);
        }
        
    }
    
    
    /**
     * @param riskOfInsuring            Resets the Risk Of Insuring
     * @throws IllegalPolicyException   Show an error message if the risk of
     *                                  Insuring is NOT between 0 and 1
     */
    public void setRiskOfInsuring(double riskOfInsuring)
            throws IllegalPolicyException{
        if(riskOfInsuring >=0 && riskOfInsuring <= 1){
            this.riskOfInsuring = riskOfInsuring;
        } else {
            message = "The value of the risk of insuring MUST be between 0 and 1";
            throw new IllegalPolicyException(message);
        }
        
    }
    
    
    /**
     * Calculates the Insurance Premium
     * @return      The annual cost(premium) of a Building Policy
     */
    @Override
    public double getPremium() {
        return estimatedCostOfRebuilding * REBUILD_FACTOR * (1 + riskOfInsuring);
    }
    
    
    /**
     * @return  The fields and their values of this class
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nPolicy Number: ").append(getPolicyNumber())
                .append("\nYear of Issue: ").append(getYearOfIssue())
                .append("\nEstimated Cost of Rebuild: ").append(estimatedCostOfRebuilding)
                .append("\nRisk of Insuring: ").append(riskOfInsuring)
                .append("\nPremium: ").append(getPremium());
        return str.toString();
    }
}
