package view;

import customers.model.Customer;
import customers.service.CustomerService;

import java.util.Scanner;

public class LoginView {

    private CustomerService customerService;
    private Scanner scanner;

    public LoginView(){
        this.customerService = new CustomerService();
        this.scanner = new Scanner(System.in);

        this.play();
    }

    private void meniu(){

        System.out.println("Apasati tasta 1 pentru a va loga");
        System.out.println("Apasati tasta 2 pentru a va inregistra");
        System.out.println("Apasati tasta 3 pentru a iesi din aplicatie");

        System.out.println(" \n");
        System.out.println("Apasati tasta 4 pentru a va loga ca admin");
    }

    private void play(){
        boolean running = true;

        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    loginCustomer();
                    break;
                case 2:
                    inregistrare();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }
    }

    private void inregistrare() {
        System.out.println("Introduceti datele urmatoare:");
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Parola: ");
        String password = scanner.nextLine();
        System.out.println("Nume complet: ");
        String fullName = scanner.nextLine();
        System.out.println("Adresa de facturare: ");
        String billingAddress = scanner.nextLine();
        System.out.println("Adresa de livrare: ");
        String defaultShippingAddress = scanner.nextLine();
        System.out.println("Tara: ");
        String country = scanner.nextLine();
        System.out.println("Numar de telefon: ");
        int phone = Integer.parseInt(scanner.nextLine());

        int id = customerService.generateId();

        Customer customer = new Customer(id, email, password, fullName, billingAddress, defaultShippingAddress, country, phone);

        if (customerService.inregistrare(customer)) {
            System.out.println("V-ati inregistrat cu succes, logati-va pentru a continua");
        } else {
            System.out.println("Emailul este deja folosit");
        }
    }

    private void loginCustomer(){

        System.out.println("Introduceti numele si parola");
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Parola: ");
        String parola = scanner.nextLine();

        Customer customer = customerService.login(email, parola);

        if (customer != null) {
            ClientView clientView = new ClientView(customer);
        }else{
            System.out.println("Date incorecte");
        }

    }

}
