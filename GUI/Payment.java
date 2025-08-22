package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Customerfile.*;

public class Payment extends JFrame implements ActionListener {
    private customers cs;
    public Payment(customers cs) {
        super("Payment");
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
        JLabel selectLabel = new JLabel("Select Payment Method");
        selectLabel.setBounds(0, 50, 700, 30);
        selectLabel.setForeground(Color.WHITE);
        selectLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        selectLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(selectLabel);
        JButton bkashBtn = new JButton("Bkash");
        bkashBtn.setIcon(new ImageIcon(new ImageIcon("images/bkash.jpg").getImage().getScaledInstance(120, 60, Image.SCALE_SMOOTH)));
        bkashBtn.setBounds(100, 150, 150, 100);
        bkashBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        bkashBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        bkashBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        bkashBtn.addActionListener(this);
        contentPanel.add(bkashBtn);
        JButton nagadBtn = new JButton("Nagad");
        nagadBtn.setIcon(new ImageIcon(new ImageIcon("images/nagad.png").getImage().getScaledInstance(120, 60, Image.SCALE_SMOOTH)));
        nagadBtn.setBounds(275, 150, 150, 100);
        nagadBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        nagadBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        nagadBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        nagadBtn.addActionListener(this);
        contentPanel.add(nagadBtn);
        JButton cardBtn = new JButton("Card");
        cardBtn.setIcon(new ImageIcon(new ImageIcon("images/card.jpg").getImage().getScaledInstance(120, 60, Image.SCALE_SMOOTH)));
        cardBtn.setBounds(450, 150, 150, 100);
        cardBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        cardBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        cardBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        cardBtn.addActionListener(this);
        contentPanel.add(cardBtn);
        JButton backBtn = new JButton("Back to Menu");
        backBtn.setBounds(275, 300, 150, 40);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        backBtn.setBackground(new Color(149, 165, 166));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        contentPanel.add(backBtn);
    }
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("Bkash")) {
            Bkash bk = new Bkash(cs);
            bk.setVisible(true);
            this.dispose();
        } else if (command.equals("Nagad")) {
            Nagad na = new Nagad(cs);
            na.setVisible(true);
            this.dispose();
        } else if (command.equals("Card")) {
            Card ca = new Card(cs);
            ca.setVisible(true);
            this.dispose();
        } else if (command.equals("Back to Menu")) {
            Menu mn = new Menu(cs);
            mn.setVisible(true);
            this.dispose();
        }
    }
}