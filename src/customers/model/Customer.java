package customers.model;

public class Customer {

    private int id;
    private String email;
    private String password;
    private String fullName;
    private String billingAdress;
    private String defaultShippingAddress;
    private String country;
    private int phone;

    public Customer(int id, String email, String password, String fullName, String billingAdress, String defaultShippingAddress, String country, int phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.billingAdress = billingAdress;
        this.defaultShippingAddress = defaultShippingAddress;
        this.country = country;
        this.phone = phone;
    }
    public Customer(String text){

        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.email = tokens[1];
        this.password = tokens[2];
        this.fullName = tokens[3];
        this.billingAdress = tokens[4];
        this.defaultShippingAddress = tokens[5];
        this.country = tokens[6];
        this.phone = Integer.parseInt(tokens[7]);

    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public String getBillingAdress() {return billingAdress;}
    public void setBillingAdress(String billingAdress) {this.billingAdress = billingAdress;}
    public String getDefaultShippingAddress() {return defaultShippingAddress;}
    public void setDefaultShippingAddress(String defaultShippingAddress) {this.defaultShippingAddress = defaultShippingAddress;}
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}
    public int getPhone() {return phone;}
    public void setPhone(int phone) {this.phone = phone;}

    public String descriere(){

        String text = "";

        text+= "Id: " + this.id + "\n";
        text+= "Email: " + this.email + "\n";
        text+= "Password: " + this.password + "\n";
        text+= "Full Name: " + this.fullName + "\n";
        text+= "BillingAdress: " + this.billingAdress + "\n";
        text+= "DefaultShippingAddress: " + this.defaultShippingAddress + "\n";
        text+= "Country: " + this.country + "\n";
        text+= "Phone: " + this.phone + "\n";
        return text;

    }


}
