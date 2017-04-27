package Dao;

import Entity.ActorDirector;
import Entity.Ganre;
import Entity.Review;
import Entity.Role;
import connection.ConnectionManager;

import javax.xml.transform.Result;
import java.sql.*;
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

    public Optional<ActorDirector> save(ActorDirector actorDirector, Role role) {
        try (Connection connection = ConnectionManager.getConnection()) {
           // connection.setAutoCommit(false);
            //try (PreparedStatement preparedStatement = connection.prepareStatement
                //    ("SELECT * FROM role WHERE role = ?")) {
              //  preparedStatement.setString(1, role.getRole());
              //  ResultSet resultSet = preparedStatement.executeQuery();
               // if (resultSet.next()) {
                    //return role.setId(resultSet.getString("role_id"));
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    ("INSERT INTO actors_directors (first_name, last_name, birthday, role_id ) VALUES (?, ?, ?, ?)"),
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, actorDirector.getFirstName());
                preparedStatement.setString(2, actorDirector.getLastName());
                preparedStatement.setObject(3, actorDirector.getBirthdayDay());
                preparedStatement.setLong(4, role.getId());
                preparedStatement.executeUpdate();
               // connection.commit();
                return Optional.of(actorDirector);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Role> getId(String role) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM role WHERE role = ?")) {
                preparedStatement.setString(1, role);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Role(resultSet.getLong("id"), role));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
