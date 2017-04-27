package Dao;

import Entity.Film;
import Entity.Ganre;
import connection.ConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    public Optional<Film> save(Film film,long ganreId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            //connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO films (name, country, relese_day,genre_id) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, film.getName());
                preparedStatement.setString(2, film.getCounty());
                preparedStatement.setObject(3, film.getReleaseDay());
                preparedStatement.setLong(4, ganreId);
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    film.setId(generatedKeys.getLong(1));
                }
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO genre_film (genre_id, film_id) VALUES (?, ?);")) {
                preparedStatement.setLong(1, ganreId);
                preparedStatement.setLong(2, film.getId());
                preparedStatement.executeUpdate();
            }
            // try (PreparedStatement preparedStatement = connection.prepareStatement(
            //        "INSERT INTO films_act_dir (film_id, actor_director_id, role_id) VALUES (?,?,?)")) {
            //    preparedStatement.setLong(1, film.getId());
            //   preparedStatement.setLong(2, actorDirector.getId());
            //  preparedStatement.setString(3, "role_id");
            //  preparedStatement.executeUpdate();
            //  connection.commit();
            //}
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

    public Optional<Film> getByName(String name) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM films WHERE name = ?")) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                Film film = new Film(name);
                while (resultSet.next()) {
                    film.setName(resultSet.getString("name"));
                }
                return Optional.of(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Film> getByYear(LocalDate releaseDay) {
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

    public List<Ganre> findAllGenre() {
        List<Ganre> ganre = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM genres")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        ganre.add(new Ganre(resultSet.getLong("genres.id"),
                                resultSet.getString("genres.genres")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ganre;

    }

    public List<Film> fullInfo() {
        List<Film> films = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT name, relese_day , country, actors_directors.first_name, actors_directors.last_name, role, " +
                            "  actors_directors.birthday, genres, nick_name, text AS review, mark FROM films " +
                            "  JOIN films_act_dir ON films_act_dir.film_id = films.id " +
                            "  JOIN actors_directors ON films_act_dir.actor_director_id = actors_directors.id " +
                            "  JOIN genres ON films_act_dir.film_id = genres.id " +
                            "  JOIN users ON films_act_dir.film_id = users.id " +
                            "  JOIN reviews ON films_act_dir.film_id = reviews.id " +
                            "  JOIN role ON films_act_dir.role_id = role.id ")) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    films.add(new Film(resultSet.getString("films.name"),
                            resultSet.getDate("films.relesr_day"),
                            resultSet.getString("films.coutry"),
                            resultSet.getString("films.ganre")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }
}

