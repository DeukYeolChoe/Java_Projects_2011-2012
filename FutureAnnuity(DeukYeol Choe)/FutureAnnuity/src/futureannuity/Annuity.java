/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Annuity
* File: Annuity.java
* Description: Calculate future annuity balance, total of payments, total of interest earned
 * through given periodic payment, interest rate,compounds per year, years.
* @author: DeukYeol Choe
* Environment: PC, Windows 7, jdk6.23, NetBeans 6.9.1
* Date: 1/21/2011
* @version 6.3
* @see javax.swing.JOptionPane;
* @see java.text.DecimalFormat;
* @see javax.swing.JFrame;
* history log : update from 1/21/2011
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package futureannuity;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Annuity {

    private double payment;
    private double interest;
    private double compound;
    private double years;
    private String resultFAB;
    private String resultTP;
    private String resultTIE;

    // initialize Annuity()
    public Annuity()
    {
        payment=interest=compound=years=0.0;
    }

    // input Annuity()
   public Annuity(double payment, double interest, double compound, double years)
    {
        this.payment = payment;
        this.interest = interest;
        this.compound = compound;
        this.years = years;
    }

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: calculateAnnuity()
* Description: This is funtion to calculate for annuity
* operation: 1. calculates annuity(FuturePayment,TotalPayment,Interest)
*            2. set up the data of format again as a ("$#,##0,000.00")
* @return: void
* @param: -
* @author: DeukYeol Choe
* Date: 1/21/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void calculateAnnuity()
    {
        interest = interest/100;
        double top = payment*(Math.pow(1+(interest/compound),compound*years)-1);
        double bottom = interest / compound;
        double resultFuturePayment = top/bottom;
        double resultTotalPayment = payment *compound * years;
        double resultInterest = resultFuturePayment - resultTotalPayment;

        DecimalFormat dollars = new DecimalFormat("$#,##0,000.00");
        resultFAB = dollars.format(resultFuturePayment);
        resultTP = dollars.format(resultTotalPayment);
        resultTIE = dollars.format(resultInterest);
    } //the end of calculateAnnuity

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: getFAB()
* Description: return the result of Future Annuity Balance
* @return: String
* @param: -
* @author: DeukYeol Choe
* Date: 1/21/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getFAB()
    {
        return resultFAB;
    }

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: getTP()
* Description: return the result of Total of Payments
* @return: String
* @param: -
* @author: DeukYeol Choe
* Date: 1/21/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getTP()
    {
        return resultTP;
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: getTIE()
* Description: return the result of Total of Interest Earned
* @return: String
* @param: -
* @author: DeukYeol Choe
* Date: 1/21/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getTIE()
    {
        return resultTIE;
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: checkVaribles()
* Description: check data validation for valid range and type-do not allow negative input
* @return: String
* @param: -
* @author: DeukYeol Choe
* Date: 1/21/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean checkVaribles()
    {
       boolean invalidInputs = (payment < 0 || payment > 10000000
       || interest < 0 || interest > 100 || years < 0 || years > 100
       || compound < 0 || compound > 100);
       if(invalidInputs)
           return true;
       else
           return false;
    }
}// the end of allwaorks
