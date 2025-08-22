package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Customerfile.*;

public class Admin extends JFrame implements ActionListener {
    private customers cs;
    public Admin(customers cs) {
        super("Admin Dashboard");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.cs = cs;
        ImagePanel panel = new ImagePanel("images/Background.jpg");
        this.setContentPane(panel);
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(150, 150, 700, 400);
        contentPanel.setBackground(new Color(0, 0, 0, 120));
        contentPanel.setLayout(null);
        panel.add(contentPanel);
        JLabel titleLabel = new JLabel("Admin Dashboard");
        titleLabel.setBounds(0, 40, 700, 40);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel);
        JButton employeeBtn = new JButton("Manage Employees");
        employeeBtn.setBounds(200, 150, 300, 80);
        employeeBtn.setFont(new Font("Segoe UI", Font.BOLD, 22));
        employeeBtn.setBackground(new Color(52, 152, 219));
        employeeBtn.setForeground(Color.WHITE);
        employeeBtn.addActionListener(this);
        contentPanel.add(employeeBtn);
        JButton backBtn = new JButton("Logout");
        backBtn.setBounds(250, 280, 200, 50);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        backBtn.setBackground(new Color(231, 76, 60));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        contentPanel.add(backBtn);
    }
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("Manage Employees")) {
            Employee em = new Employee(cs);
            em.setVisible(true);
            this.dispose();
        } else if (command.equals("Logout")) {
            login lg = new login(cs);
            lg.setVisible(true);
            this.dispose();
        }
    }
}