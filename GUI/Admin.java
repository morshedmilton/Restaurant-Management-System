package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Customerfile.*;

public class Admin extends JFrame implements ActionListener,MouseListener{
	JPanel panel;
	JLabel background;
	JButton employeeBtn,backBtn;
	Color myColor1;
	Font myFont, myFont2;
	ImageIcon icon1 = new ImageIcon ("images/Register.jpg");
	customer c ;
	customers cs ;
	
	
	public Admin(customers cs){
		super("Login Admin");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);  
		this.cs=cs;
		
		myColor1 = new Color(0,0,139);
		myFont = new Font("Century",Font.BOLD, 24);
		myFont2 = new Font("Times New Roman",Font.PLAIN,16);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor1);
		panel.setOpaque (false);
		this.add (panel);
		
		
		employeeBtn = new JButton("Employee");
		employeeBtn.setBounds(400,200, 200, 160);
		employeeBtn.setBackground(myColor1);
		employeeBtn.setForeground(Color.WHITE);
		employeeBtn.setFont (myFont);
		employeeBtn.setOpaque(true);
		employeeBtn.addActionListener(this);
		panel.add(employeeBtn);
		
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(810,450, 70, 40);
		backBtn.setForeground(Color.BLACK);
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
		if(backBtn.getText().equals(command)){
			login lg = new login(cs);
			lg.setVisible(true);
			this.setVisible(false);
		}
				else if(employeeBtn.getText().equals(command)){
					Employee em = new Employee(cs);
					em.setVisible(true);
					this.setVisible(false);	
			} 
			
		}
	}