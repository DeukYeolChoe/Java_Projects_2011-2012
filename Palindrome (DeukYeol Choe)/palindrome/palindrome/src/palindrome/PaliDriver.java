package palindrome;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaliDriver extends JFrame{

   private JLabel enterStringLabe;
   private JTextField stringField;

   public PaliDriver()		//constructor replacing init
   {
       final StackInheritance stack = new StackInheritance();
       final JLabel prompt = new JLabel("Enter String: ");
       final JTextField input = new JTextField(20);

       Container container = getContentPane();
       container.setLayout(new BorderLayout());
       container.add(prompt, BorderLayout.NORTH);
       container.add(input, BorderLayout.SOUTH);

       input.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent event)
           {
               String sentence = input.getText().toLowerCase();
               char letter = '\0';

               for( int i =0; i < sentence.length(); i++)
               {
                   letter = sentence.charAt(i);

                   if(Character.isLetterOrDigit(letter))
                       stack.push(new Character(letter));
               }

               Object removedObject = null;
               boolean flag = false;
               boolean isPali = true;

               try
               {
                   for(int count = 0; count < sentence.length() && !stack.isEmpty() && isPali
                           ; count++)
                   {
                       letter = sentence.charAt(count);

                       if(Character.isLetterOrDigit(letter))
                       {
                           removedObject = stack.pop();

                           if(letter != ((Character) removedObject).charValue())
                           {
                               isPali = false;
                           }
                       }
                   }

                   if(isPali)
                       setTitle("Palidrome");
                   else
                       setTitle("Not a Palindrome");

               }
               catch(EmptyListException exception)
               {
                   System.err.print("\n" + exception.toString());
               }

           }
       }
       );




   }

   public static void main(String [] args)
   {
      //PaliDriver window = new PaliDriver();
      PaliDriver myStack = new PaliDriver();
      myStack.setSize(400,75);
      myStack.setTitle("Testing for Palidrome");
      myStack.setResizable(false);
      myStack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myStack.setLocationRelativeTo(null);
      myStack.setVisible(true);
   }
}
