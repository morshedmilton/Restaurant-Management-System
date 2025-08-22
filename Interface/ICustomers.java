package Interface;
import Customerfile.customer;

public interface ICustomers {
    void addCustomer(customer c);
    customer getCustomer(int index);
}