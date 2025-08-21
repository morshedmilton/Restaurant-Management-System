package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Customerfile.*;

public class Register extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
	JLabel userLabel, passwordLabel, confirmPassLabel, phoneNumberLabel, background;
	JTextField userTF,phoneNumberTF;
	JPasswordField passwordTF, confirmPasswordTF;
	JButton registerBtn,backBtn;
	Font myFont, myFont2;
	Color myColor;
	ImageIcon icon1 = new ImageIcon ("images/Register.jpg");
	customer c = null;
	customers cs = null;
	
	public Register(customers cs){
		super("Register");
		this.setSize(1000,600);
		this.setIconImage(icon1.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.cs=cs;
		
		myColor = new Color (0,0,139);
		myFont = new Font("Century",Font.BOLD, 16);
		myFont2 = new Font("Times New Roman",Font.PLAIN, 16);
		
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
		
		
		
		userLabel = new JLabel("Email address:"); 
		userLabel.setBounds(200,180,150,30);
		userLabel.setOpaque(false);
		userLabel.setForeground (Color.WHITE);
		userLabel.setFont(myFont2);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(350, 180, 350, 30);
		userTF.setFont(myFont2);
		userTF.setOpaque (true);
		panel.add(userTF);
		
		phoneNumberLabel = new JLabel("Phone number:"); 
		phoneNumberLabel.setBounds(200,230,150,30);
		phoneNumberLabel.setFont(myFont2);
		phoneNumberLabel.setForeground (Color.WHITE);
		phoneNumberLabel.setOpaque (false);
		panel.add(phoneNumberLabel);
		
		phoneNumberTF = new JTextField();
		phoneNumberTF.setBounds(350,230,350,30);
		phoneNumberTF.setOpaque (true);
		phoneNumberTF.setFont(myFont2);
		panel.add(phoneNumberTF);
		
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(200,280,150,30);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setOpaque(false);
		passwordLabel.setFont(myFont2);
		panel.add(passwordLabel);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(350,280,350,30);
		passwordTF.setOpaque(true);
		passwordTF.setFont(myFont2);
		passwordTF.setEchoChar('*');
		panel.add(passwordTF);
		
		confirmPassLabel = new JLabel("Confirm password:");
		confirmPassLabel.setBounds(200,330,150,30);
		confirmPassLabel.setForeground(Color.WHITE);
		confirmPassLabel.setOpaque(false);
		confirmPassLabel.setFont(myFont2);
		panel.add(confirmPassLabel);
		
		confirmPasswordTF = new JPasswordField();
		confirmPasswordTF.setBounds(350, 330,350,30);
		confirmPasswordTF.setFont(myFont2);
		confirmPasswordTF.setEchoChar('*');
		panel.add(confirmPasswordTF);
		
		
		registerBtn = new JButton("Register");
		registerBtn.setBounds(420,400,80,40);
		registerBtn.setFont(myFont);
		registerBtn.setOpaque (true);
		registerBtn.addMouseListener(this);
		registerBtn.addActionListener(this);
		registerBtn.setBorder(null);
		panel.add(registerBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(540,400,80,40);
		backBtn.addMouseListener(this);
		backBtn.setFont(myFont);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		panel.add(backBtn);

		this.add(panel);
		
		JLabel background = new JLabel(icon1);
        background.setBounds(0, 0, 1000, 600);
        panel.add(background);
		
	}
	
	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){
		if(me.getSource() == registerBtn){
			registerBtn.setBackground(myColor);
			registerBtn.setForeground(Color.WHITE);
		}else if(me.getSource() == backBtn){
			backBtn.setBackground(myColor);
			backBtn.setForeground(Color.WHITE);
		}else{}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == registerBtn){
			registerBtn.setBackground(Color.BLUE);
			registerBtn.setForeground(Color.WHITE);
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
			this.dispose();
		}
		if(registerBtn.getText().equals(command)){
			String email = "", phone = "", password = "",confirmPass = "";
			
			email = userTF.getText();
			phone = phoneNumberTF.getText();
			password = passwordTF.getText();
			confirmPass = confirmPasswordTF.getText();
			
			if(!email.isEmpty() && !password.isEmpty() && !confirmPass.isEmpty() && !phone.isEmpty()){
				if(password.equals(confirmPass)){
					customer c=new customer(email,password,phone);
					cs.addCustomer(c);
					JOptionPane.showMessageDialog(this,"Registration successful. Please login to continue.");
					
					login lg = new login(cs);
					lg.setVisible(true);
					this.dispose();
				}else{
					JOptionPane.showMessageDialog(this,"Password missmatch");
				}
			}else{
				JOptionPane.showMessageDialog(this,"Information missing");
			}
		}
	}
	
}