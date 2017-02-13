/*
* The Car Policy Class; is a sub-class of Policy class
*/
package insurance.company;

import static java.lang.Math.max;

/**
 * 12/02/2016
 * @author Bijan G.A
 */
public class CarPolicy extends Policy{
    
    
    private double vehicleValue;
    private int driversAge;
    private int yearsWithNoClaim;
    //  Representing the number of years no claim has been made on the policy
    private boolean isFullyComprehensive;
    private static final byte BASIC_COVER = 100;
    // is an appropriately set class constant (a typical value for this constantmight be 100).
    
    
    /**
     * Creates an instance of a Car Policy
     * @param vehicleValue          The Value of the Vehicle that has been insured
     * @param driversAge            The driver's Age
     * @param yearsWithNoClaim      The number of Years that no Claim has been
     *                              made on the Policy
     * @param isFullyComprehensive  The indication of the comprehensiveness of the Policy
     * @param policyNumber          The Policy Number
     * @param yearOfIssue           The year of issue of a Policy
     * @throws IllegalPolicyException   Shows an error message if the vehicle
     *                                  value is 0 or negative OR the driver's
     *                                  age is more than 99 or less than 17 OR
     *                                  if the number of years with no claim is
     *                                  negative
     */
    public CarPolicy(double vehicleValue, int driversAge, int yearsWithNoClaim,
            int isFullyComprehensive, String policyNumber, int yearOfIssue)
            throws IllegalPolicyException {
        
        super(policyNumber, yearOfIssue);
        
        if(policyNumber.charAt(0) == 'V'){
            
            if(vehicleValue > 0 && driversAge >= 17 && driversAge <= 99
                    && yearsWithNoClaim >= 0){
                this.vehicleValue = vehicleValue;
                this.driversAge = driversAge;
                this.yearsWithNoClaim = yearsWithNoClaim;
                if(isFullyComprehensive == 0)
                    this.isFullyComprehensive = false;
                else
                    this.isFullyComprehensive = true;
                
            } else {
                message = "The number of years and vehicle value MUST NOT be 0 or "
                        + "negative and The driver's age MUST NOT be less than 17 "
                        + "or more than 99";
                throw new IllegalPolicyException(message);
            }
            
        } else {
            message = "The type of car(vehicle) policy Must be 'V'(The first character)";
            throw new IllegalPolicyException(message);
        }
        
        
    }
    
    
    /**
     * @return      The value of the vehicle
     */
    public double getVehicleValue() {
        return vehicleValue;
    }
    
    
    /**
     * @return      The driver's age
     */
    public int getDriversAge() {
        return driversAge;
    }
    
    
    /**
     * @return      The number of years no claim has been made on the policy
     */
    public int getYearsWithNoClaim() {
        return yearsWithNoClaim;
    }
    
    
    /**
     * @return      The indication of comprehensiveness of the Policy
     */
    public boolean isIsFullyComprehensive() {
        return isFullyComprehensive;
    }
    
    
    /**
     * @return      The Basic Cover which is a constant
     */
    public static byte getBASIC_COVER() {
        return BASIC_COVER;
    }
    
    
    /**
     * @param vehicleValue              Resets the vehicle value
     * @throws IllegalPolicyException   Shows an error message if th value of a
     *                                  vehicle is 0 or negative
     */
    public void setVehicleValue(double vehicleValue)
            throws IllegalPolicyException{
        if(vehicleValue > 0){
            this.vehicleValue = vehicleValue;
        } else {
            message = "The vehicle value MUST NOT be 0 or negative";
            throw new IllegalPolicyException(message);
        }
        
    }
    
    
    /**
     * @param driversAge                Resets the driver's age
     * @throws IllegalPolicyException   Shows an error message if the driver's age
     *                                  is less than 17 or more than 99
     */
    public void setDriversAge(int driversAge)
            throws IllegalPolicyException{
        if(driversAge >= 17 && driversAge <= 99){
            this.driversAge = driversAge;
        } else {
            message = "The driver's age MUST NOT be less than 17 or more than 99";
            throw new IllegalPolicyException(message);
        }
        
    }
    
    
    /**
     * @param yearsWithNoClaim          Resets the number of years no claim has
     *                                  been made on the policy
     * @throws IllegalPolicyException   Shows an error message if the number of
     *                                  years is negative
     */
    public void setYearsWithNoClaim(int yearsWithNoClaim)
            throws IllegalPolicyException{
        if(yearsWithNoClaim >= 0){
            this.yearsWithNoClaim = yearsWithNoClaim;
        } else {
            message = "The number of years CANNOT be 0 or negative";
            throw new IllegalPolicyException(message);
        }
        
    }
    
    
    /**
     * @param isFullyComprehensive      Resets the comprehensiveness of the Policy
     *                                  if the input is 0 the vehicle is not fully
     *                                  comprehensive and if it's 1 the vehicle is
     *                                  fully comprehensive
     */
    public void setIsFullyComprehensive(byte isFullyComprehensive) {
        if(isFullyComprehensive == 0)
            this.isFullyComprehensive = false;
        else
            this.isFullyComprehensive = true;            
    }
    
    
    /**
     * Calculates the Insurance Premium
     * @return          The annual cost(premium) of a Car Policy
     */
    @Override
    public double getPremium() {
        
        double initialPremium = max(BASIC_COVER, (0.1 * vehicleValue));
        
        if(isFullyComprehensive){
            initialPremium += (0.5 * initialPremium);
        }
        if(driversAge <= 25){
            initialPremium += (0.5 * initialPremium);
        }
        if(yearsWithNoClaim < 5){
            initialPremium += (0.075 * yearsWithNoClaim);
        } else if(yearsWithNoClaim >= 5){
            initialPremium += (0.075 * 5);
        }
        
        return initialPremium;
    }
    
    
    /**
     * @return          The fields and their values of this class
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nPolicy Number: ").append(getPolicyNumber())
                .append("\nYear of Issue: ").append(getYearOfIssue())
                .append("\nVehicle Value: ").append(vehicleValue)
                .append("\nDriver's Age: ").append(driversAge)
                .append("\nYears without Claim: ").append(yearsWithNoClaim)
                .append("\nIs Fully Comprehensive? ").append(isFullyComprehensive)
                .append("\nPremium: ").append(getPremium());
        return str.toString();
    }
    
    
}
