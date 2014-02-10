
package Veterinarians;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class EdVetsGUI extends javax.swing.JFrame {

    private StringBuilder display = new StringBuilder("");
    DecimalFormat dollars = new DecimalFormat("$##,##0.00");
    String fileName = "src/Animals.txt";
    PrintWriter outputStream = null;

    private int petTypeIndex = 0;
    private String currentDate;
    private String currentTime;
    private double totalCharges;
    private double other = 0.0;
    
    /** Creates new form EdVetsGUI */
    public EdVetsGUI() {
        initComponents();
        this.getRootPane().setDefaultButton(displayBillJButton);
        this.setLocationRelativeTo(null);
              // File name
        String petType = "";

        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icon.png"));

        readFromFile(fileName);
        setDate();
    }

        /**
     * Method: readFromFile
     * Reads students from a text file that is comma delimited and
     * creates an instance of the student class with the data read.
     * Uses an object from the ReadFile class to read record.
     * @parem file: String
     * @return void
     * pre-condition: a valid file name, student.txt is expected
     * for input with comma separated text fields (but no spaces) for
     * student first name, last name,and SID
     * post-condition: a new "Student students" is created with the read fields
     * and added to the ArrayList student
     * @see ReadFile
     * @see Member
     */
     private void readFromFile(String file)
     {
        ReadFile rf = new ReadFile(file);
        String input = rf.readRecord();

        // Read while there is data
        while(input != null)
        {
            petTypeJComboBox.addItem(input);
            input = rf.readRecord();
        }
        rf.close();
        petTypeJComboBox.requestFocus();
     }

    private void setDate()
    {
        DateFormat dateFormatDate = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat dateFormatTime = new SimpleDateFormat("hh:mm:ss");
        java.util.Date date = new java.util.Date();
        currentDate = dateFormatDate.format(date);
        currentTime = dateFormatTime.format(date);
    }

    private void setLabel(JLabel mainPictureJLabel)
    {
        petTypeIndex = petTypeJComboBox.getSelectedIndex();
        String callPetPicture = "";

        switch(petTypeIndex)
        {
            case 0:
                callPetPicture = "src/symbol.png";
                mainPictureJLabel.setIcon(new ImageIcon(callPetPicture));
                break;
            case 1:
                callPetPicture = "images/dog.png";
                mainPictureJLabel.setIcon(new ImageIcon(callPetPicture));
                break;
            case 2:
                callPetPicture = "images/cat.png";
                mainPictureJLabel.setIcon(new ImageIcon(callPetPicture));
                break;
            case 3:
                callPetPicture = "images/bird.png";
                mainPictureJLabel.setIcon(new ImageIcon(callPetPicture));
                break;
            case 4:
                callPetPicture = "images/snake.png";
                mainPictureJLabel.setIcon(new ImageIcon(callPetPicture));
                break;
            case 5:
                callPetPicture = "images/lizard.png";
                mainPictureJLabel.setIcon(new ImageIcon(callPetPicture));
                break;
            case 6:
                callPetPicture = "images/fish.png";
                mainPictureJLabel.setIcon(new ImageIcon(callPetPicture));
                break;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainJPanel = new javax.swing.JPanel();
        topJPanel = new javax.swing.JPanel();
        pictureJLabel = new javax.swing.JLabel();
        serviceJPanel = new javax.swing.JPanel();
        TCJCheckBox = new javax.swing.JCheckBox();
        RBJCheckBox = new javax.swing.JCheckBox();
        OSJCheckBox = new javax.swing.JCheckBox();
        HWJCheckBox = new javax.swing.JCheckBox();
        FCJCheckBox = new javax.swing.JCheckBox();
        FTJCheckBox = new javax.swing.JCheckBox();
        OVJCheckBox = new javax.swing.JCheckBox();
        OTJCheckBox = new javax.swing.JCheckBox();
        addressJPanel = new javax.swing.JPanel();
        logoJLabel4 = new javax.swing.JLabel();
        logoJLabel3 = new javax.swing.JLabel();
        logoJLabel2 = new javax.swing.JLabel();
        logoJLabel1 = new javax.swing.JLabel();
        logoJLabel5 = new javax.swing.JLabel();
        centerJPanel = new javax.swing.JPanel();
        firstNameJLabel = new javax.swing.JLabel();
        firstNameJTextField = new javax.swing.JTextField();
        lastNameJLabel = new javax.swing.JLabel();
        lastNameJTextField = new javax.swing.JTextField();
        petNameJLabel = new javax.swing.JLabel();
        petNameJTextField = new javax.swing.JTextField();
        petTypeJLabel = new javax.swing.JLabel();
        petTypeJComboBox = new javax.swing.JComboBox();
        addressJLabel = new javax.swing.JLabel();
        addressJTextField = new javax.swing.JTextField();
        cityJLabel = new javax.swing.JLabel();
        cityJTextField = new javax.swing.JTextField();
        zipJLabel = new javax.swing.JLabel();
        phoneJLabel = new javax.swing.JLabel();
        zipJFormattedTextField = new javax.swing.JFormattedTextField();
        phoneJFormattedTextField = new javax.swing.JFormattedTextField();
        displayJScrollPane = new javax.swing.JScrollPane();
        displayJTextArea = new javax.swing.JTextArea();
        bottomJPanel = new javax.swing.JPanel();
        saveJButton = new javax.swing.JButton();
        displayBillJButton = new javax.swing.JButton();
        clearJButton = new javax.swing.JButton();
        printInvoiceJButton = new javax.swing.JButton();
        quitJButton = new javax.swing.JButton();
        openFileJPanel = new javax.swing.JPanel();
        textForOpenfileJLabel = new javax.swing.JLabel();
        openJButton = new javax.swing.JButton();
        totalAmountDisplayJTextField = new javax.swing.JTextField();
        totalAmountJTextField = new javax.swing.JTextField();
        JMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        openJMenuItem = new javax.swing.JMenuItem();
        saveJMenu = new javax.swing.JMenu();
        saveForCustomerJMenuItem = new javax.swing.JMenuItem();
        saveAllofInformationJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        exitJMenuItem = new javax.swing.JMenuItem();
        invoiceJMenu = new javax.swing.JMenu();
        displayInvoiceJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edmonds Veterinarians");
        setResizable(false);

        mainJPanel.setBackground(new java.awt.Color(255, 255, 255));

        topJPanel.setBackground(new java.awt.Color(255, 255, 255));

        pictureJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/symbol.png"))); // NOI18N

        serviceJPanel.setBackground(new java.awt.Color(255, 255, 255));
        serviceJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Services", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13))); // NOI18N

        TCJCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        TCJCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14));
        TCJCheckBox.setText("TC");
        TCJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TCJCheckBoxActionPerformed(evt);
            }
        });

        RBJCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        RBJCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14));
        RBJCheckBox.setText("RB");
        RBJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBJCheckBoxActionPerformed(evt);
            }
        });

        OSJCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        OSJCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14));
        OSJCheckBox.setText("OS");
        OSJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OSJCheckBoxActionPerformed(evt);
            }
        });

        HWJCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        HWJCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14));
        HWJCheckBox.setText("HW");
        HWJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HWJCheckBoxActionPerformed(evt);
            }
        });

        FCJCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        FCJCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14));
        FCJCheckBox.setText("FC");
        FCJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FCJCheckBoxActionPerformed(evt);
            }
        });

        FTJCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        FTJCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14));
        FTJCheckBox.setText("FT");
        FTJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FTJCheckBoxActionPerformed(evt);
            }
        });

        OVJCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        OVJCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14));
        OVJCheckBox.setText("OV");
        OVJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OVJCheckBoxActionPerformed(evt);
            }
        });

        OTJCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        OTJCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14));
        OTJCheckBox.setText("OT");
        OTJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OTJCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout serviceJPanelLayout = new javax.swing.GroupLayout(serviceJPanel);
        serviceJPanel.setLayout(serviceJPanelLayout);
        serviceJPanelLayout.setHorizontalGroup(
            serviceJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviceJPanelLayout.createSequentialGroup()
                .addGroup(serviceJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(serviceJPanelLayout.createSequentialGroup()
                        .addComponent(TCJCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RBJCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OSJCheckBox))
                    .addGroup(serviceJPanelLayout.createSequentialGroup()
                        .addComponent(FCJCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FTJCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OVJCheckBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(serviceJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HWJCheckBox)
                    .addComponent(OTJCheckBox)))
        );
        serviceJPanelLayout.setVerticalGroup(
            serviceJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviceJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(serviceJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TCJCheckBox)
                    .addComponent(RBJCheckBox)
                    .addComponent(OSJCheckBox)
                    .addComponent(HWJCheckBox))
                .addGap(18, 18, 18)
                .addGroup(serviceJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FCJCheckBox)
                    .addComponent(FTJCheckBox)
                    .addComponent(OVJCheckBox)
                    .addComponent(OTJCheckBox)))
        );

        addressJPanel.setBackground(new java.awt.Color(255, 255, 255));

        logoJLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 13));
        logoJLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoJLabel4.setText("(425) 998-6673");

        logoJLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 13));
        logoJLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoJLabel3.setText("Edmonds, WA 98026");

        logoJLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 13));
        logoJLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoJLabel2.setText("669 Dogfish Land");

        logoJLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 15));
        logoJLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoJLabel1.setText("Edmonds Veterinarians");

        logoJLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 13));
        logoJLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoJLabel5.setText("Dray & Khoa");

        javax.swing.GroupLayout addressJPanelLayout = new javax.swing.GroupLayout(addressJPanel);
        addressJPanel.setLayout(addressJPanelLayout);
        addressJPanelLayout.setHorizontalGroup(
            addressJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addressJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addressJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoJLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(logoJLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(logoJLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(logoJLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addContainerGap())
        );
        addressJPanelLayout.setVerticalGroup(
            addressJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addressJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoJLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoJLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoJLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout topJPanelLayout = new javax.swing.GroupLayout(topJPanel);
        topJPanel.setLayout(topJPanelLayout);
        topJPanelLayout.setHorizontalGroup(
            topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topJPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pictureJLabel)
                .addGap(28, 28, 28)
                .addComponent(addressJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(serviceJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        topJPanelLayout.setVerticalGroup(
            topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topJPanelLayout.createSequentialGroup()
                .addGroup(topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topJPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(serviceJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(topJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pictureJLabel, 0, 0, Short.MAX_VALUE)
                            .addComponent(addressJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        centerJPanel.setBackground(new java.awt.Color(255, 255, 255));

        firstNameJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        firstNameJLabel.setText("First Name:");

        firstNameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14));

        lastNameJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        lastNameJLabel.setText("Last Name:");

        lastNameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14));

        petNameJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        petNameJLabel.setText("Pet Name:");

        petNameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14));

        petTypeJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        petTypeJLabel.setText("Pet Type:");

        petTypeJComboBox.setFont(new java.awt.Font("Tahoma", 1, 14));
        petTypeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petTypeJComboBoxActionPerformed(evt);
            }
        });

        addressJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        addressJLabel.setText("Address:");

        addressJTextField.setFont(new java.awt.Font("Tahoma", 1, 14));

        cityJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        cityJLabel.setText("City:");

        cityJTextField.setFont(new java.awt.Font("Tahoma", 1, 14));

        zipJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        zipJLabel.setText("Zip Code:");

        phoneJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        phoneJLabel.setText("Phone Number:");

        try {
            zipJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        zipJFormattedTextField.setFont(new java.awt.Font("Tahoma", 1, 14));

        try {
            phoneJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###)  ### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        phoneJFormattedTextField.setFont(new java.awt.Font("Tahoma", 1, 14));

        javax.swing.GroupLayout centerJPanelLayout = new javax.swing.GroupLayout(centerJPanel);
        centerJPanel.setLayout(centerJPanelLayout);
        centerJPanelLayout.setHorizontalGroup(
            centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(firstNameJLabel)
                    .addComponent(addressJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cityJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(zipJFormattedTextField)
                    .addComponent(petNameJLabel)
                    .addComponent(zipJLabel)
                    .addComponent(petNameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addGroup(centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centerJPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(petTypeJLabel))
                    .addGroup(centerJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(phoneJFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(petTypeJComboBox, 0, 152, Short.MAX_VALUE))))
                .addContainerGap())
        );
        centerJPanelLayout.setVerticalGroup(
            centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lastNameJLabel)
                        .addComponent(petNameJLabel)
                        .addComponent(petTypeJLabel))
                    .addGroup(centerJPanelLayout.createSequentialGroup()
                        .addComponent(firstNameJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(petNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(petTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centerJPanelLayout.createSequentialGroup()
                        .addGroup(centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cityJLabel)
                                .addComponent(zipJLabel))
                            .addComponent(phoneJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(centerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zipJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(centerJPanelLayout.createSequentialGroup()
                        .addComponent(addressJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        displayJTextArea.setBackground(new java.awt.Color(204, 255, 204));
        displayJTextArea.setColumns(20);
        displayJTextArea.setEditable(false);
        displayJTextArea.setFont(new java.awt.Font("Monospaced", 1, 14));
        displayJTextArea.setRows(5);
        displayJScrollPane.setViewportView(displayJTextArea);

        bottomJPanel.setBackground(new java.awt.Color(255, 255, 255));
        bottomJPanel.setLayout(new java.awt.GridLayout(1, 5, 10, 10));

        saveJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveJButton.setMnemonic('S');
        saveJButton.setText("Save");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });
        bottomJPanel.add(saveJButton);

        displayBillJButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        displayBillJButton.setMnemonic('D');
        displayBillJButton.setText("Display Bill");
        displayBillJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBillJButtonActionPerformed(evt);
            }
        });
        bottomJPanel.add(displayBillJButton);

        clearJButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        clearJButton.setMnemonic('C');
        clearJButton.setText("Clear");
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });
        bottomJPanel.add(clearJButton);

        printInvoiceJButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        printInvoiceJButton.setMnemonic('P');
        printInvoiceJButton.setText("Print Invoice");
        printInvoiceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printInvoiceJButtonActionPerformed(evt);
            }
        });
        bottomJPanel.add(printInvoiceJButton);

        quitJButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        quitJButton.setMnemonic('Q');
        quitJButton.setText("Quit");
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });
        bottomJPanel.add(quitJButton);

        openFileJPanel.setBackground(new java.awt.Color(255, 255, 255));

        textForOpenfileJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        textForOpenfileJLabel.setText("Customers List");

        openJButton.setFont(new java.awt.Font("Tahoma", 0, 14));
        openJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Open Button Icon.jpg"))); // NOI18N
        openJButton.setMnemonic('O');
        openJButton.setToolTipText("Open movie lists from seperate files");
        openJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout openFileJPanelLayout = new javax.swing.GroupLayout(openFileJPanel);
        openFileJPanel.setLayout(openFileJPanelLayout);
        openFileJPanelLayout.setHorizontalGroup(
            openFileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, openFileJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textForOpenfileJLabel)
                .addContainerGap())
            .addGroup(openFileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(openFileJPanelLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(openJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );
        openFileJPanelLayout.setVerticalGroup(
            openFileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(openFileJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textForOpenfileJLabel)
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(openFileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(openFileJPanelLayout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(openJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, Short.MAX_VALUE)
                    .addGap(48, 48, 48)))
        );

        totalAmountDisplayJTextField.setEditable(false);
        totalAmountDisplayJTextField.setFont(new java.awt.Font("Tahoma", 1, 36));
        totalAmountDisplayJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalAmountDisplayJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmountDisplayJTextFieldActionPerformed(evt);
            }
        });

        totalAmountJTextField.setEditable(false);
        totalAmountJTextField.setFont(new java.awt.Font("Tahoma", 1, 14));
        totalAmountJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalAmountJTextField.setText("Total Cost");
        totalAmountJTextField.setBorder(null);
        totalAmountJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmountJTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainJPanelLayout = new javax.swing.GroupLayout(mainJPanel);
        mainJPanel.setLayout(mainJPanelLayout);
        mainJPanelLayout.setHorizontalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottomJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainJPanelLayout.createSequentialGroup()
                        .addComponent(displayJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalAmountDisplayJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainJPanelLayout.createSequentialGroup()
                                .addComponent(totalAmountJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))))
                    .addComponent(topJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addComponent(openFileJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(centerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainJPanelLayout.setVerticalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainJPanelLayout.createSequentialGroup()
                .addComponent(topJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(openFileJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(centerJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(totalAmountJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(totalAmountDisplayJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
        );

        JMenuBar.setFont(new java.awt.Font("Segoe UI", 0, 14));

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");
        fileJMenu.setFont(new java.awt.Font("Segoe UI", 0, 14));

        openJMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 14));
        openJMenuItem.setMnemonic('O');
        openJMenuItem.setText("Open");
        openJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(openJMenuItem);

        saveJMenu.setMnemonic('S');
        saveJMenu.setText("Save");
        saveJMenu.setFont(new java.awt.Font("Segoe UI", 0, 14));

        saveForCustomerJMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 14));
        saveForCustomerJMenuItem.setMnemonic('C');
        saveForCustomerJMenuItem.setText("Only Customer Info");
        saveForCustomerJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveForCustomerJMenuItemActionPerformed(evt);
            }
        });
        saveJMenu.add(saveForCustomerJMenuItem);

        saveAllofInformationJMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 14));
        saveAllofInformationJMenuItem.setMnemonic('A');
        saveAllofInformationJMenuItem.setText("All of Infomations");
        saveAllofInformationJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAllofInformationJMenuItemActionPerformed(evt);
            }
        });
        saveJMenu.add(saveAllofInformationJMenuItem);

        fileJMenu.add(saveJMenu);

        printJMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 14));
        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        exitJMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 14));
        exitJMenuItem.setMnemonic('E');
        exitJMenuItem.setText("Exit");
        exitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(exitJMenuItem);

        JMenuBar.add(fileJMenu);

        invoiceJMenu.setMnemonic('I');
        invoiceJMenu.setText("Invoice");
        invoiceJMenu.setFont(new java.awt.Font("Segoe UI", 0, 14));

        displayInvoiceJMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 14));
        displayInvoiceJMenuItem.setMnemonic('D');
        displayInvoiceJMenuItem.setText("Display Invoice");
        displayInvoiceJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayInvoiceJMenuItemActionPerformed(evt);
            }
        });
        invoiceJMenu.add(displayInvoiceJMenuItem);

        JMenuBar.add(invoiceJMenu);

        helpJMenu.setMnemonic('H');
        helpJMenu.setText("Help");
        helpJMenu.setFont(new java.awt.Font("Segoe UI", 0, 14));

        aboutJMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 14));
        aboutJMenuItem.setMnemonic('A');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        JMenuBar.add(helpJMenu);

        setJMenuBar(JMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayBillJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_displayBillJButtonActionPerformed
    {//GEN-HEADEREND:event_displayBillJButtonActionPerformed
        try
        {
            
            Invoice myBill = new Invoice(TCJCheckBox.isSelected(), RBJCheckBox.isSelected(),
                    OSJCheckBox.isSelected(),HWJCheckBox.isSelected(),FCJCheckBox.isSelected(),
                    FTJCheckBox.isSelected(),OVJCheckBox.isSelected(), OTJCheckBox.isSelected(), other);

            Person myCustomer = new Person(firstNameJTextField.getText(),
                    lastNameJTextField.getText(),phoneJFormattedTextField.getText());

            myBill.calculateBill();
            totalCharges = myBill.totalBill();

            display.delete(0, display.length());
            displayBill(myBill, myBill.displayService(), totalCharges, myCustomer);
        }

        catch(BadInputException e)
        {
            throw new BadInputException();
        }
    }//GEN-LAST:event_displayBillJButtonActionPerformed

    public void displayBill(Invoice bill, String displayService, double totalAmount, Person myCustomer)
    {
        String totalAmountString =  Double.toString(totalAmount);
        display.append(" " +currentDate + "  " + currentTime + '\n');
        display.append(" Customer: " + myCustomer.getFirstName() + " " + myCustomer.getLastName()+ '\n');
        display.append(padSpaces(" Code", "Procedures", "Fee "));
        display.append("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + '\n');
        display.append(displayService);
        display.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + '\n');
        display.append(padSpaces(" Tax", "" , dollars.format(bill.taxBill()) + '\n'));
        display.append(padSpaces(" Total", "" , dollars.format(totalAmount) + '\n'));

        displayJTextArea.setText(display.toString());
        totalAmountDisplayJTextField.setText(dollars.format(totalAmount));
    }

    private StringBuffer padSpaces(String first, String second, String third)
    {
       final int MAX_SPACES = 52;
       final int SECOND_SPACES = 11;
       StringBuffer spaces = new StringBuffer();

       //find number of spaces needed to pad the string

      spaces.append(first);

      int midSpaces = SECOND_SPACES - first.length();
      System.out.println(midSpaces);
      for (int i = 0; i < midSpaces ; i++)
           spaces.append(" ");
      spaces.append(second);

      int rightSpaces = MAX_SPACES - SECOND_SPACES - second.length() - third.length();
      for (int i = 0; i < rightSpaces ; i++)
        spaces.append(" ");
      spaces.append(third);

       return spaces;
    }

    private void petTypeJComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_petTypeJComboBoxActionPerformed
    {//GEN-HEADEREND:event_petTypeJComboBoxActionPerformed
        setLabel(pictureJLabel);

        Animal animalObject = new Pet(petTypeJComboBox.getSelectedItem().toString());

        if (petTypeJComboBox.getSelectedItem().toString().equals(""))
        {
            TCJCheckBox.setEnabled(true);
            RBJCheckBox.setEnabled(true);
            OSJCheckBox.setEnabled(true);
            HWJCheckBox.setEnabled(true);
            FCJCheckBox.setEnabled(true);
            FTJCheckBox.setEnabled(true);
            OVJCheckBox.setEnabled(true);
        }
        if (petTypeJComboBox.getSelectedItem().toString().equals("Dog"))
        {
            TCJCheckBox.setEnabled(animalObject.needTeeth());
            RBJCheckBox.setEnabled(animalObject.needRabies());
            FTJCheckBox.setEnabled(animalObject.needFleas());
        }
        if (petTypeJComboBox.getSelectedItem().toString().equals("Cat"))
        {
            if(RBJCheckBox.isSelected())
                RBJCheckBox.setSelected(false);
            TCJCheckBox.setEnabled(animalObject.needTeeth());
            RBJCheckBox.setEnabled(animalObject.needRabies());
            FTJCheckBox.setEnabled(animalObject.needFleas());
        }
        if (petTypeJComboBox.getSelectedItem().toString().equals("Bird"))
        {
            if(RBJCheckBox.isSelected())
                RBJCheckBox.setSelected(false);
            if(TCJCheckBox.isSelected())
                TCJCheckBox.setSelected(false);
            TCJCheckBox.setEnabled(animalObject.needTeeth());
            RBJCheckBox.setEnabled(animalObject.needRabies());
            FTJCheckBox.setEnabled(animalObject.needFleas());
        }
        if (petTypeJComboBox.getSelectedItem().toString().equals("Snake"))
        {
            if(RBJCheckBox.isSelected())
                RBJCheckBox.setSelected(false);
            if(FTJCheckBox.isSelected())
                FTJCheckBox.setSelected(false);
            TCJCheckBox.setEnabled(animalObject.needTeeth());
            RBJCheckBox.setEnabled(animalObject.needRabies());
            FTJCheckBox.setEnabled(animalObject.needFleas());
        }
        if (petTypeJComboBox.getSelectedItem().toString().equals("Lizrd"))
        {
            if(RBJCheckBox.isSelected())
                RBJCheckBox.setSelected(false);
            if(FTJCheckBox.isSelected())
                FTJCheckBox.setSelected(false);
            TCJCheckBox.setEnabled(animalObject.needTeeth());
            RBJCheckBox.setEnabled(animalObject.needRabies());
            FTJCheckBox.setEnabled(animalObject.needFleas());
        }
        if (petTypeJComboBox.getSelectedItem().toString().equals("Fish"))
        {
            if(RBJCheckBox.isSelected())
                RBJCheckBox.setSelected(false);
            if(FTJCheckBox.isSelected())
                FTJCheckBox.setSelected(false);
            if(TCJCheckBox.isSelected())
                TCJCheckBox.setSelected(false);
            TCJCheckBox.setEnabled(animalObject.needTeeth());
            RBJCheckBox.setEnabled(animalObject.needRabies());
            FTJCheckBox.setEnabled(animalObject.needFleas());
        }

    }//GEN-LAST:event_petTypeJComboBoxActionPerformed

    private void totalAmountDisplayJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_totalAmountDisplayJTextFieldActionPerformed
    {//GEN-HEADEREND:event_totalAmountDisplayJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmountDisplayJTextFieldActionPerformed

    private void totalAmountJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_totalAmountJTextFieldActionPerformed
    {//GEN-HEADEREND:event_totalAmountJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmountJTextFieldActionPerformed

    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitJButtonActionPerformed
    {//GEN-HEADEREND:event_quitJButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitJButtonActionPerformed

    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_aboutJMenuItemActionPerformed
    {//GEN-HEADEREND:event_aboutJMenuItemActionPerformed
        AboutForm infoWindow = new AboutForm();
        infoWindow.setLocationRelativeTo(null);
        infoWindow.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed

    private void TCJCheckBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_TCJCheckBoxActionPerformed
    {//GEN-HEADEREND:event_TCJCheckBoxActionPerformed
        if(!totalAmountDisplayJTextField.getText().equals(""))
            displayBillJButtonActionPerformed(evt);
    }//GEN-LAST:event_TCJCheckBoxActionPerformed

    private void RBJCheckBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RBJCheckBoxActionPerformed
    {//GEN-HEADEREND:event_RBJCheckBoxActionPerformed
         if(!totalAmountDisplayJTextField.getText().equals(""))
            displayBillJButtonActionPerformed(evt);
    }//GEN-LAST:event_RBJCheckBoxActionPerformed

    private void OSJCheckBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_OSJCheckBoxActionPerformed
    {//GEN-HEADEREND:event_OSJCheckBoxActionPerformed
         if(!totalAmountDisplayJTextField.getText().equals(""))
            displayBillJButtonActionPerformed(evt);
    }//GEN-LAST:event_OSJCheckBoxActionPerformed

    private void HWJCheckBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_HWJCheckBoxActionPerformed
    {//GEN-HEADEREND:event_HWJCheckBoxActionPerformed
         if(!totalAmountDisplayJTextField.getText().equals(""))
            displayBillJButtonActionPerformed(evt);
    }//GEN-LAST:event_HWJCheckBoxActionPerformed

    private void FCJCheckBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_FCJCheckBoxActionPerformed
    {//GEN-HEADEREND:event_FCJCheckBoxActionPerformed
         if(!totalAmountDisplayJTextField.getText().equals(""))
            displayBillJButtonActionPerformed(evt);
    }//GEN-LAST:event_FCJCheckBoxActionPerformed

    private void FTJCheckBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_FTJCheckBoxActionPerformed
    {//GEN-HEADEREND:event_FTJCheckBoxActionPerformed
         if(!totalAmountDisplayJTextField.getText().equals(""))
            displayBillJButtonActionPerformed(evt);
    }//GEN-LAST:event_FTJCheckBoxActionPerformed

    private void OVJCheckBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_OVJCheckBoxActionPerformed
    {//GEN-HEADEREND:event_OVJCheckBoxActionPerformed
         if(!totalAmountDisplayJTextField.getText().equals(""))
            displayBillJButtonActionPerformed(evt);
    }//GEN-LAST:event_OVJCheckBoxActionPerformed

    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveJButtonActionPerformed
    {//GEN-HEADEREND:event_saveJButtonActionPerformed
        try
	{
		FileWriter fwriter = new FileWriter("src/Invoices/"+ lastNameJTextField.getText()+ "'s Invoice.doc");    // creates saveFile.txt
		PrintWriter outputFile = new PrintWriter(fwriter);

                StringBuilder output = new StringBuilder(" Customer: " + firstNameJTextField.getText() + " " + lastNameJTextField.getText() + "\n"
                        + " PetName: " + petNameJTextField.getText() + "\n"
                        + " PetType: " + petTypeJComboBox.getSelectedItem().toString() + "\n"
                        + " Address: " + addressJTextField.getText() + "\n"
                        + " City: " + cityJTextField.getText() + "\n"
                        + " ZipCode: " + zipJFormattedTextField.getText() + "\n"
                        + " PhoneNumber: " + phoneJFormattedTextField.getText() + "\n");
                outputFile.println(output);
		outputFile.println(display.toString());                // Input display values to saveFile.txt
                outputFile.close();
	}

	catch(IOException e)
	{
		e.printStackTrace();
	}
        
    }//GEN-LAST:event_saveJButtonActionPerformed

    private void openJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openJButtonActionPerformed
    {//GEN-HEADEREND:event_openJButtonActionPerformed
        // Open the customer file
        String customer;
        //movieListJComboBox.removeAllItems();

        JFileChooser fileChooser = new JFileChooser("src/Customers/");
        fileChooser.setFileFilter(new FileFilter()
        {
            public boolean accept(File f)
            {
                return f.isDirectory() || f.getName().endsWith(".txt");
            }
            public String getDescription()
            {
                return "text files (*.txt)";
            }
        });

        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = fileChooser.getSelectedFile();
            try
            {

                ReadFile rf = new ReadFile(file.toString());
                String input = rf.readRecord();

                // Read while there is data
                while(input != null)
                {
                    String[] temp = input.split(",");

                    Person person = new Person(temp[0],temp[1], temp[7]);
                    person.getAddressObject = new Address(temp[4], temp[5],temp[6]);
                    person.getPetObject = new Pet(temp[2],temp[3]);

                    firstNameJTextField.setText(person.getFirstName());
                    lastNameJTextField.setText(person.getLastName());
                    phoneJFormattedTextField.setText(person.getPhoneNumber());
                    addressJTextField.setText(person.getAddressObject.getAddress());
                    zipJFormattedTextField.setText(person.getAddressObject.getZipCode());
                    cityJTextField.setText(person.getAddressObject.getCity());
                    petNameJTextField.setText(person.getPetObject.getPetName());

                    if (person.getPetObject.getPetType().equals("Dog"))
                        petTypeJComboBox.setSelectedIndex(1);

                    else if(person.getPetObject.getPetType().equals("Cat"))
                        petTypeJComboBox.setSelectedIndex(2);

                    else if (person.getPetObject.getPetType().equals("Bird"))
                        petTypeJComboBox.setSelectedIndex(3);

                    else if (person.getPetObject.getPetType().equals("Snake"))
                        petTypeJComboBox.setSelectedIndex(4);

                    else if (person.getPetObject.getPetType().equals("Lizard"))
                        petTypeJComboBox.setSelectedIndex(5);

                    else if (person.getPetObject.getPetType().equals("Fish"))
                        petTypeJComboBox.setSelectedIndex(6);

                    else petTypeJComboBox.setSelectedIndex(0);

                    input = rf.readRecord();

                    rf.close();
                }
            }
            catch (Exception ex)
            {
                System.out.println("problem accessing file: "+file.getAbsolutePath());
            }
        }
        else
        {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_openJButtonActionPerformed

    private void OTJCheckBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_OTJCheckBoxActionPerformed
    {//GEN-HEADEREND:event_OTJCheckBoxActionPerformed
        try
        {
            if (OTJCheckBox.isSelected())
                    other = Double.parseDouble(JOptionPane.showInputDialog("Enter other amount: "));
                else
                    other = 0.0;
            displayBillJButtonActionPerformed(evt);
        }
        catch(Exception e)
        {
            OTJCheckBox.setSelected(false);
        }
    }//GEN-LAST:event_OTJCheckBoxActionPerformed

    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearJButtonActionPerformed
    {//GEN-HEADEREND:event_clearJButtonActionPerformed
        TCJCheckBox.setSelected(false);
        RBJCheckBox.setSelected(false);
        OSJCheckBox.setSelected(false);
        HWJCheckBox.setSelected(false);
        FCJCheckBox.setSelected(false);
        FTJCheckBox.setSelected(false);
        OVJCheckBox.setSelected(false);
        OTJCheckBox.setSelected(false);

        firstNameJTextField.setText("");
        lastNameJTextField.setText("");
        petNameJTextField.setText("");
        petTypeJComboBox.setSelectedIndex(0);
        addressJTextField.setText("");
        cityJTextField.setText("");
        zipJFormattedTextField.setText("");
        phoneJFormattedTextField.setText("");
        totalAmountDisplayJTextField.setText("");
        displayJTextArea.setText("");
        display.delete(0, display.length());
        
        displayBillJButton.requestFocus();
    }//GEN-LAST:event_clearJButtonActionPerformed

    private void openJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openJMenuItemActionPerformed
    {//GEN-HEADEREND:event_openJMenuItemActionPerformed
        openJButtonActionPerformed(evt);
    }//GEN-LAST:event_openJMenuItemActionPerformed

    private void saveForCustomerJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveForCustomerJMenuItemActionPerformed
    {//GEN-HEADEREND:event_saveForCustomerJMenuItemActionPerformed
        try
        {
            // get inputs
            String fName = firstNameJTextField.getText();
            if (firstNameJTextField.getText().equals(""))
                throw new BadInputException();

            String lName = lastNameJTextField.getText();
            if (lastNameJTextField.getText().equals(""))
                throw new BadInputException();

            String petName = petNameJTextField.getText();
            if (lastNameJTextField.getText().equals(""))
                throw new BadInputException();

            String petType = petTypeJComboBox.getSelectedItem().toString();
            if (petTypeJComboBox.getSelectedItem().toString().equals(""))
                throw new BadInputException();

            String address = addressJTextField.getText();
            if (lastNameJTextField.getText().equals(""))
                throw new BadInputException();

            String city = cityJTextField.getText();
            if (lastNameJTextField.getText().equals(""))
                throw new BadInputException();

            String zipCode = zipJFormattedTextField.getText();
            if (lastNameJTextField.getText().equals(""))
                throw new BadInputException();

            String phoneNumber = phoneJFormattedTextField.getText();
            if (lastNameJTextField.getText().equals(""))
                throw new BadInputException();

            Person newCustomer = new Person(fName, lName, phoneNumber);

            newCustomer.getAddressObject = new Address(address, city, zipCode);
            newCustomer.getPetObject = new Pet(petName, petType);

            try
            {
                writeToFile(newCustomer);
            }

            catch (IOException ex)
            {
                Logger.getLogger(EdVetsGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        catch (BadInputException e)
        {
            JOptionPane.showMessageDialog(null, e.toString()
                    , "Input Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_saveForCustomerJMenuItemActionPerformed

    private void saveAllofInformationJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveAllofInformationJMenuItemActionPerformed
    {//GEN-HEADEREND:event_saveAllofInformationJMenuItemActionPerformed
        saveJButtonActionPerformed(evt);
    }//GEN-LAST:event_saveAllofInformationJMenuItemActionPerformed

    private void printInvoiceJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_printInvoiceJButtonActionPerformed
    {//GEN-HEADEREND:event_printInvoiceJButtonActionPerformed
        try
        {
            displayJTextArea.print();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_printInvoiceJButtonActionPerformed

    private void displayInvoiceJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_displayInvoiceJMenuItemActionPerformed
    {//GEN-HEADEREND:event_displayInvoiceJMenuItemActionPerformed
        displayBillJButtonActionPerformed(evt);
    }//GEN-LAST:event_displayInvoiceJMenuItemActionPerformed

    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_printJMenuItemActionPerformed
    {//GEN-HEADEREND:event_printJMenuItemActionPerformed
        printInvoiceJButtonActionPerformed(evt);
    }//GEN-LAST:event_printJMenuItemActionPerformed

    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitJMenuItemActionPerformed
    {//GEN-HEADEREND:event_exitJMenuItemActionPerformed
        quitJButtonActionPerformed(evt);
    }//GEN-LAST:event_exitJMenuItemActionPerformed

    private void writeToFile(Person newCustomer) throws IOException
    {
        WriteFile wf = new WriteFile("src/Customers/" + firstNameJTextField.getText() 
                + " " + lastNameJTextField.getText() +".txt");

        String output = newCustomer.getFirstName()+ "," + newCustomer.getLastName()
                + "," + newCustomer.getPetObject.getPetName() + "," + newCustomer.getPetObject.getPetType()
                + "," + newCustomer.getAddressObject.getAddress() + "," + newCustomer.getAddressObject.getCity()
                + "," + newCustomer.getAddressObject.getZipCode() + "," + newCustomer.getPhoneNumber();

            wf.write(output);

        wf.close();
    }

    private void writeToFile() throws IOException
    {
        WriteFile wf = new WriteFile("src/Invoices/" + currentDate + " " + currentTime + ".doc");
        wf.write(displayJTextArea.getText().toString());
        wf.close();
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {

           Splash splashDisplay = new Splash(2000);    // set splash for 4 seconds
           splashDisplay.showSplash();                 // show splash

           EdVetsGUI edVetGUI = new EdVetsGUI();
           edVetGUI.setLocationRelativeTo(null);  // locate this program in the center of screen
           edVetGUI.setVisible(true);
           edVetGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox FCJCheckBox;
    private javax.swing.JCheckBox FTJCheckBox;
    private javax.swing.JCheckBox HWJCheckBox;
    private javax.swing.JMenuBar JMenuBar;
    private javax.swing.JCheckBox OSJCheckBox;
    private javax.swing.JCheckBox OTJCheckBox;
    private javax.swing.JCheckBox OVJCheckBox;
    private javax.swing.JCheckBox RBJCheckBox;
    private javax.swing.JCheckBox TCJCheckBox;
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JLabel addressJLabel;
    private javax.swing.JPanel addressJPanel;
    private javax.swing.JTextField addressJTextField;
    private javax.swing.JPanel bottomJPanel;
    private javax.swing.JPanel centerJPanel;
    private javax.swing.JLabel cityJLabel;
    private javax.swing.JTextField cityJTextField;
    private javax.swing.JButton clearJButton;
    private javax.swing.JButton displayBillJButton;
    private javax.swing.JMenuItem displayInvoiceJMenuItem;
    private javax.swing.JScrollPane displayJScrollPane;
    private javax.swing.JTextArea displayJTextArea;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JLabel firstNameJLabel;
    private javax.swing.JTextField firstNameJTextField;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JMenu invoiceJMenu;
    private javax.swing.JLabel lastNameJLabel;
    private javax.swing.JTextField lastNameJTextField;
    private javax.swing.JLabel logoJLabel1;
    private javax.swing.JLabel logoJLabel2;
    private javax.swing.JLabel logoJLabel3;
    private javax.swing.JLabel logoJLabel4;
    private javax.swing.JLabel logoJLabel5;
    private javax.swing.JPanel mainJPanel;
    private javax.swing.JPanel openFileJPanel;
    private javax.swing.JButton openJButton;
    private javax.swing.JMenuItem openJMenuItem;
    private javax.swing.JLabel petNameJLabel;
    private javax.swing.JTextField petNameJTextField;
    private javax.swing.JComboBox petTypeJComboBox;
    private javax.swing.JLabel petTypeJLabel;
    private javax.swing.JFormattedTextField phoneJFormattedTextField;
    private javax.swing.JLabel phoneJLabel;
    private javax.swing.JLabel pictureJLabel;
    private javax.swing.JButton printInvoiceJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JButton quitJButton;
    private javax.swing.JMenuItem saveAllofInformationJMenuItem;
    private javax.swing.JMenuItem saveForCustomerJMenuItem;
    private javax.swing.JButton saveJButton;
    private javax.swing.JMenu saveJMenu;
    private javax.swing.JPanel serviceJPanel;
    private javax.swing.JLabel textForOpenfileJLabel;
    private javax.swing.JPanel topJPanel;
    private javax.swing.JTextField totalAmountDisplayJTextField;
    private javax.swing.JTextField totalAmountJTextField;
    private javax.swing.JFormattedTextField zipJFormattedTextField;
    private javax.swing.JLabel zipJLabel;
    // End of variables declaration//GEN-END:variables

}
