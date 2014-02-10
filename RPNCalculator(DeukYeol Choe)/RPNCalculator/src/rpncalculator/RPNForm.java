/*  RPNForm.java */
package rpncalculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;
/**
 * GUI for Reverse Polish Notation Calculator
 * @author Paul Bladek
 */
public class RPNForm extends JFrame
{
    public static final int FRAME_WIDTH = 660;
    public static final int FRAME_HEIGHT = 330;
    public static final String MacroFile = "macroFile.txt";
    private Container contentPane;
    private JPanel displayPanel;
    private JLabel RPNLabel; 
    private JTextField displayTextField;
    private JPanel buttonPanel;
    private JButton[][] buttonGrid;
    
    private RPNCalculator calc;
    private boolean helpMode = false;
    private boolean recordMode = false;
    private boolean msgOn = false;
    private boolean commandPerformed = false;
    private boolean getOn = false;
    private boolean setOn = false;
    private String inString = "";
    private String displayString = "";
    
    private int countSetGet = 0;    // Counting for set and get
    private int countRecord = 0;    // Counting for record
    private double toDouble = 0.0;  // Converting String to Double
        
    /**
     * Creates and displays a window of the class RPNClaculator.
     * @param args the command-line arguments
     */
    public static void main(String[] args)
    {
        RPNForm gui = new RPNForm();
        gui.setVisible(true);
    }
    
    /**
     * constructor -- set up the form
     */
    public RPNForm()
    {  
        calc = new RPNCalculator();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("  RPN Calculator");
        setLocation(40, 40);
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        setDisplayPanel();
    }
    
    /**
     * sets up the displayPanel
     */
    public final void setDisplayPanel()
    {
        /**
         * inner class -- listens for any button actions
         */
        class StatusListener implements ActionListener
        {
            /**
            * deal with an action
            * @param event --the actionEvent performed
            */
            @Override
            public void actionPerformed(ActionEvent event)
            { 
                dealWith(event.getActionCommand());
                displayTextField.requestFocusInWindow();
            }  
        } // StatusListener
        
        /**
         * inner class -- listens for any button actions
         */
        class DisplayListener implements KeyListener
        {
            /**
            * Invoked when a key has been pressed.
            * @param event --the actionEvent performed
            */
            @Override
            public void keyPressed(KeyEvent event)
            {
            }
            /**
            * Invoked when a key has been released.
            * @param event --the actionEvent performed
            */
            @Override
            public void keyReleased(KeyEvent event)
            {
                char c = event.getKeyChar();
                if(event.getKeyCode() == KeyEvent.VK_SHIFT)
                    return;
                if(event.getKeyCode() == KeyEvent.VK_BACK_SPACE ||
                        event.getKeyCode() == KeyEvent.VK_DELETE)
                {
                    displayString = displayTextField.getText();
                    return;
                }
                displayTextField.setText(displayString);
                if(validChar(c))
                    dealWith(String.valueOf(c));
                displayTextField.requestFocusInWindow();
            }
            /**
            * Invoked when a key has been typed.
            * @param event --the actionEvent performed
            */
            @Override
            public void keyTyped(KeyEvent event)
            {
            }   
        } // DisplayListener
        KeyListener displayListener = new DisplayListener();
        ActionListener buttonListener = new StatusListener();
 
        displayPanel = new JPanel( );
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.X_AXIS));
        displayPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,
                new Color(0XCC, 0X99, 0XFF)));   
        RPNLabel = new JLabel(" RPN ");
        RPNLabel.setBackground(new Color(0X33, 0X00, 0X66));
        RPNLabel.setFont(new Font("Courier New", 1, 36));
        RPNLabel.setForeground(new Color(0x66, 0x33, 0x66));      
        displayPanel.add(RPNLabel);

        displayTextField = new JTextField("");
        displayTextField.setFont(new Font("Courier New", 1, 24));
        displayTextField.setHorizontalAlignment(JTextField.RIGHT);
        displayTextField.setActionCommand("Enter");
        displayTextField.addKeyListener(displayListener);
        displayPanel.add(displayTextField);
        contentPane.add(displayPanel, BorderLayout.NORTH);        

        buttonPanel = new JPanel( );
        buttonPanel.setBackground(new Color(0xff, 0xef, 0xdf));
        buttonPanel.setLayout(new GridLayout(RPNCalculator.ROWS,
                RPNCalculator.COLS));
        buttonPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,
                new Color(0X99, 0XFF, 0XFF)));
        buttonGrid = new JButton[RPNCalculator.ROWS][RPNCalculator.COLS];

        for(int i = 0; i < RPNCalculator.ROWS; i++)
        {
            for(int j = 0; j < RPNCalculator.COLS; j++)
            {
                buttonGrid[i][j]  = new JButton();
                buttonGrid[i][j].setFont(new Font("Courier New", 1, 16));
                buttonGrid[i][j].addActionListener(buttonListener);
                buttonGrid[i][j].setBorder(BorderFactory.createBevelBorder(1));
                buttonPanel.add(buttonGrid[i][j]);
            }
        }
        buttonGrid[0][0].setText("eXit");
        buttonGrid[0][1].setText("C");
        buttonGrid[0][2].setText("CE");
        buttonGrid[0][3].setFont(new Font("Courier New", 1, 20));
        buttonGrid[0][3].setBackground(new Color(0xf0, 0xf6, 0xff));
        buttonGrid[0][3].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[0][3].setText("7");
        buttonGrid[0][4].setFont(new Font("Courier New", 1, 20));
        buttonGrid[0][4].setBackground(new Color(0xf0, 0xf6, 0xff));
        buttonGrid[0][4].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[0][4].setText("8");
        buttonGrid[0][5].setFont(new Font("Courier New", 1, 20));
        buttonGrid[0][5].setBackground(new Color(0xf0, 0xf6, 0xff));
        buttonGrid[0][5].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[0][5].setText("9");
        buttonGrid[0][6].setText("+");
        buttonGrid[0][7].setText("x");
        buttonGrid[1][0].setText("Set");
        buttonGrid[1][1].setText("Get");
        buttonGrid[1][2].setText("Up");
        buttonGrid[1][3].setFont(new Font("Courier New", 1, 20));
        buttonGrid[1][3].setBackground(new Color(0xf0, 0xf6, 0xff));
        buttonGrid[1][3].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[1][3].setText("4");
        buttonGrid[1][4].setFont(new Font("Courier New", 1, 20));
        buttonGrid[1][4].setBackground(new Color(0xf0, 0xf6, 0xff));
        buttonGrid[1][4].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[1][4].setText("5");
        buttonGrid[1][5].setFont(new Font("Courier New", 1, 20));
        buttonGrid[1][5].setBackground(new Color(0xf0, 0xf6, 0xff));
        buttonGrid[1][5].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[1][5].setText("6");
        buttonGrid[1][6].setText("-");
        buttonGrid[1][7].setText("/");
        buttonGrid[2][0].setText("Load");
        buttonGrid[2][1].setText("Save");
        buttonGrid[2][2].setText("Down");
        buttonGrid[2][3].setFont(new Font("Courier New", 1, 20));
        buttonGrid[2][3].setBackground(new Color(0xf0, 0xf6, 0xff));
        buttonGrid[2][3].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[2][3].setText("1");
        buttonGrid[2][4].setFont(new Font("Courier New", 1, 20));
        buttonGrid[2][4].setBackground(new Color(0xf0, 0xf6, 0xff));
        buttonGrid[2][4].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[2][4].setText("2");
        buttonGrid[2][5].setFont(new Font("Courier New", 1, 20));
        buttonGrid[2][5].setBackground(new Color(0xf0, 0xf6, 0xff));
        buttonGrid[2][5].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[2][5].setText("3");
        buttonGrid[2][6].setText("^");
        buttonGrid[2][7].setText("%");
        buttonGrid[3][0].setText("Rec");
        buttonGrid[3][1].setText("Run");
        buttonGrid[3][2].setText("?");
        buttonGrid[3][3].setText("+/-");
        buttonGrid[3][4].setFont(new Font("Courier New", 1, 20));
        buttonGrid[3][4].setBackground(new Color(0xf0, 0xf6, 0xff));
        buttonGrid[3][4].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[3][4].setText("0");
        buttonGrid[3][5].setText(".");
        buttonGrid[3][6].setText("1/n");
        buttonGrid[3][7].setFont(new Font("Courier New", 1, 15));
        buttonGrid[3][7].setBackground(new Color(0xf6, 0xf0, 0xff));
        buttonGrid[3][7].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[3][7].setText("Enter");

        contentPane.add(buttonPanel, BorderLayout.CENTER);
        disableAlpha(); 
    } // setDisplayPanel
    
    /**
     * deal with an action
     * @param actionCommand --the actionEvent performed
     */
    public void dealWith(String actionCommand)
    {        
        if(msgOn)
        {
            msgOn = false;
            displayTextField.setForeground(Color.BLACK);
            if(recordMode)
                displayTextField.setForeground(Color.MAGENTA);
            displayTextField.setText("");
        }
        try
        {
            if(helpMode)    
            {
                displayHelp(actionCommand);
                helpMode = false;
                return;
            }
            else
                inString = displayTextField.getText();
            if(getOn)
            {      
                int index = Integer.parseInt(actionCommand);
                displayTextField.setText(Double.toString(calc.RPNGet(index)));
                getOn = false;
                countSetGet++;
            }
            if(setOn)
            {
                int index = Integer.parseInt(actionCommand);
                calc.RPNSet(toDouble, index);
                setOn = false;
                countSetGet++;
            }
            if(recordMode == true)
            {
                if(!actionCommand.equals("Rec"))
                    calc.RPNRec(actionCommand);
            }
            if(actionCommand.equals("?"))
            {
                if(recordMode == false)
                {
                    helpMode = true;
                    displayTextField.setForeground(new Color(0, 0X99, 0X66));
                    displayTextField.setText(inString = "?");
                }
            }
            else if(actionCommand.equals("eXit"))
                System.exit(0);
            else if(actionCommand.equals("Save"))
            {
               if(recordMode == false)
               {
                   try
                   {   
                      writeToFile();
                   }
                   catch (IOException ex)
                   {
                      Logger.getLogger(RPNForm.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } // Save
            else if(actionCommand.equals("Load"))
            {
               calc.Instructions.clear();
               calc.theStack.clear();
               if(recordMode == false)
               {
                  File file = new File(MacroFile);
                  Scanner scanner = new Scanner(file);
                  while(scanner.hasNext())
                  {
                      String line = scanner.nextLine();
                      calc.RPNRec(line);
                  }
               }
            } // Load
            else if(actionCommand.equals("Rec"))
            {
                if(countRecord == 0)
                   recordMode = true;   // First, turning it on
                else
                   recordMode = false;  // Next, turning it off
                
                if(recordMode == true)
                {
                    buttonGrid[3][0].setForeground(new Color(0xcc, 0x33, 0x00));    // Color red
                    displayTextField.setForeground(new Color(0xcc, 0x33, 0x00));
                    countRecord++;
                    calc.Instructions.clear();
                }
                if(recordMode == false)
                {    
                    buttonGrid[3][0].setForeground(new Color(0X00, 0X00, 0X00));    // Color black
                    displayTextField.setForeground(new Color(0X00, 0X00, 0X00)); 
                    countRecord = 0;
                }
            } // Rec
            else if(actionCommand.equals("Run"))
            {
                if(recordMode == true)
                {
                    recordMode = false;
                    buttonGrid[3][0].setForeground(new Color(0X00, 0X00, 0X00));    // Color black
                    displayTextField.setForeground(new Color(0X00, 0X00, 0X00));
                }
                if(!calc.Instructions.isEmpty())
                        displayTextField.setText(calc.RPNRun());    
            } // Run
            else if(actionCommand.equals("Up"))
            {
                if(calc.theStack.size() > 0)
                    displayTextField.setText(Double.toString(calc.RPNUp()));
            }
            else if(actionCommand.equals("Down"))
            {
                if(calc.theStack.size() > 0)
                    displayTextField.setText(Double.toString(calc.RPNDown()));
            }
            else if(actionCommand.equals("C")
                    || actionCommand.equals("c"))
            {           
                displayTextField.setText("");
                if(calc.theStack.peek() != null)
                {
                    calc.theStack.pop();    // Removes the top element from the stack.
                    displayTextField.setText(Double.toString(calc.theStack.peek()));
                }
            } // C
            else if(actionCommand.equals("CE"))
            {
                displayTextField.setText("");
                calc.theStack.clear();  // Clear Everything.
            } // CE
            else if(actionCommand.equals("Get"))
            {
                getOn = true;
                commandPerformed = false;
            } // Get
            else if(actionCommand.equals("Set"))
            {
                if(!displayTextField.getText().isEmpty())
                {
                    setOn = true;
                    commandPerformed = false;
                    toDouble = Double.parseDouble(displayTextField.getText());
                }
            } // Set
            else if(actionCommand.equals("Enter")
                    || actionCommand.equals("\n"))
            {
                if(displayTextField.getText().equals(""))
                    displayTextField.setText("");
                else
                {
                    toDouble = Double.parseDouble(displayTextField.getText());  // Converting String to double.
                    calc.RPNEnter(toDouble);
                    displayTextField.setText(Double.toString(toDouble));    // Converting double to String.
                    commandPerformed = true;    // If commandPerformed is true, it is going to be clear in displayTextField.
                    setOn = false;
                    getOn = false;
                }
            } // Enter
            else if (actionCommand.equals("1/n"))                 
            {
                if(displayTextField.getText().equals(""))
                    displayTextField.setText("");
                else
                {
                    toDouble = Double.parseDouble(displayTextField.getText());
                    displayTextField.setText(Double.toString(calc.RPNOneOverN(toDouble)));
                    displayString = "";
                }
            } // 1/n
            else if(actionCommand.equals("+/-"))
            {
                if(displayTextField.getText().equals(""))
                    displayTextField.setText("");
                else
                {
                    double doubleSign;
                    if(displayTextField.getText().contains("."))
                    {
                        doubleSign = Double.parseDouble(displayTextField.getText());
                        doubleSign = calc.RPNPosiAndNega(doubleSign);
                        displayTextField.setText(Double.toString(doubleSign));
                    }
                    else
                    {
                        doubleSign = Double.parseDouble(displayTextField.getText());
                        doubleSign = calc.RPNPosiAndNega(doubleSign);
                        displayTextField.setText(Integer.toString((int)doubleSign));
                    }
                }
            } // +/-
            else if (actionCommand.equals("."))                 
            {           
                displayTextField.setText(displayTextField.getText() + ".");               
                setNumber(actionCommand);
            } // .
            else if(Character.isDigit(actionCommand.charAt(0))) // if actioncommand is number
            {
                if(commandPerformed == true)
                    displayTextField.setText("");
                if(setOn ==  false && getOn == false && countSetGet == 0)
                    setNumber(actionCommand);
                countSetGet = 0;
                commandPerformed = false;
            } // Digit
            else // Operator
            {   
                if(actionCommand.equals("+"))
                {
                    displayString = Double.toString(calc.RPNAdd());
                    displayTextField.setText(displayString);
                }
                if(actionCommand.equals("-"))
                {
                    displayString = Double.toString(calc.RPNSubtract());
                    displayTextField.setText(displayString);
                }
                if(actionCommand.equals("*") || actionCommand.equals("x") || 
                        actionCommand.equals("X"))
                {
                    displayString = Double.toString(calc.RPNMultiply());
                    displayTextField.setText(displayString);
                }
                if(actionCommand.equals("/"))
                {
                    displayString = Double.toString(calc.RPNDivides());
                    displayTextField.setText(displayString);
                }
                if(actionCommand.equals("^"))
                {
                    displayString = Double.toString(calc.RPNExponentiation());
                    displayTextField.setText(displayString);
                }
                if(actionCommand.equals("%"))
                {
                    displayString = Double.toString(calc.RPNMod());
                    displayTextField.setText(displayString);  
                }
            }
        }
        catch(Exception e)
        {
                displayTextField.setText("Error");
                System.out.println(e);                
        } 
    } 

    /**
     * displays the appropriate help
     * @param actionCommand the command from the triggering event
     */
    private void  displayHelp(String actionCommand)
    {
        msgOn = true;
        if(actionCommand.equals("eXit"))
                displayTextField.setText("eXit: Exits program");
        else if(actionCommand.equals("C")
                || actionCommand.equals("c"))
                displayTextField.setText("C: Clears top element");
        else if(actionCommand.equals("CE"))
                displayTextField.setText("CE: Clears entire stack");
        else if(actionCommand.equals("+"))
                displayTextField.setText("+: adds top  2 elements");
        else if(actionCommand.equals("x")
                || actionCommand.equals("X")
                || actionCommand.equals("*"))
                displayTextField.setText("x: multiplies top 2 elements");
        else if(actionCommand.equals("Set"))
                displayTextField.setText("Set: Sets register (0-9)");
        else if(actionCommand.equals("Get"))
                displayTextField.setText("Get: gets register (0-9)");
        else if(actionCommand.equals("Up"))
                displayTextField.setText("Up: Rotates stack up");
        else if(actionCommand.equals("-"))
                displayTextField.setText("-: subtracts top 2 elements");
        else if(actionCommand.equals("/"))
                displayTextField.setText("/: divides top 2 elements");
        else if(actionCommand.equals("Load"))
                displayTextField.setText("Load: Loads program from file");
        else if(actionCommand.equals("Save"))
                displayTextField.setText("Save: Saves program to file");
        else if(actionCommand.equals("Down"))
                displayTextField.setText("Down: Rotates stack down");
        else if(actionCommand.equals("^"))
                displayTextField.setText("^: exponent");
        else if(actionCommand.equals("%"))
                displayTextField.setText("%: Mods top 2 elements");
        else if(actionCommand.equals("Rec"))
                displayTextField.setText("Rec: Program mode on/off");
        else if(actionCommand.equals("Run"))
                displayTextField.setText("Run: Runs program");
        else if(actionCommand.equals("?"))
                displayTextField.setText("?: press ? then key for help");
        else if(actionCommand.equals("+/-"))
                displayTextField.setText("+/-: changes sign of number");
        else if(actionCommand.equals("1/n"))
                displayTextField.setText("1/n: inverts the number");
        else if(actionCommand.equals("Enter"))
                displayTextField.setText("Enter: element to stack");
        else
                displayTextField.setText("");
    } // displayHelp
    
    /**
     * 
     * @param c the character to test
     * @return true is c is valid, false otherwise
     */
    private boolean validChar(char c)
    {
        if(Character.isDigit(c))
            return true;
        switch(c)
        {
            case '+':
            case '-':
            case '*':
            case 'x':
            case 'X':               
            case '/':         
            case 'C':
            case 'c':
            case '^':
            case '%':               
            case '?':
            case '.':
            case '\r':
            case '\n':
                
            return true;
        }
        return false;
    }
    
    /**
     * disables non-numeric-related keys
     */
    private void disableAlpha()
    {
        for(char c = '\0'; c < '%'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = '&'; c < '*'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = ':'; c <= '?'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = '@'; c <= 'C'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = 'D'; c <= 'X'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = 'Y'; c <= '^'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = '_'; c <= 'c'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = 'd'; c <= 'x'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = 'y'; c <= '~'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        
        displayTextField.getInputMap().put(KeyStroke.getKeyStroke('/'),
                            "none");
    }
    
    /**
    * Combines previous digit and next digit and displays it in the displayTextField.
    * @param actionCommand the command from the triggering event
    */  
    private void setNumber(String actionCommand)
    {
        if(actionCommand.equals("0"))
        {
            displayString = displayTextField.getText() + "0";
            displayTextField.setText(displayString);
        }
        if(actionCommand.equals("1"))
        {
            displayString = displayTextField.getText() + "1";
            displayTextField.setText(displayString);
        }
        if(actionCommand.equals("2"))
        {
            displayString = displayTextField.getText() + "2";
            displayTextField.setText(displayString);
        }
        if(actionCommand.equals("3"))
        {
            displayString = displayTextField.getText() + "3";
            displayTextField.setText(displayString);
        }
        if(actionCommand.equals("4"))
        {
            displayString = displayTextField.getText() + "4";
            displayTextField.setText(displayString);
        }
        if(actionCommand.equals("5"))
        {
            displayString = displayTextField.getText() + "5";
            displayTextField.setText(displayString);
        }
        if(actionCommand.equals("6"))
        {
            displayString = displayTextField.getText() + "6";
            displayTextField.setText(displayString);
        }
        if(actionCommand.equals("7"))
        {
            displayString = displayTextField.getText() + "7";
            displayTextField.setText(displayString);
        }
        if(actionCommand.equals("8"))
        {
            displayString = displayTextField.getText() + "8";
            displayTextField.setText(displayString);
        }
        if(actionCommand.equals("9"))
        {
            displayString = displayTextField.getText() + "9";
            displayTextField.setText(displayString);
        }
    }
    
    /**
    * Save a file from instructions
    */  
    private void writeToFile() throws IOException
    {
        WriteFile wf = new WriteFile(MacroFile);
        
        for(int i = 0; i < calc.Instructions.size(); i++)
             wf.write(calc.Instructions.get(i));
        wf.close();
    }
} // RPNForm
