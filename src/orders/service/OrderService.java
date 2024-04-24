package orders.service;

import orders.model.Order;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderService {

    private ArrayList<Order> orders;
    public OrderService() {
        this.orders = new ArrayList<>();

        this.loadData();
    }

    public OrderService(ArrayList<Order> orders){
        this.orders = orders;
    }

    private void loadData() {
        try{
            String filePath="C:\\mycode\\java\\incapsularea\\OnlineShop\\src\\orders\\data\\orders.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Order order = new Order(line);

                this.orders.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void afisare(){

        for(int i =0; i < this.orders.size(); i++){
            System.out.println(orders.get(i).descriere());
        }

    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findOrderById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Order findOrderById(int id){
        for (int i =0; i < orders.size();i++){
            if(orders.get(i).getId() == id){
                return orders.get(i);
            }
        }
        return null;
    }

    public void add(Order order){
        this.orders.add(order);
    }

    public ArrayList<Order> findOrdersByCustomerId(int id){
        ArrayList<Order> order = new ArrayList<>();

        for (int i =0; i < this.orders.size(); i++){
            if(orders.get(i).getCustomerId() == id){
                order.add(orders.get(i));
            }
        }
        return order;
    }

    public void stergeComanda(Order order){
        this.orders.remove(order);
    }

    public int clientCuCeleMaiMulteComenzi(){

        int[] frec = new int[100];

        for(int i = 0; i < orders.size();i++){
            frec[orders.get(i).getCustomerId()]++;
        }
        int max = 0;
        int customer = 0;

        for(int i = 0; i < frec.length; i++){
            if(frec[i] > max){
                max = frec[i];
                customer = i;
            }
        }
        return customer;
    }

}
