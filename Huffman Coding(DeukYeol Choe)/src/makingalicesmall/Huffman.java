/*
 * Huffman.java
 *
 * Created on May 21, 2007, 1:01 PM
 */

package makingalicesmall;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author pbladek
 */
public class Huffman
{  
    public static final int CHARMAX = 128;
    public static final byte CHARBITS = 7;
    public static final short CHARBITMAX = 128;
    private GuiJFrame frame;
    
    /**
     * Creates a new instance of Huffman object and also instantiates its GUI
     */
    public Huffman(){
        frame = new GuiJFrame(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    /**
     * This is the main method of the project which takes in command-line arguement and
     * encode or decode according to it. This method also instantiate the Huffman object
     * which in turn instantiate its GUI
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args){
//----------------------------------------------------
// used for debugging encoding
//----------------------------------------------------
//        args = new String[1];
//        args[0] = "alice.txt";
//----------------------------------------------------
// used for debugging encoding
//----------------------------------------------------
//        args = new String[2];
//        args[0] = "-d";
//        args[1] = "alice.txt";  +
//----------------------------------------------------     
        boolean decode = false;
        String textFileName = null;
        Scanner in = new Scanner(System.in);
        int commandNumber;
        System.out.println("Choose one : Command version: 1 or GUI version: 2 ");
        commandNumber = Integer.parseInt(in.nextLine());
        
        switch(commandNumber)
        {
            case 1: // Command Version
                        if(args.length > 0)
                        {
                            if(args[0].substring(0,2).toLowerCase().equals("-d"))
                            {
                                decode = true;
                                if(args.length > 1)
                                textFileName = args[1];
                                if(textFileName == null)
                                {
                                    System.out.println("Please enter a file name: ");
                                    textFileName = in.nextLine();
                                }
                            }
                            else
                                textFileName = args[0];
                        }
                        else
                        {
                            System.out.println("Please enter a file name: ");
                            textFileName = in.nextLine();
                        }
                break;
                
            case 2: // GUI VERSION
                break;
        }

        
        Huffman coder = new Huffman();
        if (textFileName != null){
            if(!decode)
            {
                coder.encode(textFileName);
            }
            else
            {
                coder.decode(textFileName);
            }
        }
    }
    
    /**
     * This method counts the occurances of each characted in the file passed in.
     * 
     * @param fileName The name of the file to be encoded
     * 
     * @return An array containing the occurances of each character sorted according 
     * to their index
     * 
     */
    private int[] countChar(String fileName) {
        try{
            Scanner in = new Scanner(new File(fileName));
            int[] count = new int[CHARMAX];
            
            while(in.hasNextLine()) {
                String ln = in.nextLine();
                char[] ch = ln.toCharArray();
                
                for(int i = 0; i < ch.length; i++)
                    count[ch[i]]++;
                count['\n']++;
            }
            return count;
            
        } catch(IOException ex){
            System.out.println(ex.getMessage());
            return null;
        }
            
    }

    /**
     * This method creates an array of HuffmanChar containing information of both the 
     * character and its occurances.
     * 
     * @param charCount The array containing the occurances of each character sorted according 
     * to their index
     * @param ARRAY_SIZE The size of the array of HuffmanChar
     * 
     * @return An array of HuffmanChar
     */
    private HuffmanChar[] createCharCountArray(int[] charCount, int ARRAY_SIZE){
        int sum = 0;
        HuffmanChar[] charCountArray = new HuffmanChar[ARRAY_SIZE];
        for(int i = 0, j = 0; i < charCount.length; i++){
            sum += charCount[i];
            
            if(charCount[i] != 0)
                charCountArray[j++] = new HuffmanChar(
                        (char)i, charCount[i]);
        }
        
        System.out.println("Sum: " + sum);
        return charCountArray;
    }
    
    /**
     * This method reads in the text file and encode it to binary numbers by using the 
     * map provided by the HuffmanTree construted using the array of HuffmanChar.
     * 
     * @param fileName The name of the file to be encoded
     * @param theTree HuffmanTree used to encode the file
     * 
     * @return Binary numbers which is the encoded text
     */
    private String getTotalBinaryCode(String fileName, HuffmanTree<Character> theTree) {
        try{
            String tempBinaryCode = "";
            String totalBinaryCodes = "";
            Scanner in = new Scanner(new File(fileName));

            while(in.hasNextLine()){
                String line = in.nextLine();

                for(int i = 0; i < line.length(); i++)  // line by line
                    tempBinaryCode = tempBinaryCode.concat(
                            (String)theTree.codeMap.get(line.charAt(i)));

                tempBinaryCode = tempBinaryCode.concat((String)theTree.codeMap.get('\n'));
                totalBinaryCodes = totalBinaryCodes + tempBinaryCode;
                tempBinaryCode = ""; 
            }
            return totalBinaryCodes;
            
        } catch (IOException ex){
            System.out.println(ex.getMessage());
            return null;
        }
            
    }
    
    /**
     * This method save the encoded binary numbers into an array of bytes.
     * 
     * @param fileName The name of the file to write to
     * @param totalBinaryCodes Encoded binary numbers to be save
     */
    private void createSaveDataArray(String fileName, String totalBinaryCodes) {
        byte[] saveDataArray = new byte[(totalBinaryCodes.length()) / 8 + 1 + 1];

        loop1:
        for(int i = 0, j = 0; j < saveDataArray.length; i += 8, j++){
            if (j == saveDataArray.length - 2){
                String lastStr = totalBinaryCodes.substring(i);

                if (lastStr.length() == 0)
                    saveDataArray[saveDataArray.length - 2] = (byte) 0;
                else
                    saveDataArray[saveDataArray.length - 2] = (byte) Integer.parseInt(lastStr, 2);

                saveDataArray[saveDataArray.length - 1] = (byte) lastStr.length();
                break loop1;
            }

            saveDataArray[j] = (byte) Integer.parseInt(
                    totalBinaryCodes.substring(i, i + 8), 2); // Converting binarycodes to decimal.
            if (i % 2000 == 0)
                if (i > 0)
                    frame.setTextArea("Key file 'alice.cod' successfully created!\nWriting encoded file " 
                            + Double.toString(i * 100.0 /saveDataArray.length).substring(0, 5) 
                            + "%...");
        }
        
        frame.setTextArea("Key file 'alice.cod' successfully created!\n"
                + "Writing encoded file completed!\n");

        writeEncodedFile(saveDataArray, fileName);// by Dray  
        frame.appendTextArea("Encoded file 'alice.huf' successfully created!\n");
    }
    
    /**
     * This method convert the HuffmanChar passed in and create the three-byte array
     * to be saved on the .cod file.
     * 
     * @param fileName The name of the file to write to
     * @param charCountArray The array of HuffmanChar to be converted to three-byte array
     * @param ARRAY_SIZE The size of the array of HuffmanChar
     */
    private void createKeyByteArray(String fileName, HuffmanChar[] charCountArray, int ARRAY_SIZE) {
        byte[] byteArray = new byte[3 * (ARRAY_SIZE)];
        int i = 0;
        for (HuffmanChar h: charCountArray){
            byte[] temp = h.toThreeBytes();
            for (int j = 0; j < 3; i++, j++)
                byteArray[i] = temp[j];
        }
        for (int j = 0; j < byteArray.length; j++)
            System.out.print(byteArray[j] + " | ");
       
        writeKeyFile(fileName, byteArray);
        frame.appendTextArea("Key file 'alice.cod' successfully created!\n");
    }
    
    /**
     * This method uses the byte array passed in to write the .huf file.
     * 
     * @param fileName The name of the file to write to
     * @param bytes The array of byte to be written to the file
     */ 
    public void writeEncodedFile(byte[] bytes, String fileName){
      fileName = fileName.substring(0 , fileName.length() - 3) + "huf";
      try // creating .huf file for Object.
            {
                ObjectOutput out = new ObjectOutputStream(new FileOutputStream(fileName));
                out.writeObject(bytes);
                out.close();
            }
            catch(IOException ex)
            {
                System.err.println(ex);
            }
    }
    
    /**
     * This method uses the byte array passed in to write the .cod file.
     * 
     * @param fileName the name of the file to write to
     * @param byteArray the array of byte to be written to the file
     */
    public void writeKeyFile(String fileName, byte[] byteArray){
        
        
        fileName = fileName.substring(0 , fileName.length() - 3) + "cod";
        try
        {
            ObjectOutput out =  new ObjectOutputStream(
                    new FileOutputStream(fileName));
            out.writeObject(byteArray);
            out.close();
            System.out.println("\n alice.cod is created");
        } 
        catch (IOException ex)
        {
            System.err.println(ex);
        }
    }
    
    /**
     * This is the main encoding method which calls on other methods in order to read in
     * the given file, create its HuffmanTree and then encode the text file according to
     * the HuffmanTree
     * 
     * @param fileName The name of the file to be encoded
     */
    public void encode(String fileName){
       frame.setTextArea("");
       int[] charCount = countChar(fileName);
       
       int nullData = 0;
       for(int i = 0; i < charCount.length; i++)
           if(charCount[i] == 0)
               nullData++;
       
       final int ARRAY_SIZE = CHARMAX - nullData;
       HuffmanChar[] charCountArray = createCharCountArray(charCount, ARRAY_SIZE);
       HuffmanTree<Character> theTree = new HuffmanTree(charCountArray);
        
       createKeyByteArray(fileName, charCountArray, ARRAY_SIZE);
       
       String totalBinaryCode = getTotalBinaryCode(fileName, theTree); 
       createSaveDataArray(fileName, totalBinaryCode);
       frame.processField.setText("Encoding has completed");
    }
    
    /**
     * This method reads in .cod file which contains an array of bytes to construct
     * back the an array of HuffmanChar which contains information on characters and
     * its occurances
     * 
     * @param fileName The name of the file to be decoded
     * 
     * @return array of HuffmanChar needed to make HuffmanTree
     */
    public HuffmanChar[] readKeyFile(String fileName){
        System.out.println("decoding file...");
        ObjectInput inCod;
        HuffmanChar[] dataArray = null;
        
        try{
            inCod = new ObjectInputStream(new FileInputStream(
                    new File(fileName.substring(0, fileName.length() - 3) + "cod")));
              //Replace to above
            byte[] tempThreeByte = new byte[3];
            byte[] tempThreeByteArray = (byte[]) inCod.readObject();
            dataArray = new HuffmanChar[tempThreeByteArray.length / 3];

            for (int i = 0; i < tempThreeByteArray.length;){
                for (int j = 0; j < 3; i++, j++)
                    tempThreeByte[j] = tempThreeByteArray[i];
                dataArray[(i - 2) / 3] = new HuffmanChar(tempThreeByte);
            }

//            System.out.println("\nSorted data");
//            for (HuffmanChar h: dataArray)
//                System.out.println(h);  // h is sorted data

            return dataArray;
        
        } catch (IOException ex){
            System.out.println(ex);
            return null;
        } catch (ClassNotFoundException ex){
            System.out.println(ex);
            return null;
        }
    }
    
    /**
     * Reads the encoded file with byte array. Each four bytes are added
     * to integer using left shift and | operations. "0"s are added to the
     * front to recover the key. If the byte less than 0, which means it 
     * will have 1s in the front even if converted to integer, we remove the
     * 1 in the front by subtracting 128, and then merging 1 and the 
     * subtracted byte individually into the integer value. Very last byte 
     * is the length of the last byte. Also array of String is used to
     * store the binary string, so that no string variable will become too 
     * big. The method will then return the string that is combination of 
     * the string array.
     * 
     * @param fileName The name of the file to be decoded
     * 
     * @return String of binary numbers read from .huf file
     */
    public String readEncodedFile(String fileName){
        ObjectInput inCod;
        byte[] tempByteArray;
        String[] totalBinaryCodes;
        try{
            inCod = new ObjectInputStream(new FileInputStream(
                    new File(fileName.substring(0, fileName.length() - 3) + "huf")));
            tempByteArray = (byte[]) inCod.readObject();
        
        } catch (IOException ex){
            System.out.println(ex);
            return null;
        } catch (ClassNotFoundException ex){
            System.out.println(ex);
            return null;
        }
        
        int arraySize = tempByteArray.length / 10000 + 1;
        totalBinaryCodes = new String[arraySize];
//        System.out.println("j size: " + arraySize);
        for (int j = 0; j < totalBinaryCodes.length; j++){
            totalBinaryCodes[j] = "";
//            System.out.println("j " + j + ": " + totalBinaryCodes[j]);
        }
        
        int fLength = tempByteArray.length / 4;
        int leftLength = tempByteArray.length - fLength * 4;
        if(leftLength < 2)
        {
            leftLength += 4;
            fLength -= 1;
        }
        for(int i = 0, j = 0; i < fLength * 4; i = i + 4)
        {
            int fBytes = 0;
            if(tempByteArray[i] < 0)
            {
                tempByteArray[i] -= 128;
                 fBytes = 128;
            }
            fBytes = fBytes | (tempByteArray[i] & 0xFF);
            if(tempByteArray[i + 1] < 0)
            {
                tempByteArray[i + 1] -= 128;
                fBytes = (fBytes << 8) | (128 & 0xFF);
                fBytes = fBytes |  (tempByteArray[i + 1] & 0xFF);
            }
            else
            {
                fBytes = (fBytes << 8) | (tempByteArray[i+1]& 0xFF);
            }
            if(tempByteArray[i + 2] < 0)
            {
                tempByteArray[i + 2] -= 128;
                fBytes = (fBytes << 8) | (128 & 0xFF);
                fBytes = fBytes |  (tempByteArray[i+2]& 0xFF);
            }
            else
            {
                fBytes = (fBytes << 8) | (tempByteArray[i+2]& 0xFF);
            }
            if(tempByteArray[i + 3] < 0)
            {
                tempByteArray[i + 3] -= 128;
                fBytes = (fBytes << 8) | (128 & 0xFF);
                fBytes = fBytes |  (tempByteArray[i + 3]& 0xFF);
            }
            else
            {
                fBytes = (fBytes << 8) | (tempByteArray[i+3]& 0xFF);
            }
            
            String temp = Integer.toBinaryString(fBytes);
            
            while(temp.length() < 32)
            {
                temp = "0" + temp;
            }
            
            if (totalBinaryCodes[j].length() > 8 * 10000){
                j++;
//                System.out.println("new j: " + j);
            }
            totalBinaryCodes[j] = totalBinaryCodes[j] + temp;
        }
//        System.out.println(tempByteArray.length-fLength * 4);
        loop1:
        for (int i = fLength * 4; i < tempByteArray.length; i++){
            byte tempByte = tempByteArray[i];
            String temp = Integer.toBinaryString(tempByte);
            
            if (i == tempByteArray.length - 2){
                while (temp.length() < tempByteArray[tempByteArray.length - 1])
                    temp = "0" + temp;
                totalBinaryCodes[totalBinaryCodes.length - 1] = 
                        totalBinaryCodes[totalBinaryCodes.length - 1] + temp;
                break loop1;
            }
            if (temp.length() > 8)
            {
                //temp = temp.substring(temp.length() - 8, temp.length());
                tempByte = (byte)(tempByte - 128);
                temp = Integer.toBinaryString(tempByte);
                while(temp.length() < 7 )
                {
                    temp = "0" + temp;
                }
                temp = "1" + temp;
            }
            else if (temp.length() < 8){
                while (temp.length() < 8)
                    temp = "0" + temp;
            }
            totalBinaryCodes[totalBinaryCodes.length - 1] = 
                        totalBinaryCodes[totalBinaryCodes.length - 1] + temp;
            if (i % 250 == 0){
                if (i > 0)
                    frame.setTextArea("Loading encoded file " + 
                            Double.toString(i * 100.0 /tempByteArray.length).substring(0, 5) 
                            + "%...");
//                System.out.println(i * 100.0 /tempByteArray.length);
            }
                //System.out.println(i + "/" + tempByteArray.length);
            //System.out.println(temp);
            //System.out.println(i + "/" + tempByteArray.length);
        }
        frame.setTextArea("Encoded file loaded 100.00%!");
        //System.out.println("totalBinCode: " + totalBinaryCodes);
        
        String finaltotalBinaryCodes = "";
        for (int j = 0; j < totalBinaryCodes.length; j++){
//            System.out.println("j " + j + ": " + totalBinaryCodes[j]);
            finaltotalBinaryCodes = finaltotalBinaryCodes + totalBinaryCodes[j];
        }
        
        return finaltotalBinaryCodes;
    }
    
    /**
     * This method decode the string of binary numbers back into decoded strings by using 
     * the map provided by the HuffmanTree and then create a new file to write in the 
     * decoded text.
     * 
     * @param fileName The name of the file to be decoded
     * @param totalBinaryCodes String of binary numbers read from .huf file
     * @param Htree HuffmanTree constructed from .cod file
     */
    private void writeDecodedFile(String fileName, String totalBinaryCodes, HuffmanTree Htree) {
        String tempKey = "";
        String originalText = "";
        
        System.out.println("totalBinaryCodes length: " + totalBinaryCodes.length());
        
        final int ORIGINAL_BIN_LENGTH = totalBinaryCodes.length();
        
        while(totalBinaryCodes.length() > 0){
            tempKey = tempKey + totalBinaryCodes.substring(0, 1);
            totalBinaryCodes = totalBinaryCodes.substring(1);
            
            if (Htree.keyMap.containsKey((String) tempKey)){
                Character tempChar = (Character) Htree.keyMap.get(tempKey);
                originalText = originalText + tempChar.charValue();
                tempKey = "";
            }
            
            if (totalBinaryCodes.length() % 7500 == 0)
                if (totalBinaryCodes.length() - ORIGINAL_BIN_LENGTH > 0)
                    frame.setTextArea("Encoded file loaded 100.00%!\nDecoding encoded file " + 
                                Double.toString( (totalBinaryCodes.length() - ORIGINAL_BIN_LENGTH)
                                * 100.0 /ORIGINAL_BIN_LENGTH).substring(0, 5) + "%...");
        }
        frame.setTextArea("Encoded file loaded 100.00%!\nDecoding encoded file completed!"
                + "\n\nEncoded file:\n\n" + originalText);
        System.out.println(originalText);
        try{
            PrintWriter newWriter = new PrintWriter(new File(
                    fileName.substring(0, fileName.length() - 4) + "x.txt"));
            newWriter.write(originalText);
            newWriter.close();
            
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * This is the main decoding method which calls on other method to read in the key and 
     * encoded file, translating encoded file back to strings and write a new file with the 
     * decoded string 
     * 
     * @param inFileName The name of the file to be decoded
     */   
    public void decode(String inFileName){
        frame.setTextArea("");
        HuffmanChar[] dataArray = readKeyFile(inFileName);
        HuffmanTree Htree = new HuffmanTree(dataArray); // dataArray is sorted data
        
        String totalBinaryCodes = readEncodedFile(inFileName);
        
        writeDecodedFile(inFileName, totalBinaryCodes, Htree);
        frame.processField.setText("Encoding has completed");
    }
}
