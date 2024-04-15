package utile;

import products.model.Product;

import java.util.ArrayList;

public class Cos {

    private int customerId;
    private ArrayList<ProductDto> products;

    public Cos(int customerId, ArrayList<ProductDto> products) {

        this.customerId = customerId;
        this.products = products;
    }

    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) {this.customerId = customerId;}
    public ArrayList<ProductDto> getProducts() {return products;}
    public void setProducts(ArrayList<ProductDto> products) {this.products = products;}


}

