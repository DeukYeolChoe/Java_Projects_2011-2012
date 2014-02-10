package Tennis;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: TennisDatabase
* File: TennisDatabase.java
* Description: This class is a frame for input data. It is used by ArrayList
* @author: DeukYeol Choe
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 4/20/2011
* @version 6.0
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class TennisDatabase {

    private String firstName, lastName, emailAdress, phoneNumber;
    private int level;

    // Constructor(initialization)
    public TennisDatabase()
    {
        firstName = "";
        lastName = "";
        emailAdress = "";
        phoneNumber = "";
        level = 0;
    }

    // Constructor
    public TennisDatabase(String firstname, String lastname, String email, String phone, int stage)
    {
        firstName = firstname;
        lastName = lastname;
        emailAdress = email;
        phoneNumber = phone;
        level= stage;
    }

    // Pass the para's value to firstname
    public void setFirstName(String firstname)
    {
        firstName = firstname;
    }

    // Get value from firstname
    public String getFirstName()
    {
        return firstName;
    }

    // Pass the para's value to lastName
    public void setLastName(String lastname)
    {
        lastName = lastname;
    }

    // Get value from lastName
    public String getLastName()
    {
        return lastName;
    }

    // Pass the para's value to emailAdress
    public void setEamilAddress(String email)
    {
        emailAdress = email;
    }

    // Get value from emailAdress
    public String getEamilAddress()
    {
        return emailAdress;
    }

    // Pass the para's value to phoneNumber
    public void setPhoneNumber(String phone)
    {
        phoneNumber = phone;
    }

    // Get value from phoneNumber
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    // Pass the para's value to level
    public void setLevel(int stage)
    {
        level = stage;
    }

    // Get value from level
    public int getLevel()
    {
        return level;
    }

     /**
     * Method: equals
     * Check the data that exists already it or not
     * @parem TennisDatabase
     * @return boolean
     */
    public boolean equals(TennisDatabase tennis)
    {
        if(this.getFirstName().equalsIgnoreCase(tennis.getFirstName()) &&
             this.getLastName().equalsIgnoreCase(tennis.getLastName()) &&
             this.getEamilAddress().equalsIgnoreCase(tennis.getEamilAddress()) &&
             this.getPhoneNumber().equalsIgnoreCase(tennis.getPhoneNumber()) &&
            (this.getLevel() == tennis.getLevel()))
                return true;
         else
                return false;
    }

} // end of class
