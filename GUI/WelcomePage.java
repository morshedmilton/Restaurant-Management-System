package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Customerfile.*;

public class WelcomePage extends JFrame implements ActionListener {
    private customers cs;
    public WelcomePage(customers cs) {
        super("Welcome");
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
        JLabel welcomeLabel = new JLabel("Welcome to Wanmin Restaurant");
        welcomeLabel.setBounds(0, 50, 700, 60);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(welcomeLabel);
        JButton menuBtn = new JButton("View Menu");
        menuBtn.setBounds(250, 150, 200, 50);
        menuBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        menuBtn.setBackground(new Color(52, 152, 219));
        menuBtn.setForeground(Color.WHITE);
        menuBtn.addActionListener(this);
        contentPanel.add(menuBtn);
        JButton aboutBtn = new JButton("About Us");
        aboutBtn.setBounds(250, 220, 200, 50);
        aboutBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        aboutBtn.setBackground(new Color(52, 152, 219));
        aboutBtn.setForeground(Color.WHITE);
        aboutBtn.addActionListener(this);
        contentPanel.add(aboutBtn);
        JButton backBtn = new JButton("Logout");
        backBtn.setBounds(275, 300, 150, 40);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        backBtn.setBackground(new Color(231, 76, 60));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        contentPanel.add(backBtn);
    }
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("View Menu")) {
            Menu mu = new Menu(cs);
            mu.setVisible(true);
            this.dispose();
        } else if (command.equals("About Us")) {
            About ab = new About(cs);
            ab.setVisible(true);
            this.dispose();
        } else if (command.equals("Logout")) {
            login lg = new login(cs);
            lg.setVisible(true);
            this.dispose();
        }
    }
}