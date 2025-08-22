package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Customerfile.*;

public class login extends JFrame implements ActionListener {
    private JTextField emailTF;
    private JPasswordField passwordTF;
    private customers cs;
    public login(customers cs) {
        super("Login");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.cs = cs;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 500, 700);
        leftPanel.setBackground(new Color(41, 128, 185));
        leftPanel.setLayout(null);
        panel.add(leftPanel);
        JLabel appName = new JLabel("Wanmin Restaurant");
        appName.setBounds(0, 270, 500, 50);
        appName.setForeground(Color.WHITE);
        appName.setFont(new Font("Segoe UI", Font.BOLD, 36));
        appName.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(appName);
        JLabel slogan = new JLabel("Experience the Taste of Excellence");
        slogan.setBounds(0, 320, 500, 30);
        slogan.setForeground(Color.WHITE);
        slogan.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        slogan.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(slogan);
        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(500, 0, 500, 700);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(null);
        panel.add(rightPanel);
        JLabel loginTitle = new JLabel("Customer Login");
        loginTitle.setBounds(0, 100, 500, 40);
        loginTitle.setForeground(new Color(44, 62, 80));
        loginTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        loginTitle.setHorizontalAlignment(SwingConstants.CENTER);
        rightPanel.add(loginTitle);
        JLabel emailLabel = new JLabel("Email Address:");
        emailLabel.setBounds(50, 200, 150, 30);
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rightPanel.add(emailLabel);
        emailTF = new JTextField();
        emailTF.setBounds(50, 230, 400, 35);
        emailTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rightPanel.add(emailTF);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 280, 150, 30);
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rightPanel.add(passwordLabel);
        passwordTF = new JPasswordField();
        passwordTF.setBounds(50, 310, 400, 35);
        passwordTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rightPanel.add(passwordTF);
        JButton lgnBtn = new JButton("Login");
        lgnBtn.setBounds(50, 370, 190, 40);
        lgnBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lgnBtn.setBackground(new Color(52, 152, 219));
        lgnBtn.setForeground(Color.WHITE);
        lgnBtn.addActionListener(this);
        rightPanel.add(lgnBtn);
        JButton lgnAdBtn = new JButton("Login as Admin");
        lgnAdBtn.setBounds(260, 370, 190, 40);
        lgnAdBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lgnAdBtn.setBackground(new Color(231, 76, 60));
        lgnAdBtn.setForeground(Color.WHITE);
        lgnAdBtn.addActionListener(this);
        rightPanel.add(lgnAdBtn);
        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(50, 430, 400, 40);
        exitBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        exitBtn.setBackground(new Color(149, 165, 166));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener(this);
        rightPanel.add(exitBtn);
        JLabel registerLabel = new JLabel("Don't have an account?");
        registerLabel.setBounds(130, 500, 180, 30);
        registerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rightPanel.add(registerLabel);
        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(290, 500, 100, 30);
        registerBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        registerBtn.setForeground(new Color(52, 152, 219));
        registerBtn.setOpaque(false);
        registerBtn.setContentAreaFilled(false);
        registerBtn.setBorderPainted(false);
        registerBtn.addActionListener(this);
        rightPanel.add(registerBtn);
    }
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("Login")) {
            String email = emailTF.getText();
            String pass = new String(passwordTF.getPassword());
            if (!email.isEmpty() && !pass.isEmpty()) {
                int index = cs.customerExists(email);
                if (index != -1) {
                    customer c = cs.checkCredentials(index, pass);
                    if (c != null) {
                        JOptionPane.showMessageDialog(this, "Login Successful");
                        WelcomePage we = new WelcomePage(cs);
                        we.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Wrong Credentials", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "User doesn't exist!", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Login Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (command.equals("Login as Admin")) {
            loginAdmin la = new loginAdmin(cs);
            la.setVisible(true);
            this.dispose();
        } else if (command.equals("Register")) {
            Register ri = new Register(cs);
            ri.setVisible(true);
            this.dispose();
        } else if (command.equals("Exit")) {
            System.exit(0);
        }
    }
}