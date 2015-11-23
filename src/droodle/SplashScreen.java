package droodle;
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
    private static JProgressBar loadingBar = new JProgressBar();
    private static SplashScreen execute;
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
        
       JLabel label = new JLabel("Droodler incorporated!");
       
       ImageIcon splashIcon = new ImageIcon(new Configuration().assetsFolder + "Face.png");
       Image image = splashIcon.getImage(); 
       Image newimg = image.getScaledInstance(350, 150,  java.awt.Image.SCALE_SMOOTH); 
       splashIcon = new ImageIcon(newimg);
      
       label.setSize(350, 150);
       label.setIcon(new ImageIcon(newimg));
       label.setFont(new Font("Verdana", Font.BOLD, 14));
       panel.add(label);
       
       loadingBar.setMaximum(50);
       loadingBar.setBounds(55, 180, 250, 15);
        container.add(loadingBar);
        loadProgressBar();
        setSize(370, 215);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadProgressBar() {
        ActionListener al = new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            	//Increases the loadingbar
            	count++;
<<<<<<< HEAD:src/droodle/SplashScreen.java
=======
            	loadingBar.setValue(count);
                
                //Debug to check counter
                System.out.println(count);
               
                //When counter reaches this number, the splashscreen is closed.
>>>>>>> f678656c9018c01a4efa12078f18cc1588e7d9ae:src/SplashScreen.java
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