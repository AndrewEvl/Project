package Dao;

import Entity.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import connection.ConnectionManager;

/**
 * Created by User on 08.04.2017.
 */
public class ReviewsDao {

    private static final Object LOCK = new Object();
    private static ReviewsDao INSTANCE = null;

    public static ReviewsDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ReviewsDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<Review> save(Review review) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO reviews (text, mark, film_id, user_id) VALUES (?, ?, ?, ?)"
                            , Statement.RETURN_GENERATED_KEYS);
            {
                preparedStatement.setString(1, review.getText());
                preparedStatement.setDouble(2, review.getMark());
                preparedStatement.setLong(3, review.getFilm().getId());
                preparedStatement.setLong(4, review.getUser().getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Optional<Review> addReview(Review review) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO reviews (text, mark) VALUES (?, ?)"
                            , Statement.RETURN_GENERATED_KEYS);
            {
                preparedStatement.setString(1, review.getText());
                preparedStatement.setDouble(2, review.getMark());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
