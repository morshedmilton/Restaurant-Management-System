package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Customerfile.*;

public class WelcomePage extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
	JLabel welcomeLabel,background;
	JButton menuBtn, aboutBtn,backBtn;
	Color myColor1;
	Font myFont,myFont1,myFont2;
	ImageIcon icon1 = new ImageIcon ("images/Register.jpg");
	customer c;
	customers cs;
	
	
	public WelcomePage(customers cs){
		super("welcome page");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);  
		this.cs=cs;
		
		myColor1 = new Color(165,165,42);
		myFont = new Font("Century",Font.BOLD, 25);
		myFont1 = new Font("Times New Roman",Font.PLAIN,18);
		myFont2=new Font("Abadi",Font.BOLD,14);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor1);
		panel.setOpaque (false);
		this.add (panel);
		
		
		welcomeLabel = new JLabel("Welcome to Wanmain Resturant"); 
		welcomeLabel.setBounds(290,160,490,60);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(myFont);
		panel.add(welcomeLabel);
		
		
		menuBtn = new JButton("Menu");
		menuBtn.setBounds(450,240, 100, 40);
		menuBtn.setBackground(Color.ORANGE);
		menuBtn.setForeground(Color.WHITE);
		menuBtn.setFont(myFont1);
		menuBtn.setOpaque(true);
		menuBtn.addActionListener(this);
		panel.add(menuBtn);
		
		
		aboutBtn = new JButton("About");
		aboutBtn.setBounds(450,320, 100, 40);
		aboutBtn.setBackground(Color.ORANGE);
		aboutBtn.setForeground(Color.WHITE);
		aboutBtn.setFont(myFont1);
		aboutBtn.addActionListener(this);
		aboutBtn.setOpaque(true);
		panel.add(aboutBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(810,450, 70, 40);
		backBtn.setForeground(Color.BLACK);
		backBtn.setFont(myFont2);
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
			backBtn.setBackground(Color.ORANGE);
			backBtn.setForeground(Color.WHITE);
		}else{}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == backBtn){
			backBtn.setBackground(Color.BLUE);
			backBtn.setForeground(Color.WHITE);
		}else{}
	}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(menuBtn.getText().equals(command)){
			Menu mu = new Menu(cs);
			mu.setVisible(true);
			this.setVisible(false);
		}else if (aboutBtn.getText().equals (command)){
			About ab = new About (cs);
			ab.setVisible (true);
			this.setVisible(false);
		}
		else if (backBtn.getText().equals (command)){
			login lg = new login (cs);
			lg.setVisible (true);
			this.setVisible(false);
	}
	
}
}