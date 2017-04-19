package Dao;

import Entity.ActorDirector;
import connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;


/**
 * Created by entity.User on 08.04.2017.
 */
public class ActorDirectorDao {

    private static final Object LOCK = new Object();
    private static ActorDirectorDao INSTANCE = null;

    public static ActorDirectorDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ActorDirectorDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<ActorDirector> save(ActorDirector actorDirector) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    ("INSERT INTO actors_directors (first_name, last_name, birthday) VALUES (?, ?, ?)"),
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, actorDirector.getFirstName());
                preparedStatement.setString(2, actorDirector.getLastName());
                preparedStatement.setObject(3, actorDirector.getBirthdayDay());
                preparedStatement.executeUpdate();
            }
            return Optional.of(actorDirector);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
