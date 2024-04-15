package order_details.model;

public class OrderDetails {

    private int id;
    private int orderId;
    private int productId;
    private double price;
    private int quantity;

    public OrderDetails(int id, int order_id, int product_id, double price, int quantity) {

        this.id = id;
        this.orderId = order_id;
        this.productId = product_id;
        this.price = price;
        this.quantity = quantity;

    }

    public OrderDetails(String text){

        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.orderId = Integer.parseInt(tokens[1]);
        this.productId = Integer.parseInt(tokens[2]);
        this.price = Double.parseDouble(tokens[3]);
        this.quantity = Integer.parseInt(tokens[4]);

    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getOrderid() {return orderId;}
    public void setOrderIdid(int order_id) {this.orderId = order_id;}
    public int getProductId() {return productId;}
    public void setProductId(int product_id) {this.productId = product_id;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public String desciere(){

        String text = "";
        text+= "Id: " + this.id + "\n";
        text+= "Order ID: " + this.orderId + "\n";
        text+= "Product ID: " + this.productId + "\n";
        text+= "Price: " + this.price + "\n";
        text+= "Quantity: " + this.quantity + "\n";
        return text;

    }
}
