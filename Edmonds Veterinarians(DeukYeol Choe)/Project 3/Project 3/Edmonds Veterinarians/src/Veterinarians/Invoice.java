package Veterinarians;

import java.text.DecimalFormat;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Invoice
* File: Invoice.java
* Description: This class calculates invoice (tax, subtotal, total charges)
* @author: DeukYeol Choe
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 2/14/2011
* @version 6.0
* history log : update from 2/16/2011
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


public class Invoice {
    //class constants
     private static final double    TeethCleaning = 85.00,
                                    RabiesVaccination = 55.00,
                                    OtherShots = 42.00,
                                    HeartwormTest = 28.00,
                                    FecalCheck = 37.00,
                                    FleasTreatment = 65.00,
                                    OfficeVisitCheck = 25.00,
                                    TAX = 0.088;

    private double other;

    private double total;
    private double totalWithoutTax;

    private StringBuilder displayService = new StringBuilder("");

    //instance variables
    private boolean teethCleaning;
    private boolean rabiesVaccination;
    private boolean otherShots;
    private boolean heartwormTest;
    private boolean fecalCheck;
    private boolean fleasTreatment;
    private boolean officeVisitCheck;
    private boolean otherFee;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: Invoice()
* Description: Default constructor--Creates a new instance of Invoice
* @return: void
* @param: void
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Invoice()
    {
        teethCleaning = rabiesVaccination = otherShots = heartwormTest
        = fecalCheck = fleasTreatment = officeVisitCheck = false;
        other = total = totalWithoutTax = 0.0;
    }

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: Invoice()
* Description: Overloaded constructor and receive 8 informations
* @return: void
* @param: paradise, atlantis, orcas, discount, specialMeals, telephone, miscellaneous, nights
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Invoice(boolean teethCleaning, boolean rabiesVaccination, boolean otherShots,
        boolean heartwormTest, boolean fecalCheck, boolean fleasTreatment, boolean officeVisitCheck, boolean otherFee, double other)
    {
        this.teethCleaning = teethCleaning;
        this.rabiesVaccination = rabiesVaccination;
        this.otherShots = otherShots;
        this.heartwormTest = heartwormTest;
        this.fecalCheck = fecalCheck;
        this.fleasTreatment = fleasTreatment;
        this.officeVisitCheck = officeVisitCheck;
        this.otherFee = otherFee;
        this.other = other;
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
        // calcualte customer's bill without tax
        if ( teethCleaning )
            totalWithoutTax += TeethCleaning;

        if ( rabiesVaccination )
            totalWithoutTax += RabiesVaccination;

        if ( otherShots )
            totalWithoutTax += OtherShots;

        if ( heartwormTest )
            totalWithoutTax += HeartwormTest;

        if ( fecalCheck )
            totalWithoutTax += FecalCheck;

        if ( fleasTreatment )
            totalWithoutTax += FleasTreatment;

        if ( officeVisitCheck )
            totalWithoutTax += OfficeVisitCheck;

        if ( otherFee )
            totalWithoutTax += other;

        return totalWithoutTax;
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
    public double totalBill()
    {
        total = totalWithoutTax + taxBill();
        return total;
    }

    public double taxBill()
    {
        return totalWithoutTax * TAX;
    }

    public String displayService()
    {
        if( teethCleaning )
            displayService.append(" TC        Teeth Cleaning                    $85.00\n");

        if( rabiesVaccination )
            displayService.append(" RB        Rabies Vaccination                $55.00\n");

        if( otherShots )
            displayService.append(" OS        Other Shots                       $42.00\n");

        if( heartwormTest )
            displayService.append(" HW        Heartworm Test                    $28.00\n");

        if( fecalCheck )
            displayService.append(" FC        Fecal Check                       $37.00\n");

        if( fleasTreatment )
            displayService.append(" FT        Fleas Treatment                   $65.00\n");

        if( officeVisitCheck )
            displayService.append(" OV        Office Visit/Check                $25.00\n");

        if( otherFee )
            displayService.append(" OT        Other                             $" + other +"\n");

        return displayService.toString();
    }
}

