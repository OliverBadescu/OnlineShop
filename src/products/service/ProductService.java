package products.service;

import products.model.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {

    private ArrayList<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();

        this.loadData();
    }

    private void loadData(){

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\OnlineShop\\src\\products\\data\\products.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Product product = new Product(line);

                this.products.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void afisare(){
        for(int i=0; i<this.products.size(); i++){
            System.out.println(products.get(i).descriere());
        }
    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findProductById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Product findProductById(int id){
        for (int i =0; i < products.size();i++){
            if(products.get(i).getId() == id){
                return products.get(i);
            }
        }
        return null;
    }

    public Product findByName(String name){
        for(int i =0; i < products.size();i++){
            if(products.get(i).getName().equals(name)){
                return products.get(i);
            }
        }
        return null;
    }

    public void sortareDupaPretCrescator(){

        boolean sortat = false;

        do {

            sortat = true;

            for (int i = 0; i < products.size()-1; i++) {

                if (products.get(i).getPrice() < products.get(i+1).getPrice()) {
                    Product temp = products.get(i);
                    products.set(i, products.get(i+1));
                    products.set(i+1, temp);
                    sortat = false;
                }

            }

        } while (!sortat);

    }

    public void sortareDupaPretDescrescator(){

        boolean sortat = false;

        do {

            sortat = true;

            for (int i = 0; i < products.size()-1; i++) {

                if (products.get(i).getPrice() > products.get(i+1).getPrice()) {
                    Product temp = products.get(i);
                    products.set(i, products.get(i+1));
                    products.set(i+1, temp);
                    sortat = false;
                }

            }

        } while (!sortat);

    }

    public void stergereProdus(Product product){
        this.products.remove(product);
    }

    public boolean adaugareProdus(Product product){
        for(int i =0 ; i < products.size(); i++){
            if(products.get(i).getName().equals(product.getName())){
                return false;
            }
        }
        this.products.add(product);
        return true;
    }

    public void promoCraciun(){
        for(int i =0 ; i < products.size(); i++){
            products.get(i).setPrice(products.get(i).getPrice() * 0.5);
        }
    }

    public void promoPaste(){
        for(int i =0 ; i < products.size(); i++){
            products.get(i).setPrice(products.get(i).getPrice() * 0.3);
        }
    }

    public void anularePromoCraciun(){

        for(int i =0 ; i < products.size(); i++){
            products.get(i).setPrice(products.get(i).getPrice() * 2);
        }

    }

    public void anularePromoPaste(){

        for(int i =0 ; i < products.size(); i++){
            products.get(i).setPrice(products.get(i).getPrice() / 0.7);
        }

    }

}
