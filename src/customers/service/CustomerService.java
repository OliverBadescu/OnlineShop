package customers.service;

import customers.model.Customer;
import order_details.model.OrderDetails;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {

    private ArrayList<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();

        this.loadData();
    }

    private void loadData(){

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\OnlineShop\\src\\customers\\data\\customers.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Customer customer = new Customer(line);

                this.customers.add(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void afisare(){

        for(int i =0; i<this.customers.size(); i++){
            System.out.println(customers.get(i).descriere());
        }

    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findCustomerById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Customer findCustomerById(int id){
        for (int i =0; i < customers.size();i++){
            if(customers.get(i).getId() == id){
                return customers.get(i);
            }
        }
        return null;
    }

    public void stergeCont(Customer customer){
        for(int i =0; i < customers.size(); i++){
            if(customers.get(i).getId() == customer.getId()){
                this.customers.remove(customers.get(i));
            }
        }
    }

    public boolean inregistrare(Customer customer){
        for(int i =0; i < customers.size();i++){
            if(customers.get(i).getEmail().equals(customer.getEmail())){
                return false;
            }
        }
        this.customers.add(customer);
        return true;
    }

    public Customer login(String email, String password){
        for(int i =0; i < customers.size(); i++){
            if(customers.get(i).getEmail().equals(email) && password.equals(customers.get(i).getPassword())){
                return customers.get(i);
            }
        }
        return null;
    }
}
