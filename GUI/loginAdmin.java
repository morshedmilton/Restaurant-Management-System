package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Customerfile.*;
public class loginAdmin extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
	JLabel emailLabel, passwordLabel,phoneNumberLabel,background,uperLabel;
	JTextField emailTF,phoneNumberTF;
	JPasswordField passwordTF;
	JButton lgnBtn, backBtn;
	Color myColor1;
	Font myFont, myFont2,myFont3;
	ImageIcon icon1 = new ImageIcon ("images/Register.jpg");
	customer c ;
	customers cs ;
	
	
	public loginAdmin(customers cs){
		super("Admin");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);  
		this.cs=cs;
		
		myColor1 = new Color(0,0,139);
		myFont = new Font("Century",Font.BOLD, 16);
		myFont2 = new Font("Times New Roman",Font.PLAIN,16);
		myFont3 = new Font("Abadi",Font.BOLD,20);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor1);
		panel.setOpaque (false);
		this.add (panel);
		
		uperLabel = new JLabel("Login as Admin"); 
		uperLabel.setBounds(440,140,200,40);
		uperLabel.setForeground(Color.WHITE);
		uperLabel.setFont(myFont3);
		panel.add(uperLabel);
		
	
		
		emailLabel = new JLabel("Email address:"); 
		emailLabel.setBounds(200,220,150,30);
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(myFont);
		panel.add(emailLabel);
		
		
		
		passwordLabel = new JLabel("Password :");
		passwordLabel.setBounds(200,270,150,30);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(myFont);
		panel.add(passwordLabel);
		
		
		emailTF = new JTextField();
	    emailTF.setBounds(350, 220, 350, 30);
		emailTF.setFont(myFont2);
		panel.add(emailTF);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(350, 270, 350, 30);
		passwordTF.setFont(myFont2);
		passwordTF.setEchoChar('*');
		panel.add(passwordTF);
		
		lgnBtn = new JButton("Login");
		lgnBtn.setBounds(650,400, 70, 40);
		lgnBtn.setOpaque(true);
		lgnBtn.addMouseListener(this);
		lgnBtn.addActionListener(this);
		panel.add(lgnBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(750,400, 70, 40);
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
		if(me.getSource() == lgnBtn){
			lgnBtn.setBackground(myColor1);
			lgnBtn.setForeground(Color.WHITE);
		}else if(me.getSource() == backBtn){
			backBtn.setBackground(myColor1);
			backBtn.setForeground(Color.WHITE);
		}else{}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == lgnBtn){
			lgnBtn.setBackground(Color.BLUE);
			lgnBtn.setForeground(Color.WHITE);
		}else if(me.getSource() == backBtn){
			backBtn.setBackground(Color.BLUE);
			backBtn.setForeground(Color.WHITE);
		}else{}
	}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(backBtn.getText().equals(command)){
			login lg = new login(cs);
			lg.setVisible(true);
			this.setVisible(false);
		}
		if(lgnBtn.getText().equals(command)){
			String email = "", pass = "";
			
			email = emailTF.getText();
			pass = passwordTF.getText();
			
			if(!email.isEmpty() && !pass.isEmpty()){
				String adminEmail = "java";
				String adminPassword = "java";
				
				if(email.equals(adminEmail) && pass.equals(adminPassword)) 
				{
					JOptionPane.showMessageDialog(this,"Login Successfull");
					Admin ag = new Admin(cs);
					ag.setVisible(true);
					this.setVisible(false);
				}
				else{JOptionPane.showMessageDialog(this,"Wrong Credentials");}
			}else{
				JOptionPane.showMessageDialog(this,"Information missing");
			}
		}
	}
	
}