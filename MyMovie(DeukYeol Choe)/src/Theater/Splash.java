package Theater;

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
        content.setBackground(Color.lightGray);

        int width = 500;
        int height = 500;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width)/2;
        int y = (screen.height - height)/2;
        setBounds(x,y,width,height);

        JLabel label = new JLabel(new ImageIcon("src/splashImage.png"));
        JLabel copyrt = new JLabel("Copyright in Dray", JLabel.CENTER);

        copyrt.setFont(new Font("Copyright in Dray",Font.BOLD, 12));
        content.add(label,BorderLayout.CENTER);
        content.add(copyrt,BorderLayout.SOUTH);
        Color border = new Color(50,20,20,55);
        content.setBorder(BorderFactory.createLineBorder(border, 10));
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
