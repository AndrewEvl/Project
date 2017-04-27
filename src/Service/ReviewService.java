package Service;

import Dao.ReviewsDao;
import Entity.Review;

/**
 * Created by User on 18.04.2017.
 */
public class ReviewService {
    private static final Object LOCK = new Object();
    private static ReviewService INSTANCE = null;

    public static ReviewService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ReviewService();
                }
            }
        }
        return INSTANCE;
    }
    public Review addReview (Review review){
        ReviewsDao.getInstance().save(review);
        return review;
    }

    public Review saveReview (Review review){
        ReviewsDao.getInstance().addReview(review);
        return review;
    }
}
