package servlet.filmsServlet;

import Entity.ActorDirector;
import Entity.Film;
import Entity.Role;
import Service.ActorDirectorService;
import Service.FilmService;
import Service.UserService;

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
public class FilmSave extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/filmsJSP/filmSave.jsp");
        req.setAttribute("genres",FilmService.getInstance().fullGenres());
        req.setAttribute("role", UserService.getInstance().allRole());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        LocalDate releaseDay = LocalDate.parse(req.getParameter("releaseDay"));
        String country = req.getParameter("country");
        Long genreId = Long.valueOf(req.getParameter("genre"));

        String directorFirstName = req.getParameter("directorFirstName");
        String directorLastName = req.getParameter("directorLastName");
        LocalDate directorBirthday = LocalDate.parse(req.getParameter("directorBirthday"));
        Long directorRole = Long.valueOf(req.getParameter("role"));

        String actorFirstName = req.getParameter("actorFirstName");
        String actorLastName = req.getParameter("actorLastName");
        LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));
        Long actorRole = Long.valueOf(req.getParameter("roleOne"));

        String jspName = name.equals("") | country.equals("")
                | genreId.equals("") ? "filmSave.jsp" : "film-success.jsp";
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/filmsJSP/" + jspName);
        FilmService.getInstance().addFilm(new Film(name, releaseDay, country), genreId);
        ActorDirectorService.getInstance().addActorDirector(new ActorDirector(actorFirstName, actorLastName, birthday), new Role(actorRole));
        ActorDirectorService.getInstance().addActorDirector(new ActorDirector(directorFirstName, directorLastName, directorBirthday), new Role(directorRole));
        requestDispatcher.forward(req, resp);
        System.out.println(name);
        System.out.println(releaseDay);
        System.out.println(country);
        System.out.println(genreId);
        System.out.println(directorRole);
        System.out.println(actorRole);
    }
}
