/*
 * RPNCalculator.java
 */

package rpncalculator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * RPNCalculator class
 * Java class for post-fix calculating
 * @author DeukYeol Choe
 * @version 1.0
 * Test Environment: JDK 1.7.0_03 on Windows 7, i3 CPU
 */ 
public class RPNCalculator
{
    public static final int ROWS = 4;
    public static final int COLS = 8;
    public static final int NUMBER_OF_REGISTERS = 10;
    public Deque<Double> theStack;   
    public LinkedList<String> Instructions;
    public double[] register;
    
    /**
     * Creates a new instance of RPNCalculator
     */
    public RPNCalculator()
    {
       theStack = new LinkedList<Double>();
       register = new double[NUMBER_OF_REGISTERS];
       Instructions = new LinkedList<String>();
    }
    
    /**
    * Input data in the Stack.
    * @param number -- digits 
    */
    public void RPNEnter(double number)
    {
        theStack.addFirst(number);
    }
    
    /**
    * Adds top two elements in the stack, and replaces them in the stack with the answer.
    * @return output -- the answer
    */    
    public double RPNAdd()
    {
        double output = theStack.pop();
        output = theStack.pop() + output;
        theStack.push(output);
        return output;
    }
    
    /**
    * Subtracts the top two elements in the stack, and replaces them in the stack with the answer.
    * @return output -- the answer.
    */    
    public double RPNSubtract()
    {
        double output = theStack.pop();
        output = theStack.pop() - output;
        theStack.push(output);
        return output;
    }
    
    /**
    * Multiplies the top two elements in the stack, and replaces them in the stack with the answer.
    * @return output -- the answer.
    */       
    public double RPNMultiply()
    {
        double output = theStack.pop();
        output = theStack.pop() * output;
        theStack.push(output);
        return output;        
    }
    
    /**
    * Divides the top two elements in the stack, and replaces them in the stack with the answer.
    * @return output -- the answer.
    */      
    public double RPNDivides()
    {
        double output = theStack.pop();
        output = theStack.pop() / output;
        theStack.push(output);
        return output;
    }
    
    /**
    * Exponentiation -- e.g. 4 5^ would be 4 to the 5th power (45).
    * @return output -- the answer.
    */     
    public double RPNExponentiation()
    {
        double output;
        double expo = theStack.pop();
        double number = theStack.pop();
        output = Math.pow(number, expo);
        theStack.push(output);
        return output;
    }
    
    /**
    * Mod
    * @return output -- the answer.
    */       
    public double RPNMod()
    {
        double mod = theStack.pop();
        double output = theStack.pop();
        output %= mod;
        theStack.push(output);
        return output;
    }
    
    /**
    * Replaces the number in the display with its multiplicative inverse (blank if not a number)
    * @return output -- the answer.
    */ 
    public double RPNOneOverN(double number)
    {
        double output = (1 / number);
        return output;
    }
    
    /**
    * Change sign of element displayed -- (blank if not a number)
    * @return number -- the answer.
    */     
    public double RPNPosiAndNega(double number)
    {
        return -number;
    }
    
    /**
    * Sets the value in m_registers[n].
    * @param number, index -- data, index
    */         
    public void RPNSet(double number, int index)
    {
        register[index] = number;
    }    
    
    /**
    * Gets the value from m_registers[n] and places it in the display.
    * @param index
    * @return register[index] -- the element.
    */   
    public double RPNGet(int index)
    {
        return register[index];
    }
    
    /**
    * Rotate the stack Up -- remove the top element and place it at the bottom.
    * @return output -- the element at the bottom.
    */      
    public double RPNUp()
    {
        double output = theStack.pollFirst();
        theStack.addLast(output);
        return output;
    }
    
    /**
    * Rotate the stack Down -- remove the bottom element and place it at the top.
    * @return output -- the element at the top.
    */       
    public double RPNDown()
    {
        double output = theStack.pollLast();
        theStack.addFirst(output);
        return output;
    }
    
    /**
    * Starts/stops Recording a Macro after clearing any existing program instructions. 
    * Commands continue to work as normal, but the color of the display is different.
    * @param number -- All data recorded such as digits, operators, and key functions
    */       
    public void RPNRec(String number)
    {
        if(number.equals("\n"))
            number = "Enter";
        Instructions.add(number);
    }
    
    /**
    * Runs the macro in m_program -- (if in record mode, stops recording first).
    * @return output -- the answer of depending on Macro (txt file)
    */    
    public String RPNRun()
    {
        String addString = "";
        String operString = "";
        double output = 0.0;
        boolean setMode = false;
        boolean getMode = false;
        boolean pointMode = false;
        boolean oneOverNMode = false;
        addString = Instructions.get(0);
        for(int i = 1; i < Instructions.size(); i++)
        {
            if(setMode == true)
            {
                if(addString == "") // for setmode
                {
                    operString = Double.toString(output);    // this output means theStack.peak()
                    RPNSet(Double.parseDouble(operString), Integer.parseInt(Instructions.get(i)));
                }
                else
                {
                    RPNSet(Double.parseDouble(addString), Integer.parseInt(Instructions.get(i)));
                }
                setMode = false;
            }
            else if(getMode == true)
            {
                addString = Double.toString(RPNGet(Integer.parseInt(Instructions.get(i))));
                getMode = false;
            }
            else if(pointMode == true)  // example, 0.5
            {
                addString = addString + "." + Instructions.get(i);
                pointMode = false;
            }
            else if(oneOverNMode == true)
            {
                addString = Double.toString(RPNOneOverN(Double.parseDouble(addString)));
                oneOverNMode = false;
            }
            else if(Character.isDigit(Instructions.get(i).charAt(0)))
            {
                addString = addString + Instructions.get(i);   // For only digit
            }
            else
            {
                if(Instructions.get(i).equals("Enter"))
                {
                    RPNEnter(Double.parseDouble(addString));
                    output = theStack.peek();
                }
                if(Instructions.get(i).equals("+"))
                    output = RPNAdd();           
                if(Instructions.get(i).equals("-"))
                    output = RPNSubtract();
                if(Instructions.get(i).equals("*") || Instructions.get(i).equals("x") || 
                        Instructions.get(i).equals("X"))
                    output = RPNMultiply();
                if(Instructions.get(i).equals("/"))
                    output = RPNDivides();
                if(Instructions.get(i).equals("^"))
                    output = RPNExponentiation(); 
                if(Instructions.get(i).equals("%"))
                    output = RPNMod();
                if(Instructions.get(i).equals("Set"))      
                    setMode = true;
                if(Instructions.get(i).equals("Get"))      
                    getMode = true;
                if(Instructions.get(i).equals("1/n"))      
                    oneOverNMode = true;
                if(Instructions.get(i).equals("."))
                    pointMode = true;
                if(setMode != true && oneOverNMode != true && pointMode != true)
                    addString = "";
            }
        }
        return Double.toString(output);
    }       
}   // RPNCalculator
