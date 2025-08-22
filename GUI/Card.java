package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Customerfile.*;

public class Card extends JFrame implements ActionListener {
    private JTextField nameTF, cardNumberTF, expTF;
    private JPasswordField cvvTF;
    private customers cs;
    public Card(customers cs) {
        super("Card Payment");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.cs = cs;
        ImagePanel panel = new ImagePanel("images/Background.jpg");
        this.setContentPane(panel);
        JPanel formPanel = new JPanel();
        formPanel.setBounds(250, 120, 500, 460);
        formPanel.setBackground(new Color(0, 0, 0, 120));
        formPanel.setLayout(null);
        panel.add(formPanel);
        JLabel paymentLabel = new JLabel("Card Payment");
        paymentLabel.setBounds(0, 30, 500, 50);
        paymentLabel.setForeground(Color.WHITE);
        paymentLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        paymentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        formPanel.add(paymentLabel);
        JLabel nameLabel = new JLabel("Cardholder Name:");
        nameLabel.setBounds(50, 100, 150, 30);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(nameLabel);
        nameTF = new JTextField();
        nameTF.setBounds(50, 130, 400, 35);
        nameTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(nameTF);
        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(50, 180, 150, 30);
        cardNumberLabel.setForeground(Color.WHITE);
        cardNumberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(cardNumberLabel);
        cardNumberTF = new JTextField();
        cardNumberTF.setBounds(50, 210, 400, 35);
        cardNumberTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(cardNumberTF);
        JLabel expLabel = new JLabel("Expiry Date (MM/YY):");
        expLabel.setBounds(50, 260, 180, 30);
        expLabel.setForeground(Color.WHITE);
        expLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(expLabel);
        expTF = new JTextField();
        expTF.setBounds(50, 290, 180, 35);
        expTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(expTF);
        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setBounds(270, 260, 50, 30);
        cvvLabel.setForeground(Color.WHITE);
        cvvLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(cvvLabel);
        cvvTF = new JPasswordField();
        cvvTF.setBounds(270, 290, 180, 35);
        cvvTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(cvvTF);
        JButton processBtn = new JButton("Process Payment");
        processBtn.setBounds(50, 370, 190, 40);
        processBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        processBtn.setBackground(new Color(46, 204, 113));
        processBtn.setForeground(Color.WHITE);
        processBtn.addActionListener(this);
        formPanel.add(processBtn);
        JButton closeBtn = new JButton("Cancel");
        closeBtn.setBounds(260, 370, 190, 40);
        closeBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        closeBtn.setBackground(new Color(149, 165, 166));
        closeBtn.setForeground(Color.WHITE);
        closeBtn.addActionListener(this);
        formPanel.add(closeBtn);
    }
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("Process Payment")) {
            String cvv = new String(cvvTF.getPassword());
            if (!nameTF.getText().isEmpty() && !cardNumberTF.getText().isEmpty() && !expTF.getText().isEmpty() && !cvv.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Payment successful.");
                Order od = new Order(cs);
                od.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Payment Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (command.equals("Cancel")) {
            Payment pa = new Payment(cs);
            this.setVisible(false);
            pa.setVisible(true);
        }
    }
}