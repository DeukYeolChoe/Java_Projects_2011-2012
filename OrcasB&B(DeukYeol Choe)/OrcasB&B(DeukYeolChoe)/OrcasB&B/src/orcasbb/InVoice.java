/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: InVoice
* File: InVoice.java
* Description: This class calculates invoice (tax, subtotal, total charges)
* @author: DeukYeol Choe
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 2/14/2011
* @version 6.0
* history log : update from 2/16/2011
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package orcasbb;

public class InVoice {
    //class constants
     static final double    PARADISE = 135.00,     // paradise room $135
                            ATLANTIS = 185.00,     // atlantis room $ 185
                            ORCAS = 235.00,        // orcas room $235
                            DISCOUNT = 0.1,        // discount 10%
                            TAX = 0.08;            // tax 8%

    // the charges about room and nights
    public double paradiseCost;
    public double atlantiseCost;
    public double orcasCost;

    double total = 0.0;               // sum of all services provided
    double tax = 0.0;                 // the tax of the sum of all services provided

    //instance variables
    private boolean paradise;
    private boolean atlantis;
    private boolean orcas;
    private boolean discount;
    private double specialMeals;
    private double telephone;
    private double miscellaneous;
    private byte nights;

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
    public InVoice()
    {
        paradise = atlantis = orcas = false;
        specialMeals = telephone = miscellaneous = 0.0;
        paradiseCost = atlantiseCost = orcasCost = 0.0;
        nights = 0;
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
    public InVoice(boolean paradise, boolean atlantis, boolean orcas,
        boolean discount, double specialMeals, double telephone, double miscellaneous, byte nights)
    {
        this.paradise = paradise;
        this.atlantis = atlantis;
        this.orcas = orcas;
        this.discount = discount;
        this.specialMeals = specialMeals;
        this.telephone = telephone;
        this.miscellaneous = miscellaneous;
        this.nights = nights;
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
        if ( paradise )         // if customer had a paradise room
        {
            if(discount == true)  // discount
            {
                paradiseCost = nights * (PARADISE - (PARADISE * DISCOUNT));
                total += paradiseCost;
            }
            else                // no discount
            {
                paradiseCost = nights * PARADISE;
                total += paradiseCost;
            }
        }

        if ( atlantis )           // if customer had a atlantis room
        {
            if(discount == true)  // discount
            {
                atlantiseCost = nights * (ATLANTIS - (ATLANTIS * DISCOUNT));
                total += atlantiseCost;
            }
            else                 // no discount
            {
                atlantiseCost = nights * ATLANTIS;
                total += atlantiseCost;
            }
        }

        if ( orcas )             // if customer had a orcas room
        {
            if(discount == true)    // discount
            {
                orcasCost = nights * (ORCAS - (ORCAS * DISCOUNT));
                total += orcasCost;
            }
            else                    // no discount
            {
                orcasCost = nights * ORCAS;
                total += orcasCost;
            }
        }

        total = total + specialMeals + telephone + miscellaneous;

        return total;
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: taxBill()
* Description: calculate the tax of the sum of room and additional fees
* @return: double
* @param: void
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public double taxBill()
    {
        tax = total * TAX;
        return tax;
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: calculateBill()
* Description: calculate total charges (room + addition fees + tax)
* @return: double
* @param: void
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public double totalCharges()
    {
        return (tax + total);
    }
}

