package palindrome;

import javax.swing.JFrame;


public class PaliGUI extends javax.swing.JFrame {

    String fileName = "src/Poli.txt";
    final StackInheritance stack = new StackInheritance();



    /** Creates new form PaliGUI */
    public PaliGUI() {
        initComponents();

        readFromFile(fileName);
    }
    
    private void readFromFile(String file)
     {
        ReadFile rf = new ReadFile(file);
        String input = rf.readRecord();

        // Read while there is data
        while(input != null)
        {
            textJComboBox.addItem(input);
            input = rf.readRecord();
        }
        rf.close();
        textJComboBox.requestFocus();
     }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bottomJPanel = new javax.swing.JPanel();
        checkJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        textJComboBox = new javax.swing.JComboBox();
        resultJTextField = new javax.swing.JTextField();
        resultJLabel = new javax.swing.JLabel();
        enterStringJTextField = new javax.swing.JTextField();
        enterStringjLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Palindrome on Stack");

        bottomJPanel.setForeground(new java.awt.Color(153, 153, 255));
        bottomJPanel.setLayout(new java.awt.GridLayout(1, 2, 20, 10));

        checkJButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        checkJButton.setText("Check");
        checkJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkJButtonActionPerformed(evt);
            }
        });
        bottomJPanel.add(checkJButton);

        exitJButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        exitJButton.setText("Exit");
        exitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJButtonActionPerformed(evt);
            }
        });
        bottomJPanel.add(exitJButton);

        textJComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        textJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textJComboBoxActionPerformed(evt);
            }
        });

        resultJTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        resultJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        resultJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        resultJLabel.setText("Result:");

        enterStringJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enterStringJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        enterStringjLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        enterStringjLabel.setText("Enter String:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottomJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(resultJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(resultJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textJComboBox, 0, 380, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enterStringjLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enterStringJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterStringJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterStringjLabel))
                .addGap(18, 18, 18)
                .addComponent(textJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultJLabel))
                .addGap(38, 38, 38)
                .addComponent(bottomJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textJComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_textJComboBoxActionPerformed
    {//GEN-HEADEREND:event_textJComboBoxActionPerformed
        enterStringJTextField.setText("");

        String sentence = textJComboBox.getSelectedItem().toString().toLowerCase();
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
                       resultJTextField.setText("Palidrome");
                   else
                       resultJTextField.setText("Not a Palindrome");

               }
               catch(EmptyListException exception)
               {
                   System.err.print("\n" + exception.toString());
               }
    }//GEN-LAST:event_textJComboBoxActionPerformed

    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitJButtonActionPerformed
    {//GEN-HEADEREND:event_exitJButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitJButtonActionPerformed

    private void checkJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_checkJButtonActionPerformed
    {//GEN-HEADEREND:event_checkJButtonActionPerformed
        String sentence = enterStringJTextField.getText().toLowerCase();
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
                       resultJTextField.setText("Palidrome");
                   else
                       resultJTextField.setText("Not a Palindrome");

               }
               catch(EmptyListException exception)
               {
                   System.err.print("\n" + exception.toString());
               }
    }//GEN-LAST:event_checkJButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {

           PaliGUI edVetGUI = new PaliGUI();
           edVetGUI.setLocationRelativeTo(null);  // locate this program in the center of screen
           edVetGUI.setVisible(true);
           edVetGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomJPanel;
    private javax.swing.JButton checkJButton;
    private javax.swing.JTextField enterStringJTextField;
    private javax.swing.JLabel enterStringjLabel;
    private javax.swing.JButton exitJButton;
    private javax.swing.JLabel resultJLabel;
    private javax.swing.JTextField resultJTextField;
    private javax.swing.JComboBox textJComboBox;
    // End of variables declaration//GEN-END:variables

}
