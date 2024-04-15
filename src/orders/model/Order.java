package orders.model;

public class Order {

    private int id;
    private int customerId;
    private double totalAmount;
    public Order(int id, int customerId, double amount) {

        this.id = id;
        this.customerId = customerId;
        this.totalAmount = amount;

    }

    public Order(String text){

        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.customerId = Integer.parseInt(tokens[1]);
        this.totalAmount = Integer.parseInt(tokens[2]);


    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) {this.customerId = customerId;}
    public double getTotalAmount() {return totalAmount;}
    public void setTotalAmount(double totalAmount) {this.totalAmount = totalAmount;}


    public String descriere(){
        String text = "";

        text += "Id: " + this.id + "\n";
        text += "Customer: " + this.customerId + "\n";
        text += "Total: " + this.totalAmount + "\n";
        return text;
    }

}
