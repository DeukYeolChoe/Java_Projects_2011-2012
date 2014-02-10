
package StudentGrades;

import java.io.*;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: WriteFile
* File: WriteFile.java
* Description: A class used to write members to a text file.
* @author: DeukYeol Choe & Khoa Dang
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 5/10/2011
* @version 6.0
* @see java.io.*;
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

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