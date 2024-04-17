package view;

import admin.model.Admin;
import admin.service.AdminService;
import customers.model.Customer;
import customers.service.CustomerService;
import order_details.model.OrderDetails;
import order_details.service.OrderDetailsService;
import orders.model.Order;
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
        System.out.println("Apasati tasta 2 pentru a afisa toate comenzile cu detalii");
        System.out.println("Apasati tasta 3 pentru a afisa produsele");
        System.out.println("Apasati tasta 4 pentru a sterge un produs");
        System.out.println("Apasati tasta 5 pentru a adauga un produs");
        System.out.println("Apasati tasta 6 pentru a edita un produs");
        System.out.println("Apasati tasta 7 pentru a sterge un client");
        System.out.println("Apasati tasta 8 pentru a edita datele unui client");
        System.out.println("Apasati tasta 9 pentru a afisa comenziile");
        System.out.println("Apasati tasta 10 pentru a sterge o comanda");

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
                case 6:
                    editareProdus();
                    break;
                case 7:
                    stergeClient();
                    break;
                case 8:
                    editareClient();
                    break;
                case 9:
                    orderService.afisare();
                    break;
                case 10:
                    stergeComanda();
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

    private void editareProdus(){

        System.out.println("Introduceti id-ul produsului care doriti sa il editati: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product produs = productService.findProductById(id);

        if(produs!= null) {
            System.out.println("Ce doriti sa editati?");
            System.out.println("1. Nume");
            System.out.println("2. Pret");
            System.out.println("3. Stoc");

            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    System.out.println("Introduceti noul nume: ");
                    String nume = scanner.nextLine();
                    produs.setName(nume);
                    break;
                case 2:
                    System.out.println("Introduceti noul pret: ");
                    double pret = Double.parseDouble(scanner.nextLine());
                    produs.setPrice(pret);
                    break;
                case 3:
                    System.out.println("Introduceti noul stoc: ");
                    int stoc = Integer.parseInt(scanner.nextLine());
                    produs.setStock(stoc);
                    break;
                default:
                    System.out.println("Tasta incorecta");

            }
        }else{
            System.out.println("Produsul nu a fost gasit");
        }

    }

    private void stergeClient(){

        System.out.println("Introduceti id-ul clientului: ");
        int id = Integer.parseInt(scanner.nextLine());
        Customer client = customerService.findCustomerById(id);

        if(client != null){
            customerService.stergereClient(client);
            System.out.println("Client a fost sters!");
        }else{
            System.out.println("Client nu a fost gasit");
        }

    }

    private void editareClient(){

        System.out.println("Introduceti id-ul clientului care doriti sa il editati: ");
        int id = Integer.parseInt(scanner.nextLine());
        Customer client = customerService.findCustomerById(id);

        if(client != null) {
            System.out.println("Ce doriti sa editati? ");
            System.out.println("1. Email");
            System.out.println("2. Password");
            System.out.println("3. Full name");
            System.out.println("4. Billing adress");
            System.out.println("5. Country");
            System.out.println("6. Phone");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    System.out.println("Introduceti noul email: ");
                    String email = scanner.nextLine();
                    client.setEmail(email);
                    break;
                case 2:
                    System.out.println("Introduceti noul password: ");
                    String password = scanner.nextLine();
                    client.setPassword(password);
                    break;
                case 3:
                    System.out.println("Introduceti noul full name: ");
                    String fullName = scanner.nextLine();
                    client.setFullName(fullName);
                    break;
                case 4:
                    System.out.println("Introduceti noul billing adress: ");
                    String billingAdress = scanner.nextLine();
                    client.setBillingAdress(billingAdress);
                    break;
                case 5:
                    System.out.println("Introduceti noul country: ");
                    String country = scanner.nextLine();
                    client.setCountry(country);
                    break;
                case 6:
                    System.out.println("Introduceti noul phone: ");
                    int phone = Integer.parseInt(scanner.nextLine());
                    client.setPhone(phone);
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }else{
            System.out.println("Clientu nu a fost gasit");
        }

    }

    private void stergeComanda(){
        System.out.println("Introduceti id-ul comenzi: ");
        int id = Integer.parseInt(scanner.nextLine());

        Order order = orderService.findOrderById(id);
        if(order != null) {
            orderService.stergeComanda(order);
            System.out.println("Comanda a fost stearsa");
        }else{
            System.out.println("Comanda nu a fost gasita");
        }
    }
}
