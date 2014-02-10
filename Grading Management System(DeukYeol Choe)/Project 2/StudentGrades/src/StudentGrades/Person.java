
package StudentGrades;

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

    //Default Constructor
    public Person()
    {
        firstName = "";
        lastName = "";
    }

    public Person(String first, String last)
    {
        firstName = first;
        lastName = last;
    }
   
    public void setName(String first, String last)
    {
        firstName = first;
        lastName = last;
    }

    // Return the first name
    public String getFirstName()
    {
        return firstName;
    }

    // Return the last name
    public String getLastName()
    {
           return lastName;
    }

    //return first name and last name as a string
    public String toString()
    {
        return firstName + " " + lastName;
    }

}
