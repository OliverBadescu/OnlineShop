package view;

import admin.model.Admin;
import admin.service.AdminService;
import customers.model.Customer;
import customers.service.CustomerService;
import order_details.model.OrderDetails;
import order_details.service.OrderDetailsService;
import orders.service.OrderService;
import products.model.Product;
import products.service.ProductService;
import reviews.service.ReviewService;
import utile.ProductDto;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {

    private Admin admin;
    private CustomerService customerService;
    private AdminService adminService;
    private OrderService orderService;
    private OrderDetailsService orderDetailsService;
    private ProductService productService;
    private ReviewService reviewService;
    private Scanner scanner;

    public AdminView(Admin admin){

        this.admin = admin;
        this.customerService = new CustomerService();
        this.adminService = new AdminService();
        this.orderService = new OrderService();
        this.orderDetailsService = new OrderDetailsService();
        this.productService = new ProductService();
        this.reviewService = new ReviewService();
        this.scanner = new Scanner(System.in);

        this.play();

    }

    private void meniu(){

        System.out.println("Apasati tasta 1 pentru a afisa lista de clienti");
        System.out.println("Apasati tasta 2 pentru a afisa toate comenzile");
        System.out.println("Apasati tasta 3 pentru a afisa produsele");
        System.out.println("Apasati tasta 4 pentru a sterge un produs");
        System.out.println("Apasati tasta 5 pentru a adauga un produs");

    }
    private void play(){


        boolean running = true;

        while(running ) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:
                    customerService.afisare();
                    break;
                case 2:
                    afisareComenzi();
                    break;
                case 3:
                    productService.afisare();
                    break;
                case 4:
                    stergeProdus();
                    break;
                case 5:
                    adaugaProdus();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }


    }
    private void afisareComenzi(){

        ArrayList<OrderDetails> orderDetails = orderDetailsService.getOrderDetails();
        ArrayList<ProductDto> productDtos = new ArrayList<>();

        for(int i =0 ; i < orderDetails.size(); i++){
            ProductDto productDto = new ProductDto(productService.findProductById(orderDetails.get(i).getProductId()).getName(),orderDetails.get(i).getQuantity(),orderDetails.get(i).getPrice());
            productDtos.add(productDto);
        }
        for(int i =0 ; i < productDtos.size(); i++){
            System.out.println(productDtos.get(i).descriere());
        }
    }

    private void stergeProdus(){

        System.out.println("Introduceti id-ul produsului: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product produs = productService.findProductById(id);

        if(produs!= null){
            productService.stergereProdus(produs);
            System.out.println("Produsul a fost sters!");
        }else{
            System.out.println("Produsul nu a fost gasit");
        }
    }

    private void adaugaProdus(){
        System.out.println("Introduceti numele produsului: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti pretul: ");
        double pret = Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti stocul: ");
        int stoc = Integer.parseInt(scanner.nextLine());
        Product nou = new Product(productService.generateId(), nume, pret, stoc);

        if(productService.adaugareProdus(nou)){
            System.out.println("Produs a fost adaugat!");
        }else{
            System.out.println("Produsul cu acest nume exista deja");
        }
    }
}
