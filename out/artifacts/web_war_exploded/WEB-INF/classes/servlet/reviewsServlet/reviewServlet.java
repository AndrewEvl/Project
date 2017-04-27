package servlet.reviewsServlet;

import Entity.Film;
import Entity.Review;
import Entity.User;
import Service.ReviewService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 25.04.2017.
 */
@WebServlet("/reviewadd")
public class reviewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/reviewJSP/addReview.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String review = req.getParameter("review");
        Double mark = Double.valueOf(req.getParameter("mark"));
        //Long userId = Long.valueOf(req.getParameter("userId"));
        //Long filmId = Long.valueOf(req.getParameter("filmId"));
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/reviewJSP/addReview.jsp");
        ReviewService.getInstance().saveReview(new Review(review,mark));
        requestDispatcher.forward(req, resp);

    }
}
