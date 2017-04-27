package servlet.actorsDirectorsServlet;

import Entity.ActorDirector;
import Entity.Role;
import Service.ActorDirectorService;
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
 * Created by User on 21.04.2017.
 */
@WebServlet("/actdirsave")
public class ActorDirectorSave extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/actorDirJSP/actdirSave.jsp");
        req.setAttribute("roles", UserService.getInstance().allRole());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));
        Long roleId = Long.valueOf(req.getParameter("role"));//long ?
        String jspName = firstName.equals("") | lastName.equals("") ? "actdirSave.jsp" : "actdir-success.jsp";
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/actorDirJSP/" + jspName);
        ActorDirectorService.getInstance().addActorDirector(new ActorDirector(firstName, lastName, birthday), new Role(roleId));
        requestDispatcher.forward(req, resp);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(roleId);
    }
}
