package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Customerfile.*;

public class login extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
	JLabel emailLabel,passwordLabel,registerLabel,background,loginAs;
	JTextField emailTF;
	JPasswordField passwordTF;
	JButton lgnBtn, exitBtn, registerBtn,lgnAdBtn;
	Color myColor1, myColor2;
	Font myFont, myFont2,myFont3;
	ImageIcon icon1 = new ImageIcon ("images/Register.jpg");
	customer c = null;
	customers cs = null;
	
	public login(customers cs){
		super("Login Admin");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);  
		this.cs=cs;
		
		myColor1 = new Color(0,0,139);
		myColor2 = new Color(236,235,232);
		myFont = new Font("Century",Font.BOLD, 16);
		myFont2 = new Font("Times New Roman",Font.PLAIN,16);
		myFont3 = new Font("Abadi",Font.PLAIN,20);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor1);
		panel.setOpaque (false);
		this.add (panel);
		
		
		loginAs = new JLabel("Login as Coustomer"); 
		loginAs.setBounds(450,100,200,40);
		loginAs.setForeground(Color.WHITE);
		loginAs.setFont(myFont3);
		panel.add(loginAs);
	
		
		emailLabel = new JLabel("Email address:"); 
		emailLabel.setBounds(200,240,150,30);
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(myFont);
		panel.add(emailLabel);
		
		
		
		passwordLabel = new JLabel("Password       :");
		passwordLabel.setBounds(200,280,150,30);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(myFont);
		panel.add(passwordLabel);
		
		
		
		emailTF = new JTextField();
	    emailTF.setBounds(350, 240, 350, 30);
		emailTF.setFont(myFont2);
		panel.add(emailTF);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(350, 280, 350, 30);
		passwordTF.setFont(myFont2);
		passwordTF.setEchoChar('*');
		panel.add(passwordTF);
		
		
		
		lgnBtn = new JButton("Login");
		lgnBtn.setBounds(520,350, 70, 40);
		lgnBtn.setOpaque(true);
		lgnBtn.addMouseListener(this);
		lgnBtn.addActionListener(this);
		panel.add(lgnBtn);
		
		lgnAdBtn = new JButton("Login (Admin)");
		lgnAdBtn.setBounds(360,350, 140, 40);
		lgnAdBtn.addMouseListener(this);
		lgnAdBtn.addActionListener(this);
		lgnAdBtn.setOpaque(true);
		panel.add(lgnAdBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(610,350, 70, 40);
		exitBtn.addMouseListener(this);
		exitBtn.addActionListener(this);
		exitBtn.setOpaque(true);
		panel.add(exitBtn);
		
		registerLabel = new JLabel("Don't have an account?");
		registerLabel.setBounds(380,430,150,30);
		registerLabel.setFont(myFont2);
		registerLabel.setForeground (Color.WHITE);
		panel.add(registerLabel);
		
		registerBtn = new JButton("Register");
		registerBtn.setBounds(550, 430, 70, 30);
		registerBtn.setFont (myFont);
		registerBtn.addMouseListener(this);
		registerBtn.addActionListener(this);
		registerBtn.setBorder(null);
		panel.add(registerBtn);
		
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
		}else if(me.getSource() == exitBtn){
			exitBtn.setBackground(myColor1);
			exitBtn.setForeground(Color.WHITE);
		}else if (me.getSource() == lgnAdBtn){
			lgnAdBtn.setBackground(myColor1);
			lgnAdBtn.setForeground(Color.WHITE);
		}else if (me.getSource() == registerBtn){
			registerBtn.setBackground(myColor1);
			registerBtn.setForeground(Color.WHITE);
		}else{}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == lgnBtn){
			lgnBtn.setBackground(Color.BLUE);
			lgnBtn.setForeground(Color.WHITE);
		}else if(me.getSource() == exitBtn){
			exitBtn.setBackground(Color.BLUE);
			exitBtn.setForeground(Color.WHITE);
		}else if(me.getSource() == lgnAdBtn){
			lgnAdBtn.setBackground(Color.BLUE);
			lgnAdBtn.setForeground(Color.WHITE);
		}else if(me.getSource() == registerBtn){
			registerBtn.setBackground(Color.BLUE);
			registerBtn.setForeground(Color.WHITE);
		}else {}
	}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(registerBtn.getText().equals(command)){
			Register ri = new Register(cs);
			ri.setVisible(true);
			this.dispose();
		}else if (exitBtn.getText().equals (command)){
			
			this.setVisible(false);
		}else if (lgnAdBtn.getText ().equals (command)){
			loginAdmin di = new loginAdmin (cs);
			di.setVisible (true);
			this.dispose();
		}
		else if(lgnBtn.getText().equals(command)){
			String email = "", pass = "";
			
			email = emailTF.getText();
			pass = passwordTF.getText();
			
			if(!email.isEmpty() && !pass.isEmpty()){
					
					int index = cs.customerExists(email);
				if(index == -1){
				JOptionPane.showMessageDialog(this, "User doesn't exist!");
				}
				else{
					c = cs.checkCredentials(index,pass);
					if(c == null ){
					JOptionPane.showMessageDialog(this, "Wrong Credentials");
					}
					else{
					JOptionPane.showMessageDialog(this,"Login Successful");
					WelcomePage we = new WelcomePage(cs);
					we.setVisible(true);
					this.dispose();
					}
					
				}
				
					
			}
			   else{
				JOptionPane.showMessageDialog(this,"Please fill up your information.");
			}
		}
	}
}