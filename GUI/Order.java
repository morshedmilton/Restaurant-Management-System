package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Customerfile.*;

public class Order extends JFrame implements ActionListener {
    private customers cs;
    public Order(customers cs) {
        super("Order Confirmation");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.cs = cs;
        ImagePanel panel = new ImagePanel("images/Background.jpg");
        this.setContentPane(panel);
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(150, 200, 700, 300);
        contentPanel.setBackground(new Color(0, 0, 0, 120));
        contentPanel.setLayout(null);
        panel.add(contentPanel);
        JLabel orderLabel = new JLabel("Order Placed Successfully!");
        orderLabel.setBounds(0, 80, 700, 50);
        orderLabel.setForeground(Color.WHITE);
        orderLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        orderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(orderLabel);
        JButton backBtn = new JButton("Back to Menu");
        backBtn.setBounds(250, 180, 200, 50);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        backBtn.setBackground(new Color(52, 152, 219));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        contentPanel.add(backBtn);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Back to Menu")) {
            Menu mn = new Menu(cs);
            mn.setVisible(true);
            this.dispose();
        }
    }
}