package products.model;

public class Product {

    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(String text){

        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.name = tokens[1];
        this.price = Double.parseDouble(tokens[2]);
        this.stock = Integer.parseInt(tokens[3]);

    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}

    public String descriere(){

        String text = "";

        text+= "Id: " + this.id + "\n";
        text+= "Name: " + this.name + "\n";
        text+= "Price: " + this.price + "\n";
        text+= "Stock: " + this.stock + "\n";
        return text;

    }

}
