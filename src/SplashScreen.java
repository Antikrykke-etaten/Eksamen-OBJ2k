import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SplashScreen extends JWindow {

    static boolean isRegistered;
    private static int count;
    private static Timer timer1;
    
    private JButton newProjectButn;
    
    private JButton oldProjectButn;

    public SplashScreen() {

        Container container = getContentPane();
        GridBagLayout gl = new GridBagLayout();
        container.setLayout(null);
        JPanel panel = new JPanel();
        panel.setBorder(new javax.swing.border.EtchedBorder());
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 10, 348, 150);
        panel.setLayout(null);
        container.add(panel);
        
       JLabel label = new JLabel("");
       
       ImageIcon splashIcon = new ImageIcon("C:\\Users\\Eirik\\Desktop\\Face.png");
       Image image = splashIcon.getImage(); 
       Image newimg = image.getScaledInstance(350, 150,  java.awt.Image.SCALE_SMOOTH); 
       splashIcon = new ImageIcon(newimg);
      
       label.setSize(350, 150);
       label.setIcon(new ImageIcon(newimg));
       label.setFont(new Font("Verdana", Font.BOLD, 14));
       panel.add(label);
       
     
        startCounter();
        setSize(370, 215);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startCounter() {
        ActionListener al = new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	count++;
                System.out.println(count);
                if (count == 50) {
                    new CardController();
                    setVisible(false);
                    timer1.stop();
                }
            }
        };
        timer1 = new Timer(50, al);
        timer1.start();
    }
};