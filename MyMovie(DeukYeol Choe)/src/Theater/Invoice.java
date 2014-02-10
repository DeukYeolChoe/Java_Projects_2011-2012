/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: InVoice
* File: InVoice.java
* Description: This class calculates invoice (tax, subtotal, total charges)
* @author: DeukYeol Choe
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 3/74/2011
* @version 6.0
* history log : update from 2/16/2011
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package Theater;

import java.text.DecimalFormat;

public class Invoice {
    //class constants
     static final double    PRICE = 9.00,           // paradise room $135
                            DISCOUNT = 5.50,        // discount 10%
                            TAX = 0.089;           // tax 8%

    public double totalAmount;
    public double amountDue;

    private int adultTickets;
    private int childTickets;
    private boolean discount;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: InVoice()
* Description: Default constructor--Creates a new instance of InVoice
* @return: void
* @param: void
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Invoice()
    {
        totalAmount = amountDue = 0.0;
        adultTickets = childTickets = 0;
        discount = false;
    }

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: InVoice()
* Description: Overloaded constructor and receive 8 informations
* @return: void
* @param: paradise, atlantis, orcas, discount, specialMeals, telephone, miscellaneous, nights
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Invoice(int adultTickets, int childTickets, boolean discount)
    {
        this.adultTickets = adultTickets;
        this.childTickets = childTickets;
        this.discount = discount;
    }

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: calculateBill()
* Description: calculate charges of room, special meals, telephone, and so on.
 * This method also adds the total of charges (not including tax)
* @return: double
* @param: mytext
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public double calculateBill()
    {
        // calcualte customer's bill
        if(discount == true)  // discount
        {
           amountDue = (adultTickets * DISCOUNT) + (adultTickets * DISCOUNT * TAX);
           totalAmount += amountDue;
        }
        else                // no discount
        {
           amountDue = (adultTickets * PRICE) + (adultTickets * PRICE * TAX);
           totalAmount += amountDue;
        }

        amountDue = (childTickets * DISCOUNT) + (childTickets * DISCOUNT * TAX);
        totalAmount += amountDue;

        return totalAmount;
    }
}

