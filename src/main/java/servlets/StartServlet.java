package servlets;

import services.ParseFeedService;
import services.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/start")
public class StartServlet extends HttpServlet {

    ParseFeedService parseFeedService = new ParseFeedService();
    DBService dbService = new DBService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/start.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String url = request.getParameter("url");
        String matchesSting = request.getParameter("matchesSting");

        boolean isUserValid = parseFeedService.isStringValid(url);

        if (isUserValid) {
            dbService.saveInDB(parseFeedService.selectionOfItems(matchesSting, parseFeedService.getAllItemsOfFeed()));
            response.sendRedirect("/list_of_items");
        }else {
            request.setAttribute("errorMessage", "Неверный адрес");
            request.getRequestDispatcher("/WEB-INF/views/start.jsp").forward(
                    request, response);
        }
    }

}
