/*
 * GuiJFrame.java
 */
package makingalicesmall;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author Sereyvathanak Khorn
 */
public class GuiJFrame extends JFrame
{
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    private static final int TEXT_WIDTH = 50;
    private static final int TEXT_HEIGHT = 25;
    private static final int STRUT_SIZE = 32;
    private static final int TEXTPANEL_WIDTH = 584;
    private static final int TEXTPANEL_HEIGHT = 600;
    
    private JFileChooser openChooser;
    private File file;
    private String textTile = "";
    private String textTitleforDisplay = "";
    private Huffman coder;
    
    private JLabel titleLabel;
    private JLabel bookTitle;
    private JTextField bookTitle1;
    private JPanel textPanel;
    private JPanel buttonPanel;
    private JButton encodeButton;
    private JButton decodeButton;
    private JTextArea information; 
    private JLabel processLabel;
    public JTextField processField;
    private int lightBlue = 0X63B1FF;
    
    private StringBuilder display = new StringBuilder();
    JScrollPane scrollPane;

    /**
     * Setting up the GUI
     * @param coder Huffman
     */
    public GuiJFrame(Huffman coder)
    {
        this.coder = coder;
        
        setTitle("Making Alice Smaller");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLayout(new FlowLayout());
        
        //Menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu());
        menuBar.add(info());
        
        //Button
        textBox();
        add(textPanel);
        button();
        add(buttonPanel);
        encodingButton();
        decodingButton(); 
    }
    
    /**
     * Create panel for buttons, (encoding button) and (decoding button)
     */
    private void button()
    {
        buttonPanel = new JPanel();
        Font buttonFont = new Font("Serif", Font.PLAIN, 18);
        
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createHorizontalStrut(STRUT_SIZE));
        buttonPanel.setPreferredSize(new Dimension(200, 600)); 
        
        buttonPanel.setBackground(new Color(lightBlue));
        
        encodeButton = new JButton("        Encode        ");
        encodeButton.setFont(buttonFont);
        encodeButton.setSelected(true);
        encodeButton.setMnemonic('E');
        encodeButton.setToolTipText("Encoding the file!");
        encodeButton.setPreferredSize(new Dimension(0, 100)); 
        
        decodeButton = new JButton("        Decode        ");
        decodeButton.setFont(buttonFont);
        decodeButton.setMnemonic('d');
        decodeButton.setToolTipText("Decoding the file!");
        decodeButton.setPreferredSize(new Dimension(0, 100)); 
        
        buttonPanel.add(encodeButton);
        buttonPanel.add(Box.createHorizontalStrut(STRUT_SIZE));
        buttonPanel.add(decodeButton);
        buttonPanel.add(Box.createHorizontalStrut(STRUT_SIZE));
    }
    
    /**
     * The method create a the panel for the text area, and the title of the GUI
     */
    private void textBox()
    {
        textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(TEXTPANEL_WIDTH, 
                TEXTPANEL_HEIGHT));
        textPanel.setLayout(new FlowLayout());
        
        titleLabel = new JLabel("Making Alice Smaller");
        titleLabel.setForeground(new Color(lightBlue));
        Font titlefont = new Font("Serif", Font.BOLD, 50);
        titleLabel.setFont(titlefont);
        
        bookTitle = new JLabel("                 Book Title: ");
        
        JPanel blank = new JPanel();
        blank.setPreferredSize(new Dimension(600, 600)); 
        blank.setBackground(new Color(lightBlue));
        
        information = new JTextArea(TEXT_HEIGHT, TEXT_WIDTH);
        information.setEditable(false);
        bookTitle1 = new JTextField(30);
        bookTitle1.setHorizontalAlignment(JTextField.CENTER);
        bookTitle1.setEditable(false);
        processLabel = new JLabel("Processing:                                "
                + "                                                        ");
        processField = new JTextField(20);
        processField.setEditable(false);
        processField.setHorizontalAlignment(processField.CENTER);
        blank.add(processLabel);
        blank.add(processField);
        
        textPanel.add(titleLabel);
        textPanel.add(bookTitle);
        textPanel.add(bookTitle1);
        scrollPane = new JScrollPane(information, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textPanel.add(scrollPane, BorderLayout.CENTER);
        
        textPanel.add(blank);
    }
    
    /**
     * Creating a listener for the encoding button
     */
    private void encodingButton()
    {
        class changeStatusListener implements ActionListener
        {
            /*
             * Creating the listener for the encoding button
             */
            @Override 
            public void actionPerformed(ActionEvent event)
            {
                setTextArea("");
                if (!textTile.equals(""))
                    coder.encode(textTile);  
            }
        }
        ActionListener listener = new changeStatusListener();
        encodeButton.addActionListener(listener);
    }
    
    /**
     * Creating a listener for the decoding button
     */
    private void decodingButton()
    {
        class changeStatusListener implements ActionListener
        {
            /*
             * Creating a listener for the decoding button
             */
            @Override 
            public void actionPerformed(ActionEvent event)
            {
                if (!textTile.equals(""))
                    coder.decode(textTile);
            }
        }
        ActionListener listener = new changeStatusListener();
        decodeButton.addActionListener(listener);
    }
    
    /**
     * Creating JMenu for the menu bar "File"
     *      File menu contains "Open" and "Exit"
     * @return File menu 
     */
    private JMenu fileMenu()
    {
        JMenu menu = new JMenu("     File      ");
        menu.add(openMenu());
        menu.add(exitMenu());
        return menu;        
    }
    
    /**
     * Creating a menu "Info" 
     * @return the info menu
     */
    private JMenu info()
    {
        JMenu info = new JMenu("     Info     ");
        info.add(infoMenu());
        return info;
    }
    
    /**
     * Creating an Information menu that hold all the information about Group A
     */
    public JMenuItem infoMenu()
    {
        JMenuItem item = new JMenuItem("     Group Information     ");
        
        class MenuItemListener implements ActionListener
        {
            /**
             * Showing information dialogue box
             */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                JOptionPane.showMessageDialog(null,
                    "The program is written by \"Group A\"\n\n"
                        + "CHOE, DEUK\nENKBET, TAMIR\nJANLIE, RYOKS\n"
                        + "KHORN, SEREYVATHANAK\n", 
                    "GROUP INFORMATION", 1);
            }
        }
        ActionListener listener = new MenuItemListener();
        item.addActionListener(listener);
        return item;
    }
    
    /**
     * Creating a sub-menu for an open chooser that will look for alice.txt
     * @return the sub-menu "Open"
     */
    public JMenuItem openMenu()
    {
        JMenuItem item = new JMenuItem("     Open     ");
        
        class MenuItemListener implements ActionListener
        {
            /**
             * Choosing a new file
             */
            @Override
            public void actionPerformed(ActionEvent event)
            {                          
                openChooser = new JFileChooser("Books/"); 
                Scanner in = null;
                if (openChooser.showOpenDialog(null) == 
                        JFileChooser.APPROVE_OPTION)
                {
                    file = openChooser.getSelectedFile();
                    textTile = file.getAbsolutePath();
                    textTitleforDisplay = file.getName();
                    String title = textTitleforDisplay.substring(0, textTitleforDisplay.length() - 4);
                    title = title.toUpperCase();
                    bookTitle1.setText(title);

                    try 
                    {
                        in =  new Scanner(file);
                        while(in.hasNextLine())
                        {
                            String line = in.nextLine();
                            display.append(line);
                            display.append("\n");
                        }
                        information.setText(display.toString());
                        display.delete(0, display.length());
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        JOptionPane.showMessageDialog(null,
                            "Either the file does not exists or readable!", 
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
        ActionListener listener = new MenuItemListener();
        item.addActionListener(listener);
        return item;
    }
    
    /**
     * Creating sub-menu for exit sub-menu
     * @return the "Exit" menu item
     */
    public JMenuItem exitMenu()
    {
        JMenuItem item2 = new JMenuItem("     Exit     ");
        
        class MenuItemListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        }
        ActionListener listener = new MenuItemListener();
        item2.addActionListener(listener);
        return item2;
    }
    
    /**
     * Set the GUI to be unable to resize
     * @return false for no resizing 
     */
    @Override
    public boolean isResizable()
    {
        return false;       
    }   
    
    /**
     * Giving TextArea to set String
     * @param str String that will appear in the information textArea
     */
    public void setTextArea(String str)
    {
        information.setText(str);
    }

    /**
     * Append more String onto the old String in the information textArea
     * @param str String that will appear in the information textArea
     */
    public void appendTextArea(String str)
    {
        String oldStr = information.getText();
        information.setText(oldStr + str);
    }
    
    /**
     * Accessors for the information textArea
     * @return Text in information
     */
    public String getTextAreaString()
    {
        return information.getText();
    }
}