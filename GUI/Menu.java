package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import Customerfile.*;

public class Menu extends JFrame implements ActionListener {
    private JSpinner[] spinners;
    private customers cs;
    private String[] mainCourseItems = {"Cheeseburger - 200/=", "Cheese Sandwich - 250/=", "Chicken Burger - 180/=", "Spicy Chicken - 170/=", "Hot Dog - 190/="};
    private String[] appetizerItems = {"Fruit Salad - 130/=", "Cocktails - 120/=", "Nuggets - 100/=", "Sandwich - 70/=", "French Fries - 130/="};
    private String[] beverageItems = {"Milk Shake - 80/=", "Iced Tea - 70/=", "Orange Juice - 100/=", "Lemon Tea - 40/="};

    public Menu(customers cs) {
        super("Menu");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.cs = cs;
        ImagePanel panel = new ImagePanel("images/Background.jpg");
        this.setContentPane(panel);
        JLabel menuLabel = new JLabel("Food Menu");
        menuLabel.setBounds(0, 40, 1000, 40);
        menuLabel.setForeground(Color.WHITE);
        menuLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(menuLabel);
        JPanel mainCoursePanel = createCategoryPanel("Main Course", mainCourseItems, 0);
        mainCoursePanel.setBounds(50, 120, 400, 220);
        panel.add(mainCoursePanel);
        JPanel appetizerPanel = createCategoryPanel("Appetizers", appetizerItems, mainCourseItems.length);
        appetizerPanel.setBounds(50, 350, 400, 220);
        panel.add(appetizerPanel);
        JPanel beveragePanel = createCategoryPanel("Beverages", beverageItems, mainCourseItems.length + appetizerItems.length);
        beveragePanel.setBounds(550, 120, 400, 190);
        panel.add(beveragePanel);
        JButton processBtn = new JButton("Process Order");
        processBtn.setBounds(550, 520, 200, 50);
        processBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        processBtn.setBackground(new Color(46, 204, 113));
        processBtn.setForeground(Color.WHITE);
        processBtn.addActionListener(this);
        panel.add(processBtn);
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(780, 520, 170, 50);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        backBtn.setBackground(new Color(149, 165, 166));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        panel.add(backBtn);
    }
    private JPanel createCategoryPanel(String title, String[] items, int spinnerStartIndex) {
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(null);
        categoryPanel.setOpaque(false);
        TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), title);
        border.setTitleFont(new Font("Segoe UI", Font.BOLD, 18));
        border.setTitleColor(Color.WHITE);
        categoryPanel.setBorder(border);
        int yPos = 40;
        spinners = new JSpinner[mainCourseItems.length + appetizerItems.length + beverageItems.length];
        for (int i = 0; i < items.length; i++) {
            JCheckBox checkBox = new JCheckBox(items[i]);
            checkBox.setBounds(20, yPos, 250, 25);
            checkBox.setForeground(Color.WHITE);
            checkBox.setOpaque(false);
            checkBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            categoryPanel.add(checkBox);
            spinners[spinnerStartIndex + i] = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
            spinners[spinnerStartIndex + i].setBounds(300, yPos, 50, 25);
            categoryPanel.add(spinners[spinnerStartIndex + i]);
            yPos += 30;
        }
        return categoryPanel;
    }
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("Process Order")) {
            JOptionPane.showMessageDialog(this, "Your order is being processed.");
            Payment pd = new Payment(cs);
            pd.setVisible(true);
            this.dispose();
        } else if (command.equals("Back")) {
            WelcomePage wp = new WelcomePage(cs);
            wp.setVisible(true);
            this.dispose();
        }
    }
}