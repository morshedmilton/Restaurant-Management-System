package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Customerfile.*;
public class Menu extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
	JLabel menuLabel,background,title,title1,title2;
	JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,cc1,cc2,cc3,cc4,cc5,cc6,cc7;
	JButton backBtn,procesBtn;
	ImageIcon icon1 = new ImageIcon ("images/Register.jpg");
	Color myColor1,myColor2;
	Font myFont,myFont2,myFont3;
	JSpinner spiner[] = new JSpinner[14];
	SpinnerNumberModel spinModel;
	customer c;
	customers cs;
	public Menu(customers cs){
		super("Menu");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);  
		this.cs=cs;
		
		myColor1 = new Color(0,0,139);
		myColor2 = new Color(236,235,232);
		myFont = new Font("Bradley Hand ITC",Font.BOLD, 30);
		myFont2 = new Font("Times New Roman",Font.PLAIN,16);
		myFont3 = new Font("Bradley Hand ITC",Font.BOLD,18);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor1);
		panel.setOpaque (false);
		this.add (panel);

		menuLabel = new JLabel("Food Menu");
		menuLabel.setBounds(440,60,160,30);
		menuLabel.setForeground(Color.WHITE);
		menuLabel.setFont(myFont);
		panel.add(menuLabel);
		
		title = new JLabel("Main Course");
		title.setBounds(100,100,120,30);
		title.setForeground(Color.WHITE);
		title.setFont(myFont3);
		panel.add(title);
		
		title1 = new JLabel("Appetizers");
		title1.setBounds(100,240,120,30);
		title1.setForeground(Color.WHITE);
		title1.setFont(myFont3);
		panel.add(title1);
		
		title2 = new JLabel("Beverages");
		title2.setBounds(100,380,120,30);
		title2.setForeground(Color.WHITE);
		title2.setFont(myFont3);
		panel.add(title2);
		
		c1 = new JCheckBox ("Cheeseburger...........200/=");
		c1.setBounds (120,140,200,20);
	    c1.setForeground(Color.WHITE);
		c1.setOpaque (false);
		c1.setFont(myFont2);
		panel.add(c1);
		
		c2 = new JCheckBox ("Cheese sandwich.....250/=");
		c2.setBounds (120,160,200,20);
		c2.setForeground(Color.WHITE);
		c2.setOpaque (false);
		c2.setFont(myFont2);
		panel.add(c2);
		
		c3 = new JCheckBox ("Chicken burgers......180/=");
		c3.setBounds (120,180,200,20);
		c3.setOpaque (false);
		c3.setForeground(Color.WHITE);
		c3.setFont(myFont2);
		panel.add(c3);
		
		c4 = new JCheckBox ("spicy chicken...........170/=");
		c4.setBounds (120,200,200,20);
		c4.setOpaque (false);
		c4.setForeground(Color.WHITE);
		c4.setFont(myFont2);
		panel.add(c4);
		
		c5 = new JCheckBox ("Hot dog....................190/=");
		c5.setBounds (120,220,200,20);
		c5.setOpaque (false);
		c5.setForeground(Color.WHITE);
		c5.setFont(myFont2);
		panel.add(c5);
		
		c6 = new JCheckBox ("Fruit Salad................130/=");
		c6.setBounds (120,280,200,20);
		c6.setOpaque (false);
		c6.setForeground(Color.WHITE);
		c6.setFont(myFont2);
		panel.add(c6);
		
		c7 = new JCheckBox ("Cocktails.................120/=");
		c7.setBounds (120,300,200,20);
		c7.setOpaque (false);
		c7.setForeground(Color.WHITE);
		c7.setFont(myFont2);
		panel.add(c7);
		
		c8 = new JCheckBox ("Nuggets...................100/=");
		c8.setBounds (120,320,200,20);
		c8.setOpaque (false);
		c8.setForeground(Color.WHITE);
		c8.setFont(myFont2);
		panel.add(c8);
		
		c9 = new JCheckBox ("Sandwich..................70/=");
		c9.setBounds (120,340,200,20);
		c9.setOpaque (false);
		c9.setForeground(Color.WHITE);
		c9.setFont(myFont2);
		panel.add(c9);
		
		cc1 = new JCheckBox ("French Fries............130/=");
		cc1.setBounds (120,360,200,20);
		cc1.setOpaque (false);
		cc1.setForeground(Color.WHITE);
		cc1.setFont(myFont2);
		panel.add(cc1);
		
		cc2 = new JCheckBox ("Milk Shake .............80/=");
		cc2.setBounds (120,420,200,20);
		cc2.setOpaque (false);
		cc2.setForeground(Color.WHITE);
		cc2.setFont(myFont2);
		panel.add(cc2);
		
		cc3 = new JCheckBox ("Iced Tea .................70/=");
		cc3.setBounds (120,440,200,20);
		cc3.setOpaque (false);
		cc3.setForeground(Color.WHITE);
		cc3.setFont(myFont2);
		panel.add(cc3);
		
		cc4 = new JCheckBox ("Orange Juice ..........100/=");
		cc4.setBounds (120,460,200,20);
		cc4.setOpaque (false);
		cc4.setForeground(Color.WHITE);
		cc4.setFont(myFont2);
		panel.add(cc4);
		
		cc5 = new JCheckBox ("Lemon Tea .............40/=");
		cc5.setBounds (120,480,200,20);
		cc5.setOpaque (false);
		cc5.setForeground(Color.WHITE);
		cc5.setFont(myFont2);
		panel.add(cc5);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(800,510, 70, 30);
		backBtn.setForeground(Color.BLACK);
		backBtn.setFont (myFont2);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setOpaque(true);
		panel.add(backBtn);
		
		procesBtn = new JButton("Process");
		procesBtn.setBounds(600,510, 120, 30);
		procesBtn.setForeground(Color.BLACK);
		procesBtn.setFont (myFont2);
		procesBtn.addMouseListener(this);
		procesBtn.addActionListener(this);
		procesBtn.setOpaque(true);
		panel.add(procesBtn);
		
		
		
		
		int spinerY = 140;
		for(int i=0;i<14;i++){
			this.addJSpinner(i,340,spinerY,50,20);	
			spinerY+=20;
			if(i==4) spinerY+=40;
			else if (i==9)spinerY+=40;
		}
		
		this.add(panel);
		background = new JLabel (icon1);
		background.setBounds (0,0,1000,600);
		panel.add(background);
		this.setVisible(true);
		
	}
	
	    
	
	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){
		if(me.getSource() == backBtn){
			backBtn.setBackground(myColor2);
			backBtn.setForeground(Color.WHITE);
		}else if(me.getSource() == procesBtn){
			procesBtn.setBackground(myColor2);
			procesBtn.setForeground(Color.WHITE);
		}
	}  
	public void mouseExited(MouseEvent me){
		if(me.getSource() == backBtn){
			backBtn.setBackground(Color.BLUE);
			backBtn.setForeground(Color.WHITE);
		}else if(me.getSource() == procesBtn){
			procesBtn.setBackground(Color.BLUE);
			procesBtn.setForeground(Color.WHITE);
		}
	}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 

public void addJSpinner(int spinerNumber,int a,int b,int c,int d)
		{
			spinModel = new SpinnerNumberModel(0,0,10,1);
			spiner[spinerNumber] = new JSpinner(spinModel);
			spiner[spinerNumber].setBounds(a,b,c,d);
			panel.add(spiner[spinerNumber]);
		}

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if (backBtn.getText ().equals (command)){
			WelcomePage wi = new WelcomePage (cs);
			wi.setVisible (true);
			this.setVisible (false);
		}
		else if(procesBtn.getText().equals(command)) 
		{
			int x;
			    x = (((Integer) spiner[0].getValue()) * 200) +
					(((Integer) spiner[1].getValue()) * 250) +
					(((Integer) spiner[2].getValue()) * 180) +
					(((Integer) spiner[3].getValue()) * 170) +
					(((Integer) spiner[4].getValue()) * 190) +
					(((Integer) spiner[5].getValue()) * 130) +
					(((Integer) spiner[6].getValue()) * 120) +
					(((Integer) spiner[7].getValue()) * 100) +
					(((Integer) spiner[8].getValue()) * 70) +
					(((Integer) spiner[9].getValue()) * 130) +
					(((Integer) spiner[10].getValue()) * 80) +
					(((Integer) spiner[11].getValue()) * 70) +
					(((Integer) spiner[12].getValue()) * 100) +
					(((Integer) spiner[13].getValue()) * 40);
			JOptionPane.showMessageDialog(this,"Total Bill Is:"+x);
			Payment pd = new Payment (cs);
			pd.setVisible (true);
			this.setVisible(false);
			
		}
		else{}
	
		if (ae.getSource() == c1)
			{
				if (c1.isSelected() == true)
				{
					spiner[0].getValue();
					Integer value1 = (Integer) spiner[0].getValue();
				      System.out.println(value1);
				}
			}
			else if (ae.getSource() == c2)
			{
				if (c2.isSelected() == true)
				{
					Integer value2 = (Integer) spiner[1].getValue();
					System.out.println(value2);
				}
			}
			else if (ae.getSource() == c3)
			{
				if (c3.isSelected() == true)
				{
					Integer value3 = (Integer) spiner[2].getValue();
					System.out.println(value3);
				}
			}
			else if (ae.getSource() == c4)
			{
				if (c4.isSelected() == true)
				{
					Integer value4 = (Integer) spiner[3].getValue();
					System.out.println(value4);
				}
			}
			else if (ae.getSource() == c5)
			{
				if (c5.isSelected() == true)
				{
					Integer value5 = (Integer) spiner[4].getValue();
					System.out.println(value5);
				}
			}
			else if (ae.getSource() == c6)
			{
				if (c6.isSelected() == true)
				{
					Integer value6 = (Integer) spiner[5].getValue();
					System.out.println(value6);
				}
			}
			else if (ae.getSource() == c7)
			{
				if (c7.isSelected() == true)
				{
					Integer value7 = (Integer) spiner[6].getValue();
					System.out.println(value7);
				}
			}
			else if (ae.getSource() == c8)
			{
				if (c8.isSelected() == true)
				{
					Integer value8 = (Integer) spiner[7].getValue();
					System.out.println(value8);
				}
			}
			else if (ae.getSource() == c9)
			{
				if (c9.isSelected() == true)
				{
					Integer value9 = (Integer) spiner[8].getValue();
					System.out.println(value9);
				}
			}
			
			else if (ae.getSource() == cc1)
			{
				if (cc1.isSelected() == true)
				{
					Integer value10 = (Integer) spiner[9].getValue();
					System.out.println(value10);
				}
			}
			else if (ae.getSource() == cc2)
			{
				if (cc2.isSelected() == true)
				{
					Integer value11 = (Integer) spiner[10].getValue();
					System.out.println(value11);
				}
			}
			else if (ae.getSource() == cc3)
			{
				if (cc3.isSelected() == true)
				{
					Integer value12 = (Integer) spiner[11].getValue();
					System.out.println(value12);
				}
			}
			else if (ae.getSource() == cc4)
			{
				if (cc4.isSelected() == true)
				{
					Integer value13 = (Integer) spiner[12].getValue();
					System.out.println(value13);
				}
			}
			else if (ae.getSource() == cc5)
			{
				if (cc5.isSelected() == true)
				{
					Integer value14 = (Integer) spiner[13].getValue();
					System.out.println(value14);
				}
			}
			
}}









