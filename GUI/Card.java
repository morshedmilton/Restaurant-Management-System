package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Customerfile.*;

public class Card extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
	JLabel nameLabel,background,paymentLabel,cardNumberLabel,cvvLabel,experitionLabel,cardLabel;
	JButton processBtn, closeBtn;
	JTextField nameTF,cardNumberTF,expTF;
	JPasswordField cvvTF;
	Color myColor1;
	Font myFont,myFont1;
	ImageIcon icon1 = new ImageIcon ("images/Register.jpg");
	ImageIcon icon2 = new ImageIcon ("images/card1.jpg");
	customer c;
	customers cs;
	
	public Card(customers cs){
		super("Card");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.cs=cs;
		
		myColor1 = new Color(0,0,139);
		myFont = new Font("Century",Font.BOLD, 20);
		myFont1 = new Font("Times New Roman",Font.PLAIN,16);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor1);
		panel.setOpaque (false);
		this.add (panel);
		
		paymentLabel = new JLabel("Card Payment"); 
		paymentLabel.setBounds(430,80,150,50);
		paymentLabel.setForeground(Color.WHITE);
		paymentLabel.setFont(myFont);
		panel.add(paymentLabel);
		
		cardLabel = new JLabel(icon2); 
		cardLabel.setBounds(400,140,200,100);
		panel.add(cardLabel);
		
		cardNumberLabel = new JLabel("Card Number"); 
		cardNumberLabel.setBounds(220,260,150,30);
		cardNumberLabel.setForeground(Color.WHITE);
		cardNumberLabel.setFont(myFont1);
		panel.add(cardNumberLabel);
		
		cvvLabel = new JLabel("CVC "); 
		cvvLabel.setBounds(670,260,50,30);
		cvvLabel.setForeground(Color.WHITE);
		cvvLabel.setFont(myFont1);
		panel.add(cvvLabel);
		
		nameLabel = new JLabel("Card Holder Name"); 
		nameLabel.setBounds(200,310,150,30);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(myFont1);
		panel.add(nameLabel);
		
		experitionLabel = new JLabel("Experition Date"); 
		experitionLabel.setBounds(200,360,150,30);
		experitionLabel.setForeground(Color.WHITE);
		experitionLabel.setFont(myFont1);
		panel.add(experitionLabel);
		
		
		nameTF = new JTextField ();
		nameTF.setBounds(350, 310, 350, 30);
		nameTF.setFont(myFont1);
		panel.add(nameTF);
		
		cardNumberTF = new JTextField ();
		cardNumberTF.setBounds(350, 260, 300, 30);
		cardNumberTF.setFont(myFont1);
		panel.add(cardNumberTF);
		
		cvvTF = new JPasswordField ();
		cvvTF.setBounds(720, 260, 120, 30);
		cvvTF.setEchoChar('*');
		cvvTF.setFont(myFont1);
		panel.add(cvvTF);
		
		expTF = new JTextField ();
		expTF.setBounds(350, 360, 350, 30);
		expTF.setFont(myFont1);
		panel.add(expTF);
		
		processBtn = new JButton("Process");
		processBtn.setBounds(450,440, 100, 40);
		processBtn.setForeground(Color.BLACK);
		processBtn.setFont(myFont1);
		processBtn.setOpaque(true);
		processBtn.addMouseListener(this);
		processBtn.addActionListener(this);
		panel.add(processBtn);
		
		
		closeBtn = new JButton("Close");
		closeBtn.setBounds(590,440, 100, 40);
		closeBtn.setForeground(Color. BLACK);
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
			String cardNumber = "",exp="",name="",cvv="";
			
			cardNumber = cardNumberTF.getText();
			exp = expTF.getText();
			name=nameTF.getText();
			cvv = cvvTF.getText();
			if(!cardNumber.isEmpty()&&!exp.isEmpty()&&!cvv.isEmpty()&&!name.isEmpty() ){
				
					JOptionPane.showMessageDialog(this,"Payment successful.");
					Order od = new Order (cs);
			        od.setVisible(true);
			        this.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(this,"Please fill up your payment information.");
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