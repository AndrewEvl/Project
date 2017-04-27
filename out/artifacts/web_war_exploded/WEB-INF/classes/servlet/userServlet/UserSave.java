package servlet.userServlet;

import Entity.User;
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
 * Created by User on 18.04.2017.
 */
@WebServlet("/usersave")
public class UserSave extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/userJSP/userSave.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String nickName = req.getParameter("nickName");
        LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));
        String password = req.getParameter("password");
        String mail = req.getParameter("mail");
        String jspName = firstName.equals("") | lastName.equals("") | nickName.equals("")
                | birthday.equals("") | password.equals("") | mail.equals("") ? "userSave.jsp" : "user-success.jsp";
        RequestDispatcher requestDispatcher =
                getServletContext().getRequestDispatcher("/WEB-INF/jsp/userJSP/" + jspName);
        UserService.getInstance().addUser(new User(firstName,lastName,nickName,birthday,password,mail));
        requestDispatcher.forward(req, resp);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(nickName);
        System.out.println(birthday);
        System.out.println(password);
        System.out.println(mail);
    }
}
