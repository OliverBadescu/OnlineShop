package view;

import customers.model.Customer;
import customers.service.CustomerService;
import order_details.model.OrderDetails;
import order_details.service.OrderDetailsService;
import orders.model.Order;
import orders.service.OrderService;
import products.model.Product;
import products.service.ProductService;
import reviews.model.Review;
import reviews.service.ReviewService;
import utile.Cos;
import utile.ProductDto;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientView {

    private Customer customer;
    private CustomerService customerService;
    private OrderService orderService;
    private OrderDetailsService orderDetailsService;
    private ProductService productService;
    private ReviewService reviewService;
    private Scanner scanner;
    private Cos cos;


    public ClientView(Customer customer) {
        this.customer = customer;
        this.customerService = new CustomerService();
        this.orderService = new OrderService();
        this.orderDetailsService = new OrderDetailsService();
        this.productService = new ProductService();
        this.reviewService = new ReviewService();
        this.scanner = new Scanner(System.in);
        this.cos = new Cos(this.customer.getId(), null);


        this.play();
    }



    private void meniu(){

        System.out.println("Apasati tasta 1 pentru a afisa produsele");
        System.out.println("Apasati tasta 2 pentru a adauga un produs in cos");
        System.out.println("Apasati tasta 3 pentru a scoate un produs din cos");
        System.out.println("Apasati tasta 4 pentru a edita cantitatea produselor din cos");
        System.out.println("Apasati tasta 5 pentru a afisa cosul dvs.");
        System.out.println("Apasati tasta 6 pentru a trimite comanda");
        System.out.println("Apasati tasta 7 pentru a afisa detaliile comenzilor dvs.");
        System.out.println("Apasati tasta 8 pentru a goli cosul dvs.");
        System.out.println("Apasati tasta 9 pentru a afisa cel mai vandut produs");
        System.out.println("Apasati tasta 10 pentru a adauga un review la un produs");
        System.out.println("Apasati tasta 11 pentru a afisa review-urile unui produs");
        System.out.println("Apasati tasta 12 pentru a sorta produsele dupa pret crescator");
        System.out.println("Apasati tasta 13 pentru a sorta produsele dupa pret descrescator");
        System.out.println("Apasati tasta 14 pentru a afisa datele dvs.");
        System.out.println("Apasati tasta 15 pentru a edita datele dvs.");
        System.out.println("Apasati tasta 16 pentru a sterge contul dvs.");

        System.out.println("\n");

        System.out.println("Apasati tasta 20 pentru a iesi din cont");
    }

    private void play(){

        boolean running = true;

        while(running ){
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {

                case 1:
                    productService.afisare();
                    break;
                case 2:
                    adaugareProdusInCos();
                    break;
                case 3:
                    stergereDinCos();
                    break;
                case 4:
                    editareCos();
                    break;
                case 5:
                    afisareCos();
                    break;
                case 6:
                    trimiteComanda();
                    break;
                case 7:
                    afisareComenzi();
                    break;
                case 8:
                    cos.setProducts(null);
                    break;
                case 9:
                    celMaiVandutProdus();
                    break;
                case 10:
                    adaugareRating();
                    break;
                case 11:
                    afisareReviewuri();
                    break;
                case 12:
                    productService.sortareDupaPretCrescator();
                    break;
                case 13:
                    productService.sortareDupaPretDescrescator();
                    break;
                case 14:
                    System.out.println(this.customer.descriere());
                    break;
                case 15:
                    editareDate();
                    break;
                case 16:
                    stergereCont();
                    running = false;
                    break;
                case 20:
                    running = false;
                    break;

                default:
                    System.out.println("Tasta incorecta");
            }
        }

    }

    private void adaugareProdusInCos(){

        boolean running = true;
        ArrayList<ProductDto> list = new ArrayList<>();

        while(running ){
            System.out.println("Introduceti numele produsului care doriti sa il adaugati in cos: ");
            String nume = scanner.nextLine();
            Product product = productService.findByName(nume);

            if(product != null){
                System.out.println("Cate bucati doriti?");
                int buc = Integer.parseInt(scanner.nextLine());
                ProductDto productDto = new ProductDto(product.getName(), buc, product.getPrice());
                System.out.println("Produsul a fost adaugat in cos");
                list.add(productDto);
            }else{
                System.out.println("Produsul nu a fost gasit");
            }

            System.out.println("Doriti sa adaugi alt produs in cos?");
            String alegere = scanner.nextLine();

            if(alegere.equals("Nu") || alegere.equals("nu")){
                running = false;
            }
        }
        cos.setProducts(list);

    }

    private void stergereDinCos(){

        ArrayList<ProductDto> list = cos.getProducts();
        boolean running = true;
        boolean found = false;
        while(running) {
            System.out.println("Introduceti numele produsului care doriti sa il stergeti: ");
            String nume = scanner.nextLine();
            Product product = productService.findByName(nume);


            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equals(product.getName())) {
                    list.remove(list.get(i));
                    found = true;
                    System.out.println("Produsul a fost sters");
                }
            }
            if (!found) {
                System.out.println("Produsul nu a fost gasit in cos");
            }
            System.out.println("Doriti sa stergeti alt produs din cos?");
            String alegere = scanner.nextLine();

            if(alegere.equals("Nu") || alegere.equals("nu")){
                running = false;
            }
        }
        cos.setProducts(list);
    }

    private void editareCos(){

        ArrayList<ProductDto> list = cos.getProducts();
        boolean running = true;
        boolean found = false;
        while(running) {

            System.out.println("Introduceti numele produsului care doriti sa il editati: ");
            String nume = scanner.nextLine();
            for(int i =0; i<list.size(); i++){

                if(list.get(i).getName().equals(nume)){
                    System.out.println("Introduceti noua cantitate: ");
                    int cantitate = Integer.parseInt(scanner.nextLine());
                    list.get(i).setCantitate(cantitate);
                    found = true;
                }

            }
            if(!found){
                System.out.println("Produsul nu a fost gasit in cos");
            }

            System.out.println("Doriti sa editati alt produs din cos?");
            String alegere = scanner.nextLine();

            if(alegere.equals("Nu") || alegere.equals("nu")){
                running = false;
            }
        }
        cos.setProducts(list);

    }

    private void afisareCos(){

        ArrayList<ProductDto> list = cos.getProducts();

        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).descriere());
            }
        }else{
            System.out.println("Cosul dvs. este gol");
        }




    }

    private void trimiteComanda(){

        ArrayList<ProductDto> list = cos.getProducts();
        int id = orderDetailsService.generateId();
        double amount=0;

        if (list!= null){
            for(int i =0 ; i < list.size(); i++){
                amount += list.get(i).getPrice() * list.get(i).getCantitate();
            }
            afisareCos();
            System.out.println("Acesta este cosul dvs, total comenzii este: " + amount);
            System.out.println("Doriti sa trimiteti comanda?(y/n)");
            String alegere = scanner.nextLine();
            if(alegere.equals("y")){
                Order order = new Order(id, this.customer.getId(),amount);
                orderService.add(order);
                System.out.println("Comanda a fost adaugata");
                for(int i =0 ; i < list.size(); i++){
                    OrderDetails orderDetails = new OrderDetails(orderDetailsService.generateId(), id, productService.findByName(list.get(i).getName()).getId(), list.get(i).getPrice(), list.get(i).getCantitate());
                    orderDetailsService.add(orderDetails);
                    Product product = productService.findProductById(orderDetails.getProductId());
                    product.setStock(product.getStock()-orderDetails.getQuantity());
                }
                cos.setProducts(null);
            }
        }else{
            System.out.println("Cosul dvs. este gol");
        }

    }

    public void afisareComenzi(){

        ArrayList<Order> list = orderService.findOrdersByCustomerId(this.customer.getId());
        ArrayList<OrderDetails> orderDetails = orderDetailsService.order(list);
        ArrayList<ProductDto> productDtos = new ArrayList<>();

        for(int i =0 ; i < orderDetails.size(); i++){
            ProductDto productDto = new ProductDto(productService.findProductById(orderDetails.get(i).getProductId()).getName(),orderDetails.get(i).getQuantity(),orderDetails.get(i).getPrice());
            productDtos.add(productDto);
        }

        for(int i =0 ; i < productDtos.size(); i++){
            System.out.println(productDtos.get(i).descriere());
        }



    }

    public void celMaiVandutProdus(){

        Product product = productService.findProductById(orderDetailsService.celMaiVandutProdus());

        System.out.println(product.descriere());


    }

    public void adaugareRating(){

        System.out.println("Introduceti numele produsului la care doriti sa adaugati un review: ");
        String nume = scanner.nextLine();

        Product product = productService.findByName(nume);
        if(product!=null){
            System.out.println("Introduceti titlul: ");
            String title = scanner.nextLine();
            System.out.println("Introduceti descrierea: ");
            String desc = scanner.nextLine();
            System.out.println("Introduceti rating-ul(1-5): ");
            int rating = Integer.parseInt(scanner.nextLine());

            Review review = new Review(reviewService.generateId(), product.getId(), title, desc, rating);
            reviewService.adaugareReview(review);
        }else{
            System.out.println("Produsul nu a fost gasit");
        }

    }

    public void afisareReviewuri(){

        System.out.println("Introduceti numele produsului la care doriti sa vizualizati reviewurile: ");
        System.out.println("Nume: ");
        String nume = scanner.nextLine();
        Product product = productService.findByName(nume);


        if(product!=null){
            ArrayList<Review> reviews = reviewService.getReviewsProduct(product.getId());
            int nrRev= reviewService.getNrReviews(reviews);
            System.out.println("Ratingul total este " + reviewService.calculareRating(reviews) + " si are " + nrRev + " review-uri");
            System.out.println("\n");
            for(int i =0 ; i < reviews.size(); i++){
                System.out.println(reviews.get(i).descriere());
            }
        }else{
            System.out.println("Produsul nu a fost gasit");
        }

    }

    public void editareDate(){

        System.out.println("Ce doriti sa editati? ");
        System.out.println("1. Email");
        System.out.println("2. Password");
        System.out.println("3. Full name");
        System.out.println("4. Billing adress");
        System.out.println("5. Country");
        System.out.println("6. Phone");

        int alegere = Integer.parseInt(scanner.nextLine());

        switch (alegere){
            case 1:
                System.out.println("Introduceti noul email: ");
                String email = scanner.nextLine();
                this.customer.setEmail(email);
                break;
            case 2:
                System.out.println("Introduceti noul password: ");
                String password = scanner.nextLine();
                this.customer.setPassword(password);
                break;
            case 3:
                System.out.println("Introduceti noul full name: ");
                String fullName = scanner.nextLine();
                this.customer.setFullName(fullName);
                break;
            case 4:
                System.out.println("Introduceti noul billing adress: ");
                String billingAdress = scanner.nextLine();
                this.customer.setBillingAdress(billingAdress);
                break;
            case 5:
                System.out.println("Introduceti noul country: ");
                String country = scanner.nextLine();
                this.customer.setCountry(country);
                break;
            case 6:
                System.out.println("Introduceti noul phone: ");
                int phone = Integer.parseInt(scanner.nextLine());
                this.customer.setPhone(phone);
                break;
            default:
                System.out.println("Tasta incorecta");



        }


    }

    public void stergereCont(){

        System.out.println("Sunteti siguri ca doriti sa va stergeti contul?(y/n)");
        String alegere = scanner.nextLine();

        if(alegere.equals("y")){
            customerService.stergeCont(this.customer);
        }

    }



}
