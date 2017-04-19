package servlet;

import Entity.ActorDirector;
import Entity.Film;
import Service.FilmService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by User on 19.04.2017.
 */
@WebServlet("/filmsave")
public class FilmSave extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/jsp/filmSave.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        LocalDate releaseDay = LocalDate.parse(req.getParameter("releaseDay"));
        String country = req.getParameter("country");
        String genre = req.getParameter("genre");
        String jspName = name.equals("")  | country.equals("")
                | genre.equals("") ? "filmSave.jsp" : "film-success.jsp";
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/classes/jsp/" + jspName);
        FilmService.getInstance().addFilm(new Film(name,releaseDay,country,genre));
        requestDispatcher.forward(req, resp);
        System.out.println(name);
        System.out.println(releaseDay);
        System.out.println(country);
        System.out.println(genre);
    }
}
