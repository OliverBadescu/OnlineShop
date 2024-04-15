package reviews.model;

public class Review {

    private int id;
    private int productId;
    private String title;
    private String description;
    private double rating;
    private int nrReview;

    public Review(int id, int productId, String title, String description, double rating) {
        this.id = id;
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public Review(String text){
        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.productId = Integer.parseInt(tokens[1]);
        this.title = tokens[2];
        this.description = tokens[3];
        this.rating = Double.parseDouble(tokens[4]);
        this.nrReview = Integer.parseInt(tokens[5]);
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getProductId() {return productId;}
    public void setProductId(int productId) {this.productId = productId;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public double getRating() {return rating;}
    public void setRating(double rating) {this.rating = rating;}
    public int getNrReview() {return nrReview;}
    public void setNrReview(int nrReview) {this.nrReview = nrReview;}

    public String descriere(){

        String text = "";

        text += "Titlu: " + this.title + "\n";
        text += "Description: " + this.description + "\n";
        text += "Rating: " + this.rating + "\n";

        return text;
    }

}
