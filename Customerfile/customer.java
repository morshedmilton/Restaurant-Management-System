package Customerfile;

public class customer {
    private String email;
    private String phone;
    private String password;

    public customer(String email, String password, String phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhone() { return phone; }
}