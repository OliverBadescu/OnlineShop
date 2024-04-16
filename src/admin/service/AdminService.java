package admin.service;

import admin.model.Admin;
import products.model.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {

    private ArrayList<Admin> admins;

    public AdminService() {
        admins = new ArrayList<>();
        this.loadData();
    }

    private void loadData(){

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\OnlineShop\\src\\admin\\data\\admins.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Admin admin = new Admin(line);

                this.admins.add(admin);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Admin login(String username, String password){
        for(int i=0; i < admins.size();i++){
            if(admins.get(i).getUser().equals(username) && admins.get(i).getPassword().equals(password)){
                return admins.get(i);
            }
        }
        return null;
    }



}
