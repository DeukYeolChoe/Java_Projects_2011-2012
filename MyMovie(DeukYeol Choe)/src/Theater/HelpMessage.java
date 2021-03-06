/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HelpMessage.java
 *
 * Created on Mar 8, 2011, 9:05:28 PM
 */

package Theater;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Dray
 */
public class HelpMessage extends javax.swing.JFrame {

    /** Creates new form HelpMessage */
    public HelpMessage() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pictureJLabel = new javax.swing.JLabel();
        infoJPanel = new javax.swing.JPanel();
        addressJLabel = new javax.swing.JLabel();
        nameJLabel = new javax.swing.JLabel();
        phoneJLabel = new javax.swing.JLabel();
        collegeJLabel = new javax.swing.JLabel();
        instructorJLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Information");
        setResizable(false);

        pictureJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/splashImage.png"))); // NOI18N

        infoJPanel.setBackground(new java.awt.Color(153, 153, 153));
        infoJPanel.setForeground(new java.awt.Color(0, 51, 255));

        addressJLabel.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
        addressJLabel.setText("Address : WA");

        nameJLabel.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
        nameJLabel.setText("Maker : Dray Choe");

        phoneJLabel.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
        phoneJLabel.setText("Phone : 206-445-XXXX");

        collegeJLabel.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
        collegeJLabel.setText("College: EDMOND CC");

        instructorJLabel.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        instructorJLabel.setText("Instructor : Niko");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("ENTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoJPanelLayout = new javax.swing.GroupLayout(infoJPanel);
        infoJPanel.setLayout(infoJPanelLayout);
        infoJPanelLayout.setHorizontalGroup(
            infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoJPanelLayout.createSequentialGroup()
                .addGroup(infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(addressJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(phoneJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(collegeJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(instructorJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                    .addGroup(infoJPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        infoJPanelLayout.setVerticalGroup(
            infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addressJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phoneJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(collegeJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(instructorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pictureJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
            .addComponent(infoJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HelpMessage myMoney = new HelpMessage();
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
    private javax.swing.JLabel addressJLabel;
    private javax.swing.JLabel collegeJLabel;
    private javax.swing.JPanel infoJPanel;
    private javax.swing.JLabel instructorJLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JLabel phoneJLabel;
    private javax.swing.JLabel pictureJLabel;
    // End of variables declaration//GEN-END:variables

}
