/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: annuityGUI
* File: annuityGUI.java
* Description: Calculate payments given periodic payment, interest rate
* ,and compounds per year, years. It also displays future annuity balance,
 * total of payments, total of interest earned.
* @author: DeukYeol Choe
* Environment: PC, Windows 7, jdk6.23, NetBeans 6.9.1
* Date: 1/21/2011
* @version 6.3
* @see javax.swing.JOptionPane;
* @see java.text.DecimalFormat;
* @see java.awt.Dimension;
* @see java.awt.Toolkit;
* @see javax.swing.JFrame;
* history log : update from 1/21/2011
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

package futureannuity;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class annuityGUI extends javax.swing.JFrame {
    /** Creates new form annuityGUI */
    public annuityGUI() {
        initComponents();

        // set calculateJButton as default
        this.getRootPane().setDefaultButton(calculateJButton);

        // set icon for form
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Mallett.jpg"));
        paymentJTextField.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        secondJPanel = new javax.swing.JPanel();
        paymentJLabel = new javax.swing.JLabel();
        interestJLabel = new javax.swing.JLabel();
        compoundsJLabel = new javax.swing.JLabel();
        yearsJLabel = new javax.swing.JLabel();
        paymentJTextField = new javax.swing.JTextField();
        compoundsJTextField = new javax.swing.JTextField();
        yearsJTextField = new javax.swing.JTextField();
        interestJSpinner = new javax.swing.JSpinner();
        balanceJLabel = new javax.swing.JLabel();
        totalpaymentJLabel = new javax.swing.JLabel();
        totalInterestJLabel = new javax.swing.JLabel();
        balanceJTextField = new javax.swing.JTextField();
        totalpaymentJTextField = new javax.swing.JTextField();
        totalInterestJTextField = new javax.swing.JTextField();
        calculateJButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Future Annuity");

        secondJPanel.setBackground(new java.awt.Color(153, 153, 255));

        paymentJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        paymentJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        paymentJLabel.setText("Periodic Payment:");

        interestJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        interestJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        interestJLabel.setText("Interest (as a %):");

        compoundsJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        compoundsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        compoundsJLabel.setText("Compounds per year:");

        yearsJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        yearsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        yearsJLabel.setText("Years:");

        paymentJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentJTextFieldActionPerformed(evt);
            }
        });

        compoundsJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compoundsJTextFieldActionPerformed(evt);
            }
        });

        yearsJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearsJTextFieldActionPerformed(evt);
            }
        });

        interestJSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        javax.swing.GroupLayout secondJPanelLayout = new javax.swing.GroupLayout(secondJPanel);
        secondJPanel.setLayout(secondJPanelLayout);
        secondJPanelLayout.setHorizontalGroup(
            secondJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(secondJPanelLayout.createSequentialGroup()
                .addGroup(secondJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, secondJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(yearsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, secondJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, secondJPanelLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(paymentJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, secondJPanelLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(interestJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                        .addGroup(secondJPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(compoundsJLabel))))
                .addGroup(secondJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(secondJPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(secondJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paymentJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(compoundsJTextField)
                            .addComponent(yearsJTextField))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, secondJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(interestJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        secondJPanelLayout.setVerticalGroup(
            secondJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(secondJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(secondJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(secondJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interestJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(interestJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(secondJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compoundsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(compoundsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(secondJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        balanceJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        balanceJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        balanceJLabel.setText("Future Annuity Balance:");

        totalpaymentJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        totalpaymentJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalpaymentJLabel.setText("Total of Payments:");

        totalInterestJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        totalInterestJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalInterestJLabel.setText("Total of Interest Earned:");

        balanceJTextField.setEditable(false);
        balanceJTextField.setFont(new java.awt.Font("Tahoma", 1, 18));
        balanceJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        totalpaymentJTextField.setEditable(false);
        totalpaymentJTextField.setFont(new java.awt.Font("Tahoma", 1, 18));
        totalpaymentJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        totalInterestJTextField.setEditable(false);
        totalInterestJTextField.setFont(new java.awt.Font("Tahoma", 1, 18));
        totalInterestJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalInterestJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalInterestJTextFieldActionPerformed(evt);
            }
        });

        calculateJButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        calculateJButton.setMnemonic('c');
        calculateJButton.setText("Calculate");
        calculateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateJButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        clearButton.setMnemonic('c');
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        quitButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        quitButton.setMnemonic('q');
        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(calculateJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(secondJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totalInterestJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(balanceJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(totalpaymentJLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalInterestJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(totalpaymentJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(balanceJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(secondJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalpaymentJLabel)
                            .addComponent(totalpaymentJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(balanceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(balanceJLabel))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalInterestJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalInterestJLabel))
                .addGap(19, 19, 19)
                .addComponent(calculateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method:clearButtonActionPerformed()
* Description: make all fieldtexts to remove clearly
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 1/21/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearButtonActionPerformed
    {//GEN-HEADEREND:event_clearButtonActionPerformed
        paymentJTextField.setText("");
        interestJSpinner.setValue(0);
        compoundsJTextField.setText("");
        yearsJTextField.setText("");
        balanceJTextField.setText("");
        totalpaymentJTextField.setText("");
        totalInterestJTextField.setText("");
        paymentJTextField.requestFocus(); //return input cursor to payment field
    }//GEN-LAST:event_clearButtonActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: quitButtonActionPerformed()
* Description: exit forcely this program
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 1/21/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitButtonActionPerformed
    {//GEN-HEADEREND:event_quitButtonActionPerformed
        System.exit(1);
    }//GEN-LAST:event_quitButtonActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: calculateJButtonActionPerformed()
* Description: Gets the variables from paymentJTextField,interestJTextField
 * compoundsJTextField, yearsJTextField and calculates them through Annuity.java
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 1/21/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void calculateJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_calculateJButtonActionPerformed
    {//GEN-HEADEREND:event_calculateJButtonActionPerformed
        try
        {
            double payment = Double.parseDouble(paymentJTextField.getText());
            double interest = Double.parseDouble(interestJSpinner.getValue().toString());
            double compound = Double.parseDouble(compoundsJTextField.getText());
            double years = Double.parseDouble(yearsJTextField.getText());

            //calculates variables through Annuity.java
            Annuity myAnnuity = new Annuity(payment,interest,compound,years);

            //check data validation for valid range and type-do not allow negative input
            boolean invalidInputs = myAnnuity.checkVaribles();
            
            if(invalidInputs)
            {
                throw new NumberFormatException();
            }

            myAnnuity.calculateAnnuity(); // calculating funtion ! !

            //Gets the calculated variables again.
            balanceJTextField.setText(myAnnuity.getFAB());     //the result of FAB
            totalpaymentJTextField.setText(myAnnuity.getTP());  //the result of TP
            totalInterestJTextField.setText(myAnnuity.getTIE());  //the result of TIE
        } // the end of try
        catch(NumberFormatException name)
        {
            JOptionPane.showMessageDialog(null,"No negative! No words! No excessive number!",
             "Input Error", JOptionPane.ERROR_MESSAGE);
                paymentJTextField.requestFocus();
                paymentJTextField.selectAll();
                clearButtonActionPerformed(evt);
        }//the end of catch
    }//GEN-LAST:event_calculateJButtonActionPerformed

    private void totalInterestJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_totalInterestJTextFieldActionPerformed
    {//GEN-HEADEREND:event_totalInterestJTextFieldActionPerformed
        // just show up
    }//GEN-LAST:event_totalInterestJTextFieldActionPerformed

    private void yearsJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_yearsJTextFieldActionPerformed
    {//GEN-HEADEREND:event_yearsJTextFieldActionPerformed
        // enter -> run calculatebutton
        calculateJButtonActionPerformed(evt);
    }//GEN-LAST:event_yearsJTextFieldActionPerformed

    private void paymentJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_paymentJTextFieldActionPerformed
    {//GEN-HEADEREND:event_paymentJTextFieldActionPerformed
    }//GEN-LAST:event_paymentJTextFieldActionPerformed

    private void compoundsJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_compoundsJTextFieldActionPerformed
    {//GEN-HEADEREND:event_compoundsJTextFieldActionPerformed
    }//GEN-LAST:event_compoundsJTextFieldActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: main()
* Description: Sets up the display in the center of the screen
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 1/21/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                annuityGUI myMoney = new annuityGUI();
                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screen.width - myMoney.getWidth())/2;
                int y = (screen.height - myMoney.getHeight())/2;
                myMoney.setBounds(x,y,myMoney.getWidth(),myMoney.getHeight());

                myMoney.setVisible(true);
                myMoney.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balanceJLabel;
    private javax.swing.JTextField balanceJTextField;
    private javax.swing.JButton calculateJButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel compoundsJLabel;
    private javax.swing.JTextField compoundsJTextField;
    private javax.swing.JLabel interestJLabel;
    private javax.swing.JSpinner interestJSpinner;
    private javax.swing.JLabel paymentJLabel;
    private javax.swing.JTextField paymentJTextField;
    private javax.swing.JButton quitButton;
    private javax.swing.JPanel secondJPanel;
    private javax.swing.JLabel totalInterestJLabel;
    private javax.swing.JTextField totalInterestJTextField;
    private javax.swing.JLabel totalpaymentJLabel;
    private javax.swing.JTextField totalpaymentJTextField;
    private javax.swing.JLabel yearsJLabel;
    private javax.swing.JTextField yearsJTextField;
    // End of variables declaration//GEN-END:variables

}
