package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Customerfile.*;

public class Payment extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
	JLabel selectLabel,background,bkashLabel,nagadLabel,cardLabel;
	
	JButton bkash, nagad,card,backBtn;
	Color myColor1;
	Font myFont,myFont1;
	ImageIcon icon1 = new ImageIcon ("images/Register.jpg");
	ImageIcon icon2 = new ImageIcon ("images/bkash.jpg");
	ImageIcon icon3 = new ImageIcon ("images/nagad.png");
	ImageIcon icon4 = new ImageIcon ("images/card.jpg");
	customer c;
	customers cs;
	
	public Payment(customers cs){
		super("payment");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.cs=cs;
		
		myColor1 = new Color(0,0,139);
		myFont = new Font("Century",Font.BOLD, 20);
		myFont1 = new Font("Times New Roman",Font.PLAIN,18);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor1);
		panel.setOpaque (false);
		this.add (panel);
		
		
		selectLabel = new JLabel("Select payment method"); 
		selectLabel.setBounds(360,180,290,30);
		selectLabel.setForeground(Color.WHITE);
		selectLabel.setFont(myFont);
		panel.add(selectLabel);
		
		bkashLabel = new JLabel(icon2); 
		bkashLabel.setBounds(220,300,140,80);
		bkashLabel.setForeground(Color.WHITE);
		bkashLabel.setFont(myFont1);
		panel.add(bkashLabel);
		
		nagadLabel = new JLabel(icon3); 
		nagadLabel.setBounds(420,300,140,80);
		nagadLabel.setForeground(Color.WHITE);
		nagadLabel.setFont(myFont1);
		panel.add(nagadLabel);
		
		cardLabel = new JLabel(icon4); 
		cardLabel.setBounds(620,300,140,80);
		cardLabel.setForeground(Color.WHITE);
		cardLabel.setFont(myFont1);
		panel.add(cardLabel);
		
		bkash = new JButton("Bkash");
		bkash.setBounds(250,400, 80, 40);
		bkash.setForeground(Color.BLACK);
		bkash.setFont(myFont1);
		bkash.setOpaque(true);
		bkash.addMouseListener(this);
		bkash.addActionListener(this);
		panel.add(bkash);
		
		nagad = new JButton("Nagad");
		nagad.setBounds(450,400, 80, 40);
		nagad.setForeground(Color.BLACK);
		nagad.setFont(myFont1);
		nagad.setOpaque(true);
		nagad.addMouseListener(this);
		nagad.addActionListener(this);
		panel.add(nagad);
		
		
		card = new JButton("Card");
		card.setBounds(650,400, 80, 40);
		card.setForeground(Color.BLACK);
		card.setFont(myFont1);
		card.addMouseListener(this);
		card.addActionListener(this);
		card.setOpaque(true);
		panel.add(card);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(800,450, 80, 40);
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
		if(me.getSource() == bkash){
			bkash.setBackground(myColor1);
			bkash.setForeground(Color.WHITE);
		}else if(me.getSource() == nagad){
			nagad.setBackground(myColor1);
			nagad.setForeground(Color.WHITE);
		}else if (me.getSource() == card){
			card.setBackground(myColor1);
			card.setForeground(Color.WHITE);
		}else if (me.getSource() == backBtn){
			backBtn.setBackground(myColor1);
			backBtn.setForeground(Color.WHITE);
		}else {}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == bkash){
			bkash.setBackground(Color.BLUE);
			bkash.setForeground(Color.WHITE);
		}else if(me.getSource() == nagad){
			nagad.setBackground(Color.BLUE);
			nagad.setForeground(Color.WHITE);
		}else if (me.getSource() == card){
			card.setBackground(Color.BLUE);
			card.setForeground(Color.WHITE);
		}else if (me.getSource() == backBtn){
			backBtn.setBackground(Color.BLUE);
			backBtn.setForeground(Color.WHITE);
		}else{}
	}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(bkash.getText().equals(command)){
			Bkash bk = new Bkash(cs);
			bk.setVisible(true);
			this.setVisible(false);
		}else if (nagad.getText().equals (command)){
			Nagad na = new Nagad(cs);
			na.setVisible(true);
			this.setVisible(false);
		}
		else if (card.getText().equals (command)){
			Card ca = new Card(cs);
			ca.setVisible(true);
			this.setVisible(false);
	}
	if (backBtn.getText().equals (command)){
			Menu mn = new Menu(cs);
			mn.setVisible(true);
			this.setVisible(false);
	
}
else {}
}
}