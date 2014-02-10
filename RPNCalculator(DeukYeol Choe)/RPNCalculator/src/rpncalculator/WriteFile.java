/*  WriteFile.java */
package rpncalculator;

import java.io.*;

/**
 * WriteFile class
 * A class used to write members to a text file
 * @author DeukYeol Choe
 * @version 1.0
 * Test Environment: JDK 1.7.0_03 on Windows 7, i3 CPU
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