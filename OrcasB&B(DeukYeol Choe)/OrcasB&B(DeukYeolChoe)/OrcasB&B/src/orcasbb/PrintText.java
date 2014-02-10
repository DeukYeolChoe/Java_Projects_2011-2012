/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: PrintText
* File: PrintText.java
* Description: This class is used to print out
* @author: DeukYeol Choe
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 2/14/2011
* @version 6.0
* @see java.awt.Dimension;
* @see java.awt.*;
* @see java.awt.font.*;
* @see java.awt.geom.*;
* @see java.awt.print.*;
* @see java.text.*;
* history log : update from 2/16/2011
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package orcasbb;
/**
* The PrintText application expands on the
* PrintExample application in that it images
* text on to the single page printed.
*/
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import java.text.*;

public class PrintText implements Printable
{
      /**
     * The text to be printed.
     */
    String mText = " Oh my God!! ";

    /**1
     * Our text in a form for which we can obtain a
     * AttributedCharacterIterator.
     */
    AttributedString mStyledText = new AttributedString(mText);

    //Initialization
    public PrintText()
    {
        mText = "";
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: PrintText()
* Description: receive the value from mytext(=display.toString() in OrcasGUI class)
* @return: void
* @param: mytext
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public PrintText(String mytext)
    {
        this.mText = mytext;
    }

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: startPrint()
* Description: start to print out
* @return: void
* @param: void
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      public void startPrint()
      {

          /* Get the representation of the current printer and
         * the current print job.
         */
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        /* Build a book containing pairs of page painters (Printables)
         * and PageFormats. This example has a single page containing
         * text.
         */
        Book book = new Book();
        book.append(new PrintText(), new PageFormat());

        /* Set the object to be printed (the Book) into the PrinterJob.
         * Doing this before bringing up the print dialog allows the
         * print dialog to correctly display the page range to be printed
         * and to dissallow any print settings not appropriate for the
         * pages to be printed.
         */
        printerJob.setPageable(book);

        /* Show the print dialog to the user. This is an optional step
         * and need not be done if the application wants to perform
         * 'quiet' printing. If the user cancels the print dialog then false
         * is returned. If true is returned we go ahead and print.
         */
        boolean doPrint = printerJob.printDialog();
        if (doPrint) {

            try {

                printerJob.print();

            } catch (PrinterException exception) {

                System.err.println("Printing error: " + exception);
            }
        }
    } // end of start method

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: print()
* Description: print a page of text
* @return: int
* @param: g, format, pageIndex
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int print(Graphics g, PageFormat format, int pageIndex) {

        /* We'll assume that Jav2D is available.
         */
        Graphics2D g2d = (Graphics2D) g;

        /* Move the origin from the corner of the Paper to the corner
         * of the imageable area.
         */
        g2d.translate(format.getImageableX(), format.getImageableY());

        /* Set the text color.
         */
        g2d.setPaint(Color.black);

        /* Use a LineBreakMeasurer instance to break our text into
         * lines that fit the imageable area of the page.
         */
        Point2D.Float pen = new Point2D.Float();
        AttributedCharacterIterator charIterator = mStyledText.getIterator();
        LineBreakMeasurer measurer = new LineBreakMeasurer(charIterator, g2d.getFontRenderContext());
        float wrappingWidth = (float) format.getImageableWidth();

        while (measurer.getPosition() < charIterator.getEndIndex()) {

            TextLayout layout = measurer.nextLayout(wrappingWidth);
            pen.y += layout.getAscent();
            float dx = layout.isLeftToRight()? 0 : (wrappingWidth - layout.getAdvance());

            layout.draw(g2d, pen.x + dx, pen.y);
            pen.y += layout.getDescent() + layout.getLeading();

        }
        return Printable.PAGE_EXISTS;
    }
}
