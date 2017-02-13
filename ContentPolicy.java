/*
* The Content Policy Class; is a sub-class of Policy class
*/
package insurance.company;

/**
 * 12/02/2016
 * @author Bijan G.A
 */
public class ContentPolicy extends Policy{
        
    private double contentValue;
    private double riskOfInsuring;
    //This should again be a value between 0 and 1, inclusive, with, 0
    //representing the lowest risk and 1 the highest risk.
    private static final double CONTENT_FACTOR = Math.pow(10, -2);
    //is an appropriately set class constant (a typical value for this constan(might be 0.01).
    
    
    /**
     * Creates an instance of a content Policy
     * @param contentValue              The insured value of the content
     * @param riskOfInsuring            The risk of insuring the content
     * @param policyNumber              The Policy Number
     * @param yearOfIssue               The year of issue of a Policy
     * @throws IllegalPolicyException   Shows an error message if the content
     *                                  value is 0 or negative or the risk of
     *                                  insuring is NOT between 0 and 1
     */
    public ContentPolicy(double contentValue, double riskOfInsuring,
            String policyNumber, int yearOfIssue)
            throws IllegalPolicyException {
        
        super(policyNumber, yearOfIssue);
        
        if(policyNumber.charAt(0) == 'C'){
            if(contentValue > 0 && riskOfInsuring >= 0 && riskOfInsuring <= 1){
                this.contentValue = contentValue;
                this.riskOfInsuring = riskOfInsuring;
            } else {
                message = "The content value MUST NOT be 0 or negative"
                        + "and The risk of insuring value MUST be between 0 and 1";
                throw new IllegalPolicyException(message);
            }
            
        } else {
            message = "The type of content policy Must be 'C'(The first character)";
            throw new IllegalPolicyException(message);
        }
        
        
    }
    
    
    /**
     * @return      The Value of a Content
     */
    public double getContentValue() {
        return contentValue;
    }
    
    
    /**
     * @return      The Risk of Insuring the Content
     */
    public double getRiskOfInsuring() {
        return riskOfInsuring;
    }
    
    
    /**
     * @return      The Content Factor which is a constant
     */
    public static double getCONTENT_FACTOR() {
        return CONTENT_FACTOR;
    }
    
    
    /**
     * @param contentValue      Resets the Value of a Content
     */
    public void setContentValue(double contentValue)
            throws IllegalPolicyException{
        if(contentValue > 0){
            this.contentValue = contentValue;
        } else {
            message = "The content value MUST NOT be 0 or negative";
            throw new IllegalPolicyException(message);
        }
    }
    
    
    /**
     * @param riskOfInsuring        Resets the Risk of Insuring the Content
     */
    public void setRiskOfInsuring(double riskOfInsuring)
            throws IllegalPolicyException{
        if(riskOfInsuring >= 0 && riskOfInsuring <= 1){
            this.riskOfInsuring = riskOfInsuring;
        } else {
            message = "The risk of insuring value MUST be between 0 and 1";
            throw new IllegalPolicyException(message);
        }
        
    }
    
    
    /**
     * Calculates the Insurance Premium
     * @return      The annual cost(premium) of a Content Policy
     */
    @Override
    public double getPremium() {
        return contentValue * CONTENT_FACTOR * (1 + riskOfInsuring);
    }
    
    
    /**
     * @return      The fields and their values of this class
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nPolicy Number: ").append(getPolicyNumber())
                .append("\nYear of Issue: ").append(getYearOfIssue())
                .append("\nContent Value: ").append(contentValue)
                .append("\nRisk of Insuring: ").append(riskOfInsuring)
                .append("\nPremium: ").append(getPremium());
        return str.toString();
    }
}
