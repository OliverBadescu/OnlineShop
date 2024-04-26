import java.util.ArrayList;
import org.junit.Test;
import products.model.Product;
import reviews.model.Review;
import reviews.service.ReviewService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class ReviewServiceTests {

    ReviewService reviewService;

    @Test

    public void GivenAvailableIdCheckIfGetsFound(){

        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5);
        reviews.add(review);
        reviewService = new ReviewService(reviews);

        Review review1 = reviewService.findReviewById(1);
        Review review2 = reviewService.findReviewById(2);

        assertEquals(1,review1.getId());
        assertEquals(null,review2);

    }


    @Test

    public void GivenAvailableDataCheckIfGetsLoaded(){

        ReviewService reviewService1 = new ReviewService();
        Review review = reviewService1.findReviewById(1);

        assertEquals(1, review.getId());

    }

    @Test

    public void afisareSiGenerare(){

        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5);
        reviews.add(review);
        reviewService = new ReviewService(reviews);

        reviewService.afisare();
        int id = reviewService.generateId();

    }

    @Test

    public void GivenAvailableRatingsCheckIfTotalRatingGetsCalculated(){

        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5);
        reviewService = new ReviewService(reviews);

        double rating = reviewService.calculareRating(reviews);
        assertEquals(0,rating, 0);

        reviews.add(review);

        rating = reviewService.calculareRating(reviews);

        assertEquals(5,rating,0);

    }

    @Test

    public void GivenAvailableReviewCheckIfGetsAdded(){
        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5);
        reviewService = new ReviewService(reviews);

        reviewService.adaugareReview(review);

        assertEquals(1,review.getId());
    }


    @Test

    public void GivenAvailableProductIdCheckIfReviewsGetReturned(){
        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5);
        Review review1 = new Review(2,2,"test","test",5);
        reviews.add(review);
        reviews.add(review1);
        reviewService = new ReviewService(reviews);

        ArrayList<Review> products = new ArrayList<>();
        products = reviewService.getReviewsProduct(1);

        assertEquals(1, products.size());


    }

    @Test

    public void GivenAvailableReviewsCheckReviewsNumber(){
        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5);
        Review review1 = new Review(2,2,"test","test",5);
        reviews.add(review);
        reviews.add(review1);
        reviewService = new ReviewService(reviews);

        int nr = reviewService.getNrReviews(reviews);

        assertEquals(2,nr);

    }

    @Test

    public void GivenAvailableReviewTitleCheckIfGetsFound(){
        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5);
        Review review1 = new Review(2,2,"test1","test",5);
        reviews.add(review);
        reviews.add(review1);
        reviewService = new ReviewService(reviews);

        ArrayList<Review> test = reviewService.getReviewsByTitle("test");
        assertEquals(1, test.size());

    }

    @Test

    public void GivenAvailableReviewCheckIfGetsDeleted(){

        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review(1,1,"test","test",5);
        Review review1 = new Review(2,2,"test1","test",5);
        reviews.add(review);
        reviews.add(review1);
        reviewService = new ReviewService(reviews);

        reviewService.stergeReview(review);

        assertEquals(null,reviewService.findReviewById(1));

    }


}
