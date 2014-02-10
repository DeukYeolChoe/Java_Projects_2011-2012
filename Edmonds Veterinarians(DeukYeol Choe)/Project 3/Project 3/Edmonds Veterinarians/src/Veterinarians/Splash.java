package Veterinarians;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: Splash
* File: Splash.java
* Description: This class is making splash; showing special display before running its program
* @author: DeukYeol Choe & Khoa Dange
* Environment: PC, Windows 7, jdk 6.23, NetBeans 6.9.1
* Date: 5/10/2011
* @version 6.0
* @see java.awt.BorderLayout;
* @see java.awt.Color;
* @see java.awt.Dimension;
* @see java.awt.Font;
* @see java.awt.Toolkit;
* @see javax.swing.BorderFactory;
* @see javax.swing.ImageIcon;
* @see javax.swing.JLabel;
* @see javax.swing.JPanel;
* @see javax.swing.JWindow;
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class Splash extends JWindow
{
    private int duration;

    public Splash(int dur)
    {
        duration = dur;
    }

    public void showSplash()
    {
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.black);

        // Set the window's bounds, centering the window
        int width = 900;
        int height = 400;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);

        // Build the splash screen
        JLabel welcome = new JLabel("Edmonds Veterinarians", JLabel.CENTER);
        JLabel label = new JLabel(new ImageIcon("src/Splash.jpg"));
        JLabel copyrt = new JLabel
                ("Copyright 2011, Student Grades by Khoa Dang and Dray Choe", JLabel.CENTER);
        welcome.setFont(new Font("Segoe Print", Font.BOLD, 30));
        welcome.setForeground(Color.white);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 13));
        copyrt.setForeground(Color.white);
        content.add(welcome, BorderLayout.NORTH);
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color border = new Color(50, 20, 20,  55);
        content.setBorder(BorderFactory.createLineBorder(border, 10));

        // Display it
        setVisible(true);

        try
        {
            Thread.sleep(duration);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        setVisible(false);
    }
}
