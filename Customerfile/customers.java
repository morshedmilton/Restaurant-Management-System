package Customerfile;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import Interface.ICustomers;

public class customers implements ICustomers {
    private customer customerList[] = new customer[1000];
    private static int customerCount = 0;

    public customers() {
        try {
            File dataDir = new File("Data");
            if (!dataDir.exists()) {
                dataDir.mkdirs();
            }
            File file = new File("Data/customer_data.txt");
            if (file.exists()) {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String line1 = sc.nextLine();
                    if (line1.isEmpty()) continue;
                    String line2 = sc.nextLine();
                    String line3 = sc.nextLine();
                    if (sc.hasNextLine()) {
                        sc.nextLine();
                    }
                    customer c = new customer(line1, line2, line3);
                    customerList[customerCount++] = c;
                }
                sc.close();
            }
        } catch (Exception ex) {
            System.out.println("Error loading customer data: " + ex.getMessage());
        }
    }

    public int customerExists(String email) {
        for (int i = 0; i < customerCount; i++) {
            if (customerList[i].getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }

    public customer checkCredentials(int index, String pass) {
        if (index >= 0 && index < customerCount && customerList[index].getPassword().equals(pass)) {
            return customerList[index];
        }
        return null;
    }

    public customer getCustomer(int index) {
        if (index >= 0 && index < customerCount) {
            return customerList[index];
        }
        return null;
    }

    public void addCustomer(customer c) {
        if (customerCount < customerList.length) {
            customerList[customerCount++] = c;
            String customerDetails = c.getEmail() + "\n" + c.getPassword() + "\n" + c.getPhone() + "\n\n";
            try {
                FileWriter fw = new FileWriter("Data/customer_data.txt", true);
                fw.write(customerDetails);
                fw.close();
            } catch (Exception ex) {
                System.out.println("Error saving customer data: " + ex.getMessage());
            }
        }
    }
}