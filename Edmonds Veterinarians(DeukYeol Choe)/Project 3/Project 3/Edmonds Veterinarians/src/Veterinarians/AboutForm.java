package Veterinarians;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: AboutForm
* File: AboutForm.java
* Description: Information form about this program
* @author: DeukYeol Choe & Khoa Dang
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 5/10/2011
* @version 6.0
* @see java.awt.Dimension;
* @see java.awt.Toolkit;
* @see javax.swing.JFrame;
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



public class AboutForm extends javax.swing.JFrame {

    /** Creates new form HelpMessage */
    public AboutForm() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icon.png"));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wholeJPanel = new javax.swing.JPanel();
        infoJPanel = new javax.swing.JPanel();
        addressJLabel = new javax.swing.JLabel();
        nameJLabel = new javax.swing.JLabel();
        phoneJLabel = new javax.swing.JLabel();
        collegeJLabel = new javax.swing.JLabel();
        instructorJLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        instructorJLabel1 = new javax.swing.JLabel();
        instructorJLabel2 = new javax.swing.JLabel();
        instructorJLabel3 = new javax.swing.JLabel();
        instructorJLabel4 = new javax.swing.JLabel();
        pictureJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Information");
        setResizable(false);

        wholeJPanel.setBackground(new java.awt.Color(255, 255, 255));

        infoJPanel.setBackground(new java.awt.Color(255, 255, 255));
        infoJPanel.setForeground(new java.awt.Color(0, 51, 255));

        addressJLabel.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        addressJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addressJLabel.setText("This program helps you calculate the invoice ");

        nameJLabel.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameJLabel.setText("Developers : Dray Choe & Khoa Dang ");

        phoneJLabel.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        phoneJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phoneJLabel.setText("of the pet clinic, display, print, and store the ");

        collegeJLabel.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
        collegeJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        collegeJLabel.setText("invoices in sepearate text file. It also shows ");

        instructorJLabel.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        instructorJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructorJLabel.setText("appropriate services for each kind of pet.");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("ENTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        instructorJLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        instructorJLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructorJLabel1.setText("This program is designed for pet clinics.");

        instructorJLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        instructorJLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructorJLabel2.setText("If you have any trouble with this program,");

        instructorJLabel3.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
        instructorJLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructorJLabel3.setText("please contact me at (425) 239-3746.");

        instructorJLabel4.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        instructorJLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructorJLabel4.setText("Version: 1.0");

        javax.swing.GroupLayout infoJPanelLayout = new javax.swing.GroupLayout(infoJPanel);
        infoJPanel.setLayout(infoJPanelLayout);
        infoJPanelLayout.setHorizontalGroup(
            infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoJPanelLayout.createSequentialGroup()
                .addGroup(infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(phoneJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(collegeJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(instructorJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))
                    .addGroup(infoJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(instructorJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                    .addGroup(infoJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(instructorJLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                    .addGroup(infoJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(instructorJLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                    .addGroup(infoJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(instructorJLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(nameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
            .addGroup(infoJPanelLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        infoJPanelLayout.setVerticalGroup(
            infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(collegeJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructorJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructorJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructorJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructorJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pictureJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/About.jpg"))); // NOI18N

        javax.swing.GroupLayout wholeJPanelLayout = new javax.swing.GroupLayout(wholeJPanel);
        wholeJPanel.setLayout(wholeJPanelLayout);
        wholeJPanelLayout.setHorizontalGroup(
            wholeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wholeJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        wholeJPanelLayout.setVerticalGroup(
            wholeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wholeJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wholeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wholeJPanelLayout.createSequentialGroup()
                        .addComponent(infoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(wholeJPanelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(pictureJLabel))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wholeJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wholeJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method: enterJButtonActionPerformed
     * Description : when clicking it, you can go back to main GUI program
     * @return void
     * pre-condition: nothing
     * post-condition: nothing
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        setVisible(false); // go back to main program
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressJLabel;
    private javax.swing.JLabel collegeJLabel;
    private javax.swing.JPanel infoJPanel;
    private javax.swing.JLabel instructorJLabel;
    private javax.swing.JLabel instructorJLabel1;
    private javax.swing.JLabel instructorJLabel2;
    private javax.swing.JLabel instructorJLabel3;
    private javax.swing.JLabel instructorJLabel4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JLabel phoneJLabel;
    private javax.swing.JLabel pictureJLabel;
    private javax.swing.JPanel wholeJPanel;
    // End of variables declaration//GEN-END:variables

}
