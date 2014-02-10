package Tennis;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
'Comments by the prof:
'Great effort. Here are suggestions for improvement:
'1. Use comments throughout the program, not just at the top heading.
'2. An image of a tennis logo (or other) would enhance the look of the form.
'3. Did not implement printing of member--it is required.
'4. Make the Add New Member button default.
'5. Make the level JSpinner read-only when displaying the member information.
'6. Validate email and phone number entries.
'7. It is good style to tab code inside a method.
'8. Provide buttons for adding, deleting, editing members and exiting the
    application.
'9. Declare all constants if there are any.
'10. Clear the JListBox display box before you use it and populate it with members as
    the form loads.
'11. Change the tab sequence to indicate correct order of entry.
'12. Name the classes and project appropriately.
'13. Provide check for member duplication--do not allow two members in the database
    with identical information.
'14. Follow the Java naming convention for naming variables, methods and classes.
'15. Read the members data from an external file or database.
'16. Include a separate tennis Members class for the project.
'17. Check for valid phone and email--consider using JFormattedTextField for them.
'18. Add new non-existing member only if all four required fields are valid and
    included.
'19. Enable menu choices that synchronize with buttons functionality.
'20. Provide a sound data structure for the Members.
'21. Sort the data with two different sorting algorithms by last name and by level.
'22. Disable maximization of the form.
'23. Add an About form which describes the project.
'24. Add a Splash screen that starts the project, displayed in the middle of the
    screen.
'25. Provide ToolTip to help user navigate through the form.
'26. Consider separate forms/classes for adding/editing a member.
'27. Highlighting a tennis member in the JListBox should display that members
    information in the corresponding text boxes.
'28. Make changes to the database dynamic. For example, if a member is deleted, that
    member should not show up in the JLisBox after being deleted.
'29. Add ability to search for
 */

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: TennisGUI
* File: TennisGUI.java
* Description: This class is GUI for adding or edting new player for tennis
* @author: DeukYeol Choe
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 4/20/2011
* @version 6.0
* @see java.awt.Toolkit;
* @see java.io.IOException;
* @see java.util.ArrayList;
* @see java.util.logging.Level;
* @see java.util.logging.Logger;
* @see javax.swing.JFrame;
* @see javax.swing.JOptionPane;
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class TennisGUI extends javax.swing.JFrame {

    // class instance ArrayList of TennisDatabase objects
    public ArrayList<TennisDatabase> tennisInfo = new ArrayList<TennisDatabase>();

    // It will be used for readfile
    private String fileName = "src/playersList.txt";

    /** Creates new form TennisGUI */
    public TennisGUI()
    {
        initComponents();
        
        this.getRootPane().setDefaultButton(addJButton); //set buttonAdd as default
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icon.png")); // set icon

        // set invisible button both update and cancel
        updateJButton.setVisible(false);
        cancelJButton.setVisible(false);

        // Read form an external file playersList.txts and create an
        // ArrayList of TennisDatabase
        readFromFile(fileName);

        // Show the players list in the JList
        displayDatabase();
    }

    /**
     * Method: readFromFile
         * Reads TennisDatabase from a text file that is comma delimited and
         * creates an instance of the TennisDatabase class with the data read.
         * Then the newly created city is added to the tennisInfo database.
         * Uses an object from the ReadFile class to read record.
     * @parem file: String
     * @return void
     * pre-condition: a valid file name, playersList is expected
         * for input with comma separated text fields (but no spaces) for
         * lastname, firstname, email-address, phone-number, and level
     * post-condition: a new TennisDatabase is created with the read fields
         * and added to the ArrayList cities
     * @see ReadFile
     * @see Member
     */
   private void readFromFile(String file)
   {
       ReadFile rf = new ReadFile(file);
       String input = rf.readRecord();

       while(input != null)
       {
           TennisDatabase inputData = new TennisDatabase();
           String[] temp = input.split(",");  // seperate letters depending on ','

           inputData.setFirstName(temp[0]);
           inputData.setLastName(temp[1]);
           inputData.setEamilAddress(temp[2]);
           inputData.setPhoneNumber(temp[3]);
           inputData.setLevel(Integer.parseInt(temp[4]));  // switch the type from String to Int
           //           metropolis.setDegree(Float.parseFloat(temp[4]));

           tennisInfo.add(inputData);
           input = rf.readRecord();  // check whether another data existance or not
       }
       rf.close();
   }

     /**
     * Method: displayCities
     * Displays player's list on the Jlist sorted by last name
     * @parem void
     * @return void
     * pre-condition: Uses the ArrayList tennisInfo
     * post-condition: tennisInfo ArrayList is sorted and displayed either by
     * level or last name.
     * @see #selectionSort
     * @see #insetionSort
     */
    public void displayDatabase()
    {
         String[] playersList = new String[tennisInfo.size()];
         if(byLevelJMenuItem.isSelected())
         {
             selectionSort(tennisInfo);
             for(int index = 0; index < tennisInfo.size(); index++)
             {
                 playersList[index] = tennisInfo.get(index).getLastName() + ", "
                         + tennisInfo.get(index).getFirstName() + " -> " +" level : "
                         + tennisInfo.get(index).getLevel();
             }
         }
         else
         {
             insertionSort(tennisInfo);
             for(int index = 0; index < tennisInfo.size(); index++)
             {
                 playersList[index] = tennisInfo.get(index).getLastName()+ ", "
                         + tennisInfo.get(index).getFirstName();
             }
         }

         displayJList.setListData(playersList);
         displayJList.setSelectedIndex(0); // If not set up this, when we run it at first.
                                          // We can't see the info of selected players (only beginning time)
    }

     /**
     * Method: insertionSort
         * Sorts ArrayList tennisInfo in ascending order by Lastname. Uses the insertion
         * sort algorithm which inserts city at correct position and shuffles
         * everyone else below that position.
     * @parem ArrayList: tennisInfo
     * @return void
     * pre-condition: ArrayList tennisInfo filled-in with TennisDatabase objects.
     * post-condition: tennisInfo ArrayList is sorted by Lastname.
     */
    public static void insertionSort(ArrayList <TennisDatabase> tennisInfo)
    {
	int i,j;
	for(i = 0; i < tennisInfo.size(); i++)
	{
            TennisDatabase temp = tennisInfo.get(i);
            j = i - 1;
            while (j >= 0 && tennisInfo.get(j).getLastName().compareToIgnoreCase(temp.getLastName()) > 0)
            // Truth is bigger than temp.getName()
            {
		tennisInfo.set(j+1, tennisInfo.get(j));
		j--;
            }
                tennisInfo.set(j+1, temp);
	}
    }

     /**
     * Method: selectionSort
         * Sorts ArrayList tennisInfo in ascending order by level. Calls
         * findsMaximum to find city with maximum population in each pass
         * and swap to exchange tennesInfo when necessary.
     * @parem ArrayList: tennisInfo
     * @return void
     * pre-condition: ArrayList tennisInfo filled-in with TennisDatabase objects.
     * post-condition: tennisInfo ArrayList is sorted by population.
     */
    public static void selectionSort(ArrayList <TennisDatabase> tennisInfo)
    {
	int i, j;
	for(i = 0; i < tennisInfo.size(); i++)
	{
		int max = findMaximum(tennisInfo,i);
		swap(tennisInfo,i,max);
	}
    }

    /**
     * Method: findMaximum
         * Called by selectionSort to find the index of the member with the maximum
         * level from a given index to the end of the ArrayList
     * @parem ArrayList: cities
     * @parem  int i: index from which to search for the max >= 0
     * @return int: position or index  where maximum is located
     * pre-condition: ArrayList members filled-in with members objects, int i >= 0.
     * post-condition: members ArrayList is sorted by level.
     */
	public static int findMaximum(ArrayList <TennisDatabase> tennisInfo,int i)
	{
            int j, max = i ;
            for(j = i + 1; j < tennisInfo.size(); j++)
            {
                if(tennisInfo.get(j).getLevel() > tennisInfo.get(max).getLevel())
                    max = j;
            }
		return max;
	}

    /**
     * Method: swap
         * Called by selectionSort to find the index of the member with the maximum
         * level from a given index to the end of the ArrayList
     * @parem ArrayList: members
     * @parem  int i: index of element to swapped >= 0
     * @parem  int max: index of element to wapped >= 0
     * @return void
     * pre-condition: ArrayList members filled-in with members objects, int i, max >= 0.
     * post-condition: members ArrayList with two members swapped.
     */
    public static void swap (ArrayList <TennisDatabase> tennisInfo, int i, int max)
    {
	TennisDatabase temp = tennisInfo.get(i);
        //member[i] = member[j];
        tennisInfo.set(i, tennisInfo.get(max)); // tennisInfo.get(max) - > tennisInfo.get(i)
	tennisInfo.set(max, temp);
    }

     /**
     * Method: binarySearch
         * Search by key inputed info to find the index of the member
     * @parem ArrayList: members
     * @parem  String array[]: index of element to swapped >= 0
     * @parem  String key: index of element to swapped >= 0
     * @return void
     * pre-condition: Input exact data info
     * post-condition: If exists input the player, show the info on the display
     */
    public static int binarySearch(String array[], String key)
    {
	   int low = 0;              // low subscript
	   int high = array.length -1;  // high subscript
	   int middle;               // middle subscript

	   while ( low <= high ) {
	      middle = ( low + high ) / 2;

	      if ( key.equalsIgnoreCase(array[middle]))  // match
	         return middle;
	      else if ( key.compareToIgnoreCase(array[middle]) < 0 ) // if key is smaller than array[middle]
	         high = middle - 1;  // search low end of array
	      else
	         low = middle + 1;   // search high end of array
	   }

	   return -1;   // searchKey not found
    }

     /**
     * Method: clearAll
     * clear up player's information selected
     * @parem ArrayList: void
     * @return void
     * pre-condition: nothing
     * post-condition: remove information of selected players  such as name, phone, email, and level
     */
    private void clearAll()
    {
        //Clear and set JTextFields visible
        displayJList.setEnabled(false);
        firstNameJTextField.setText("");
        firstNameJTextField.setEditable(true);
        lastNameJTextField.setText("");
        lastNameJTextField.setEditable(true);
        emailJTextField.setText("");
        emailJTextField.setEditable(true);
        phoneJFormattedTextField.setText("");
        phoneJFormattedTextField.setEditable(true);
        levelJSpinner.setValue(1);
        levelJSpinner.setEnabled(true);
        firstNameJTextField.requestFocus();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sortButtonGroup = new javax.swing.ButtonGroup();
        JScrollPane = new javax.swing.JScrollPane();
        disPlayTextArea = new javax.swing.JTextArea();
        displayJPanel = new javax.swing.JPanel();
        displayJScrollPane = new javax.swing.JScrollPane();
        displayJList = new javax.swing.JList();
        headerJPanel = new javax.swing.JPanel();
        tennisDatabaseJLabel = new javax.swing.JLabel();
        photoJLabel = new javax.swing.JLabel();
        buttonJPanel = new javax.swing.JPanel();
        updateJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();
        addJButton = new javax.swing.JButton();
        editJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        quitJButton = new javax.swing.JButton();
        inputDataJPanel = new javax.swing.JPanel();
        firstNameJLabel = new javax.swing.JLabel();
        firstNameJTextField = new javax.swing.JTextField();
        lastNameJLabel = new javax.swing.JLabel();
        lastNameJTextField = new javax.swing.JTextField();
        emailJLabel = new javax.swing.JLabel();
        phoneJLabel = new javax.swing.JLabel();
        levelJLabel = new javax.swing.JLabel();
        levelJSpinner = new javax.swing.JSpinner();
        phoneJFormattedTextField = new javax.swing.JFormattedTextField();
        emailJTextField = new javax.swing.JTextField();
        playersJLabel = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        exitJMenuItem = new javax.swing.JMenuItem();
        sortJMenu = new javax.swing.JMenu();
        byLastNameJMenuItem = new javax.swing.JRadioButtonMenuItem();
        byLevelJMenuItem = new javax.swing.JRadioButtonMenuItem();
        actionJMenu = new javax.swing.JMenu();
        addJMenuItem = new javax.swing.JMenuItem();
        deleteJMenuItem = new javax.swing.JMenuItem();
        editJMenuItem = new javax.swing.JMenuItem();
        searchPlayerJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        helpJMenuItem = new javax.swing.JMenuItem();

        disPlayTextArea.setColumns(20);
        disPlayTextArea.setRows(5);
        JScrollPane.setViewportView(disPlayTextArea);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tennis Database");
        setResizable(false);

        displayJPanel.setBackground(new java.awt.Color(255, 255, 255));

        displayJList.setFont(new java.awt.Font("Tahoma", 1, 11));
        displayJList.setToolTipText("Added player list");
        displayJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                displayJListValueChanged(evt);
            }
        });
        displayJScrollPane.setViewportView(displayJList);

        javax.swing.GroupLayout displayJPanelLayout = new javax.swing.GroupLayout(displayJPanel);
        displayJPanel.setLayout(displayJPanelLayout);
        displayJPanelLayout.setHorizontalGroup(
            displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
        );
        displayJPanelLayout.setVerticalGroup(
            displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayJScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );

        tennisDatabaseJLabel.setFont(new java.awt.Font("Tahoma", 1, 28));
        tennisDatabaseJLabel.setText("Tennis Database");

        photoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tennisphoto.png"))); // NOI18N

        javax.swing.GroupLayout headerJPanelLayout = new javax.swing.GroupLayout(headerJPanel);
        headerJPanel.setLayout(headerJPanelLayout);
        headerJPanelLayout.setHorizontalGroup(
            headerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerJPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(tennisDatabaseJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(photoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerJPanelLayout.setVerticalGroup(
            headerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerJPanelLayout.createSequentialGroup()
                .addGroup(headerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerJPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(tennisDatabaseJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerJPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(photoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        buttonJPanel.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        updateJButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        updateJButton.setMnemonic('U');
        updateJButton.setText("Update");
        updateJButton.setToolTipText("The data you input renew!");
        updateJButton.setNextFocusableComponent(cancelJButton);
        updateJButton.setOpaque(false);
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });
        buttonJPanel.add(updateJButton);

        cancelJButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        cancelJButton.setMnemonic('C');
        cancelJButton.setText("Cancel");
        cancelJButton.setToolTipText("Cancel that you are updating");
        cancelJButton.setNextFocusableComponent(addJButton);
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });
        buttonJPanel.add(cancelJButton);

        addJButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        addJButton.setMnemonic('A');
        addJButton.setText("Add New Member");
        addJButton.setToolTipText("Add new member!");
        addJButton.setNextFocusableComponent(editJButton);
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        buttonJPanel.add(addJButton);

        editJButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        editJButton.setMnemonic('E');
        editJButton.setText("Edit Member");
        editJButton.setToolTipText("Change member's information");
        editJButton.setNextFocusableComponent(deleteJButton);
        editJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJButtonActionPerformed(evt);
            }
        });
        buttonJPanel.add(editJButton);

        deleteJButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        deleteJButton.setMnemonic('D');
        deleteJButton.setText("Delete Member");
        deleteJButton.setToolTipText("Get out!! member");
        deleteJButton.setNextFocusableComponent(quitJButton);
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });
        buttonJPanel.add(deleteJButton);

        quitJButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        quitJButton.setMnemonic('Q');
        quitJButton.setText("Quit");
        quitJButton.setToolTipText("Exit this program");
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });
        buttonJPanel.add(quitJButton);

        firstNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        firstNameJLabel.setForeground(new java.awt.Color(255, 0, 0));
        firstNameJLabel.setText("First Name* :");

        firstNameJTextField.setEditable(false);
        firstNameJTextField.setFont(new java.awt.Font("Tahoma", 1, 12));
        firstNameJTextField.setToolTipText("Input the first name of new player");
        firstNameJTextField.setNextFocusableComponent(lastNameJTextField);
        firstNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameJTextFieldActionPerformed(evt);
            }
        });

        lastNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        lastNameJLabel.setForeground(new java.awt.Color(255, 0, 0));
        lastNameJLabel.setText("Last Name* :");

        lastNameJTextField.setEditable(false);
        lastNameJTextField.setFont(new java.awt.Font("Tahoma", 1, 12));
        lastNameJTextField.setToolTipText("Input the last name of new player");
        lastNameJTextField.setNextFocusableComponent(emailJTextField);
        lastNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameJTextFieldActionPerformed(evt);
            }
        });

        emailJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        emailJLabel.setText("Email Address :");

        phoneJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phoneJLabel.setForeground(new java.awt.Color(255, 0, 0));
        phoneJLabel.setText("Phone Number* :");

        levelJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        levelJLabel.setForeground(new java.awt.Color(255, 0, 0));
        levelJLabel.setText("Level* :");

        levelJSpinner.setFont(new java.awt.Font("Tahoma", 1, 14));
        levelJSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        levelJSpinner.setToolTipText("What is his/her level?");
        levelJSpinner.setEnabled(false);
        levelJSpinner.setNextFocusableComponent(updateJButton);

        phoneJFormattedTextField.setEditable(false);
        try {
            phoneJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(  ###  )  -  ###  -  ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        phoneJFormattedTextField.setToolTipText("Input phone number including area number");
        phoneJFormattedTextField.setFont(new java.awt.Font("Tahoma", 1, 12));
        phoneJFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneJFormattedTextFieldActionPerformed(evt);
            }
        });

        emailJTextField.setEditable(false);
        emailJTextField.setFont(new java.awt.Font("Tahoma", 1, 12));
        emailJTextField.setToolTipText("Input email(ex. apple@gmail.com)");
        emailJTextField.setNextFocusableComponent(emailJTextField);
        emailJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailJTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputDataJPanelLayout = new javax.swing.GroupLayout(inputDataJPanel);
        inputDataJPanel.setLayout(inputDataJPanelLayout);
        inputDataJPanelLayout.setHorizontalGroup(
            inputDataJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputDataJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputDataJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inputDataJPanelLayout.createSequentialGroup()
                        .addComponent(emailJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(inputDataJPanelLayout.createSequentialGroup()
                        .addGroup(inputDataJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(levelJLabel)
                            .addComponent(phoneJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputDataJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(levelJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(141, 141, 141))
                    .addGroup(inputDataJPanelLayout.createSequentialGroup()
                        .addGroup(inputDataJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inputDataJPanelLayout.createSequentialGroup()
                                .addComponent(lastNameJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputDataJPanelLayout.createSequentialGroup()
                                .addComponent(firstNameJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(177, 177, 177)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputDataJPanelLayout.setVerticalGroup(
            inputDataJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputDataJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputDataJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputDataJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputDataJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputDataJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputDataJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(levelJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        playersJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        playersJLabel.setText("Players : ");
        playersJLabel.setToolTipText("List of added players");

        fileJMenu.setText("File");
        fileJMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileJMenuActionPerformed(evt);
            }
        });

        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("The information the seleced member will be clear");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print");
        printJMenuItem.setToolTipText("Printing out! only information of chosen player");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        exitJMenuItem.setMnemonic('E');
        exitJMenuItem.setText("Exit");
        exitJMenuItem.setToolTipText("Quit this program");
        exitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(exitJMenuItem);

        jMenuBar.add(fileJMenu);

        sortJMenu.setMnemonic('S');
        sortJMenu.setText("Sort");

        sortButtonGroup.add(byLastNameJMenuItem);
        byLastNameJMenuItem.setMnemonic('N');
        byLastNameJMenuItem.setSelected(true);
        byLastNameJMenuItem.setText("By LastName");
        byLastNameJMenuItem.setToolTipText("Sorting list by lastname");
        byLastNameJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byLastNameJMenuItemActionPerformed(evt);
            }
        });
        sortJMenu.add(byLastNameJMenuItem);

        sortButtonGroup.add(byLevelJMenuItem);
        byLevelJMenuItem.setMnemonic('N');
        byLevelJMenuItem.setText("By Level");
        byLevelJMenuItem.setToolTipText("Sorting list by level");
        byLevelJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byLevelJMenuItemActionPerformed(evt);
            }
        });
        sortJMenu.add(byLevelJMenuItem);

        jMenuBar.add(sortJMenu);

        actionJMenu.setMnemonic('t');
        actionJMenu.setText("Action");
        actionJMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionJMenuActionPerformed(evt);
            }
        });

        addJMenuItem.setMnemonic('A');
        addJMenuItem.setText("Add");
        addJMenuItem.setToolTipText("Add new player");
        addJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(addJMenuItem);

        deleteJMenuItem.setMnemonic('D');
        deleteJMenuItem.setText("Delete");
        deleteJMenuItem.setToolTipText("Delete a member");
        deleteJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(deleteJMenuItem);

        editJMenuItem.setMnemonic('E');
        editJMenuItem.setText("Edit");
        editJMenuItem.setToolTipText("Edit a member's information");
        editJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(editJMenuItem);

        searchPlayerJMenuItem.setMnemonic('S');
        searchPlayerJMenuItem.setText("Search Player");
        searchPlayerJMenuItem.setToolTipText("Who's lookg for? Clikck on!");
        searchPlayerJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPlayerJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(searchPlayerJMenuItem);

        jMenuBar.add(actionJMenu);

        helpJMenu.setText("Help");

        helpJMenuItem.setMnemonic('A');
        helpJMenuItem.setText("About");
        helpJMenuItem.setToolTipText("About this...");
        helpJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(helpJMenuItem);

        jMenuBar.add(helpJMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(displayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(playersJLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(headerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDataJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputDataJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(playersJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(displayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     /**
     * Method: updateJButtonActionPerformed
     * When I press on updatebutton, the data I input is saved to ArrayList
     * @parem ArrayList: void
     * @return void
     * pre-condition: 4 data firstname, lastname, phone, and level must input into proper JtextField
     */
    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_updateJButtonActionPerformed
    {//GEN-HEADEREND:event_updateJButtonActionPerformed
        try
        {
           int index = (displayJList.getSelectedIndex());
           if(index == -1)
               index = 0;
           tennisInfo.get(index).setFirstName(firstNameJTextField.getText());
           tennisInfo.get(index).setLastName(lastNameJTextField.getText());
           tennisInfo.get(index).setEamilAddress(emailJTextField.getText());
           tennisInfo.get(index).setPhoneNumber(phoneJFormattedTextField.getText());
           int tempLevel = Integer.parseInt(levelJSpinner.getValue().toString());
           tennisInfo.get(index).setLevel(tempLevel);

           if(tennisInfo.get(index).getFirstName().equals(""))
              throw new NullPointerException();
           if(tennisInfo.get(index).getLastName().equals(""))
              throw new NullPointerException();
           if(tennisInfo.get(index).getPhoneNumber().equals(""))
              throw new NullPointerException();
           
           displayDatabase();
           savePlayer();

           displayJList.setEnabled(true);
           firstNameJTextField.setEditable(false);
           lastNameJTextField.setEditable(false);
           emailJTextField.setEditable(false);
           phoneJFormattedTextField.setEditable(false);
           levelJSpinner.setEnabled(false);

           addJButton.setEnabled(true);
           editJButton.setEnabled(true);
           deleteJButton.setEnabled(true);
           updateJButton.setVisible(false);
           cancelJButton.setVisible(false);
        }
        catch(NullPointerException nullex)
        {
            JOptionPane.showMessageDialog( null,"Update failure. You Must input 4 information with red", " input error ",
            JOptionPane.WARNING_MESSAGE );
        }
       
    }//GEN-LAST:event_updateJButtonActionPerformed

    private void firstNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_firstNameJTextFieldActionPerformed
    {//GEN-HEADEREND:event_firstNameJTextFieldActionPerformed
    }//GEN-LAST:event_firstNameJTextFieldActionPerformed

    private void lastNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_lastNameJTextFieldActionPerformed
    {//GEN-HEADEREND:event_lastNameJTextFieldActionPerformed
    }//GEN-LAST:event_lastNameJTextFieldActionPerformed

     /**
     * Method: addJButtonActionPerformed
     * When I press on addbutton, showing new form for adding new player
     * @parem ArrayList: void
     * @return void
     * pre-condition: need to make new form previously
     */
    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addJButtonActionPerformed
    {//GEN-HEADEREND:event_addJButtonActionPerformed
        // call AddFrom and make its object
        AddForm addWindow = new AddForm();
        // set the form to the center of the screen
        addWindow.setLocationRelativeTo(null);
        // appear the new form
        addWindow.setVisible(true);
        // disappear the TennisGUI
        setVisible(false);

// Add new city
//        try
//        {
// get all five fields for the new city via Joptionpane.showinputdialog
// not the most elegant way to input new city info
// for extra credit, do this with a separate form

//            String firstName = JOptionPane.showInputDialog("Enter First Name of the player :");
//            String lastName = JOptionPane.showInputDialog("Enter Last Name of the player :");
//            String emailAddress = JOptionPane.showInputDialog("Enter email-address :");
//            String phoneNumber = JOptionPane.showInputDialog("Enter phone-number :");
//            String level = JOptionPane.showInputDialog("Enter level :");
//
//            int intLevel = Integer.parseInt(level);
//
//            if(firstName == null)
//                throw new NullPointerException();
//            if(lastName == null)
//                throw new NullPointerException();
//            if(phoneNumber == null)
//                throw new NullPointerException();
//            if(level == null)
//                throw new NullPointerException();
//
//            TennisDatabase newPlayer = new TennisDatabase(firstName, lastName, emailAddress, phoneNumber, intLevel);
//            if(!playerExists(newPlayer))
//            {
//                tennisInfo.add(newPlayer);
//
//                displayDatabase();
//                saveCities();
//            }
//        }
//        catch(NullPointerException nullex)
//        {
//            JOptionPane.showMessageDialog( null,"City not added", " input error",
//                   JOptionPane.WARNING_MESSAGE );
//               displayJList.setSelectedIndex(0);
//        }
    }//GEN-LAST:event_addJButtonActionPerformed

     /**
     * Method: displayJListValueChanged
     * When raising event on the JList, the list of players become renew.
     * @parem ArrayList: void
     * @return void
     * pre-condition: the data of player must be existence
     */
    private void displayJListValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_displayJListValueChanged
    {//GEN-HEADEREND:event_displayJListValueChanged
        int index = (displayJList.getSelectedIndex());
        if(index == -1)
           index = 0;
        showCityData(index);
    }//GEN-LAST:event_displayJListValueChanged

     /**
     * Method: editJButtonActionPerformed
     * When clicking on editJButton, the JTextFile with firstName, lastName, email,
      * phone, and level become activated for input data.
     * @parem ArrayList: void
     * @return void
     * pre-condition: All of JTextFiles should be uneditable
     */
    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editJButtonActionPerformed
    {//GEN-HEADEREND:event_editJButtonActionPerformed
        displayJList.setEnabled(false);
        firstNameJTextField.setEditable(true);
        lastNameJTextField.setEditable(true);
        emailJTextField.setEditable(true);
        phoneJFormattedTextField.setEditable(true);
        levelJSpinner.setEnabled(true);

        updateJButton.setVisible(true);
        cancelJButton.setVisible(true);

        addJButton.setEnabled(false);
        editJButton.setEnabled(false);
        deleteJButton.setEnabled(false);
        
        firstNameJTextField.requestFocus();
        firstNameJTextField.selectAll();

    }//GEN-LAST:event_editJButtonActionPerformed

     /**
     * Method: searchPlayerJMenuItemActionPerformed
     * It helps to find the player you want to spot
     * @parem ArrayList: void
     * @return void
     * pre-condition: binarySearch method
     */
    private void searchPlayerJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_searchPlayerJMenuItemActionPerformed
    {//GEN-HEADEREND:event_searchPlayerJMenuItemActionPerformed
        // Find player via binary search
        String playerName = JOptionPane.showInputDialog("Enter Last name of player");

        //Sort the Jlist of player name by name
        byLastNameJMenuItem.setSelected(true);
        displayDatabase();

        // Create
        String[] playerArray = new String[tennisInfo.size()];
        for(int i = 0; i < playerArray.length; i++)
            playerArray[i] = tennisInfo.get(i).getLastName();

        //Fine index of city
        int index = binarySearch(playerArray, playerName);

        if(index == -1) {
            JOptionPane.showMessageDialog(null, playerName + " not FOUND", "Search Result",
                    JOptionPane.WARNING_MESSAGE);
            displayJList.setSelectedIndex(0);
        } else
            displayJList.setSelectedIndex(index);
    }//GEN-LAST:event_searchPlayerJMenuItemActionPerformed

     /**
     * Method: deleteJButtonActionPerformed
     * delete the information about the selected player
     * @parem ArrayList: void
     * @return void
     * pre-condition: It must exist players one more
     */
    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteJButtonActionPerformed
    {//GEN-HEADEREND:event_deleteJButtonActionPerformed
        // add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Are you sure", "Delete Player?",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if(result == 0)
        {
            int index = displayJList.getSelectedIndex();
            tennisInfo.remove(index);
            displayDatabase();
            savePlayer();
        }
    }//GEN-LAST:event_deleteJButtonActionPerformed

      /**
     * Method: quitJButtonActionPerformed
     * quit the program you are running
     * @parem ArrayList: void
     * @return void
     * pre-condition: nothing
     */
    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitJButtonActionPerformed
    {//GEN-HEADEREND:event_quitJButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitJButtonActionPerformed

     /**
     * Method: byLastNameJMenuItemActionPerformed
     * sorting the list of players by lastname
     * @parem ArrayList: void
     * @return void
     * pre-condition: exist sorting algorism
     */
    private void byLastNameJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_byLastNameJMenuItemActionPerformed
    {//GEN-HEADEREND:event_byLastNameJMenuItemActionPerformed
       displayDatabase();
    }//GEN-LAST:event_byLastNameJMenuItemActionPerformed

     /**
     * Method: byLevelJMenuItemActionPerformed
     * sorting the list of players by level
     * @parem ArrayList: void
     * @return void
     * pre-condition: exist sorting algorism
     */
    private void byLevelJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_byLevelJMenuItemActionPerformed
    {//GEN-HEADEREND:event_byLevelJMenuItemActionPerformed
        displayDatabase();
    }//GEN-LAST:event_byLevelJMenuItemActionPerformed

     /**
     * Method: cancelJButtonActionPerformed
     * set button's state
     * @parem ArrayList: void
     * @return void
     * pre-condition:
     */
    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelJButtonActionPerformed
    {//GEN-HEADEREND:event_cancelJButtonActionPerformed
        displayJList.setEnabled(true);
        firstNameJTextField.setEditable(false);
        lastNameJTextField.setEditable(false);
        emailJTextField.setEditable(false);
        phoneJFormattedTextField.setEditable(false);
        levelJSpinner.setEnabled(false);

        addJButton.setEnabled(true);
        editJButton.setEnabled(true);
        deleteJButton.setEnabled(true);

        updateJButton.setVisible(false);
        cancelJButton.setVisible(false);
    }//GEN-LAST:event_cancelJButtonActionPerformed

    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearJMenuItemActionPerformed
    {//GEN-HEADEREND:event_clearJMenuItemActionPerformed
        clearAll();
        updateJButton.setVisible(true);
        cancelJButton.setVisible(true);
    }//GEN-LAST:event_clearJMenuItemActionPerformed

    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitJMenuItemActionPerformed
    {//GEN-HEADEREND:event_exitJMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitJMenuItemActionPerformed

    private void addJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addJMenuItemActionPerformed
    {//GEN-HEADEREND:event_addJMenuItemActionPerformed
        addJButtonActionPerformed(evt);
    }//GEN-LAST:event_addJMenuItemActionPerformed

    private void deleteJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteJMenuItemActionPerformed
    {//GEN-HEADEREND:event_deleteJMenuItemActionPerformed
        deleteJButtonActionPerformed(evt);
    }//GEN-LAST:event_deleteJMenuItemActionPerformed

    private void helpJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_helpJMenuItemActionPerformed
    {//GEN-HEADEREND:event_helpJMenuItemActionPerformed
        AboutForm infoWindow = new AboutForm();
        infoWindow.setVisible(true);
    }//GEN-LAST:event_helpJMenuItemActionPerformed

    private void editJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJMenuItemActionPerformed
        editJButtonActionPerformed(evt);
    }//GEN-LAST:event_editJMenuItemActionPerformed

    private void actionJMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionJMenuActionPerformed
    }//GEN-LAST:event_actionJMenuActionPerformed

    private void fileJMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileJMenuActionPerformed
    }//GEN-LAST:event_fileJMenuActionPerformed

    private void phoneJFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneJFormattedTextFieldActionPerformed
    }//GEN-LAST:event_phoneJFormattedTextFieldActionPerformed

    private void emailJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailJTextFieldActionPerformed
    }//GEN-LAST:event_emailJTextFieldActionPerformed

      /**
     * Method: printJMenuItemActionPerformed
     * printing out
     * @parem ArrayList: void
     * @return void
     * pre-condition: Must exist the data of player
     */
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        StringBuilder display = new StringBuilder("");

        for( int index = 0; index < tennisInfo.size(); index++ )
        {
            display.append("\n");
            display.append("FirstName : ");
            display.append(tennisInfo.get(index).getFirstName());
            display.append("\n");
            display.append("LastName : ");
            display.append(tennisInfo.get(index).getLastName());
            display.append("\n");
            display.append("Email : ");
            display.append(tennisInfo.get(index).getEamilAddress());
            display.append("\n");
            display.append("Phone-Number : ");
            display.append(tennisInfo.get(index).getPhoneNumber());
            display.append("\n");
            display.append("Level : ");
            display.append(tennisInfo.get(index).getLevel());
            display.append("\n");
            display.append("-----------------------------------------------");
        }
        disPlayTextArea.setText(display.toString());

        try
        {
            disPlayTextArea.print();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }//GEN-LAST:event_printJMenuItemActionPerformed

     /**
     * Method: showCityData
     * show the information of selected player on the display
     * @parem file: int index
     * @return void
     * pre-condition: exist playersList.txt
     * post-condition: show the result on the display
     */
    private void showCityData(int index)
    {
        firstNameJTextField.setText(tennisInfo.get(index).getFirstName());
        lastNameJTextField.setText(tennisInfo.get(index).getLastName());
        emailJTextField.setText(tennisInfo.get(index).getEamilAddress());
        phoneJFormattedTextField.setText(tennisInfo.get(index).getPhoneNumber());
        levelJSpinner.setValue(tennisInfo.get(index).getLevel());
    }

    /**
     * Method: playerExists
     * Check the player want to add exists already or not in the database
     * @parem file: TennisDatabase
     * @return boolean
     * pre-condition: a valid file name, playersList.txt is expected
     * post-condition: a new text file is created with the current list
     * in the database
     * @see WriteFile
     * @see TennisDatabase
     */
    public boolean playerExists(TennisDatabase player)
    {
        boolean thereIsOne = false;
        for(int index = 0; index < tennisInfo.size() && !thereIsOne; index++)
        {
            if(tennisInfo.get(index).equals(player))
                thereIsOne = true;
        }
        return thereIsOne;
    }

     /**
     * Method: savePlayer
     * save the information of chosen player to an external file
     * @return void
     * pre-condition: a valid file name
     * in the database
     */
    public void savePlayer()
    {
        try
        {
            writeToFile(fileName);
        }
        catch(IOException ex)
        {
            Logger.getLogger(TennisGUI.class.getName()).log(Level.SEVERE, null, ex); //??????
        }
    }

     /**
     * Method: writeToFile
     * Write cities to a text file that is comma delimited.
     * @parem file: String
     * @return void
     * pre-condition: a valid file name, playersList.txt is expected
     * post-condition: a new text file is created with the current cities
     * in the database
     * @see WriteFile
     * @see TennisDatabase
     */
    private void writeToFile(String file) throws IOException
    {
        WriteFile wf = new WriteFile(file);
        for(int index = 0; index < tennisInfo.size(); index++)
        {
           TennisDatabase tempPlayer = tennisInfo.get(index);
           String output = tempPlayer.getFirstName() + "," + tempPlayer.getLastName()+
                   "," + tempPlayer.getEamilAddress() + "," +
                   tempPlayer.getPhoneNumber() + "," + tempPlayer.getLevel();
           wf.write(output);
        }
        wf.close();
    }

    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
                Splash splashDisplay = new Splash(2000);    // set splash for 4 seconds
                splashDisplay.showSplash();                 // show splash

                TennisGUI tennisPlayers = new TennisGUI();
                tennisPlayers.setLocationRelativeTo(null);  // locate this program in the center of screen
                tennisPlayers.setVisible(true);
                tennisPlayers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JMenu actionJMenu;
    private javax.swing.JButton addJButton;
    private javax.swing.JMenuItem addJMenuItem;
    private javax.swing.JPanel buttonJPanel;
    private javax.swing.JRadioButtonMenuItem byLastNameJMenuItem;
    private javax.swing.JRadioButtonMenuItem byLevelJMenuItem;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JMenuItem deleteJMenuItem;
    private javax.swing.JTextArea disPlayTextArea;
    private javax.swing.JList displayJList;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JScrollPane displayJScrollPane;
    private javax.swing.JButton editJButton;
    private javax.swing.JMenuItem editJMenuItem;
    private javax.swing.JLabel emailJLabel;
    private javax.swing.JTextField emailJTextField;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JLabel firstNameJLabel;
    private javax.swing.JTextField firstNameJTextField;
    private javax.swing.JPanel headerJPanel;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JMenuItem helpJMenuItem;
    private javax.swing.JPanel inputDataJPanel;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JLabel lastNameJLabel;
    private javax.swing.JTextField lastNameJTextField;
    private javax.swing.JLabel levelJLabel;
    private javax.swing.JSpinner levelJSpinner;
    private javax.swing.JFormattedTextField phoneJFormattedTextField;
    private javax.swing.JLabel phoneJLabel;
    private javax.swing.JLabel photoJLabel;
    private javax.swing.JLabel playersJLabel;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JButton quitJButton;
    private javax.swing.JMenuItem searchPlayerJMenuItem;
    private javax.swing.ButtonGroup sortButtonGroup;
    private javax.swing.JMenu sortJMenu;
    private javax.swing.JLabel tennisDatabaseJLabel;
    private javax.swing.JButton updateJButton;
    // End of variables declaration//GEN-END:variables

}
