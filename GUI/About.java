package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Customerfile.*;

public class About extends JFrame implements MouseListener, ActionListener{
    JPanel panel;
    JLabel background, headline, aboutPageLabel, locationLabel, contactLabel, webmailLabel, privacyPolicyLabel, supportLabel;
    JButton backBtn;
    Color myColor1;
    ImageIcon icon1= new ImageIcon("Images/Register.jpg");
	Font  myFont ,myFont1,myFont2;
	customer c;
	customers cs;
    public About(customers cs) {
        
        super("welcome page");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.cs=cs;	
		
		myFont = new Font("Century",Font.BOLD, 20);
		myFont1 = new Font("Times New Roman",Font.PLAIN,18);
		myFont2 = new Font("Abadi",Font.BOLD,14);
		myColor1 = new Color(0,0,139);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor1);
		panel.setOpaque (false);
		this.add (panel);

        
		
		//headline
		headline = new JLabel("About Us");
		headline.setBounds(450,90,100,30);
		headline.setFont(myFont);
		headline.setForeground(Color.WHITE);
		headline.setOpaque(false);
		panel.add(headline);		
		
        // AboutPage
        aboutPageLabel = new JLabel("<html>About: Join us at Wanmin Restaurent, where passion, flavor, and creativity come together to elevate your dining experience to new heights.</html>");
        aboutPageLabel.setBounds(70, 142, 900, 42);
		aboutPageLabel.setFont(myFont1);
		aboutPageLabel.setForeground(Color.WHITE);
		aboutPageLabel.setOpaque(false);
        panel.add(aboutPageLabel);	

        // Location
        locationLabel = new JLabel("Location: Bhashundha R/A Gate, Nosor Tower, 1230 Dhaka.");
        locationLabel.setBounds(70, 190, 800, 40);
		locationLabel.setForeground(Color.WHITE);
		locationLabel.setFont(myFont1);
		locationLabel.setOpaque(false);
        panel.add(locationLabel);

        // Contact Information
        contactLabel = new JLabel("Contact Number: 0170000000, 01600000000");
        contactLabel.setBounds(70, 236, 500, 40);
		contactLabel.setForeground(Color.WHITE);
		contactLabel.setFont(myFont1);
		contactLabel.setOpaque(false);
        panel.add(contactLabel);	

        // Webmail
        webmailLabel = new JLabel("Webmail: wanminrestaurent@gmail.com");
        webmailLabel.setBounds(70, 280, 500, 40);
		webmailLabel.setForeground(Color.WHITE);
		webmailLabel.setFont(myFont1);
		webmailLabel.setOpaque(false);
        panel.add(webmailLabel);

        // Privacy Policy
        privacyPolicyLabel = new JLabel("<html>Privacy Policy: We prioritize the security and confidentiality of your personal information at Wanmin Restaurent. Any data collected, including contact details and transaction history, is used solely for improving our services and facilitating your experience with the application. Rest assured, we do not share your information with third parties unless required by law or for essential service provisions.<html>");
        privacyPolicyLabel.setBounds(70, 330, 870, 100);
		privacyPolicyLabel.setForeground(Color.WHITE);
		privacyPolicyLabel.setFont(myFont1);
		privacyPolicyLabel.setOpaque(false);
        panel.add(privacyPolicyLabel);		
		
        // Support
        supportLabel = new JLabel("<html>Support:For prompt assistance and queries regarding Wanmin Restaurent, our support team is available via email at wanminrestaurent@gmail.com or by phone at 01600000000. We are dedicated to addressing your concerns and ensuring your experience with our application is seamless and enjoyable.<html>");
        supportLabel.setBounds(70, 440, 860, 70);
		supportLabel.setForeground(Color.WHITE);
		supportLabel.setFont(myFont1);
		supportLabel.setOpaque(false);
        panel.add(supportLabel);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(830,500, 70, 30);
		backBtn.setBackground(Color.BLUE);
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont (myFont2);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setOpaque(true);
		panel.add(backBtn);
		
		this.add(panel);
		this.setVisible(true);
		
		background = new JLabel (icon1);
		background.setBounds (0,0,1000,600);
		panel.add(background);
    }
	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){
		if(me.getSource() == backBtn){
			backBtn.setBackground(Color.BLUE);
			backBtn.setForeground(Color.WHITE);
		}else{}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == backBtn){
			backBtn.setBackground(Color.ORANGE);
			backBtn.setForeground(Color.WHITE);
		}else{}
	}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 

    public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
        if (backBtn.getText().equals (command)) {
            WelcomePage Wi = new WelcomePage(cs);
            Wi.setVisible(true);
			this.setVisible(false);
        }
    } 
}

