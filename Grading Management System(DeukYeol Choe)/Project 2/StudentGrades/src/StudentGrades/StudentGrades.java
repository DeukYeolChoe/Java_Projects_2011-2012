//'~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//'Good effort. Here are suggestions for improving:
//'1. Use JavaDoc comments through the program, not just at the top heading.
//'2. Need at least three classes: Person, Student, and GradeGUI.
//'3. Make the Calculate button default—pressing the Enter key should fire it.
//'4. Enable and disable buttons and menus as appropriate.
//'5. Follow Java's naming convention for class, methods, variables and constants.
//'6. Use final definitions for constants.
//'8. It is good style to tab code inside each method.
//'9. Provide accelerator keys for all buttons and menu choices.
//'10. Use System.exit(0); to exit program.
//'11. Read student data from an external file and assign it to student objects.
//'12. Provide ability to add, edit, and delete students data.
//'13. Name the project appropriately.
//'14. Print not implemented.
//'15. Save a new record or edited record as the user navigates away from that record.
//'16. The user should be able to navigate through the list of students by using the navigational buttons
//JButtons.
//'17. Provide icon for the form.
//'18. Use the StringTokenizer, BufferedReader, and FileReader classes to get the student data.
//'19. Avoid excessive number of class variables-declare local variables inside methods.
//'20. Clean up the empty procedures code.
//'21. Consider making the output disabled (read-only) until there is a need to edit the record.
//'22. Place all navigational JButtons in a control JPanel.
//'23. Add menus to the form with meaningful and synchronized choices.
//'24. Add a Splash screen.
//'25. Add an About form.
//'26. Disable form from maximization.
//'27. Missing ToolTips.
//'28. Allow multiple parcels can be shipped to the same person at the same location.
//'29. Give title to form.
//'30. Follow the UML diagram for designing the classes.
//'31. Show forms centered as they load.
//'32. *Add a Course class with all the necessary modifications.
//'33. *Print the entire GUI.
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
package StudentGrades;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*Class:         StudentGrades
*File:          StudentGrades.java
*Description:   This program has functions with adding, editing, saving, updating, and so on
*               it shows user two displays; one of them is student-lists, which are on enrollment.
*               another is course display with having information that the selected student is taking now.
*               It contains navigate function, which can move current index to first-index, previous-index, next-index, and last-index
*
*@Class:        CS 142
*@author:       Khoa Dang & Dray Choe
*@Instructor:   Niko Culevski
*@Due Date:     05/11/2011
*
*Environment:	PC, Windows 7, jdk6.24, NetBeans 6.9.1
*Date:          05/10/2011
*@version       1.0.0
*@see           java.awt.Dimension;
*@see           java.awt.Toolkit;
*@see           java.io.File;
*@see           java.io.FileNotFoundException;
*@see           java.io.FileOutputStream;
*@see           java.io.IOException;
*@see           java.io.PrintWriter;
*@see           java.text.DecimalFormat;
*@see           java.util.ArrayList;
*@see           java.util.logging.Level;
*@see           java.util.logging.Logger;
*@see           javax.swing.JFrame;
*@see           javax.swing.JOptionPane;
*History Log:	05/10/2011
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class StudentGrades extends javax.swing.JFrame
{
    // class instance ArrayList of Student objects
    private ArrayList<Student> student = new ArrayList<Student>();

    //class instance ArrayList of Courses objects
    private ArrayList<Courses> course = new ArrayList<Courses>();

    // external file name of students
    private String fileName = "src/StudentGrades/Students.txt";

    // Method to create difference text file names to store each person's courses
    public String courseFileName(int INDEX)
    {
    // external file name of students' courses
    String courseFileName = "src/StudentGrades/database/" + student.get(INDEX).getFirstName() +"Courses.txt";

    return courseFileName;
    }

    DecimalFormat score = new DecimalFormat("###.0");



    /** Creates new form StudentGrades */
    public StudentGrades()
    {
        initComponents();

        //Set add button as the default button
        this.getRootPane().setDefaultButton(finalAddJButton); //set buttonAdd as default
        //Set the icon image
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/StudentGrades/icon.png"));

        //Invisible the update and cancel buttons
        updateJButton.setVisible(false);
        cancelJButton.setVisible(false);
        finalAddJButton.setVisible(false);
        cancelAddJButton.setVisible(false);
        clearJMenuItem.setEnabled(false);
        clearJButton.setEnabled(false);
        addCourseButton.setVisible(false);
        cancelAddCourseJButton.setVisible(false);
        editCourseJButton.setVisible(false);
        cancelEditCourseJButton.setVisible(false);
        byFirstNameJRadioButtonMenuItem.setSelected(true);
                
         // Read form an external file Sudents.txt and create an
        // ArrayList of Student type, student
        readFromFile(fileName);

        // Show the players list in the JList
        displayStudents();
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
            String[] temp = input.split(",");

            Student students = new Student(temp[0],temp[1], Integer.parseInt(temp[2]));

            student.add(students);
            input = rf.readRecord();
        }
        rf.close();
     }

     /**
     * Method: readCourseFile
     * Reads courses from a text file in StudentGrades.database that is comma delimited and
     * creates an instance of the courses class with the data read.
     * Uses an object from the ReadFile class to read record.
     * @parem file: String
     * @return void
     * pre-condition: a valid file name, "Lastname+Course.txt" is expected
     * for input with comma separated text fields (but no spaces) for
     * student first name, last name, and SID
     * post-condition: a new "Courses courses" is created with the read fields
     * and added to the ArrayList course
     * @see ReadFile
     * @see Member
     */
     private void readCourseFile(String file)
     {
        ReadFile rf = new ReadFile(file);
        String input = rf.readRecord();

        // Read while there is data
        while(input != null)
        {
            String[] temp = input.split(",");

            Courses courses = new Courses(temp[0],temp[1], Integer.parseInt(temp[2]), temp[3],Float.parseFloat(temp[4]),Float.parseFloat(temp[5]));


            course.add(courses);
            input = rf.readRecord();
        }
        rf.close();
     }

     /**
     * Method: displayStudents
     * Displays students in JList sorted by name(first&last) using selection sort algorithm
     * @parem void
     * @return void
     * pre-condition: Uses the ArrayList student
     * post-condition: ArrayList student is sorted and displayed either by
     * last name or first name.
     * @see #selectionSort
     * @see #insetionSort
     */
     public void displayStudents()
     {
        String[] studentsList = new String[student.size()];      // Name only
        if (byFirstNameJRadioButtonMenuItem.isSelected())
        {
            //sort by last name using insertion sort
            lastInsertionSort(student);
            for(int index = 0; index < student.size(); index++)
            {
                studentsList[index] = student.get(index).getFirstName() + ", " +
                        student.get(index).getLastName();
            }
        }
        else
        {
            //sort by last name using insertion sort
            lastInsertionSort(student);
            for(int index = 0; index < student.size(); index++)
            {
                studentsList[index] = student.get(index).getLastName() + ", " +
                        student.get(index).getFirstName();
            }
        }

        studentJList.setListData(studentsList);       // populate JList with students
        studentJList.setSelectedIndex(0);           // select first member
     }

     /**
     * Method: displayCourses
     * Displays courses in JList sorted by using InsertionSort algorithm
     * @parem void
     * @return void
     * pre-condition: Uses the ArrayList course
     * post-condition: ArrayList course is sorted and displayed on Jlist
     * @see #insetionSort
     */
     public void displayCourses()
     {
        String[] CouresList = new String[course.size()];      // Name only

            //sort by course name using insertion sort
            courseInsertionSort(course);

            //Method to tab the course information
            final int SPACE = 8;

            for(int index = 0; index < course.size(); index++)
            {
                int space1 = SPACE - course.get(index).getCourseName().length();
                int space2 = SPACE - course.get(index).getCourseNumber().length();
                int space3 = SPACE - String.valueOf(course.get(index).getCourseCredit()).length();
                int space4 = SPACE - course.get(index).getCourseSection().length();
                int space5 = SPACE - String.valueOf(course.get(index).getMidtermScore()).length();
                int space6 = SPACE - String.valueOf(course.get(index).getAverage()).length();

                String spaceI = "";
                String spaceII = "";
                String spaceIII = "";
                String spaceIV = "";
                String spaceV = "";
                String spaceVI = "";

                for(int i = 0; i <= space1; i++)
                {
                    spaceI += " ";
                }
                for(int i = 0; i <= space2; i++)
                {
                    spaceII += " ";
                }
                for(int i = 0; i <= space3; i++)
                {
                    spaceIII += " ";
                }
                for(int i = 0; i <= space4; i++)
                {
                    spaceIV += " ";
                }
                for(int i = 0; i <= space5; i++)
                {
                    spaceV += " ";
                }
                for(int i = 0; i <= space6; i++)
                {
                    spaceVI += " ";
                }
                
                
                //display the course info
                CouresList[index] = course.get(index).getCourseName() + spaceI +
                        course.get(index).getCourseNumber() + spaceII + course.get(index).getCourseCredit()
                        + spaceIII + course.get(index).getCourseSection() + spaceIV + course.get(index).getMidtermScore()
                        + spaceV + course.get(index).getFinalScore() + spaceVI + course.get(index).getAverage();
            }



        courseJList.setListData(CouresList);       // populate JList with coures
        courseJList.setSelectedIndex(0);           // select first course
     }

     /**
     * Method: lastInsertionSort
     * Sorts ArrayList students in ascending order by last name. Uses the insertion
     * sort algorithm which inserts city at correct position and shuffles
     * everyone else below that position.
     * @parem ArrayList: Student
     * @return void
     * pre-condition: ArrayList Student filled-in
     * post-condition: Student ArrayList is sorted by last name.
     */
    public static void lastInsertionSort(ArrayList < Student > student)
    {
        int i,j;

        for(i = 0; i < student.size(); i++)
        {
            Student temp = student.get(i);
            j = i - 1;

            while (j >= 0 && (student.get(j).getLastName() + student.get(j).getFirstName()).compareToIgnoreCase(temp.getLastName() + temp.getFirstName()) > 0)
            {
                student.set(j + 1, student.get(j));
                j--;
            }
            student.set(j + 1, temp);
        }
    }

    /**
     * Method: firstInsertionSort
     * Sorts ArrayList students in ascending order by first name. Uses the insertion
     * sort algorithm which inserts city at correct position and shuffles
     * everyone else below that position.
     * @parem ArrayList: Student
     * @return void
     * pre-condition: ArrayList Student filled-in
     * post-condition: Student ArrayList is sorted by first name.
     */
    public static void firstInsertionSort(ArrayList < Student > student)
    {
        int i,j;

        for(i = 0; i < student.size(); i++)
        {
            Student temp = student.get(i);
            j = i - 1;

            while (j >= 0 && (student.get(j).getFirstName() + student.get(j).getLastName()).compareToIgnoreCase(temp.getFirstName() + temp.getLastName()) > 0)
            {
                student.set(j + 1, student.get(j));
                j--;
            }
            student.set(j + 1, temp);
        }
    }

    /**
     * Method: courseInsertionSort
     * Sorts ArrayList Courses in ascending order by subject. Uses the insertion
     * sort algorithm which inserts Courses at correct position and shuffles
     * everyone else below that position.
     * @parem ArrayList: Courses
     * @return void
     * pre-condition: ArrayList course filled-in with Courses objects.
     * post-condition: Course ArrayList is sorted by subject.
     */
    public static void courseInsertionSort(ArrayList < Courses > course)
    {
        int i,j;

        for(i = 0; i < course.size(); i++)
        {
            Courses temp = course.get(i);
            j = i - 1;

            while (j >= 0 && (course.get(j).getCourseName()+course.get(j).getCourseNumber()).compareToIgnoreCase(temp.getCourseName()+temp.getCourseNumber()) > 0)
            {
                course.set(j + 1, course.get(j));
                j--;
            }
            course.set(j + 1, temp);
        }
    }

    /**
     * Method: binarySearch
     * This is a binary search method to find thing user wants to find
     * It compare low value and high value and divides 2 continuedly util finding it
     * @parem String[] array, String key
     * @return int
     */
    public static int binarySearch(String[] array, String key)
    {
       int low = 0;                     // low subscript
       int high = array.length - 1;     // high subscript
       int middle;                      // middle subscript

       while ( low <= high ) {
          middle = ( low + high ) / 2;

          if ( key.equalsIgnoreCase(array[middle]))  // match
             return middle;
          else if (  key.compareToIgnoreCase(array[ middle ] ) < 0 )
             high = middle - 1;  // search low end of array
          else
             low = middle + 1;   // search high end of array
       }

       return -1;   // searchKey not found
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        studentGradesJPanel = new javax.swing.JPanel();
        infoJPanel = new javax.swing.JPanel();
        firstNameJLabel = new javax.swing.JLabel();
        firstNameJTextField = new javax.swing.JTextField();
        sidJLabel = new javax.swing.JLabel();
        sidJTextField = new javax.swing.JTextField();
        lastNameJLabel = new javax.swing.JLabel();
        lastNameJTextField = new javax.swing.JTextField();
        coursesJPanel = new javax.swing.JPanel();
        courseJLabel = new javax.swing.JLabel();
        courseNameJLabel = new javax.swing.JLabel();
        courseNameJTextField = new javax.swing.JTextField();
        courseNumberJLabel = new javax.swing.JLabel();
        courseNumberJTextField = new javax.swing.JTextField();
        creditJLabel = new javax.swing.JLabel();
        creditJTextField = new javax.swing.JTextField();
        sectionJLabel = new javax.swing.JLabel();
        sectionJTextField = new javax.swing.JTextField();
        addCourseButton = new javax.swing.JButton();
        courseJScrollPane = new javax.swing.JScrollPane();
        courseJList = new javax.swing.JList();
        deleteCourseJButton = new javax.swing.JButton();
        midJLabel = new javax.swing.JLabel();
        midJTextField = new javax.swing.JTextField();
        fiJLabel = new javax.swing.JLabel();
        fiJTextField = new javax.swing.JTextField();
        finalAddCourseJButton = new javax.swing.JButton();
        cancelAddCourseJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        finalEditCourseJButton = new javax.swing.JButton();
        editCourseJButton = new javax.swing.JButton();
        cancelEditCourseJButton = new javax.swing.JButton();
        buttonJPanel = new javax.swing.JPanel();
        firstJButton = new javax.swing.JButton();
        previousJButton = new javax.swing.JButton();
        nextJButton = new javax.swing.JButton();
        lastJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        printJButton = new javax.swing.JButton();
        clearJButton = new javax.swing.JButton();
        editJButton = new javax.swing.JButton();
        addJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        updateJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();
        finalAddJButton = new javax.swing.JButton();
        cancelAddJButton = new javax.swing.JButton();
        studentsJPanel = new javax.swing.JPanel();
        studentJScrollPane = new javax.swing.JScrollPane();
        studentJList = new javax.swing.JList();
        listJLabel = new javax.swing.JLabel();
        logoJLabel = new javax.swing.JLabel();
        studentGradesJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        jSeparator = new javax.swing.JPopupMenu.Separator();
        exitJMenuItem = new javax.swing.JMenuItem();
        actionJMenu = new javax.swing.JMenu();
        addJMenuItem = new javax.swing.JMenuItem();
        editJMenuItem = new javax.swing.JMenuItem();
        deleteJMenuItem = new javax.swing.JMenuItem();
        navigateJMenu = new javax.swing.JMenu();
        searchJMenuItem = new javax.swing.JMenuItem();
        firstJMenuItem = new javax.swing.JMenuItem();
        previousJMenuItem = new javax.swing.JMenuItem();
        nextJMenuItem = new javax.swing.JMenuItem();
        lastJMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        byFirstNameJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        byLastNameJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Grades Report");
        setResizable(false);

        studentGradesJPanel.setBackground(new java.awt.Color(204, 204, 255));

        infoJPanel.setBackground(new java.awt.Color(204, 204, 255));

        firstNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        firstNameJLabel.setText("First Name:");

        firstNameJTextField.setEditable(false);
        firstNameJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        firstNameJTextField.setToolTipText("First Name");

        sidJLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        sidJLabel.setText("Student ID:");

        sidJTextField.setEditable(false);
        sidJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sidJTextField.setToolTipText("Student ID");

        lastNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        lastNameJLabel.setText("Last Name:");

        lastNameJTextField.setEditable(false);
        lastNameJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lastNameJTextField.setToolTipText("Last Name");

        javax.swing.GroupLayout infoJPanelLayout = new javax.swing.GroupLayout(infoJPanel);
        infoJPanel.setLayout(infoJPanelLayout);
        infoJPanelLayout.setHorizontalGroup(
            infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoJPanelLayout.createSequentialGroup()
                        .addComponent(firstNameJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(infoJPanelLayout.createSequentialGroup()
                        .addComponent(sidJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(sidJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameJTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lastNameJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        infoJPanelLayout.setVerticalGroup(
            infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameJLabel)
                    .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameJLabel)
                    .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sidJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sidJLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        coursesJPanel.setBackground(new java.awt.Color(204, 204, 255));

        courseJLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        courseJLabel.setText("Courses Information");

        courseNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        courseNameJLabel.setText("Course Name:");

        courseNameJTextField.setEditable(false);
        courseNameJTextField.setFont(new java.awt.Font("Tahoma", 0, 18));
        courseNameJTextField.setToolTipText("Course Name");

        courseNumberJLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        courseNumberJLabel.setText("Course Number:");

        courseNumberJTextField.setEditable(false);
        courseNumberJTextField.setFont(new java.awt.Font("Tahoma", 0, 18));
        courseNumberJTextField.setToolTipText("Course Number");

        creditJLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        creditJLabel.setText("Credits:");

        creditJTextField.setEditable(false);
        creditJTextField.setFont(new java.awt.Font("Tahoma", 0, 18));
        creditJTextField.setToolTipText("Course Credit");

        sectionJLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        sectionJLabel.setText("Section:");

        sectionJTextField.setEditable(false);
        sectionJTextField.setFont(new java.awt.Font("Tahoma", 0, 18));
        sectionJTextField.setToolTipText("Course Section");

        addCourseButton.setText("Add Course");
        addCourseButton.setToolTipText("Add new course");
        addCourseButton.setEnabled(false);
        addCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseButtonActionPerformed(evt);
            }
        });

        courseJList.setFont(new java.awt.Font("Courier New", 0, 13));
        courseJList.setToolTipText("Course List");
        courseJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                courseJListValueChanged(evt);
            }
        });
        courseJScrollPane.setViewportView(courseJList);

        deleteCourseJButton.setText("Delete Course");
        deleteCourseJButton.setToolTipText("Delete selected course");
        deleteCourseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCourseJButtonActionPerformed(evt);
            }
        });

        midJLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        midJLabel.setText("Midterm:");

        midJTextField.setEditable(false);
        midJTextField.setFont(new java.awt.Font("Tahoma", 0, 18));
        midJTextField.setToolTipText("Midterm Score");

        fiJLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        fiJLabel.setText("Final:");

        fiJTextField.setEditable(false);
        fiJTextField.setFont(new java.awt.Font("Tahoma", 0, 18));
        fiJTextField.setToolTipText("Final Score");

        finalAddCourseJButton.setText("Add Course");
        finalAddCourseJButton.setToolTipText("Add new course");
        finalAddCourseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalAddCourseJButtonActionPerformed(evt);
            }
        });

        cancelAddCourseJButton.setText("Cancel");
        cancelAddCourseJButton.setToolTipText("Cancel Adding Course");
        cancelAddCourseJButton.setEnabled(false);
        cancelAddCourseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddCourseJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Course");

        jLabel2.setText("Number");

        jLabel3.setText("Credits");

        jLabel4.setText("Section");

        jLabel5.setText("Midterm");

        jLabel6.setText("Final");

        jLabel7.setText("Average");

        finalEditCourseJButton.setText("Edit Course");
        finalEditCourseJButton.setToolTipText("Edit existing course");
        finalEditCourseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalEditCourseJButtonActionPerformed(evt);
            }
        });

        editCourseJButton.setText("Save Course");
        editCourseJButton.setToolTipText("Save edited information");
        editCourseJButton.setEnabled(false);
        editCourseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCourseJButtonActionPerformed(evt);
            }
        });

        cancelEditCourseJButton.setText("Cancel");
        cancelEditCourseJButton.setToolTipText("Cancel Deleting Course");
        cancelEditCourseJButton.setEnabled(false);
        cancelEditCourseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelEditCourseJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coursesJPanelLayout = new javax.swing.GroupLayout(coursesJPanel);
        coursesJPanel.setLayout(coursesJPanelLayout);
        coursesJPanelLayout.setHorizontalGroup(
            coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursesJPanelLayout.createSequentialGroup()
                .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursesJPanelLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(courseJLabel))
                    .addGroup(coursesJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(coursesJPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel6)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel7))
                            .addGroup(coursesJPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(coursesJPanelLayout.createSequentialGroup()
                                        .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, coursesJPanelLayout.createSequentialGroup()
                                                .addComponent(courseNameJLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(courseNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(coursesJPanelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(creditJLabel)
                                                    .addComponent(midJLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(midJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(creditJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(coursesJPanelLayout.createSequentialGroup()
                                                .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(sectionJLabel)
                                                    .addComponent(courseNumberJLabel))
                                                .addGap(6, 6, 6)
                                                .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(courseNumberJTextField)
                                                    .addComponent(sectionJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(coursesJPanelLayout.createSequentialGroup()
                                                .addComponent(fiJLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fiJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(coursesJPanelLayout.createSequentialGroup()
                                        .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(editCourseJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(addCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(12, 12, 12)
                                        .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(finalAddCourseJButton)
                                            .addComponent(finalEditCourseJButton))
                                        .addGap(18, 18, 18)
                                        .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cancelEditCourseJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cancelAddCourseJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(deleteCourseJButton))))))
                    .addGroup(coursesJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(courseJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        coursesJPanelLayout.setVerticalGroup(
            coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursesJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(coursesJPanelLayout.createSequentialGroup()
                        .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courseNameJLabel)
                            .addComponent(courseNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(creditJLabel)
                            .addComponent(creditJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(midJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(midJLabel)))
                    .addGroup(coursesJPanelLayout.createSequentialGroup()
                        .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courseNumberJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseNumberJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sectionJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sectionJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fiJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fiJLabel))))
                .addGap(18, 18, 18)
                .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(finalAddCourseJButton)
                    .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelAddCourseJButton)
                        .addComponent(deleteCourseJButton))
                    .addComponent(addCourseButton))
                .addGap(18, 18, 18)
                .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCourseJButton)
                    .addComponent(finalEditCourseJButton)
                    .addComponent(cancelEditCourseJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(courseJLabel)
                .addGap(18, 18, 18)
                .addGroup(coursesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttonJPanel.setBackground(new java.awt.Color(204, 204, 255));

        firstJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        firstJButton.setMnemonic('F');
        firstJButton.setText("First");
        firstJButton.setToolTipText("Go to first student ");
        firstJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstJButtonActionPerformed(evt);
            }
        });

        previousJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        previousJButton.setMnemonic('P');
        previousJButton.setText("Previous");
        previousJButton.setToolTipText("Go previous one student");
        previousJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousJButtonActionPerformed(evt);
            }
        });

        nextJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        nextJButton.setMnemonic('N');
        nextJButton.setText("Next");
        nextJButton.setToolTipText("Go next one student");
        nextJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextJButtonActionPerformed(evt);
            }
        });

        lastJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        lastJButton.setMnemonic('L');
        lastJButton.setText("Last");
        lastJButton.setToolTipText("Go to last student");
        lastJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastJButtonActionPerformed(evt);
            }
        });

        exitJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        exitJButton.setMnemonic('X');
        exitJButton.setText("Exit");
        exitJButton.setToolTipText("Quit the program");
        exitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJButtonActionPerformed(evt);
            }
        });

        printJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        printJButton.setMnemonic('I');
        printJButton.setText("Print");
        printJButton.setToolTipText("Print the form");
        printJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJButtonActionPerformed(evt);
            }
        });

        clearJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        clearJButton.setMnemonic('R');
        clearJButton.setText("Clear");
        clearJButton.setToolTipText("Clear stundent name fileds and SID when in editing mode");
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });

        editJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        editJButton.setMnemonic('E');
        editJButton.setText("Edit");
        editJButton.setToolTipText("Edit student information");
        editJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJButtonActionPerformed(evt);
            }
        });

        addJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        addJButton.setMnemonic('D');
        addJButton.setText("Add");
        addJButton.setToolTipText("Add new student");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        deleteJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        deleteJButton.setMnemonic('T');
        deleteJButton.setText("Delete");
        deleteJButton.setToolTipText("Delete selectec student");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });

        updateJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        updateJButton.setMnemonic('U');
        updateJButton.setText("Update student's information");
        updateJButton.setEnabled(false);
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });

        cancelJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        cancelJButton.setText("Cancel");
        cancelJButton.setToolTipText("Cancel editing student");
        cancelJButton.setEnabled(false);
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });

        finalAddJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        finalAddJButton.setMnemonic('S');
        finalAddJButton.setText("Save");
        finalAddJButton.setToolTipText("Add new student");
        finalAddJButton.setEnabled(false);
        finalAddJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalAddJButtonActionPerformed(evt);
            }
        });

        cancelAddJButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        cancelAddJButton.setText("Cancel");
        cancelAddJButton.setToolTipText("Cancel adding student");
        cancelAddJButton.setEnabled(false);
        cancelAddJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonJPanelLayout = new javax.swing.GroupLayout(buttonJPanel);
        buttonJPanel.setLayout(buttonJPanelLayout);
        buttonJPanelLayout.setHorizontalGroup(
            buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buttonJPanelLayout.createSequentialGroup()
                        .addComponent(printJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(buttonJPanelLayout.createSequentialGroup()
                                .addComponent(updateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(finalAddJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelAddJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(buttonJPanelLayout.createSequentialGroup()
                                .addComponent(clearJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(buttonJPanelLayout.createSequentialGroup()
                        .addComponent(firstJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previousJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        buttonJPanelLayout.setVerticalGroup(
            buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearJButton)
                    .addComponent(editJButton)
                    .addComponent(addJButton)
                    .addComponent(deleteJButton)
                    .addComponent(printJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateJButton)
                    .addComponent(cancelJButton)
                    .addComponent(finalAddJButton)
                    .addComponent(cancelAddJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousJButton)
                    .addComponent(nextJButton)
                    .addComponent(lastJButton)
                    .addComponent(exitJButton)
                    .addComponent(firstJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        studentsJPanel.setBackground(new java.awt.Color(204, 204, 255));

        studentJList.setToolTipText("Student List");
        studentJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                studentJListValueChanged(evt);
            }
        });
        studentJScrollPane.setViewportView(studentJList);

        listJLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        listJLabel.setText("Students List");

        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentGrades/logo.jpg"))); // NOI18N
        logoJLabel.setToolTipText("logo");

        javax.swing.GroupLayout studentsJPanelLayout = new javax.swing.GroupLayout(studentsJPanel);
        studentsJPanel.setLayout(studentsJPanelLayout);
        studentsJPanelLayout.setHorizontalGroup(
            studentsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsJPanelLayout.createSequentialGroup()
                .addGroup(studentsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentsJPanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(listJLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentsJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                    .addGroup(studentsJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(studentJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        studentsJPanelLayout.setVerticalGroup(
            studentsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout studentGradesJPanelLayout = new javax.swing.GroupLayout(studentGradesJPanel);
        studentGradesJPanel.setLayout(studentGradesJPanelLayout);
        studentGradesJPanelLayout.setHorizontalGroup(
            studentGradesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentGradesJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(studentGradesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coursesJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(312, 312, 312))
        );
        studentGradesJPanelLayout.setVerticalGroup(
            studentGradesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentGradesJPanelLayout.createSequentialGroup()
                .addGroup(studentGradesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(studentsJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, studentGradesJPanelLayout.createSequentialGroup()
                        .addComponent(infoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coursesJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");

        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("Clear student name and ID when in editing mode");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print");
        printJMenuItem.setToolTipText("Print the whole form");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);
        fileJMenu.add(jSeparator);

        exitJMenuItem.setMnemonic('Q');
        exitJMenuItem.setText("Quit");
        exitJMenuItem.setToolTipText("Exit the program");
        exitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(exitJMenuItem);

        studentGradesJMenuBar.add(fileJMenu);

        actionJMenu.setMnemonic('A');
        actionJMenu.setText("Action");

        addJMenuItem.setMnemonic('A');
        addJMenuItem.setText("Add New Student");
        addJMenuItem.setToolTipText("Add new student");
        addJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(addJMenuItem);

        editJMenuItem.setMnemonic('E');
        editJMenuItem.setText("Edit");
        editJMenuItem.setToolTipText("Edit existing student");
        editJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(editJMenuItem);

        deleteJMenuItem.setMnemonic('D');
        deleteJMenuItem.setText("Delete Students");
        deleteJMenuItem.setToolTipText("Delete selected student");
        deleteJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJMenuItemActionPerformed1(evt);
            }
        });
        actionJMenu.add(deleteJMenuItem);

        studentGradesJMenuBar.add(actionJMenu);

        navigateJMenu.setMnemonic('A');
        navigateJMenu.setText("Navigate");

        searchJMenuItem.setMnemonic('S');
        searchJMenuItem.setText("Search Students");
        searchJMenuItem.setToolTipText("Search student by first name");
        searchJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJMenuItemActionPerformed(evt);
            }
        });
        navigateJMenu.add(searchJMenuItem);

        firstJMenuItem.setMnemonic('F');
        firstJMenuItem.setText("Go First");
        firstJMenuItem.setToolTipText("Go to first student");
        firstJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstJMenuItemActionPerformed(evt);
            }
        });
        navigateJMenu.add(firstJMenuItem);

        previousJMenuItem.setMnemonic('P');
        previousJMenuItem.setText("Go Previous");
        previousJMenuItem.setToolTipText("Go previous one student");
        previousJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousJMenuItemActionPerformed(evt);
            }
        });
        navigateJMenu.add(previousJMenuItem);

        nextJMenuItem.setMnemonic('N');
        nextJMenuItem.setText("Go Next");
        nextJMenuItem.setToolTipText("Go next one student");
        nextJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextJMenuItemActionPerformed(evt);
            }
        });
        navigateJMenu.add(nextJMenuItem);

        lastJMenuItem.setMnemonic('L');
        lastJMenuItem.setText("Go Last");
        lastJMenuItem.setToolTipText("Go to the last student");
        lastJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastJMenuItemActionPerformed(evt);
            }
        });
        navigateJMenu.add(lastJMenuItem);

        studentGradesJMenuBar.add(navigateJMenu);

        jMenu1.setMnemonic('S');
        jMenu1.setText("Sort");

        buttonGroup.add(byFirstNameJRadioButtonMenuItem);
        byFirstNameJRadioButtonMenuItem.setMnemonic('F');
        byFirstNameJRadioButtonMenuItem.setText("by First Name");
        byFirstNameJRadioButtonMenuItem.setToolTipText("Sort by First Name");
        byFirstNameJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byFirstNameJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(byFirstNameJRadioButtonMenuItem);

        buttonGroup.add(byLastNameJRadioButtonMenuItem);
        byLastNameJRadioButtonMenuItem.setMnemonic('L');
        byLastNameJRadioButtonMenuItem.setSelected(true);
        byLastNameJRadioButtonMenuItem.setText("by Last Name");
        byLastNameJRadioButtonMenuItem.setToolTipText("Sort by Last Name");
        byLastNameJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byLastNameJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(byLastNameJRadioButtonMenuItem);

        studentGradesJMenuBar.add(jMenu1);

        helpJMenu.setMnemonic('H');
        helpJMenu.setText("Help");

        aboutJMenuItem.setMnemonic('B');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.setToolTipText("About Form");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        studentGradesJMenuBar.add(helpJMenu);

        setJMenuBar(studentGradesJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentGradesJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentGradesJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void byFirstNameJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byFirstNameJRadioButtonMenuItemActionPerformed
        // display the player and sort by First Name
        displayStudents();
    }//GEN-LAST:event_byFirstNameJRadioButtonMenuItemActionPerformed

    private void byLastNameJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byLastNameJRadioButtonMenuItemActionPerformed
        // display the player and sort by Last Name
        displayStudents();
    }//GEN-LAST:event_byLastNameJRadioButtonMenuItemActionPerformed

    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJButtonActionPerformed
        // Quit the program
        int quit = JOptionPane.showConfirmDialog(null,"Are you Sure?", "Quit Program?",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if(quit == 0)
        {
        System.exit(0);
        }
    }//GEN-LAST:event_exitJButtonActionPerformed

    // Display member data dynamic when chaging value
    private void studentJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_studentJListValueChanged
        //display member data dynamic
        int index = (studentJList.getSelectedIndex());
        if (index == -1)
            index = 0;
        showPlayerData(index);
        
        showCourseData(index);

        courseJList.setSelectedIndex(0);
                                
    }//GEN-LAST:event_studentJListValueChanged

    /**
     * Method: showPlayerData
     * when calling it, this method displays student's info, firstname, lastname, and sid, to JTextField
     * @parem int index
     * @return void
     */
    private void showPlayerData(int index)
    {
        firstNameJTextField.setText(student.get(index).getFirstName());
        lastNameJTextField.setText(student.get(index).getLastName());
        sidJTextField.setText(String.valueOf(student.get(index).getStudentID()));
    }

    /**
     * Method: showCourseData
     * when calling it, this method displays course's info, subject, number, section, and credit, to JList for courses
     * @parem int index
     * @return void
     */
    private void showCourseData(int index)
    {
      
        course.clear();
                       
        courseJList.removeAll();
      
        readCourseFile(courseFileName(index));
        displayCourses();
    }

    /**
     * Method: searchJMenuItemActionPerformed
     * This finds what you want to see through binarySearch()
     * @parem java.awt.event.ActionEvent evt
     * @return void
     * @see displayStudents()
     * @see binarySearch()
     */
    private void searchJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJMenuItemActionPerformed
        //Try-Catch block to prevent crashes when canceling search.
        try
        {
        // Find student via binary search
        String studentName = JOptionPane.showInputDialog("Enter the first name of student");

        //Sort the JList of student last name by last name
         byLastNameJRadioButtonMenuItem.setSelected(true);
         displayStudents();

         //Create a String array of member names
         String[] studentArray = new String[student.size()];
         for (int i = 0; i < studentArray.length; i++)
             studentArray[i] = student.get(i).getFirstName();

         //Find index of student
         int index = binarySearch(studentArray, studentName);

         if (index == -1)
         {
             JOptionPane.showMessageDialog(null, studentName + " not Found", "Search Result",
                    JOptionPane.WARNING_MESSAGE);
             studentJList.setSelectedIndex(0);
         }
         else
            studentJList.setSelectedIndex(index);
        }
        catch (NullPointerException nullex)
        {
            studentJList.requestFocus();
            studentJList.setSelectedIndex(0);
        }
    }//GEN-LAST:event_searchJMenuItemActionPerformed

    // Enable and disable appropriate buttons
    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        
        studentJList.setEnabled(false);
        firstNameJTextField.setEditable(true);
        lastNameJTextField.setEditable(true);
        sidJTextField.setEditable(true);
        finalAddJButton.setEnabled(true);
        addJButton.setEnabled(false);
        deleteJButton.setEnabled(false);
        editJButton.setEnabled(false);
        finalAddJButton.setEnabled(true);
        finalAddJButton.setVisible(true);
        cancelAddJButton.setEnabled(true);
        cancelAddJButton.setVisible(true);
        clearJMenuItem.setEnabled(true);
        clearJButton.setEnabled(true);
        byFirstNameJRadioButtonMenuItem.setEnabled(false);
        byLastNameJRadioButtonMenuItem.setEnabled(false);
        addJMenuItem.setEnabled(false);
        editJMenuItem.setEnabled(false);
        deleteJMenuItem.setEnabled(false);
        searchJMenuItem.setEnabled(false);
        firstJButton.setEnabled(false);
        lastJButton.setEnabled(false);
        previousJButton.setEnabled(false);
        nextJButton.setEnabled(false);        
        firstJMenuItem.setEnabled(false);
        lastJMenuItem.setEnabled(false);
        previousJMenuItem.setEnabled(false);
        nextJMenuItem.setEnabled(false);
        deleteCourseJButton.setEnabled(false);
        finalAddCourseJButton.setEnabled(false);

        finalEditCourseJButton.setEnabled(false);
        clearCourseField();

        firstNameJTextField.requestFocus();
        clearJMenuItemActionPerformed(evt);


    }//GEN-LAST:event_addJButtonActionPerformed

    // When calling it, makes three info, firstname, lastname, and sid, clear
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        // Call clear button
        clearJButtonActionPerformed(evt);
    }//GEN-LAST:event_clearJMenuItemActionPerformed

    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJButtonActionPerformed
        //Clear all Fields of student
        firstNameJTextField.setText("");
        lastNameJTextField.setText("");
        sidJTextField.setText("");
        
    }//GEN-LAST:event_clearJButtonActionPerformed

    // quit this program
    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJMenuItemActionPerformed
        // Call exit button
        exitJButtonActionPerformed(evt);
    }//GEN-LAST:event_exitJMenuItemActionPerformed
    // Enable and disable appropriate buttons
    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJButtonActionPerformed
        
        studentJList.setEnabled(false);
        firstNameJTextField.setEditable(true);
        lastNameJTextField.setEditable(true);
        sidJTextField.setEditable(true);
        addJButton.setEnabled(false);
        deleteJButton.setEnabled(false);
        updateJButton.setEnabled(true);
        updateJButton.setVisible(true);
        cancelJButton.setEnabled(true);
        cancelJButton.setVisible(true);
        editJButton.setEnabled(false);
        clearJMenuItem.setEnabled(true);
        editJMenuItem.setEnabled(false);
        byFirstNameJRadioButtonMenuItem.setEnabled(false);
        byLastNameJRadioButtonMenuItem.setEnabled(false);
        addJMenuItem.setEnabled(false);
        deleteJMenuItem.setEnabled(false);
        searchJMenuItem.setEnabled(false);
        firstJButton.setEnabled(false);
        lastJButton.setEnabled(false);
        previousJButton.setEnabled(false);
        nextJButton.setEnabled(false);
        firstJMenuItem.setEnabled(false);
        lastJMenuItem.setEnabled(false);
        previousJMenuItem.setEnabled(false);
        nextJMenuItem.setEnabled(false);
        deleteCourseJButton.setEnabled(false);
        finalAddCourseJButton.setEnabled(false);
        finalEditCourseJButton.setEnabled(false);
        clearCourseField();
        firstNameJTextField.requestFocus();
        firstNameJTextField.selectAll();
    }//GEN-LAST:event_editJButtonActionPerformed

    private void deleteJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJMenuItemActionPerformed
        // call the delete button
        deleteJButtonActionPerformed(evt);
    }//GEN-LAST:event_deleteJMenuItemActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // delete student
        // delete the selected player
        int result = JOptionPane.showConfirmDialog(null,"Are you Sure To Delete This Student?", "Delete Selected Student",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if(result == 0) //delete selected student
        {
            int index = studentJList.getSelectedIndex();

            //delete the external file that keep student's courses
            File f = new File(courseFileName(index));
            f.delete();
            
            student.remove(index);
            displayStudents();
            saveStudents();
            
        }
    }//GEN-LAST:event_deleteJButtonActionPerformed

    /**
     * Method: updateJButtonActionPerformed
     * Description : This method is to update student's data with firstname, lastname, and sid.
     * @parem file: java.awt.event.ActionEvent evt
     * @return void
     * pre-condition: The three data, f&l name and sid, must be filled in JButton
     * post-condition: After updating it, the file is saved on StudentGrades.database again
     * @see PrintWriter
     * @see FileOutputStream
     */
    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed
        // update new information
        int INDEX = studentJList.getSelectedIndex();
        String tempName = student.get(INDEX).getFirstName();
        String tName = firstNameJTextField.getText();
        boolean sameFirstName = tempName.equals(tName);
        if(!sameFirstName);
        {
            

            //delete the external file that keep student's courses
            File f = new File(courseFileName(INDEX));
            File f2 = new File("src/StudentGrades/database/" + tName + "Courses.txt");

            f.renameTo(f2);
            
            
        }

        // try-catch block to prevent inapropriate input
        try
        {
            // Save Info
            String fName = firstNameJTextField.getText();
            if (firstNameJTextField.getText().equals(""))
                throw new NullPointerException();

            String lName = lastNameJTextField.getText();
            if (lastNameJTextField.getText().equals(""))
                throw new NullPointerException();

            int id = Integer.parseInt(sidJTextField.getText().toString());
            if (sidJTextField.getText().equals(""))
                throw new NullPointerException();

            if (id < 0 || id > 999999999)
                throw new NumberFormatException();
            
            int index = studentJList.getSelectedIndex();

            //create new student and add it to the JList
              Student newStudent = new Student(fName, lName, id);

            if(!memberExists(newStudent))
            {
                student.set(index, newStudent);
                displayStudents();
                saveStudents();
            }
              else
                JOptionPane.showMessageDialog(null, "Cannot edit because there's an "
                        + "existing student in the database", "Input Error",
                        JOptionPane.WARNING_MESSAGE);

            updateJButton.setVisible(false);
            cancelJButton.setVisible(false);
            addJButton.setEnabled(true);
            deleteJButton.setEnabled(true);
            updateJButton.setEnabled(false);
            cancelJButton.setEnabled(false);
            editJButton.setEnabled(true);
            studentJList.setEnabled(true);
            firstNameJTextField.setEditable(false);
            lastNameJTextField.setEditable(false);
            sidJTextField.setEditable(false);
            clearJMenuItem.setEnabled(false);
            byFirstNameJRadioButtonMenuItem.setEnabled(true);
            byLastNameJRadioButtonMenuItem.setEnabled(true);
            editJMenuItem.setEnabled(true);
            addJMenuItem.setEnabled(true);
            deleteJMenuItem.setEnabled(true);
            searchJMenuItem.setEnabled(true);
            firstJButton.setEnabled(true);
            lastJButton.setEnabled(true);
            previousJButton.setEnabled(true);
            nextJButton.setEnabled(true);
            firstJMenuItem.setEnabled(true);
            lastJMenuItem.setEnabled(true);
            previousJMenuItem.setEnabled(true);
            nextJMenuItem.setEnabled(true);
            deleteCourseJButton.setEnabled(true);
            finalAddCourseJButton.setEnabled(true);
            finalEditCourseJButton.setEnabled(true);
            studentJList.requestFocus();
            studentJList.setSelectedIndex(1);
            studentJList.setSelectedIndex(0);
        }
        catch (NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null, "Please input appropriate input in all fields!"
                     ,"Input Error",JOptionPane.WARNING_MESSAGE);
           editJButtonActionPerformed(evt);
            //studentJList.setSelectedIndex(1);
            //studentJList.setSelectedIndex(0);
        }
        catch(NumberFormatException nume)
        {
            JOptionPane.showMessageDialog(null, "Please input number only for student ID. Student ID can't be larger than 9 digits.",
                    "Input Error", JOptionPane.INFORMATION_MESSAGE );
            editJButtonActionPerformed(evt);
            //studentJList.setSelectedIndex(1);
            //studentJList.setSelectedIndex(0);
        }






            
    }//GEN-LAST:event_updateJButtonActionPerformed

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        // Cancel editing
            updateJButton.setVisible(false);
            cancelJButton.setVisible(false);
            addJButton.setEnabled(true);
            deleteJButton.setEnabled(true);
            updateJButton.setEnabled(false);
            cancelJButton.setEnabled(false);
            editJButton.setEnabled(true);
            studentJList.setEnabled(true);
            firstNameJTextField.setEditable(false);
            lastNameJTextField.setEditable(false);
            sidJTextField.setEditable(false);
            clearJMenuItem.setEnabled(false);            
            byLastNameJRadioButtonMenuItem.setEnabled(true);
            byFirstNameJRadioButtonMenuItem.setEnabled(true);
            editJMenuItem.setEnabled(true);
            addJMenuItem.setEnabled(true);
            deleteJMenuItem.setEnabled(true);
            searchJMenuItem.setEnabled(true);
            firstJButton.setEnabled(true);
            lastJButton.setEnabled(true);
            previousJButton.setEnabled(true);
            nextJButton.setEnabled(true);
            firstJMenuItem.setEnabled(true);
            lastJMenuItem.setEnabled(true);
            previousJMenuItem.setEnabled(true);
            nextJMenuItem.setEnabled(true);
            deleteCourseJButton.setEnabled(true);
            finalAddCourseJButton.setEnabled(true);
            finalEditCourseJButton.setEnabled(true);
            studentJList.requestFocus();
            studentJList.setSelectedIndex(1);
            studentJList.setSelectedIndex(0);
    }//GEN-LAST:event_cancelJButtonActionPerformed

    private void editJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJMenuItemActionPerformed
        // Call edit button
        editJButtonActionPerformed(evt);
    }//GEN-LAST:event_editJMenuItemActionPerformed

    private void deleteJMenuItemActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJMenuItemActionPerformed1
        // Call delete button
        deleteJButtonActionPerformed(evt);
    }//GEN-LAST:event_deleteJMenuItemActionPerformed1

    private void cancelAddJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddJButtonActionPerformed
        // Cancel Adding New Member
        studentJList.setEnabled(true);
        firstNameJTextField.setEditable(false);
        lastNameJTextField.setEditable(false);
        sidJTextField.setEditable(false);
        addJButton.setEnabled(true);
        deleteJButton.setEnabled(true);
        editJButton.setEnabled(true);
        finalAddJButton.setEnabled(false);
        finalAddJButton.setVisible(false);
        cancelAddJButton.setEnabled(false);
        cancelAddJButton.setVisible(false);
        clearJMenuItem.setEnabled(false);
        byLastNameJRadioButtonMenuItem.setEnabled(true);
        byFirstNameJRadioButtonMenuItem.setEnabled(true);
        editJMenuItem.setEnabled(true);
        addJMenuItem.setEnabled(true);
        deleteJMenuItem.setEnabled(true);
        searchJMenuItem.setEnabled(true);
        firstJButton.setEnabled(true);
        lastJButton.setEnabled(true);
        previousJButton.setEnabled(true);
        nextJButton.setEnabled(true);
        firstJMenuItem.setEnabled(true);
        lastJMenuItem.setEnabled(true);
        previousJMenuItem.setEnabled(true);
        nextJMenuItem.setEnabled(true);
        deleteCourseJButton.setEnabled(true);
        finalAddCourseJButton.setEnabled(true);
        finalEditCourseJButton.setEnabled(true);
        studentJList.requestFocus();
        studentJList.setSelectedIndex(1);
        studentJList.setSelectedIndex(0);
    }//GEN-LAST:event_cancelAddJButtonActionPerformed

    /**
     * Method: newTextFile
     * Description : This method is to make new Courses.txt
     * @parem file: nothing
     * @return void
     * pre-condition: The firstNameJTextField must include the data of firstname
     * post-condition: After making it, new file is saved on StudentGrades.database
     * @see PrintWriter
     * @see FileOutputStream
     */

    public void newTextFile()
    {
        PrintWriter outputStream = null;
        String in = firstNameJTextField.getText();
         try
        {
            
            outputStream = new PrintWriter(new FileOutputStream("src/StudentGrades/database/" + in +"Courses.txt"));
                        
        }
        catch(FileNotFoundException e)	   //thrown by FileOutputStream
        {
            System.out.println("Error opening file Out.txt.");
            System.exit(0);
        }

        outputStream.print("");
        outputStream.close();
    }

    /**
     * Method: finalAddJButtonActionPerformed
     * Description : This method is to add new student
     * @parem file: java.awt.event.ActionEvent evt
     * @return void
     * pre-condition: The data must be filled in JTextField(not null)
     * post-condition: After adding it, it displays the new data to JList
     * @see newTextFile
     * @see displayStudents
     * @see saveStudents
     */
    private void finalAddJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalAddJButtonActionPerformed
        newTextFile();
        //Add new member
        try
        {
            // get inputs
             String fName = firstNameJTextField.getText();
            if (firstNameJTextField.getText().equals(""))
                throw new NullPointerException();

            String lName = lastNameJTextField.getText();
            if (lastNameJTextField.getText().equals(""))
                throw new NullPointerException();

            int id = Integer.parseInt(sidJTextField.getText().toString());
            if (sidJTextField.getText().equals(""))
                throw new NullPointerException();

            if (id < 0 || id > 999999999)
                throw new NumberFormatException();

            

            //create new player and add it to the JList
              Student newStudent = new Student(fName, lName, id);
            if(!memberExists(newStudent))
            {
                student.add(newStudent);
                displayStudents();
                saveStudents();
            }


            else
                JOptionPane.showMessageDialog(null, "New student not added because there's an existing student in the database", "Input Error",
                        JOptionPane.WARNING_MESSAGE);

        studentJList.setEnabled(true);
        firstNameJTextField.setEditable(false);
        lastNameJTextField.setEditable(false);
        sidJTextField.setEditable(false);
        addJButton.setEnabled(true);
        deleteJButton.setEnabled(true);
        editJButton.setEnabled(true);
        finalAddJButton.setEnabled(false);
        finalAddJButton.setVisible(false);
        cancelAddJButton.setEnabled(false);
        cancelAddJButton.setVisible(false);
        clearJMenuItem.setEnabled(false);
        byFirstNameJRadioButtonMenuItem.setEnabled(true);
        byLastNameJRadioButtonMenuItem.setEnabled(true);
        editJMenuItem.setEnabled(true);
        addJMenuItem.setEnabled(true);
        deleteJMenuItem.setEnabled(true);
        searchJMenuItem.setEnabled(true);
        firstJButton.setEnabled(true);
        lastJButton.setEnabled(true);
        previousJButton.setEnabled(true);
        nextJButton.setEnabled(true);
        firstJMenuItem.setEnabled(true);
        lastJMenuItem.setEnabled(true);
        previousJMenuItem.setEnabled(true);
        nextJMenuItem.setEnabled(true);
        deleteCourseJButton.setEnabled(true);
        finalAddCourseJButton.setEnabled(true);
        finalEditCourseJButton.setEnabled(true);

        studentJList.requestFocus();
        }
        catch (NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null, "Student not Added! Please input appropriate input in all fields!"
                    , "Input Error",JOptionPane.WARNING_MESSAGE);
            addJButtonActionPerformed(evt);
            //studentJList.setSelectedIndex(1);
            //studentJList.setSelectedIndex(0);

        }
        catch(NumberFormatException nume)
        {
            JOptionPane.showMessageDialog(null, "Please input number only for student ID. Student ID can't be larger than 9 digits",
                    "Input Error", JOptionPane.INFORMATION_MESSAGE );
            addJButtonActionPerformed(evt);
            //studentJList.setSelectedIndex(1);
            //studentJList.setSelectedIndex(0);

        }

        
        

        
    }//GEN-LAST:event_finalAddJButtonActionPerformed

    private void nextJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextJButtonActionPerformed
        // Go to next student
        
        int index = studentJList.getSelectedIndex();
        studentJList.setSelectedIndex(index + 1);
    }//GEN-LAST:event_nextJButtonActionPerformed

    private void previousJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousJButtonActionPerformed
        // Go to previous student
        
        int index = studentJList.getSelectedIndex();
        studentJList.setSelectedIndex(index - 1);
    }//GEN-LAST:event_previousJButtonActionPerformed

    private void firstJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstJButtonActionPerformed
        // Go to first student
        
        studentJList.setSelectedIndex(0);
    }//GEN-LAST:event_firstJButtonActionPerformed

    private void lastJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastJButtonActionPerformed
        // Go to last student
        
        int index = studentJList.getLastVisibleIndex();
        studentJList.setSelectedIndex(index);
    }//GEN-LAST:event_lastJButtonActionPerformed

    private void addCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseButtonActionPerformed
        // add course to student List

        try
        {
            // get inputs
             String name = courseNameJTextField.getText();
            if (firstNameJTextField.getText().equals(""))
                throw new NullPointerException();

            String number = courseNumberJTextField.getText();
            if (lastNameJTextField.getText().equals(""))
                throw new NullPointerException();

            int credit = Integer.parseInt(creditJTextField.getText().toString());
            if (sidJTextField.getText().equals(""))
                throw new NullPointerException();

            String section = sectionJTextField.getText();
            if (lastNameJTextField.getText().equals(""))
                throw new NullPointerException();

            float mid = Float.parseFloat(midJTextField.getText().toString());
            if (midJTextField.getText().equals(""))
                throw new NullPointerException();

            float fi = Float.parseFloat(fiJTextField.getText().toString());
            if (fiJTextField.getText().equals(""))
                throw new NullPointerException();

            if (mid < 0 || mid > 100)
                    throw new NumberFormatException();

            if (fi < 0 || fi > 100)
                    throw new NumberFormatException();

            if (credit < 0)
                    throw new NumberFormatException();

            //create new player and add it to the JList
              Courses newCourse = new Courses(name,number,credit,section,mid,fi);
            if(!courseExists(newCourse))
            {
                course.add(newCourse);
                displayCourses();
                saveCourses();
            }
            else
                JOptionPane.showMessageDialog(null, "New course not added because there's an existing member in the database", "Input Error",
                        JOptionPane.WARNING_MESSAGE);

        courseNameJTextField.setEditable(false);
        courseNumberJTextField.setEditable(false);
        creditJTextField.setEditable(false);
        sectionJTextField.setEditable(false);
        midJTextField.setEditable(false);
        fiJTextField.setEditable(false);
        addCourseButton.setEnabled(false);
        addCourseButton.setVisible(false);
        cancelAddCourseJButton.setEnabled(false);
        cancelAddCourseJButton.setVisible(false);
        finalAddCourseJButton.setEnabled(true);
        finalAddCourseJButton.setVisible(true);
        courseJList.setEnabled(true);
        studentJList.setEnabled(true);
        deleteCourseJButton.setEnabled(true);
        deleteCourseJButton.setVisible(true);
        firstJButton.setEnabled(true);
        lastJButton.setEnabled(true);
        previousJButton.setEnabled(true);
        nextJButton.setEnabled(true);
        editJButton.setEnabled(true);
        addJButton.setEnabled(true);
        deleteJButton.setEnabled(true);
        firstJMenuItem.setEnabled(true);
        lastJMenuItem.setEnabled(true);
        previousJMenuItem.setEnabled(true);
        nextJMenuItem.setEnabled(true);
        editJMenuItem.setEnabled(true);
        addJMenuItem.setEnabled(true);
        deleteJMenuItem.setEnabled(true);
        searchJMenuItem.setEnabled(true);
        finalEditCourseJButton.setEnabled(true);
        finalEditCourseJButton.setVisible(true);
        byFirstNameJRadioButtonMenuItem.setEnabled(true);
        byLastNameJRadioButtonMenuItem.setEnabled(true);
        courseJList.requestFocus();


        courseJList.setSelectedIndex(1);
        courseJList.setSelectedIndex(0);
        }
        catch (NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null, "Course not Added! Please input appropriate input in all fields!"
                    , "Input Error", JOptionPane.WARNING_MESSAGE);
            
            courseJList.setSelectedIndex(1);
            courseJList.setSelectedIndex(0);
        }
        catch(NumberFormatException nume)
        {
            JOptionPane.showMessageDialog(null, "Please input number only for student credit, midterm, and final.\n"
                    + "         Midterm and Final scores must be in range [0 to 100]\n"
                    + "                           Credit must be larger than 0",
                    "Input Error", JOptionPane.INFORMATION_MESSAGE );
            
            cancelAddCourseJButtonActionPerformed(evt);
            courseJList.setSelectedIndex(1);
            courseJList.setSelectedIndex(0);
        }
    }//GEN-LAST:event_addCourseButtonActionPerformed

    private void deleteCourseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCourseJButtonActionPerformed
        // Delete Course
        // delete the selected player
        int result = JOptionPane.showConfirmDialog(null,"Are you Sure To Delete This Course?", "Delete Selected Course",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if(result == 0) //delete selected course
        {
            int index = courseJList.getSelectedIndex();
            course.remove(index);
            displayCourses();
            saveCourses();
        }
    }//GEN-LAST:event_deleteCourseJButtonActionPerformed

    private void finalAddCourseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalAddCourseJButtonActionPerformed
        // Enable buttons and Text Fields
        courseNameJTextField.setEditable(true);
        courseNumberJTextField.setEditable(true);
        creditJTextField.setEditable(true);
        sectionJTextField.setEditable(true);
        midJTextField.setEditable(true);
        fiJTextField.setEditable(true);
        addCourseButton.setEnabled(true);
        addCourseButton.setVisible(true);
        cancelAddCourseJButton.setEnabled(true);
        cancelAddCourseJButton.setVisible(true);
        finalAddCourseJButton.setEnabled(false);
        finalAddCourseJButton.setVisible(false);
        courseJList.setEnabled(false);
        studentJList.setEnabled(false);
        deleteCourseJButton.setEnabled(false);
        deleteCourseJButton.setVisible(false);
        finalEditCourseJButton.setEnabled(false);
        finalEditCourseJButton.setVisible(false);
        firstJButton.setEnabled(false);
        lastJButton.setEnabled(false);
        previousJButton.setEnabled(false);
        nextJButton.setEnabled(false);
        editJButton.setEnabled(false);
        addJButton.setEnabled(false);
        deleteJButton.setEnabled(false);
        firstJMenuItem.setEnabled(false);
        lastJMenuItem.setEnabled(false);
        previousJMenuItem.setEnabled(false);
        nextJMenuItem.setEnabled(false);
        editJMenuItem.setEnabled(false);
        addJMenuItem.setEnabled(false);
        deleteJMenuItem.setEnabled(false);
        searchJMenuItem.setEnabled(false);
        byFirstNameJRadioButtonMenuItem.setEnabled(false);
        byLastNameJRadioButtonMenuItem.setEnabled(false);

        courseNameJTextField.requestFocus();

        clearCourseField();
    }//GEN-LAST:event_finalAddCourseJButtonActionPerformed

    private void cancelAddCourseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddCourseJButtonActionPerformed
         // Enable buttons and Text Fields
        courseNameJTextField.setEditable(false);
        courseNumberJTextField.setEditable(false);
        creditJTextField.setEditable(false);
        sectionJTextField.setEditable(false);
        midJTextField.setEditable(false);
        fiJTextField.setEditable(false);
        addCourseButton.setEnabled(false);
        addCourseButton.setVisible(false);
        cancelAddCourseJButton.setEnabled(false);
        cancelAddCourseJButton.setVisible(false);
        finalAddCourseJButton.setEnabled(true);
        finalAddCourseJButton.setVisible(true);
        courseJList.setEnabled(true);
        studentJList.setEnabled(true);
        deleteCourseJButton.setEnabled(true);
        deleteCourseJButton.setVisible(true);
        finalEditCourseJButton.setEnabled(true);
        finalEditCourseJButton.setVisible(true);
        firstJButton.setEnabled(true);
        lastJButton.setEnabled(true);
        previousJButton.setEnabled(true);
        nextJButton.setEnabled(true);
        editJButton.setEnabled(true);
        addJButton.setEnabled(true);
        deleteJButton.setEnabled(true);
        firstJMenuItem.setEnabled(true);
        lastJMenuItem.setEnabled(true);
        previousJMenuItem.setEnabled(true);
        nextJMenuItem.setEnabled(true);
        editJMenuItem.setEnabled(true);
        addJMenuItem.setEnabled(true);
        deleteJMenuItem.setEnabled(true);
        searchJMenuItem.setEnabled(true);
        byFirstNameJRadioButtonMenuItem.setEnabled(true);
        byLastNameJRadioButtonMenuItem.setEnabled(true);
        courseJList.requestFocus();
        courseJList.setSelectedIndex(1);
        courseJList.setSelectedIndex(0);
        
    }//GEN-LAST:event_cancelAddCourseJButtonActionPerformed

    private void clearCourseField()
    {
        courseNameJTextField.setText("");
        courseNumberJTextField.setText("");
        creditJTextField.setText("");
        sectionJTextField.setText("");
        midJTextField.setText("");
        fiJTextField.setText("");
    }
    private void courseJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_courseJListValueChanged
        // Display the course information in JTextFields
        int index = courseJList.getSelectedIndex();
        if (index == -1)
            index = 0;
        displayCourseData(index);

    }//GEN-LAST:event_courseJListValueChanged

    private void firstJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstJMenuItemActionPerformed
        //cal fisrt button
        firstJButtonActionPerformed(evt);
    }//GEN-LAST:event_firstJMenuItemActionPerformed

    private void previousJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousJMenuItemActionPerformed
        //cal fisrt button
        previousJButtonActionPerformed(evt);
    }//GEN-LAST:event_previousJMenuItemActionPerformed

    private void nextJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextJMenuItemActionPerformed
        //cal fisrt button
        nextJButtonActionPerformed(evt);
    }//GEN-LAST:event_nextJMenuItemActionPerformed

    private void lastJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastJMenuItemActionPerformed
        //cal fisrt button
        lastJButtonActionPerformed(evt);
    }//GEN-LAST:event_lastJMenuItemActionPerformed

    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        // show the about form
        AboutForm myAboutForm = new AboutForm();

                // Center form
                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screen.width - myAboutForm.getWidth())/2;
                int y = (screen.height - myAboutForm.getHeight())/2;
                myAboutForm.setBounds(x, y, myAboutForm.getWidth(), myAboutForm.getHeight());

                myAboutForm.setVisible(true);
                myAboutForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed

    private void addJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJMenuItemActionPerformed
        // Call Add Button
        addJButtonActionPerformed(evt);
    }//GEN-LAST:event_addJMenuItemActionPerformed

    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        // Call the Print Button
        printJButtonActionPerformed(evt);
    }//GEN-LAST:event_printJMenuItemActionPerformed

    private void printJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJButtonActionPerformed
         // Print the form
         //http://www.apl.jhu.edu/~hall/java/Swing-Tutorial/Swing-Tutorial-Printing.html
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJButtonActionPerformed

    private void finalEditCourseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalEditCourseJButtonActionPerformed
        // Enable buttons and Text Fields
        courseNameJTextField.setEditable(true);
        courseNumberJTextField.setEditable(true);
        creditJTextField.setEditable(true);
        sectionJTextField.setEditable(true);
        midJTextField.setEditable(true);
        fiJTextField.setEditable(true);
        editCourseJButton.setEnabled(true);
        editCourseJButton.setVisible(true);
        cancelEditCourseJButton.setEnabled(true);
        cancelEditCourseJButton.setVisible(true);
        finalEditCourseJButton.setEnabled(false);
        finalEditCourseJButton.setVisible(false);
        courseJList.setEnabled(false);
        studentJList.setEnabled(false);
        deleteCourseJButton.setEnabled(false);
        deleteCourseJButton.setVisible(false);
        finalAddCourseJButton.setEnabled(false);
        finalAddCourseJButton.setVisible(false);
        firstJButton.setEnabled(false);
        lastJButton.setEnabled(false);
        previousJButton.setEnabled(false);
        nextJButton.setEnabled(false);
        editJButton.setEnabled(false);
        addJButton.setEnabled(false);
        deleteJButton.setEnabled(false);
        firstJMenuItem.setEnabled(false);
        lastJMenuItem.setEnabled(false);
        previousJMenuItem.setEnabled(false);
        nextJMenuItem.setEnabled(false);
        editJMenuItem.setEnabled(false);
        addJMenuItem.setEnabled(false);
        deleteJMenuItem.setEnabled(false);
        searchJMenuItem.setEnabled(false);
        byFirstNameJRadioButtonMenuItem.setEnabled(false);
        byLastNameJRadioButtonMenuItem.setEnabled(false);

        courseNameJTextField.requestFocus();

        
    }//GEN-LAST:event_finalEditCourseJButtonActionPerformed

    private void cancelEditCourseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditCourseJButtonActionPerformed
        // Enable buttons and Text Fields
        courseNameJTextField.setEditable(false);
        courseNumberJTextField.setEditable(false);
        creditJTextField.setEditable(false);
        sectionJTextField.setEditable(false);
        midJTextField.setEditable(false);
        fiJTextField.setEditable(false);
        editCourseJButton.setEnabled(false);
        editCourseJButton.setVisible(false);
        cancelEditCourseJButton.setEnabled(false);
        cancelEditCourseJButton.setVisible(false);
        finalEditCourseJButton.setEnabled(true);
        finalEditCourseJButton.setVisible(true);
        courseJList.setEnabled(true);
        studentJList.setEnabled(true);
        deleteCourseJButton.setEnabled(true);
        deleteCourseJButton.setVisible(true);
        finalAddCourseJButton.setEnabled(true);
        finalAddCourseJButton.setVisible(true);
        firstJButton.setEnabled(true);
        lastJButton.setEnabled(true);
        previousJButton.setEnabled(true);
        nextJButton.setEnabled(true);
        editJButton.setEnabled(true);
        addJButton.setEnabled(true);
        deleteJButton.setEnabled(true);
        firstJMenuItem.setEnabled(true);
        lastJMenuItem.setEnabled(true);
        previousJMenuItem.setEnabled(true);
        nextJMenuItem.setEnabled(true);
        editJMenuItem.setEnabled(true);
        addJMenuItem.setEnabled(true);
        deleteJMenuItem.setEnabled(true);
        searchJMenuItem.setEnabled(true);
        byFirstNameJRadioButtonMenuItem.setEnabled(true);
        byLastNameJRadioButtonMenuItem.setEnabled(true);

        courseJList.setSelectedIndex(1);
        courseJList.setSelectedIndex(0);
        courseJList.requestFocus();
    }//GEN-LAST:event_cancelEditCourseJButtonActionPerformed

    private void editCourseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCourseJButtonActionPerformed
        // edit selected course
        try
        {
            // get inputs
             String name = courseNameJTextField.getText();
            if (firstNameJTextField.getText().equals(""))
                throw new NullPointerException();

            String number = courseNumberJTextField.getText();
            if (lastNameJTextField.getText().equals(""))
                throw new NullPointerException();

            int credit = Integer.parseInt(creditJTextField.getText().toString());
            if (sidJTextField.getText().equals(""))
                throw new NullPointerException();

            String section = sectionJTextField.getText();
            if (lastNameJTextField.getText().equals(""))
                throw new NullPointerException();

            float mid = Float.parseFloat(midJTextField.getText().toString());
            if (midJTextField.getText().equals(""))
                throw new NullPointerException();

            float fi = Float.parseFloat(fiJTextField.getText().toString());
            if (fiJTextField.getText().equals(""))
                throw new NullPointerException();

            if (mid < 0 || mid > 100)
                    throw new NumberFormatException();

            if (fi < 0 || fi > 100)
                    throw new NumberFormatException();

            if (credit < 0)
                    throw new NumberFormatException();

            int index = courseJList.getSelectedIndex();

            //create new player and add it to the JList
              Courses newCourse = new Courses(name,number,credit,section,mid,fi);
            if(!courseExists(newCourse))
            {
                course.set(index, newCourse);
                displayCourses();
                saveCourses();
            }
            else
                JOptionPane.showMessageDialog(null, "New course not edited because there's an existing course in the course list.", "Input Error",
                        JOptionPane.WARNING_MESSAGE);

        courseNameJTextField.setEditable(false);
        courseNumberJTextField.setEditable(false);
        creditJTextField.setEditable(false);
        sectionJTextField.setEditable(false);
        midJTextField.setEditable(false);
        fiJTextField.setEditable(false);
        editCourseJButton.setEnabled(false);
        editCourseJButton.setVisible(false);
        cancelEditCourseJButton.setEnabled(false);
        cancelEditCourseJButton.setVisible(false);
        finalEditCourseJButton.setEnabled(true);
        finalEditCourseJButton.setVisible(true);
        courseJList.setEnabled(true);
        studentJList.setEnabled(true);
        deleteCourseJButton.setEnabled(true);
        deleteCourseJButton.setVisible(true);
        finalAddCourseJButton.setEnabled(true);
        finalAddCourseJButton.setVisible(true);
        firstJButton.setEnabled(true);
        lastJButton.setEnabled(true);
        previousJButton.setEnabled(true);
        nextJButton.setEnabled(true);
        editJButton.setEnabled(true);
        addJButton.setEnabled(true);
        deleteJButton.setEnabled(true);
        firstJMenuItem.setEnabled(true);
        lastJMenuItem.setEnabled(true);
        previousJMenuItem.setEnabled(true);
        nextJMenuItem.setEnabled(true);
        editJMenuItem.setEnabled(true);
        addJMenuItem.setEnabled(true);
        deleteJMenuItem.setEnabled(true);
        searchJMenuItem.setEnabled(true);
        byFirstNameJRadioButtonMenuItem.setEnabled(true);
        byLastNameJRadioButtonMenuItem.setEnabled(true);

        courseJList.setSelectedIndex(1);
        courseJList.setSelectedIndex(0);
        courseJList.requestFocus();


        }
        catch (NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null, "Course not Added! Please input appropriate input in all fields!"
                    , "Input Error", JOptionPane.WARNING_MESSAGE);
            courseJList.setSelectedIndex(1);
            courseJList.setSelectedIndex(0);
        }
        catch(NumberFormatException nume)
        {
            JOptionPane.showMessageDialog(null, "Please input number only for student credit, midterm, and final.\n"
                    + "         Midterm and Final scores must be in range [0 to 100]\n"
                    + "                           Credit must be larger than 0",
                    "Input Error", JOptionPane.INFORMATION_MESSAGE );
            cancelAddCourseJButtonActionPerformed(evt);
            courseJList.setSelectedIndex(1);
            courseJList.setSelectedIndex(0);
        }
    }//GEN-LAST:event_editCourseJButtonActionPerformed

    /**
     * This displayCourseData method displays data with student's grades to JTextField
     * @param int index
     * @return
     */
    private void displayCourseData(int index)
    {   if(course.isEmpty())
            clearCourseField();
        else
        {
        courseNameJTextField.setText(course.get(index).getCourseName());
        courseNumberJTextField.setText(course.get(index).getCourseNumber());
        creditJTextField.setText(String.valueOf(course.get(index).getCourseCredit()));
        sectionJTextField.setText(course.get(index).getCourseSection());
        midJTextField.setText(String.valueOf(course.get(index).getMidtermScore()));
        fiJTextField.setText(String.valueOf(course.get(index).getFinalScore()));
        }
    }
    /**
     * This boolean method is used to check if there is an exits member or not
     * @param player
     * @return
     */
    private boolean memberExists(Student students)
    {
        boolean thereIsOne = false;
        for(int index = 0; index < student.size() && !thereIsOne; index++)
        {
            if (student.get(index).equals(students))
                thereIsOne = true;
        }
        return thereIsOne;
    }

    /**
     * This boolean method is used to check if there is an exits member or not
     * @param player
     * @return
     */
    private boolean courseExists(Courses courses)
    {
        boolean thereIsOne = false;
        for(int index = 0; index < course.size() && !thereIsOne; index++)
        {
            if (course.get(index).equals(courses))
                thereIsOne = true;
        }
        return thereIsOne;
    }

    /**
     * This method is used to write the member info into the .txt file
     */
    private void saveStudents()
    {
        try
        {
            writeToFile(fileName);
        }
        catch (IOException ex)
        {
            Logger.getLogger(StudentGrades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Method: saveStudents
     * Description : Save the selected data as a text through "writeToFile()"
     * @parem file: nothing
     * @return void
     * pre-condition: a valid student list
     * post-condition: a new text file is created with the current students
     * in the database
     * @see writeToFile
     */
    private void saveCourses()
    {
        try
        {
            int index = studentJList.getSelectedIndex();
            writeCourseToFile(courseFileName(index));
        }
        catch (IOException ex)
        {
            Logger.getLogger(StudentGrades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method: writeToFile
     * Write student to a text file that is comma delimited.
     * @parem file: String
     * @return void
     * pre-condition: a valid file name, students.txt is expected
     * post-condition: a new text file is created with the current student
     * in the database
     * @see WriteFile
     */
    private void writeToFile(String file) throws IOException
    {
        WriteFile wf = new WriteFile(file);
        for(int index = 0; index < student.size(); index++)
        {
            Student tempPlayer = student.get(index);
            String output = tempPlayer.getFirstName() + "," + tempPlayer.getLastName() +
                    "," + tempPlayer.getStudentID();
            wf.write(output);
        }
        wf.close();
    }

    /**
     * Method: writeToFile
     * Write course to a text file that is comma delimited.
     * @parem file: String
     * @return void
     * pre-condition: a valid file name, "lastname + Courses".txt is expected
     * post-condition: a new text file is created with the current courses
     * in the database
     * @see WriteFile
     */
    private void writeCourseToFile(String file) throws IOException
    {
        WriteFile wf = new WriteFile(file);
        for(int index = 0; index < course.size(); index++)
        {
            Courses tempCourse = course.get(index);
            String output = tempCourse.getCourseName() + "," + tempCourse.getCourseNumber() +
                    "," + tempCourse.getCourseCredit() + "," +
                    tempCourse.getCourseSection()+ "," + tempCourse.getMidtermScore() + "," +
                    tempCourse.getFinalScore();
            wf.write(output);
        }
        wf.close();
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {

        //Show Splash screen first for 4 second
            Splash mySplash = new Splash(4000);
            mySplash.showSplash();
            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                StudentGrades myStudentGrades = new StudentGrades();
                // Center form
                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screen.width - myStudentGrades.getWidth())/2;
                int y = (screen.height - myStudentGrades.getHeight())/2;
                myStudentGrades.setBounds(x, y, myStudentGrades.getWidth(), myStudentGrades.getHeight());

                myStudentGrades.setVisible(true);
                myStudentGrades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JMenu actionJMenu;
    private javax.swing.JButton addCourseButton;
    private javax.swing.JButton addJButton;
    private javax.swing.JMenuItem addJMenuItem;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JPanel buttonJPanel;
    private javax.swing.JRadioButtonMenuItem byFirstNameJRadioButtonMenuItem;
    private javax.swing.JRadioButtonMenuItem byLastNameJRadioButtonMenuItem;
    private javax.swing.JButton cancelAddCourseJButton;
    private javax.swing.JButton cancelAddJButton;
    private javax.swing.JButton cancelEditCourseJButton;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JLabel courseJLabel;
    private javax.swing.JList courseJList;
    private javax.swing.JScrollPane courseJScrollPane;
    private javax.swing.JLabel courseNameJLabel;
    private javax.swing.JTextField courseNameJTextField;
    private javax.swing.JLabel courseNumberJLabel;
    private javax.swing.JTextField courseNumberJTextField;
    private javax.swing.JPanel coursesJPanel;
    private javax.swing.JLabel creditJLabel;
    private javax.swing.JTextField creditJTextField;
    private javax.swing.JButton deleteCourseJButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JMenuItem deleteJMenuItem;
    private javax.swing.JButton editCourseJButton;
    private javax.swing.JButton editJButton;
    private javax.swing.JMenuItem editJMenuItem;
    private javax.swing.JButton exitJButton;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JLabel fiJLabel;
    private javax.swing.JTextField fiJTextField;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JButton finalAddCourseJButton;
    private javax.swing.JButton finalAddJButton;
    private javax.swing.JButton finalEditCourseJButton;
    private javax.swing.JButton firstJButton;
    private javax.swing.JMenuItem firstJMenuItem;
    private javax.swing.JLabel firstNameJLabel;
    private javax.swing.JTextField firstNameJTextField;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JPanel infoJPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator;
    private javax.swing.JButton lastJButton;
    private javax.swing.JMenuItem lastJMenuItem;
    private javax.swing.JLabel lastNameJLabel;
    private javax.swing.JTextField lastNameJTextField;
    private javax.swing.JLabel listJLabel;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JLabel midJLabel;
    private javax.swing.JTextField midJTextField;
    private javax.swing.JMenu navigateJMenu;
    private javax.swing.JButton nextJButton;
    private javax.swing.JMenuItem nextJMenuItem;
    private javax.swing.JButton previousJButton;
    private javax.swing.JMenuItem previousJMenuItem;
    private javax.swing.JButton printJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JMenuItem searchJMenuItem;
    private javax.swing.JLabel sectionJLabel;
    private javax.swing.JTextField sectionJTextField;
    private javax.swing.JLabel sidJLabel;
    private javax.swing.JTextField sidJTextField;
    private javax.swing.JMenuBar studentGradesJMenuBar;
    private javax.swing.JPanel studentGradesJPanel;
    private javax.swing.JList studentJList;
    private javax.swing.JScrollPane studentJScrollPane;
    private javax.swing.JPanel studentsJPanel;
    private javax.swing.JButton updateJButton;
    // End of variables declaration//GEN-END:variables

}
