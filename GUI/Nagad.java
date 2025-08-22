package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Customerfile.*;

public class Nagad extends JFrame implements ActionListener {
    private JTextField phoneNumberTF;
    private JPasswordField pinTF;
    private customers cs;
    public Nagad(customers cs) {
        super("Nagad Payment");
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
        JLabel paymentLabel = new JLabel("Nagad Payment");
        paymentLabel.setBounds(0, 40, 500, 50);
        paymentLabel.setForeground(Color.WHITE);
        paymentLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        paymentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        formPanel.add(paymentLabel);
        JLabel numberLabel = new JLabel("Phone Number:");
        numberLabel.setBounds(50, 120, 150, 30);
        numberLabel.setForeground(Color.WHITE);
        numberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(numberLabel);
        phoneNumberTF = new JTextField();
        phoneNumberTF.setBounds(50, 150, 400, 35);
        phoneNumberTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(phoneNumberTF);
        JLabel pinLabel = new JLabel("Enter PIN:");
        pinLabel.setBounds(50, 200, 150, 30);
        pinLabel.setForeground(Color.WHITE);
        pinLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(pinLabel);
        pinTF = new JPasswordField();
        pinTF.setBounds(50, 230, 400, 35);
        pinTF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(pinTF);
        JButton processBtn = new JButton("Process Payment");
        processBtn.setBounds(50, 300, 190, 40);
        processBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        processBtn.setBackground(new Color(46, 204, 113));
        processBtn.setForeground(Color.WHITE);
        processBtn.addActionListener(this);
        formPanel.add(processBtn);
        JButton closeBtn = new JButton("Cancel");
        closeBtn.setBounds(260, 300, 190, 40);
        closeBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        closeBtn.setBackground(new Color(149, 165, 166));
        closeBtn.setForeground(Color.WHITE);
        closeBtn.addActionListener(this);
        formPanel.add(closeBtn);
    }
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("Process Payment")) {
            String pin = new String(pinTF.getPassword());
            String phoneNumber = phoneNumberTF.getText();
            if (!pin.isEmpty() && !phoneNumber.isEmpty()) {
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