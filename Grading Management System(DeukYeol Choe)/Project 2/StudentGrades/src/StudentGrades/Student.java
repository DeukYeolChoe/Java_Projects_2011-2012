
package StudentGrades;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Student
* File: Student.java
* Description: This class is a template with student-identification; it also inherits
 * from Person.java with personal data
* @author: DeukYeol Choe & Khoa Dang
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 5/10/2011
* @version 6.0
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Student extends Person
{
    //variable
    protected int sId;
    
    
    // Default constructor
    public Student()
    {
        super();
        sId = 0;
        
    }

    // Constructor with parameters
    public Student(String fName, String lName, int iD)
    {
        super(fName, lName); // set both firstname and lastname through person's constructor
        sId = iD;
                
    }

    
    // Set student-ID
    public void setStudentID(int ID)
    {
        sId = ID;
    }
    
    // Return student-ID
    public int getStudentID()
    {
        return sId;
    }
  
    // Return firstname through Person(superclass)
    public String getFirstName()
    {
        return firstName;
    }

    // Return lastname through Person(superclass)
    public String getLastName()
    {
        return lastName;
    }
    
    // Return three things lastname firstname student-ID as a String
    public String toString()
    {
        return super.toString() + " " + sId ;
    }

}
