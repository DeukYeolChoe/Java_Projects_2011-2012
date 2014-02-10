package Tennis;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: AddForm
* File: AddForm.java
* Description: When clicking on addbutton, this is showing up.
 * seperating it from TennisGUI is more practical program
* @author: DeukYeol Choe
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 4/20/2011
* @version 6.0
* @see java.util.ArrayList;
* @see java.util.List;
* @see javax.swing.JOptionPane;
* @see java.awt.Toolkit;
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class AddForm extends javax.swing.JFrame
{
    TennisGUI accessArrayList = new TennisGUI();

    // Constructure
    public AddForm() {
        initComponents();
        this.getRootPane().setDefaultButton(addUpdateJButton);  // set default button
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icon.png"));   // set icon
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addUpdateJButton = new javax.swing.JButton();
        addCancelJButton = new javax.swing.JButton();
        addJPanel = new javax.swing.JPanel();
        addFirstNameJLabel = new javax.swing.JLabel();
        addFirstNameJTextField = new javax.swing.JTextField();
        addLastNameJLabel = new javax.swing.JLabel();
        addLastNameJTextField = new javax.swing.JTextField();
        addEmailJLabel = new javax.swing.JLabel();
        addPhoneJLabel = new javax.swing.JLabel();
        addLevelJLabel = new javax.swing.JLabel();
        addLevelJSpinner = new javax.swing.JSpinner();
        addphoneJFormattedTextField = new javax.swing.JFormattedTextField();
        emailJTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("addForm");
        setResizable(false);

        addUpdateJButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        addUpdateJButton.setMnemonic('U');
        addUpdateJButton.setText("Add member");
        addUpdateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUpdateJButtonActionPerformed(evt);
            }
        });

        addCancelJButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        addCancelJButton.setMnemonic('C');
        addCancelJButton.setText("Cancel");
        addCancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCancelJButtonActionPerformed(evt);
            }
        });

        addFirstNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        addFirstNameJLabel.setForeground(new java.awt.Color(255, 0, 0));
        addFirstNameJLabel.setText("First Name* :");

        addFirstNameJTextField.setFont(new java.awt.Font("Tahoma", 1, 11));
        addFirstNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFirstNameJTextFieldActionPerformed(evt);
            }
        });

        addLastNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        addLastNameJLabel.setForeground(new java.awt.Color(255, 0, 0));
        addLastNameJLabel.setText("Last Name* :");

        addLastNameJTextField.setFont(new java.awt.Font("Tahoma", 1, 11));
        addLastNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLastNameJTextFieldActionPerformed(evt);
            }
        });

        addEmailJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        addEmailJLabel.setText("Email Address :");

        addPhoneJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        addPhoneJLabel.setForeground(new java.awt.Color(255, 0, 0));
        addPhoneJLabel.setText("Phone Number* :");

        addLevelJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        addLevelJLabel.setForeground(new java.awt.Color(255, 0, 0));
        addLevelJLabel.setText("Level* :");

        addLevelJSpinner.setFont(new java.awt.Font("Tahoma", 1, 11));
        addLevelJSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));

        try {
            addphoneJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(  ###  )  -  ###  -  ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        addphoneJFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addphoneJFormattedTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addJPanelLayout = new javax.swing.GroupLayout(addJPanel);
        addJPanel.setLayout(addJPanelLayout);
        addJPanelLayout.setHorizontalGroup(
            addJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addJPanelLayout.createSequentialGroup()
                .addGroup(addJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addJPanelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(addLevelJLabel)
                        .addGap(34, 34, 34)
                        .addComponent(addLevelJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addPhoneJLabel)
                            .addComponent(addEmailJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addFirstNameJLabel)
                                .addComponent(addLastNameJLabel)))
                        .addGap(18, 18, 18)
                        .addGroup(addJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addphoneJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(addFirstNameJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addLastNameJTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                            .addComponent(emailJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addJPanelLayout.setVerticalGroup(
            addJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addJPanelLayout.createSequentialGroup()
                .addGroup(addJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFirstNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addFirstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLastNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmailJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPhoneJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addphoneJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLevelJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLevelJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addUpdateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCancelJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(addJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(addJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUpdateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCancelJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     /**
     * Method: addUpdateJButtonActionPerformed
     * add new player
     * @return void
     * pre-condition: valid data. There must be 4 value addFirstName, addLastName, addPhone, and addLevel
     * post-condition: show the result on TennisGUI
     * in the database
     */
    private void addUpdateJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addUpdateJButtonActionPerformed
    {//GEN-HEADEREND:event_addUpdateJButtonActionPerformed
       try
       {
           // Extract values from JTextFields
           String addFirstName = addFirstNameJTextField.getText();
           String addLastName = addLastNameJTextField.getText();
           String addEmail = emailJTextField.getText();
           String addPhone = addphoneJFormattedTextField.getText();
           String addLevel = addLevelJSpinner.getValue().toString();
           int addIntLevel = Integer.parseInt(addLevel);
 
           // conditions if the values of name, phone, and level are empty, call NullPointerException.
           //tennisInfo.get(index).getPhoneNumber().equals("")
           if(addFirstName.equals(""))
              throw new NullPointerException();
           if(addLastName.equals(""))
              throw new NullPointerException();
           if(addPhone.equals(""))
              throw new NullPointerException();

           TennisDatabase accessDatabase = new TennisDatabase(addFirstName, addLastName, addEmail, addPhone, addIntLevel);
           if(!accessArrayList.playerExists(accessDatabase))
            {
                accessArrayList.tennisInfo.add(accessDatabase);  // pass accessDatabase adding new data to tennisInfo in TennisGUI

                accessArrayList.displayDatabase();
                accessArrayList.savePlayer();
           }

            setVisible(false);

            TennisGUI tennisWindow = new TennisGUI();
            tennisWindow.setVisible(true);
            tennisWindow.setLocationRelativeTo(null);
        }

        catch(NullPointerException nullex)
        {
            JOptionPane.showMessageDialog( null,"Player not added. You Must fill 4 fields with red", " input error ",
            JOptionPane.WARNING_MESSAGE );
        }

    }//GEN-LAST:event_addUpdateJButtonActionPerformed

     /**
     * Method: addCancelJButtonActionPerformed
     * when clicking cancel button, add form will be disappear and show TennisGUI on the screen
     * @return void
     * pre-condition: valid data. There must be 4 value addFirstName, addLastName, addPhone, and addLevel
     * post-condition: show the result on TennisGUI
     * in the database
     */
    private void addCancelJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addCancelJButtonActionPerformed
    {//GEN-HEADEREND:event_addCancelJButtonActionPerformed
       setVisible(false);
       TennisGUI tennisWindow = new TennisGUI();
       tennisWindow.setVisible(true);
       tennisWindow.setLocationRelativeTo(null);
}//GEN-LAST:event_addCancelJButtonActionPerformed

    private void addFirstNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addFirstNameJTextFieldActionPerformed
    {//GEN-HEADEREND:event_addFirstNameJTextFieldActionPerformed
    }//GEN-LAST:event_addFirstNameJTextFieldActionPerformed

    private void addLastNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addLastNameJTextFieldActionPerformed
    {//GEN-HEADEREND:event_addLastNameJTextFieldActionPerformed
    }//GEN-LAST:event_addLastNameJTextFieldActionPerformed

    private void addphoneJFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addphoneJFormattedTextFieldActionPerformed
}//GEN-LAST:event_addphoneJFormattedTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCancelJButton;
    private javax.swing.JLabel addEmailJLabel;
    private javax.swing.JLabel addFirstNameJLabel;
    private javax.swing.JTextField addFirstNameJTextField;
    private javax.swing.JPanel addJPanel;
    private javax.swing.JLabel addLastNameJLabel;
    private javax.swing.JTextField addLastNameJTextField;
    private javax.swing.JLabel addLevelJLabel;
    private javax.swing.JSpinner addLevelJSpinner;
    private javax.swing.JLabel addPhoneJLabel;
    private javax.swing.JButton addUpdateJButton;
    private javax.swing.JFormattedTextField addphoneJFormattedTextField;
    private javax.swing.JTextField emailJTextField;
    // End of variables declaration//GEN-END:variables

}
