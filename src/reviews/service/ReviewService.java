package reviews.service;

import reviews.model.Review;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReviewService {

    private ArrayList<Review> reviews;

    public ReviewService() {
        this.reviews = new ArrayList<>();

        this.loadData();
    }

    public ReviewService(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    private void loadData(){

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\OnlineShop\\src\\reviews\\data\\reviews.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Review review = new Review(line);

                this.reviews.add(review);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void afisare(){

        for(int i =0; i < this.reviews.size(); i++){
            System.out.println(reviews.get(i).descriere());
        }

    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findReviewById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Review findReviewById(int id){
        for (int i =0; i < reviews.size();i++){
            if(reviews.get(i).getId() == id){
                return reviews.get(i);
            }
        }
        return null;
    }

    public double calculareRating(ArrayList<Review> reviews){

        if (reviews.isEmpty()) {
            return 0;
        }

        double ratingTotal = 0;
        int numarTotalRecenzii = 0;

        for (Review review : reviews) {
            ratingTotal += review.getRating() * (review.getNrReview() + 1);
            numarTotalRecenzii += review.getNrReview() + 1;
        }

        if (numarTotalRecenzii == 0) {
            return 0;
        }

        double ratingNou = ratingTotal / numarTotalRecenzii;

        for (Review review : reviews) {
            review.setNrReview(numarTotalRecenzii);
        }

        return ratingNou;
    }

    public void adaugareReview(Review review){
        this.reviews.add(review);
    }

    public ArrayList<Review> getReviewsProduct(int productId){

        ArrayList<Review> productReviews = new ArrayList<>();

        for(int i =0; i < this.reviews.size(); i++){
            if(this.reviews.get(i).getProductId() == productId){
                productReviews.add(this.reviews.get(i));
            }
        }
        return productReviews;
    }

    public int getNrReviews(ArrayList<Review> reviews){
        int ct =0;

        for(int i =0; i < reviews.size(); i++){
            ct++;
        }
        return ct;
    }

    public ArrayList<Review> getReviewsByTitle(String title){

        ArrayList<Review> reviews = new ArrayList<>();
        for(int i =0; i < this.reviews.size(); i++){
            if(this.reviews.get(i).getTitle().equals(title)){
                reviews.add(this.reviews.get(i));
            }
        }
        return reviews;
    }

    public void stergeReview(Review review){
        this.reviews.remove(review);
    }
}
