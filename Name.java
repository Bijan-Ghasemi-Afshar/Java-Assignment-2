/*
 * The Name Class; Rpresents the name of the client
 */
package insurance.company;

/**
 * 13/02/2016
 * @author Bijan G.A
 */
public class Name {
    
    // Declaring variables
    private String title;
    private String initials;
    private String surname;
    
    
    /**
     * Creates an instance of Name
     * @param title     The title of the client
     * @param initials  The initials of the client
     * @param surname   The surname of the client
     */
    public Name(String title, String initials, String surname) {
        this.title = title;
        this.initials = initials;
        this.surname = surname;
    }
    
    
    /**     
     * @return      The title of the client
     */
    public String getTitle(Address fullAddress) {
        
        return title;
    }
    
    
    /**     
     * @return      The initials of the client
     */
    public String getInitials() {
        return initials;
    }
    
    
    /**     
     * @return      The surname of the client
     */
    public String getSurname() {
        return surname;
    }
    
    
    /**     
     * @param title     Resets the title of the client
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    /**
     * @param initials      Resets the initials of the client
     */
    public void setInitials(String initials) {
        this.initials = initials;
    }
    
    
    /**     
     * @param surname       Resets the surname of the client
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
    /**     
     * @return      The fields and their value of this class
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("\n\t");
        str.append(title).append(". ").append(initials);
        str.append(" ").append(surname);
        return str.toString();
    }              
}
