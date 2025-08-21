package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Customerfile.*;

public class Order extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
	JLabel orderLabel,background;;
	JButton  backBtn;
	Color myColor1,myColor;
	Font myFont,myFont1;
	ImageIcon icon1 = new ImageIcon ("images/Register.jpg");
	customer c;
	customers cs;
	
	public Order(customers cs){
		super("Order");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.cs=cs;
		
		myColor = new Color(255,140,0);
		myColor1 = new Color(0,0,139);
		myFont = new Font("Century",Font.BOLD, 24);
		myFont1 = new Font("Times New Roman",Font.PLAIN,16);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor1);
		panel.setOpaque (false);
		this.add (panel);
		
		orderLabel = new JLabel("Order done!"); 
		orderLabel.setBounds(390,250,150,50);
		orderLabel.setForeground(myColor);
		orderLabel.setOpaque(false);
		orderLabel.setFont(myFont);
		panel.add(orderLabel);
		
		
		backBtn = new JButton("Back To Menu");
		backBtn.setBounds(650,450, 200, 40);
		backBtn.setForeground(Color.BLACK);
		backBtn.setFont(myFont1);
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
			backBtn.setBackground(myColor1);
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
			Menu mn = new Menu(cs);
			mn.setVisible(true);
			this.setVisible(false);
		}
	}
}
