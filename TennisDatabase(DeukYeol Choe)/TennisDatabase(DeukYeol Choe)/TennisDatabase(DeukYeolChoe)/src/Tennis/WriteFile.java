package Tennis;

import java.io.*;

/**
 * WriteFile.java
 * A class used to write members to a text file.
 * <pre>
 *    Project: Tennis Database
 *    Platform: jdk 1.6.0_14; NetBeans IDE 6.8; Windows Vista
 *    Course:
 *    Hourse: 2 hours and 45 minutes
 *    Created on Apr 20, 2011, 1:45:39 PM
 *    Revised on
 * </pre>
 *
 * @author:	chlemrfuf@naver.com
 * @version: 	%1% %2%
 * @see:     	java.io.FileReader
 * @see:     	java.io.BufferedReader
 */

public class WriteFile
{
    //private FileOutputStream filename;
    private FileWriter filename;

    public WriteFile(String inputFilename) throws IOException
    {
        try
        {
            filename = new FileWriter(inputFilename, false);
        }
        catch (FileNotFoundException ex) {}
    }

    public void write(String item)
    {        
        PrintWriter output = new PrintWriter(filename);
        output.println(item);
    }

    public void close()
    {
        try
        {
            filename.close();
        }
        catch (IOException ex) {}
    }
}
