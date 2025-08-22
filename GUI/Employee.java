package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Customerfile.*;

public class Employee extends JFrame implements ActionListener {
    private JTextField nameTF, phoneNumberTF, nidTF;
    private DefaultTableModel model;
    private JTable table;
    private String[] rows = new String[3];
    private customers cs;

    public Employee(customers cs) {
        super("Employee Management");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.cs = cs;
        ImagePanel panel = new ImagePanel("images/Background.jpg");
        this.setContentPane(panel);
        JLabel uperLabel = new JLabel("Employee Information");
        uperLabel.setBounds(0, 40, 1000, 40);
        uperLabel.setForeground(Color.WHITE);
        uperLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        uperLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(uperLabel);
        JPanel formPanel = new JPanel();
        formPanel.setBounds(30, 120, 400, 500);
        formPanel.setBackground(new Color(0,0,0,120));
        formPanel.setLayout(null);
        panel.add(formPanel);
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(nameLabel);
        nameTF = new JTextField();
        nameTF.setBounds(30, 60, 340, 30);
        nameTF.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(nameTF);
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(30, 100, 100, 25);
        idLabel.setForeground(Color.WHITE);
        idLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(idLabel);
        nidTF = new JTextField();
        nidTF.setBounds(30, 130, 340, 30);
        nidTF.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(nidTF);
        JLabel phoneNumberLabel = new JLabel("Phone number:");
        phoneNumberLabel.setBounds(30, 170, 120, 25);
        phoneNumberLabel.setForeground(Color.WHITE);
        phoneNumberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(phoneNumberLabel);
        phoneNumberTF = new JTextField();
        phoneNumberTF.setBounds(30, 200, 340, 30);
        phoneNumberTF.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(phoneNumberTF);
        JButton addBtn = new JButton("Add Employee");
        addBtn.setBounds(30, 260, 160, 40);
        addBtn.setBackground(new Color(46, 204, 113));
        addBtn.setForeground(Color.WHITE);
        addBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        addBtn.addActionListener(this);
        formPanel.add(addBtn);
        JButton removeBtn = new JButton("Remove");
        removeBtn.setBounds(210, 260, 160, 40);
        removeBtn.setBackground(new Color(231, 76, 60));
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        removeBtn.addActionListener(this);
        formPanel.add(removeBtn);
        JButton clrBtn = new JButton("Clear Fields");
        clrBtn.setBounds(30, 320, 160, 40);
        clrBtn.setBackground(new Color(241, 196, 15));
        clrBtn.setForeground(Color.WHITE);
        clrBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        clrBtn.addActionListener(this);
        formPanel.add(clrBtn);
        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(210, 320, 160, 40);
        updateBtn.setBackground(new Color(52, 152, 219));
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        updateBtn.addActionListener(this);
        formPanel.add(updateBtn);
        JButton backBtn = new JButton("Back to Dashboard");
        backBtn.setBounds(30, 400, 340, 40);
        backBtn.setBackground(new Color(149, 165, 166));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backBtn.addActionListener(this);
        formPanel.add(backBtn);
        String[] cols = {"Name", "ID", "Phone Number"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(cols);
        table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setRowHeight(30);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int n = table.getSelectedRow();
                if (n != -1) {
                    nameTF.setText(model.getValueAt(n, 0).toString());
                    nidTF.setText(model.getValueAt(n, 1).toString());
                    phoneNumberTF.setText(model.getValueAt(n, 2).toString());
                }
            }
        });
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(450, 120, 500, 500);
        panel.add(scroll);
    }
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("Add Employee")) {
            rows[0] = nameTF.getText();
            rows[1] = nidTF.getText();
            rows[2] = phoneNumberTF.getText();
            model.addRow(rows);
            clearFields();
        } else if (command.equals("Remove")) {
            int n = table.getSelectedRow();
            if (n >= 0) {
                model.removeRow(n);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "No row has been selected to remove.");
            }
        } else if (command.equals("Clear Fields")) {
            clearFields();
        } else if (command.equals("Update")) {
            int n = table.getSelectedRow();
            if (n >= 0) {
                model.setValueAt(nameTF.getText(), n, 0);
                model.setValueAt(nidTF.getText(), n, 1);
                model.setValueAt(phoneNumberTF.getText(), n, 2);
            } else {
                JOptionPane.showMessageDialog(null, "No row has been selected to update.");
            }
        } else if (command.equals("Back to Dashboard")) {
            Admin ad = new Admin(cs);
            ad.setVisible(true);
            this.dispose();
        }
    }
    private void clearFields(){
        nameTF.setText("");
        nidTF.setText("");
        phoneNumberTF.setText("");
    }
}