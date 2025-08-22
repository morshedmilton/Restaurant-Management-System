package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Customerfile.*;

public class About extends JFrame implements ActionListener {
    private customers cs;
    public About(customers cs) {
        super("About Us");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.cs = cs;
        ImagePanel panel = new ImagePanel("images/Background.jpg");
        this.setContentPane(panel);
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(100, 120, 800, 460);
        contentPanel.setBackground(new Color(0, 0, 0, 120));
        contentPanel.setLayout(null);
        panel.add(contentPanel);
        JLabel headline = new JLabel("About Us");
        headline.setBounds(0, 30, 800, 30);
        headline.setFont(new Font("Segoe UI", Font.BOLD, 28));
        headline.setForeground(Color.WHITE);
        headline.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(headline);
        JTextArea aboutText = new JTextArea(
            "Welcome to Wanmin Restaurant, where culinary passion meets creativity to elevate your dining experience.\n\n" +
            "Location:\nBhashundhara R/A, Dhaka 1229, Bangladesh\n\n" +
            "Contact Information:\nPhone: 01700-000000, 01600-000000\nEmail: wanmin.restaurant@info.com\n\n" +
            "Privacy Policy:\nWe are committed to protecting your personal information. Your data is used solely for improving our services and is never shared with third parties without your consent.\n\n" +
            "Support:\nFor any assistance or queries, please feel free to contact our support team via email or phone."
        );
        aboutText.setBounds(50, 90, 700, 250);
        aboutText.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        aboutText.setForeground(Color.WHITE);
        aboutText.setOpaque(false);
        aboutText.setEditable(false);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        contentPanel.add(aboutText);
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(340, 380, 120, 40);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        backBtn.setBackground(new Color(52, 152, 219));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        contentPanel.add(backBtn);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Back")) {
            WelcomePage wp = new WelcomePage(cs);
            wp.setVisible(true);
            this.dispose();
        }
    }
}