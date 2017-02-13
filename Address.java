/*
* The Address Class; Represents the Address of the client
*/
package insurance.company;

/**
 * 13/02/2016
 * @author Bijan G.A
 */
public class Address implements Comparable<Address>{
    
    // Declaring variables
    private String street;
    private String townORcity;
    private String postcode;
    
    
    /**
     * Creates an instance of Address
     * @param street        The street name of client's address
     * @param townORcity    The town or city name of client's address
     * @param postcode      The postcode of client
     */
    public Address(String street, String townORcity, String postcode) {
        this.street = street;
        this.townORcity = townORcity;
        this.postcode = postcode;
    }
    
    
    /**
     * Compares to address for their equality
     * @param secondCAddress        The address to be compared to this address
     * @return      0 if both addresses are equal, 1 otherwise
     */
    @Override
    public int compareTo(Address secondCAddress) {
        
        if(this.street.equals(secondCAddress.street) &&
                this.postcode.equals(secondCAddress.postcode)&&
                this.townORcity.equals(secondCAddress.townORcity))
        {
            
            return 0;
            
        } else 
        {
            return 1;
        }
        
        
    }
    
    
    /**
     * @return      The street of client's address
     */
    public String getStreet() {
        return street;
    }
    
    
    /**
     * @return      The town or city of client's address
     */
    public String getTownORcity() {
        return townORcity;
    }
    
    
    /**
     * @return      The postcode of client's postcode
     */
    public String getPostcode() {
        return postcode;
    }
    
    
    /**
     * @param street        Resets the street of client's address
     */
    public void setStreet(String street) {
        this.street = street;
    }
    
    
    /**
     * @param townORcity        Resets the town or city of client's address
     */
    public void setTownORcity(String townORcity) {
        this.townORcity = townORcity;
    }
    
    
    /**
     * @param postcode      Resets the postcode of client's address
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    
    /**
     * @return      The fields and their value of this class
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("\n\t");
        str.append(street).append("\n\t");
        str.append(townORcity).append("\n\t");
        str.append(postcode);
        return str.toString();
    }
}
