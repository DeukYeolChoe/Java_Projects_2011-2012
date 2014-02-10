package Veterinarians;

import java.util.ArrayList;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Person
* File: Person.java
* Description: this class gives user basic templates with firstname, lastname
* @author: DeukYeol Choe & Khoa Dang
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 5/10/2011
* @version 6.0
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Person
{
    //variables to keep first name and last name
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;

    Address getAddressObject = new Address();
    Pet getPetObject = new Pet();

    //Default Constructor
    public Person()
    {
        firstName = "";
        lastName = "";
        phoneNumber = "";
    }

    public Person(String firstName, String lastName, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    // Return the first name
    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    // Return the last name
    public String getLastName()
    {
        return lastName;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    // Return the first name
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
}
