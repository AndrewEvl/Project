package Dao;

import Entity.ActorDirector;
import Entity.Film;
import connection.ConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by User on 08.04.2017.
 */
public class FilmDao {

    private static final Object LOCK = new Object();
    private static FilmDao INSTANCE = null;

    public static FilmDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new FilmDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<Film> save(Film film) {
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO films (name, country, relese_day) VALUES (?, ?, ?);",Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, film.getName());
                preparedStatement.setString(2, film.getCounty());
                preparedStatement.setObject(3, film.getReleaseDay());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                //if (generatedKeys.next()) {
                  //  film.setId(generatedKeys.getLong(1));
               // }
            }
            //try (PreparedStatement preparedStatement = connection.prepareStatement(
                  //  "INSERT INTO ganre_film (ganre_id, film_id) VALUES (?, ?);")) {
              //  preparedStatement.setString(1, film.getGenre());
              //  preparedStatement.setLong(2, film.getId());
               // preparedStatement.executeUpdate();
          //  }
            //try (PreparedStatement preparedStatement = connection.prepareStatement(
                   // "INSERT INTO films_act_dir (film_id, actor_director_id, role_id) VALUES (?,?,?)")) {
               // preparedStatement.setLong(1,film.getId());
                //preparedStatement.setLong(2,actorDirector.getId() );
                //preparedStatement.setString(3,"role_id");
                //preparedStatement.executeUpdate();
                connection.commit();
               // return Optional.of(film);
           // }
            return Optional.of(film);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Film> getById(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "SELECT * FROM films WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Film(id, resultSet.getString("name")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Film> getByYear (LocalDate releaseDay) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT  * FROM  films WHERE YEAR(relese_day) = ?")) {
                preparedStatement.setObject(1, releaseDay.getYear());
                ResultSet resultSet = preparedStatement.executeQuery();
                Film film = new Film(releaseDay);
                while (resultSet.next()) {
                    film.setName(resultSet.getString("film_name"));
                }
                return Optional.of(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}