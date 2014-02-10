/*-'~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
'Comments by the prof:
'Great effort. Here are suggestions for improving:
'1. Use Javadocs comments through the program, not just at the top heading
'Use comments to describe the class each method and complicated code.
'2. Convert entries in JTextFields from strings to numbers with the appropriate
'parse methods. You get type mismatch run-time error otherwise.
'3. Make the convert button default.
'4. Correct the formulasresults are incorrect.
'5. Apply 8% tax to bill.
'6. Use final definition for all constants.
'7. It is good style to tab code inside a method.
'8. Provide Clear, Print and Quit buttons.
'9. Set focus to JTextFieldNights after Clear.
'10. Change the tab sequence to indicate correct order of entry.
'11. Use the Heading.txt heading for the project.
'12. Display date and time of bill.
'13. Display bill as currency.
'14. Follow the Java naming convention for naming variables.
'15. Avoid excessive class variables-declare local variables inside methods.
'16. Clean up the empty methods code.
'17. Implement input validation for all text fields (avoid -3 or 10000 or pr#$%d
nights, for example).
'18. Select one radio button (both for room and discounts) as checked initially.
'19. Set date and time in form load event procedure.
'20. Use the function to prevent crashing in empty or incorrect type input.
'21. Text fields should be empty initially.
'22. Nights should be a byte.
'23. Recalculate bill dynamically--as you select a radio button or the check box,
recalculate bill.
'24. Use monospaced font in JListBox such as Courier--it helps line-up columns
correctly.
'25. Recalculate bill dynamically--as you select a radio button or the check box,
recalculate bill.
'26. Use monospaced font such as Courier for the JListBox--it helps set columns
correctly.
'27. Provide ToolTip.
'28. Provide an icon for the form.
'29. Program crashes on empty text boxes.
'30. Consider using a JSpinner for the number of nights.
'31. Center the form as it loads.
 * */

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: OrcasGUI
* File: OrcasGUI.java
* Description: Calculate payments given room and additional charges payment.
 * It also displays items, charges.
* @author: DeukYeol Choe
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 2/14/2011
* @version 6.0
* @see java.awt.Dimension;
* @see java.awt.Dimension;
* @see java.awt.Graphics;
* @see java.awt.Toolkit;
* @see java.io.BufferedReader;
* @see java.io.FileNotFoundException;
* @see java.io.FileReader;
* @see java.io.FileWriter;
* @see java.io.IOException;
* @see java.io.PrintWriter;
* @see java.text.DateFormat;
* @see java.text.NumberFormat;
* @see java.text.SimpleDateFormat;
* @see javax.swing.JFrame;
* @see javax.swing.JOptionPane;
* history log : update from 2/16/2011
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package orcasbb;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OrcasGUI extends javax.swing.JFrame{


     NumberFormat dollars = NumberFormat.getCurrencyInstance();        // numberformat
     StringBuffer display = new StringBuffer("");                      // stringbuffer for display bill

     // initialize three variables
     double specialMeals = 0.0;
     double telePhone  = 0.0;
     double miscellAneous = 0.0;


    /** Creates new form OrcasGUI */
    public OrcasGUI() {
        initComponents();
        this.getRootPane().setDefaultButton(calculateJButton); // Set defaultButton -> calculateButton

        String filename = "src\\heading.txt",      // File name
        customerName;

        // set icon for form
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/orcasbb.png"));

        // basic setup
        nightsSpinner.requestFocus();
        paradiseJRadioButton.setSelected(true);
        discountJCheckBox.setSelected(true);

        // date and time setting
        setDate();

        // Call heading.txt and input it to customerName
        try
        {
            FileReader freader = new FileReader(filename);
            BufferedReader inputFile = new BufferedReader(freader);

            // Read the first name from the file.
            customerName = inputFile.readLine();

            // Add customer name to JComboBox
            while (customerName != null)
            {
                customerListJComboBox.addItem(customerName);
                customerName = inputFile.readLine();
            }
        }
         catch(FileNotFoundException exp)        // catch file not found
        {
            exp.printStackTrace();
        }

        catch(IOException exp)                  // catch reading error
        {
            exp.printStackTrace();
        }
}
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: setDate()
* Description: set up time and date
* @return: void
* @param: void
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setDate()
    {
        DateFormat dateFormatDate = new SimpleDateFormat("M/dd/yyyy");
        DateFormat dateFormatTime = new SimpleDateFormat("hh:mm:ss");
        java.util.Date date = new java.util.Date();
        todayDateJTextField.setText(dateFormatDate.format(date));
        timeJTextField.setText(dateFormatTime.format(date));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RoomInformationbuttonGroup = new javax.swing.ButtonGroup();
        topJPanel = new javax.swing.JPanel();
        titleJLabel = new javax.swing.JLabel();
        pictureJLabel = new javax.swing.JLabel();
        todayDateJLabel = new javax.swing.JLabel();
        timeJLabel = new javax.swing.JLabel();
        todayDateJTextField = new javax.swing.JTextField();
        timeJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        customerListJComboBox = new javax.swing.JComboBox();
        leftJPanel = new javax.swing.JPanel();
        nightsJLabel = new javax.swing.JLabel();
        nightsSpinner = new javax.swing.JSpinner();
        paradiseJRadioButton = new javax.swing.JRadioButton();
        atlantisJRadioButton = new javax.swing.JRadioButton();
        orcasJRadioButton = new javax.swing.JRadioButton();
        discountJCheckBox = new javax.swing.JCheckBox();
        rightJPanel = new javax.swing.JPanel();
        specialMealsJLabel = new javax.swing.JLabel();
        telephoneJLabel = new javax.swing.JLabel();
        miscellaneousLabel = new javax.swing.JLabel();
        specialMealsJTextField = new javax.swing.JTextField();
        telephoneJTextField = new javax.swing.JTextField();
        miscellaneousJTextField = new javax.swing.JTextField();
        bottomJPanel = new javax.swing.JPanel();
        displayScrollPane = new javax.swing.JScrollPane();
        outJTextArea = new javax.swing.JTextArea();
        calculateJButton = new javax.swing.JButton();
        clearJButton = new javax.swing.JButton();
        printJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menuJMenuBar = new javax.swing.JMenuBar();
        Files = new javax.swing.JMenu();
        Rooms = new javax.swing.JMenu();
        Help = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Orcas Bed and Breakfast");
        setBackground(new java.awt.Color(255, 153, 153));
        setFont(new java.awt.Font("Agency FB", 1, 12));
        setForeground(new java.awt.Color(0, 255, 0));

        titleJLabel.setFont(new java.awt.Font("SansSerif", 1, 36));
        titleJLabel.setText("    Orcas B&B");

        pictureJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/orcasbb/ocean.png"))); // NOI18N

        todayDateJLabel.setFont(new java.awt.Font("SansSerif", 0, 14));
        todayDateJLabel.setText("                                                                  Today's Date:");

        timeJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        timeJLabel.setText("                                                                               Time:");

        todayDateJTextField.setEditable(false);
        todayDateJTextField.setFont(new java.awt.Font("SansSerif", 0, 14));
        todayDateJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        todayDateJTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        timeJTextField.setEditable(false);
        timeJTextField.setFont(new java.awt.Font("SansSerif", 0, 14));
        timeJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        timeJTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        timeJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeJTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setText("                                                                     Cumtomers:");

        customerListJComboBox.setFont(new java.awt.Font("Tahoma", 0, 12));
        customerListJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerListJComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topJPanelLayout = new javax.swing.GroupLayout(topJPanel);
        topJPanel.setLayout(topJPanelLayout);
        topJPanelLayout.setHorizontalGroup(
            topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topJPanelLayout.createSequentialGroup()
                .addComponent(pictureJLabel)
                .addGap(6, 6, 6)
                .addGroup(topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(todayDateJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(timeJLabel)
                    .addComponent(titleJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerListJComboBox, 0, 117, Short.MAX_VALUE)
                    .addGroup(topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(timeJTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(todayDateJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
                .addContainerGap())
        );
        topJPanelLayout.setVerticalGroup(
            topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topJPanelLayout.createSequentialGroup()
                .addGroup(topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topJPanelLayout.createSequentialGroup()
                        .addGroup(topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(topJPanelLayout.createSequentialGroup()
                                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(topJPanelLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(customerListJComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(todayDateJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(todayDateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pictureJLabel))
                .addContainerGap())
        );

        leftJPanel.setBackground(new java.awt.Color(153, 153, 255));
        leftJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)), "Room Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        nightsJLabel.setFont(new java.awt.Font("SansSerif", 0, 14));
        nightsJLabel.setText("Nights:");

        nightsSpinner.setFont(new java.awt.Font("SansSerif", 0, 14));
        nightsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        nightsSpinner.setToolTipText("How long do you stay ??");
        nightsSpinner.setNextFocusableComponent(paradiseJRadioButton);

        paradiseJRadioButton.setBackground(new java.awt.Color(153, 153, 255));
        RoomInformationbuttonGroup.add(paradiseJRadioButton);
        paradiseJRadioButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        paradiseJRadioButton.setMnemonic('e');
        paradiseJRadioButton.setText("Paradise");
        paradiseJRadioButton.setToolTipText("A day $135(2 double beds, partial view)");
        paradiseJRadioButton.setNextFocusableComponent(atlantisJRadioButton);
        paradiseJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paradiseJRadioButtonActionPerformed(evt);
            }
        });

        atlantisJRadioButton.setBackground(new java.awt.Color(153, 153, 255));
        RoomInformationbuttonGroup.add(atlantisJRadioButton);
        atlantisJRadioButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        atlantisJRadioButton.setMnemonic('t');
        atlantisJRadioButton.setText("Atlantis");
        atlantisJRadioButton.setToolTipText("A day $185(2 queen beds, partial view)");
        atlantisJRadioButton.setNextFocusableComponent(orcasJRadioButton);
        atlantisJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atlantisJRadioButtonActionPerformed(evt);
            }
        });

        orcasJRadioButton.setBackground(new java.awt.Color(153, 153, 255));
        RoomInformationbuttonGroup.add(orcasJRadioButton);
        orcasJRadioButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        orcasJRadioButton.setMnemonic('O');
        orcasJRadioButton.setText("Orcas");
        orcasJRadioButton.setToolTipText("A day $235(1 king size bed, with panoramic view of ocean)");
        orcasJRadioButton.setNextFocusableComponent(discountJCheckBox);
        orcasJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orcasJRadioButtonActionPerformed(evt);
            }
        });

        discountJCheckBox.setBackground(new java.awt.Color(153, 153, 255));
        discountJCheckBox.setFont(new java.awt.Font("SansSerif", 0, 14));
        discountJCheckBox.setMnemonic('D');
        discountJCheckBox.setText("Manager's Special Discount");
        discountJCheckBox.setToolTipText("Discount 10%");
        discountJCheckBox.setNextFocusableComponent(specialMealsJTextField);
        discountJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountJCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftJPanelLayout = new javax.swing.GroupLayout(leftJPanel);
        leftJPanel.setLayout(leftJPanelLayout);
        leftJPanelLayout.setHorizontalGroup(
            leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftJPanelLayout.createSequentialGroup()
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftJPanelLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(nightsJLabel)
                        .addGap(18, 18, 18)
                        .addComponent(nightsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leftJPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(paradiseJRadioButton)
                        .addGap(27, 27, 27)
                        .addComponent(atlantisJRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(orcasJRadioButton)))
                .addContainerGap(31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(leftJPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(discountJCheckBox)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        leftJPanelLayout.setVerticalGroup(
            leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nightsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nightsJLabel))
                .addGap(18, 18, 18)
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orcasJRadioButton)
                    .addComponent(paradiseJRadioButton)
                    .addComponent(atlantisJRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(discountJCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rightJPanel.setBackground(new java.awt.Color(153, 255, 153));
        rightJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)), "Additional Charges", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        rightJPanel.setName(""); // NOI18N

        specialMealsJLabel.setDisplayedMnemonic('S');
        specialMealsJLabel.setFont(new java.awt.Font("SansSerif", 0, 14));
        specialMealsJLabel.setText("Special Meals:");

        telephoneJLabel.setDisplayedMnemonic('T');
        telephoneJLabel.setFont(new java.awt.Font("SansSerif", 0, 14));
        telephoneJLabel.setText("Telephone:");

        miscellaneousLabel.setDisplayedMnemonic('M');
        miscellaneousLabel.setFont(new java.awt.Font("SansSerif", 0, 14));
        miscellaneousLabel.setText("Miscellaneous:");

        specialMealsJTextField.setBackground(new java.awt.Color(51, 51, 51));
        specialMealsJTextField.setFont(new java.awt.Font("SansSerif", 0, 14));
        specialMealsJTextField.setForeground(new java.awt.Color(255, 255, 255));
        specialMealsJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        specialMealsJTextField.setToolTipText("Special beef, pork, and so on");
        specialMealsJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialMealsJTextFieldActionPerformed(evt);
            }
        });

        telephoneJTextField.setBackground(new java.awt.Color(51, 51, 51));
        telephoneJTextField.setFont(new java.awt.Font("SansSerif", 0, 14));
        telephoneJTextField.setForeground(new java.awt.Color(255, 255, 255));
        telephoneJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        telephoneJTextField.setToolTipText("Cellphone bill");
        telephoneJTextField.setNextFocusableComponent(miscellaneousJTextField);

        miscellaneousJTextField.setBackground(new java.awt.Color(51, 51, 51));
        miscellaneousJTextField.setFont(new java.awt.Font("SansSerif", 0, 14));
        miscellaneousJTextField.setForeground(new java.awt.Color(255, 255, 255));
        miscellaneousJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        miscellaneousJTextField.setToolTipText("Anything else");
        miscellaneousJTextField.setNextFocusableComponent(calculateJButton);
        miscellaneousJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miscellaneousJTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightJPanelLayout = new javax.swing.GroupLayout(rightJPanel);
        rightJPanel.setLayout(rightJPanelLayout);
        rightJPanelLayout.setHorizontalGroup(
            rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightJPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(telephoneJLabel)
                    .addComponent(specialMealsJLabel)
                    .addComponent(miscellaneousLabel))
                .addGap(32, 32, 32)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(miscellaneousJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(telephoneJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(specialMealsJTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addContainerGap())
        );
        rightJPanelLayout.setVerticalGroup(
            rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightJPanelLayout.createSequentialGroup()
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(specialMealsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specialMealsJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(miscellaneousJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miscellaneousLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        outJTextArea.setColumns(40);
        outJTextArea.setEditable(false);
        outJTextArea.setFont(new java.awt.Font("Monospaced", 0, 14));
        outJTextArea.setRows(5);
        displayScrollPane.setViewportView(outJTextArea);

        calculateJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        calculateJButton.setMnemonic('C');
        calculateJButton.setText("Calculate");
        calculateJButton.setToolTipText("Calculates your bills");
        calculateJButton.setNextFocusableComponent(clearJButton);
        calculateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateJButtonActionPerformed(evt);
            }
        });

        clearJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        clearJButton.setMnemonic('r');
        clearJButton.setText("Clear");
        clearJButton.setToolTipText("Makes initialization");
        clearJButton.setNextFocusableComponent(printJButton);
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });

        printJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        printJButton.setForeground(new java.awt.Color(0, 153, 204));
        printJButton.setMnemonic('P');
        printJButton.setText("Print");
        printJButton.setToolTipText("Prints your bills");
        printJButton.setNextFocusableComponent(exitJButton);
        printJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJButtonActionPerformed(evt);
            }
        });

        exitJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        exitJButton.setMnemonic('x');
        exitJButton.setText("Exit");
        exitJButton.setToolTipText("Exit");
        exitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJButtonActionPerformed(evt);
            }
        });

        saveJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        saveJButton.setMnemonic('S');
        saveJButton.setText("Save");
        saveJButton.setToolTipText("Saves the ressult as a file");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomJPanelLayout = new javax.swing.GroupLayout(bottomJPanel);
        bottomJPanel.setLayout(bottomJPanelLayout);
        bottomJPanelLayout.setHorizontalGroup(
            bottomJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomJPanelLayout.createSequentialGroup()
                .addComponent(displayScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(bottomJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(printJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(calculateJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(clearJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(saveJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                .addContainerGap())
        );
        bottomJPanelLayout.setVerticalGroup(
            bottomJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
            .addGroup(bottomJPanelLayout.createSequentialGroup()
                .addComponent(calculateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(clearJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12));
        jLabel1.setText("By DeukYeol Choe");

        Files.setMnemonic('F');
        Files.setText("File");
        menuJMenuBar.add(Files);

        Rooms.setMnemonic('R');
        Rooms.setText("Rooms");
        menuJMenuBar.add(Rooms);

        Help.setMnemonic('H');
        Help.setText("Help");
        menuJMenuBar.add(Help);

        setJMenuBar(menuJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottomJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(leftJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rightJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10))
                        .addComponent(topJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(623, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(topJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(leftJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rightJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(bottomJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: miscellaneousJTextFieldActionPerformed()
* Description: when event occurs, this will run calculateJButton
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void miscellaneousJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miscellaneousJTextFieldActionPerformed
    {//GEN-HEADEREND:event_miscellaneousJTextFieldActionPerformed
        calculateJButtonActionPerformed(evt);
    }//GEN-LAST:event_miscellaneousJTextFieldActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: exitJButtonActionPerformed()
* Description: when press this button, it will turn off the program
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitJButtonActionPerformed
    {//GEN-HEADEREND:event_exitJButtonActionPerformed
        System.exit(1);
    }//GEN-LAST:event_exitJButtonActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: calculateJButtonActionPerformed()
* Description: when press this button, it will work that check errors, call Invoice class and display method
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void calculateJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_calculateJButtonActionPerformed
    {//GEN-HEADEREND:event_calculateJButtonActionPerformed

       final double MAX_Charges = 10000.0;    // maximum fee 
       double total = 0.0;                    // sum of all services provided but not including tax
       boolean doPrint = false;               // checking printing method will do or not
       
      // select customerList from combobox(from Heading.txt)
      String name = customerListJComboBox.getSelectedItem().toString();

           try
           {  
               //Exchange text data to double data
               specialMeals= Double.parseDouble(specialMealsJTextField.getText());
               telePhone = Double.parseDouble(telephoneJTextField.getText());
               miscellAneous = Double.parseDouble(miscellaneousJTextField.getText());

               //Exchange text data to byte data
               byte nights = Byte.parseByte(nightsSpinner.getValue().toString());

               // Check RadioButton. The one must be selected out of three
               if ((!paradiseJRadioButton.isSelected() && !atlantisJRadioButton.isSelected() &&
                    !orcasJRadioButton.isSelected()))
                      throw new NumberFormatException();

               // Check bills(specialMeals,telePhone, and miscellAneous) over Maxvalue(=10000)
               if ((specialMeals > MAX_Charges) || (telePhone > MAX_Charges) || (miscellAneous > MAX_Charges))
                     throw new NumberFormatException();

               // Call InVoice second class for calculating
               InVoice myBill = new InVoice(paradiseJRadioButton.isSelected(),
               atlantisJRadioButton.isSelected(), orcasJRadioButton.isSelected(),
               discountJCheckBox.isSelected(), specialMeals, telePhone, miscellAneous, nights);

               // Calculate the total value, but that don't include tax
               total = myBill.calculateBill();

               // Clear display
               display.delete(0, display.length());

               // Display bill
               displayBill(name, total, myBill, specialMeals, telePhone, miscellAneous );
            }
            // If error raises, then this will run
            catch (NumberFormatException nume)
            {
               JOptionPane.showMessageDialog( null,
                    "FOLLOW THIS RULES!! \n"
                    + "1. Nights must be bigger than 1, and you must choose one of three room options \n"
                    + "2. Please NO negative!   No letters!   No over 10000! \n",
                    "Incorrect Data", JOptionPane.WARNING_MESSAGE );
               specialMealsJTextField.requestFocus();
               specialMealsJTextField.selectAll();
            }
    }//GEN-LAST:event_calculateJButtonActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: clearJButtonActionPerformed()
* Description: when press this button, it will remove all variables selected and input and set up basic values
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearJButtonActionPerformed
    {//GEN-HEADEREND:event_clearJButtonActionPerformed
        paradiseJRadioButton.setSelected(true);
        atlantisJRadioButton.setSelected(false);
        orcasJRadioButton.setSelected(false);
        discountJCheckBox.setSelected(false);
        specialMealsJTextField.setText("");
        telephoneJTextField.setText("");
        miscellaneousJTextField.setText("");
        outJTextArea.setText("");
        nightsSpinner.setValue(0);
        display.delete(0, display.length());
        nightsSpinner.requestFocus();
    }//GEN-LAST:event_clearJButtonActionPerformed

    private void specialMealsJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_specialMealsJTextFieldActionPerformed
    {//GEN-HEADEREND:event_specialMealsJTextFieldActionPerformed
    }//GEN-LAST:event_specialMealsJTextFieldActionPerformed

    private void timeJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_timeJTextFieldActionPerformed
    {//GEN-HEADEREND:event_timeJTextFieldActionPerformed
    }//GEN-LAST:event_timeJTextFieldActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: printJButtonActionPerformed()
* Description: when press this button, it will print out the result of the charges through PrintText class
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void printJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_printJButtonActionPerformed
    {//GEN-HEADEREND:event_printJButtonActionPerformed
       PrintText printText = new PrintText(display.toString());
       printText.startPrint();
    }//GEN-LAST:event_printJButtonActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: paradiseJRadioButtonActionPerformed()
* Description: when press this button, it will recalculate the charge
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void paradiseJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paradiseJRadioButtonActionPerformed
        if(specialMeals > 0.0)                      // It prevents error because specialMeals telePhone, and miscellAneous
            if(telePhone > 0.0)                     // are empty while we are checking radiobuttons at first
                if(miscellAneous > 0.0)             // If three data are filled by numbers, these don't create error
                    calculateJButtonActionPerformed(evt);
    }//GEN-LAST:event_paradiseJRadioButtonActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: atlantisJRadioButtonActionPerformed()
* Description: when press this button, it will recalculate the charge
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void atlantisJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atlantisJRadioButtonActionPerformed
        if(specialMeals > 0.0)                      // It prevents error because specialMeals telePhone, and miscellAneous
            if(telePhone > 0.0)                     // are empty while we are checking radiobuttons at first
                if(miscellAneous > 0.0)             // If three data are filled by numbers, these don't create error
                    calculateJButtonActionPerformed(evt);
    }//GEN-LAST:event_atlantisJRadioButtonActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: orcasJRadioButtonActionPerformed()
* Description: when press this button, it will recalculate the charge
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void orcasJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orcasJRadioButtonActionPerformed
        if(specialMeals > 0.0)                      // It prevents error because specialMeals telePhone, and miscellAneous
            if(telePhone > 0.0)                     // are empty while we are checking radiobuttons at first
                if(miscellAneous > 0.0)             // If three data are filled by numbers, these don't create error
                    calculateJButtonActionPerformed(evt);
    }//GEN-LAST:event_orcasJRadioButtonActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: discountJCheckBoxActionPerformed()
* Description: when press this button, it will recalculate the charge
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void discountJCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountJCheckBoxActionPerformed
        if(specialMeals > 0.0)                      // It prevents error because specialMeals telePhone, and miscellAneous
            if(telePhone > 0.0)                     // are empty while we are checking radiobuttons at first
                if(miscellAneous > 0.0)             // If three data are filled by numbers, these don't create error
                     calculateJButtonActionPerformed(evt);
    }//GEN-LAST:event_discountJCheckBoxActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: saveJButtonActionPerformed()
* Description: when press this button, it will save the charge as a file
* @return: void
* @param: evt
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveJButtonActionPerformed
    {//GEN-HEADEREND:event_saveJButtonActionPerformed
        try
	{
		FileWriter fwriter = new FileWriter("saveFile.doc");    // creates saveFile.txt
		PrintWriter outputFile = new PrintWriter(fwriter);

		outputFile.println(display.toString());                // Input display values to saveFile.txt
                outputFile.close();
	}

	catch(IOException e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_saveJButtonActionPerformed

    private void customerListJComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_customerListJComboBoxActionPerformed
    {//GEN-HEADEREND:event_customerListJComboBoxActionPerformed
        
    }//GEN-LAST:event_customerListJComboBoxActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: displayBill()
* Description: when call this method, it will make the display of the charge of the result
* @return: void
* @param: name, sum, bill, speicialMeals. telePhone, miscellaneous
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void displayBill(String name, double sum, InVoice bill, double specialMeals, double telePhone, double miscellAneous)
    {
        display.append(padSpaces("Customer:", name  + '\n'));
        //display.append('\n');
        display.append(padSpaces("Items","Charges"+ '\n'));
        display.append(padSpaces("~~~~~","~~~~~~~"+ '\n'));

        if (paradiseJRadioButton.isSelected())
        {
            if(discountJCheckBox.isSelected())
                display.append(padSpaces("Room Charges:", dollars.format(bill.paradiseCost)  + '\n'));
            else
                display.append(padSpaces("Room Charges:", dollars.format(bill.paradiseCost)  + '\n'));
        }
        if (atlantisJRadioButton.isSelected())
        {
            if(discountJCheckBox.isSelected())
                display.append(padSpaces("Room Charges:", dollars.format(bill.atlantiseCost)  + '\n'));
            else
                display.append(padSpaces("Room Charges:", dollars.format(bill.atlantiseCost)  + '\n'));
        }
        if (orcasJRadioButton.isSelected())
        {
            if(discountJCheckBox.isSelected())
                display.append(padSpaces("Room Charges:", dollars.format(bill.orcasCost)  + '\n'));
            else
                display.append(padSpaces("Room Charges:", dollars.format(bill.orcasCost)  + '\n'));
        }
        if (specialMeals > 0.0)
            display.append(padSpaces("Special Meals Charges:", dollars.format(specialMeals)  + '\n'));
        if (telePhone > 0.0)
            display.append(padSpaces("Telephone:", dollars.format(telePhone)  + '\n'));
        if (miscellAneous > 0.0)
            display.append(padSpaces("Miscelaneous Charges:", dollars.format(miscellAneous)  + '\n'));

        display.append(padSpaces("Subtotal:", dollars.format(sum)  + '\n'));
        display.append(padSpaces("Tax:", dollars.format(bill.taxBill())  + '\n'));
        display.append(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + '\n');
        display.append(padSpaces("Total Charges:", dollars.format(bill.totalCharges())+ '\n'));
        outJTextArea.setText(display.toString());
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: padSpaces()
* Description: A method to add spaces between the two String arguments in order
* @return: spaces--a StringBuffer composed of first + spaces + second
* @param: first, second
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private StringBuffer padSpaces(String first, String second)
    {
       final int MAX_SPACES = 46;
       final int LEFT_SPACES = 30;
       StringBuffer spaces = new StringBuffer();

       //find number of spaces needed to pad the string

       int leftSpaces = LEFT_SPACES - first.length();
       for (int i = 0; i < leftSpaces; i++)
           spaces.append(" ");
      spaces.append(first);

      int midSpaces = MAX_SPACES - leftSpaces - first.length() - second.length();
      for (int i = 0; i < midSpaces ; i++)
           spaces.append(" ");
      spaces.append(second);

      int rightSpaces = MAX_SPACES - leftSpaces - midSpaces - first.length() - second.length();
      for (int i = 0; i < rightSpaces ; i++)
            spaces.append(" ");
      
       return spaces;
    }

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
* Method: main()
* Description: when this program is ran, the display is located the center of a screen
* @return: void
* @param: arges[]
* @author: DeukYeol Choe
* Date: 2/16/2011
*<pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OrcasGUI orcas = new OrcasGUI();
                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screen.width - orcas.getWidth())/2;
                int y = (screen.height - orcas.getHeight())/2;
                orcas.setBounds(x,y,orcas.getWidth(),orcas.getHeight());
                orcas.setVisible(true);
                orcas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Files;
    private javax.swing.JMenu Help;
    private javax.swing.ButtonGroup RoomInformationbuttonGroup;
    private javax.swing.JMenu Rooms;
    private javax.swing.JRadioButton atlantisJRadioButton;
    private javax.swing.JPanel bottomJPanel;
    private javax.swing.JButton calculateJButton;
    private javax.swing.JButton clearJButton;
    private javax.swing.JComboBox customerListJComboBox;
    private javax.swing.JCheckBox discountJCheckBox;
    private javax.swing.JScrollPane displayScrollPane;
    private javax.swing.JButton exitJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel leftJPanel;
    private javax.swing.JMenuBar menuJMenuBar;
    private javax.swing.JTextField miscellaneousJTextField;
    private javax.swing.JLabel miscellaneousLabel;
    private javax.swing.JLabel nightsJLabel;
    private javax.swing.JSpinner nightsSpinner;
    private javax.swing.JRadioButton orcasJRadioButton;
    private javax.swing.JTextArea outJTextArea;
    private javax.swing.JRadioButton paradiseJRadioButton;
    private javax.swing.JLabel pictureJLabel;
    private javax.swing.JButton printJButton;
    private javax.swing.JPanel rightJPanel;
    private javax.swing.JButton saveJButton;
    private javax.swing.JLabel specialMealsJLabel;
    private javax.swing.JTextField specialMealsJTextField;
    private javax.swing.JLabel telephoneJLabel;
    private javax.swing.JTextField telephoneJTextField;
    private javax.swing.JLabel timeJLabel;
    private javax.swing.JTextField timeJTextField;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JLabel todayDateJLabel;
    private javax.swing.JTextField todayDateJTextField;
    private javax.swing.JPanel topJPanel;
    // End of variables declaration//GEN-END:variables

}
