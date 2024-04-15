package utile;

public class ProductDto {

     private String name;
     private int cantitate;
     private double price;


     public ProductDto(String name, int cantitate, double price) {

          this.name = name;
          this.cantitate = cantitate;
          this.price = price;
     }

     public String getName() {return name;}
     public void setName(String name) {this.name = name;}
     public int getCantitate() {return cantitate;}
     public void setCantitate(int cantitate) {this.cantitate = cantitate;}
     public double getPrice() {return price;}
     public void setPrice(double price) {this.price = price;}

     public String descriere(){

          String text = "";

          text += "Name: " + name + "\n";
          text += "Cantitate: " + cantitate + "\n";
          text += "Price: " + price + "\n";
          return text;
     }


}
