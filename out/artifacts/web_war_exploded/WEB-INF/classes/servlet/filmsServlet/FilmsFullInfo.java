package servlet.filmsServlet;

import Service.FilmService;
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
       req.setAttribute("film", FilmService.getInstance().fullInfiFilm());
       getServletContext().getRequestDispatcher("/WEB-INF/jsp/filmsJSP/film-full-info.jsp").forward(req, resp);
    }
}
