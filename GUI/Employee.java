package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Customerfile.*;

public class Employee extends JFrame implements  ActionListener{
	JPanel panel;
	JLabel nameLabel,phoneNumberLabel,background,uperLabel ,idLabel;
	JTextField nameTF,phoneNumberTF,nidTF;
	JButton addBtn, backBtn,removeBtn,clrBtn,updateBtn;
	Font myFont, myFont2,myFont3;
	ImageIcon icon = new ImageIcon ("images/Register.jpg");
	DefaultTableModel model;
	JScrollPane scroll;
	Color myColor1;
	JTable table;
	String [] cols = {"Name","ID","Phone Number"};
	String [] rows = new String [3];
	customer c;
	customers cs;
	
	public Employee(customers cs){
		super("Employee");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.cs=cs;
		
		myColor1 = new Color(0,0,139);
		myFont = new Font("Cascadia Code",Font.BOLD, 12);
		myFont2 = new Font("Times New Roman",Font.PLAIN,16);
		myFont3 = new Font("Abadi",Font.BOLD,20);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor1);
		panel.setOpaque (false);
		this.add (panel);
		
		
		uperLabel = new JLabel("Employee's Information"); 
		uperLabel.setBounds(420,100,260,40);
		uperLabel.setForeground(Color.WHITE);
		uperLabel.setFont(myFont3);
		panel.add(uperLabel);
	
		
		
		nameLabel = new JLabel("Name:"); 
		nameLabel.setBounds(80,160,100,25);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(myFont);
		panel.add(nameLabel);
		
		
		
		idLabel= new JLabel("ID:");
		idLabel.setBounds(80,200,100,25);
		idLabel.setForeground(Color.WHITE);
		idLabel.setFont(myFont);
		panel.add(idLabel);
		
		
		phoneNumberLabel = new JLabel ("Phone number:");
		phoneNumberLabel.setBounds(80,240,100,25);
		phoneNumberLabel.setForeground(Color.WHITE);
		phoneNumberLabel.setFont(myFont);
		panel.add (phoneNumberLabel);
		
		
		
		nameTF = new JTextField();
	    nameTF.setBounds(180, 160, 280, 25);
		nameTF.setFont(myFont2);
		panel.add(nameTF);
		
		phoneNumberTF = new JTextField ();
		phoneNumberTF.setBounds(180, 240, 280, 25);
		phoneNumberTF.setFont(myFont2);
		panel.add(phoneNumberTF);
		
		nidTF = new JTextField ();
		nidTF.setBounds(180, 200, 280, 25);
		nidTF.setFont(myFont2);
		panel.add(nidTF);
		
		
		addBtn = new JButton("Add Employee");
		addBtn.setBounds(140,370,120 , 40);
		addBtn.setBackground(Color.ORANGE);
		addBtn.setForeground(Color.BLACK);
		addBtn.setOpaque(true);
		addBtn.addActionListener(this);
		panel.add(addBtn);
		
		
		
		removeBtn = new JButton("Remove");
		removeBtn.setBounds(290,370, 120, 40);
		removeBtn.setBackground(Color.ORANGE);
		removeBtn.setForeground(Color.BLACK);
		removeBtn.setOpaque(true);
		removeBtn.addActionListener(this);
		panel.add(removeBtn);
		
		clrBtn = new JButton("Clear");
		clrBtn.setBounds(140,430, 120, 40);
		clrBtn.setBackground(Color.ORANGE);
		clrBtn.setForeground(Color.BLACK);
		clrBtn.setOpaque(true);
		clrBtn.addActionListener(this);
		panel.add(clrBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(290,430, 120, 40);
		updateBtn.setBackground(Color.ORANGE);
		updateBtn.setForeground(Color.BLACK);
		updateBtn.setOpaque(true);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(850,500, 70, 40);
		backBtn.setBackground(Color.ORANGE);
		backBtn.setForeground(Color.BLACK);
		backBtn.addActionListener(this);
		backBtn.setOpaque(true);
		panel.add(backBtn);
		
		table = new JTable ();
		
		model = new DefaultTableModel ();
		model.setColumnIdentifiers (cols);
		
		table.setModel(model);
		table.setFont (myFont);
	    table.setSelectionBackground (Color.GREEN);
		table.setRowHeight (30);
		table.setEnabled (true);
		table.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked (MouseEvent me){
				int n = table.getSelectedRow ();
				String name = model.getValueAt (n,0).toString ();
				String nid = model.getValueAt (n,1).toString ();
				String phoneNumber = model.getValueAt (n,2).toString ();
				
				nameTF.setText(name);
				nidTF.setText(nid);
				phoneNumberTF.setText(phoneNumber);
				
			}
			
		});
	
		scroll = new JScrollPane (table);
		scroll.setBounds (500,160,450,300);
		panel.add (scroll);
		
		this.add(panel);
		this.setVisible(true);
		
		background = new JLabel (icon);
		background.setBounds (0,0,1000,600);
		panel.add(background);
		
	}
	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(backBtn.getText().equals(command)){
			Admin lg = new Admin(cs);
			lg.setVisible(true);
			this.setVisible(false);
		}
		  else if (ae.getSource()== addBtn){
			
			rows[0]=nameTF.getText();
			rows[2]=phoneNumberTF.getText();
			rows[1]=nidTF.getText();
			model.addRow (rows);
			
		}
		  else if (ae.getSource()== clrBtn){
			
			nameTF.setText("");
			nidTF.setText("");
			phoneNumberTF.setText("");
			
		}
		else if (ae.getSource()==removeBtn){
			
			int n = table.getSelectedRow();
			if (n>=0){
				model.removeRow(n);
			}else {
				JOptionPane.showMessageDialog(null,"no row has been selected or no row exits");
			}
			
		}
		else if (ae.getSource ()== updateBtn){
			
			int n = table.getSelectedRow();
			
			String name_f = nameTF.getText();
			String nid_f = nidTF.getText();
			String phoneNumber_f = phoneNumberTF.getText();
			
			model.setValueAt (name_f,n,0);
			model.setValueAt (nid_f,n,1);
			model.setValueAt (phoneNumber_f,n,2);
			
		}
			
		}
}