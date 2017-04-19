package servlet;

import connection.ConnectionManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by User on 11.04.2017.
 */
@WebServlet("/filminfo")
public class FilmsFullInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT name, relese_day, country, actors_directors.first_name, actors_directors.last_name, role, " +
                            "  actors_directors.birthday, ganres, nick_name, text AS review, mark FROM films " +
                            "  JOIN films_act_dir ON films_act_dir.film_id = films.id " +
                            "  JOIN actors_directors ON films_act_dir.actor_director_id = actors_directors.id " +
                            "  JOIN ganres ON films_act_dir.film_id = ganres.id " +
                            "  JOIN users ON films_act_dir.film_id = users.id " +
                            "  JOIN reviews ON films_act_dir.film_id = reviews.id " +
                            "  JOIN role ON films_act_dir.role_id = role.id")) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    writer.write("<h3>" + resultSet.getString("") + "</h3>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
