package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Customerfile.*;

public class Register extends JFrame implements ActionListener {
    private JTextField userTF, phoneNumberTF;
    private JPasswordField passwordTF, confirmPasswordTF;
    private customers cs;

    public Register(customers cs) {
        super("Register");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.cs = cs;
        ImagePanel panel = new ImagePanel("images/Background.jpg");
        this.setContentPane(panel);
        JPanel formPanel = new JPanel();
        formPanel.setBounds(250, 110, 500, 520);
        formPanel.setBackground(new Color(0, 0, 0, 120));
        formPanel.setLayout(null);
        panel.add(formPanel);
        JLabel titleLabel = new JLabel("Create an Account");
        titleLabel.setBounds(0, 30, 500, 40);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        formPanel.add(titleLabel);
        JLabel userLabel = new JLabel("Email Address:");
        userLabel.setBounds(50, 100, 150, 30);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(userLabel);
        userTF = new JTextField();
        userTF.setBounds(50, 130, 400, 35);
        userTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(userTF);
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setBounds(50, 180, 150, 30);
        phoneNumberLabel.setForeground(Color.WHITE);
        phoneNumberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(phoneNumberLabel);
        phoneNumberTF = new JTextField();
        phoneNumberTF.setBounds(50, 210, 400, 35);
        phoneNumberTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(phoneNumberTF);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 260, 150, 30);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(passwordLabel);
        passwordTF = new JPasswordField();
        passwordTF.setBounds(50, 290, 400, 35);
        passwordTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(passwordTF);
        JLabel confirmPassLabel = new JLabel("Confirm Password:");
        confirmPassLabel.setBounds(50, 340, 150, 30);
        confirmPassLabel.setForeground(Color.WHITE);
        confirmPassLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(confirmPassLabel);
        confirmPasswordTF = new JPasswordField();
        confirmPasswordTF.setBounds(50, 370, 400, 35);
        confirmPasswordTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(confirmPasswordTF);
        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(50, 430, 190, 40);
        registerBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        registerBtn.setBackground(new Color(46, 204, 113));
        registerBtn.setForeground(Color.WHITE);
        registerBtn.addActionListener(this);
        formPanel.add(registerBtn);
        JButton backBtn = new JButton("Back to Login");
        backBtn.setBounds(260, 430, 190, 40);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        backBtn.setBackground(new Color(149, 165, 166));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        formPanel.add(backBtn);
    }
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("Register")) {
            String email = userTF.getText();
            String phone = phoneNumberTF.getText();
            String password = new String(passwordTF.getPassword());
            String confirmPass = new String(confirmPasswordTF.getPassword());
            if (!email.isEmpty() && !phone.isEmpty() && !password.isEmpty() && !confirmPass.isEmpty()) {
                if (password.equals(confirmPass)) {
                    customer c = new customer(email, password, phone);
                    cs.addCustomer(c);
                    JOptionPane.showMessageDialog(this, "Registration successful! Please login to continue.");
                    login lg = new login(cs);
                    lg.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Passwords do not match.", "Registration Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Registration Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (command.equals("Back to Login")) {
            login lg = new login(cs);
            lg.setVisible(true);
            this.dispose();
        }
    }
}