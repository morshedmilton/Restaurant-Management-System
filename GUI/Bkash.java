package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Customerfile.*;

public class Bkash extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
	JLabel numberLabel,background,pinLabel,paymentLabel,bkashLabel;
	JButton processBtn, closeBtn;
	JTextField phoneNumberTF;
	JPasswordField pinTF;
	Color myColor1;
	Font myFont,myFont1;
	ImageIcon icon1 = new ImageIcon ("images/Register.jpg");
	ImageIcon icon2 = new ImageIcon ("images/bkash1.jpg");
	customer c;
	customers cs;
	
	public Bkash(customers cs){
		super("Bkash");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.cs=cs;
		
		myColor1 = new Color(0,0,139);
		myFont = new Font("Century",Font.BOLD, 18);
		myFont1 = new Font("Times New Roman",Font.PLAIN,16);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor1);
		panel.setOpaque (false);
		this.add (panel);
		
		bkashLabel = new JLabel(icon2); 
		bkashLabel.setBounds(400,110,200,100);
		panel.add(bkashLabel);
		
		paymentLabel = new JLabel("Bkash Payment"); 
		paymentLabel.setBounds(430,80,150,50);
		paymentLabel.setForeground(Color.WHITE);
		paymentLabel.setFont(myFont);
		panel.add(paymentLabel);
		
		numberLabel = new JLabel("Phone number"); 
		numberLabel.setBounds(200,260,150,30);
		numberLabel.setForeground(Color.WHITE);
		numberLabel.setFont(myFont);
		panel.add(numberLabel);
		
	    pinLabel = new JLabel("Enter pin "); 
		pinLabel.setBounds(200,310,150,30);
		pinLabel.setForeground(Color.WHITE);
		pinLabel.setFont(myFont);
		panel.add(pinLabel);
		
		pinTF = new JPasswordField();
		pinTF.setBounds(350, 310, 350, 30);
		pinTF.setFont(myFont1);
		pinTF.setEchoChar('*');
		panel.add(pinTF);
		
		phoneNumberTF = new JTextField ();
		phoneNumberTF.setBounds(350, 260, 350, 30);
		phoneNumberTF.setFont(myFont1);
		panel.add(phoneNumberTF);
		
		processBtn = new JButton("Process");
		processBtn.setBounds(450,400, 100, 40);
		processBtn.setForeground(Color.BLACK);
		processBtn.setFont(myFont1);
		processBtn.setOpaque(true);
		processBtn.addMouseListener(this);
		processBtn.addActionListener(this);
		panel.add(processBtn);
		
		
		closeBtn = new JButton("Close");
		closeBtn.setBounds(590,400, 100, 40);
		closeBtn.setForeground(Color.BLACK);
		closeBtn.setFont(myFont1);
		closeBtn.addMouseListener(this);
		closeBtn.addActionListener(this);
		closeBtn.setOpaque(true);
		panel.add(closeBtn);
		
		
		this.add(panel);
		this.setVisible(true);
		
		background = new JLabel (icon1);
		background.setBounds (0,0,1000,600);
		panel.add(background);
		
	}
	
	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){
		if(me.getSource() == processBtn){
			processBtn.setBackground(myColor1);
			processBtn.setForeground(Color.WHITE);
		}else if(me.getSource() == closeBtn){
			closeBtn.setBackground(myColor1);
			closeBtn.setForeground(Color.WHITE);
		}else{}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == processBtn){
			processBtn.setBackground(Color.BLUE);
			processBtn.setForeground(Color.WHITE);
		}else if(me.getSource() == closeBtn){
			closeBtn.setBackground(Color.BLUE);
			closeBtn.setForeground(Color.WHITE);
		}else{}
	}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(processBtn.getText().equals(command)){
			String pin = "",phoneNumber="";
			
			pin = pinTF.getText();
			phoneNumber = phoneNumberTF.getText();
			
			if(!pin.isEmpty()&&!phoneNumber.isEmpty() ){
				
					JOptionPane.showMessageDialog(this,"Payment successful.");
					Order od = new Order (cs);
			        od.setVisible(true);
			        this.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(this,"Please fill up your phone number and pin..");
				}
			}
		else if (closeBtn.getText().equals (command)){
			Payment pa = new Payment (cs);
			this.setVisible(false);
			pa.setVisible (true);
		}else{
				JOptionPane.showMessageDialog(this,"Phone number and pin incorrect.");
			}
	}
	}
	
