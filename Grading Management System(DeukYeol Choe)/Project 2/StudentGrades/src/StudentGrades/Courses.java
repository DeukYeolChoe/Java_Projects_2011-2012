
package StudentGrades;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Courses
* File: Courses.java
* Description: this class gives user basic template such as name, sid, credit, section,
 * midterm, final score.
* @author: Khoa Dang & DeukYeol Choe
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 5/10/2011
* @version 6.0
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Courses
{
    //Variable
    protected String na;
    protected String num;
    protected int cre;
    protected String sec;
    protected float midtermScore;
    protected float finalScore;

    //Default constructor
    public Courses()
    {
        na = "";
        num = "";
        cre = 0;
        sec = "";
        midtermScore = 0;
        finalScore = 0;
    }

    public Courses(String name,String number,int credit,String section,float mid, float fi)
    {
        na = name;
        num = number;
        cre = credit;
        sec = section;
        midtermScore = mid;
        finalScore = fi;
    }

    public void setCourseName(String name)
    {
        na = name;
    }

    public String getCourseName()
    {
        return na;
    }

    public void setCourseNumber(String number)
    {
        num = number;
    }

    public String getCourseNumber()
    {
        return num;
    }

    public void setCourseCredit(int credit)
    {
        cre = credit;
    }

    public int getCourseCredit()
    {
        return cre;
    }

    public void setCourseSection(String section)
    {
        sec = section;
    }

    public String getCourseSection()
    {
        return sec;
    }
    public void setMidtermScore(float mid)
    {
        midtermScore = mid;
    }

    public float getMidtermScore()
    {
        return midtermScore;
    }

    public void setFinalScore(float fi)
    {
        finalScore = fi;
    }

    public float getFinalScore()
    {
        return finalScore;
    }

    public float getAverage()
    {
        return ((getMidtermScore() + getFinalScore()) / 2);
    }

}
