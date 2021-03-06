package Tennis;
import java.io.*;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: ReadFile
* File: ReadFile.java
* Description: This class extracts from a external file, whicl is the information of players
* @author: DeukYeol Choe
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 4/20/2011
* @version 6.0
* @see java.io.*;
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


public class ReadFile
{
    private FileReader inputFile;
    private BufferedReader input;
    private boolean fileExists;

    public ReadFile(String inFilename)
    {
        try
        {
            inputFile = new FileReader(inFilename);
            input = new BufferedReader(inputFile);
            fileExists = false;
        }
        catch(FileNotFoundException ex)
        {
            System.out.print("File Open Error : " + ex.getMessage());
            fileExists = false;
        }
    }

    public String readRecord()
    {
        String line = "";
        try
        {
            line = input.readLine();
        }
        catch(IOException ex) {}

        return line;
    }

    public void close()
    {
        try
        {
            inputFile.close();
        }
        catch(IOException ex) {}
    }
}