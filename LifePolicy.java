/*
* The Life Policy Class; is a sub-class of Policy class
*/
package insurance.company;

/**
 * 13/02/2016
 * @author Bijan G.A
 */
public class LifePolicy extends Policy{
    
    private int policyHolderAge;
    private int insuranceAmount;
    //the amount for which the life is covered
    private double healthRisk;
    //the health risk of the policy-holder and is a value between
    //0 (lowest risk) and 5 (highest risk)
    
    
    /**
     * Creates an instance of a Life Policy
     * @param policyHolderAge       The age of policy-holder
     * @param insuranceAmount       The amount for which the life is covered
     * @param healthRisk            The health risk of the policy-holder
     * @param policyNumber          The policy number
     * @param yearOfIssue           The year of issue of the policy
     * @throws IllegalPolicyException   Shows an error message if the age of the
     *                                  policy-holder is 0 or negative OR the
     *                                  insurance amount is 0 or negative OR the
     *                                  health risk is NOT between 0 and 5
     */
    public LifePolicy(int policyHolderAge, int insuranceAmount,
            double healthRisk, String policyNumber, int yearOfIssue)
            throws IllegalPolicyException {
        
        super(policyNumber, yearOfIssue);
        
        if(policyNumber.charAt(0) == 'L'){
            if(policyHolderAge > 0 && insuranceAmount > 0 && healthRisk >=0 &&
                    healthRisk <= 5){
                this.policyHolderAge = policyHolderAge;
                this.insuranceAmount = insuranceAmount;
                this.healthRisk = healthRisk;
            } else {
                message = "Policy holder's age and insurance amount are positive"
                        + " values and health risk MUST be between 0 and 5";
                throw new IllegalPolicyException(message);
            }
            
        } else{
            message = "The type of Life policy Must be 'L'(The first character)";
            throw new IllegalPolicyException(message);
        }
        
    }
    
    
    /**
     * @return      The age of the policy-holder
     */
    public int getPolicyHolderAge() {
        return policyHolderAge;
    }
    
    
    /**
     * @return      The amount for which the life is covered
     */
    public int getInsuranceAmount() {
        return insuranceAmount;
    }
    
    
    /**
     * @return      The health risk of the policy-holder
     */
    public double getHealthRisk() {
        return healthRisk;
    }
    
    
    /**
     * @param policyHolderAge
     */
    public void setPolicyHolderAge(int policyHolderAge) 
            throws IllegalPolicyException {
        if(policyHolderAge > 0)
            this.policyHolderAge = policyHolderAge;
        else{
            message = "Policy holder's age is a positive value";
            throw new IllegalPolicyException(message);
        }
            
        
    }
    
    
    /**
     * @param insuranceAmount
     */
    public void setInsuranceAmount(int insuranceAmount) 
            throws IllegalPolicyException{
        if(insuranceAmount > 0)
            this.insuranceAmount = insuranceAmount;
        else{
            message = "The insurance amount is a positive value";
            throw new IllegalPolicyException(message);
        }        
    }
    
    
    /**
     * @param healthRisk        Resets the health risk of the policy-holder
     * @throws IllegalPolicyException   Shows an error message if the health
     *                                  risk is NOT between 0 and 5
     */
    public void setHealthRisk(double healthRisk) throws IllegalPolicyException{
        
        if(healthRisk >= 0 && healthRisk <= 5){
            this.healthRisk = healthRisk;
        } else {
            message = "The health risk MUST be between 0 and 5";
            throw new IllegalPolicyException(message);
        }
        
    }
    
    
    /**
     * Calculates the Insurance Premium
     * @return          The annual cost(premium) of a Life Policy
     */
    @Override
    public double getPremium() {
        int companyAgeThreshold = 30;
        
        double basicAmount = insuranceAmount/1000;
        
        double premium = basicAmount * (1 + healthRisk);
        
        if(policyHolderAge > companyAgeThreshold)
            premium *= policyHolderAge/companyAgeThreshold;
        
        return premium;
    }
    
    
    /**
     * @return      The fields and their values of this class
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nPolicy Number: ").append(getPolicyNumber())
                .append("\nYear of Issue: ").append(getYearOfIssue())
                .append("\nPolicy Holder's Age: ").append(policyHolderAge)
                .append("\nInsurance Amount: ").append(insuranceAmount)
                .append("\nHealth Risk: ").append(healthRisk)
                .append("\nPremium: ").append(getPremium());
        return str.toString();
    }
}
