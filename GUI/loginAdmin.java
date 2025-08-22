package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Customerfile.*;

public class loginAdmin extends JFrame implements ActionListener {
    private JTextField emailTF;
    private JPasswordField passwordTF;
    private customers cs;
    public loginAdmin(customers cs) {
        super("Admin Login");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.cs = cs;
        ImagePanel panel = new ImagePanel("images/Background.jpg");
        this.setContentPane(panel);
        JPanel formPanel = new JPanel();
        formPanel.setBounds(250, 150, 500, 400);
        formPanel.setBackground(new Color(0, 0, 0, 120));
        formPanel.setLayout(null);
        panel.add(formPanel);
        JLabel titleLabel = new JLabel("Admin Login");
        titleLabel.setBounds(0, 40, 500, 40);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        formPanel.add(titleLabel);
        JLabel emailLabel = new JLabel("Admin Email:");
        emailLabel.setBounds(50, 120, 150, 30);
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(emailLabel);
        emailTF = new JTextField("java");
        emailTF.setBounds(50, 150, 400, 35);
        emailTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(emailTF);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 200, 150, 30);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(passwordLabel);
        passwordTF = new JPasswordField("java");
        passwordTF.setBounds(50, 230, 400, 35);
        passwordTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(passwordTF);
        JButton lgnBtn = new JButton("Login");
        lgnBtn.setBounds(50, 300, 190, 40);
        lgnBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lgnBtn.setBackground(new Color(231, 76, 60));
        lgnBtn.setForeground(Color.WHITE);
        lgnBtn.addActionListener(this);
        formPanel.add(lgnBtn);
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(260, 300, 190, 40);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        backBtn.setBackground(new Color(149, 165, 166));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        formPanel.add(backBtn);
    }
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("Login")) {
            String email = emailTF.getText();
            String pass = new String(passwordTF.getPassword());
            if (email.equals("java") && pass.equals("java")) {
                JOptionPane.showMessageDialog(this, "Admin Login Successful");
                Admin ag = new Admin(cs);
                ag.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Wrong Admin Credentials", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (command.equals("Back")) {
            login lg = new login(cs);
            lg.setVisible(true);
            this.dispose();
        }
    }
}