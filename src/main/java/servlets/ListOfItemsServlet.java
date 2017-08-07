package servlets;

import services.DBService;
import services.ParseFeedService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/list_of_items")
public class ListOfItemsServlet extends HttpServlet{

    ParseFeedService parseFeedService = new ParseFeedService();
    DBService dbService = new DBService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("items", dbService.getListOfItems());
        request.getRequestDispatcher("/WEB-INF/views/search_in_list_of_items.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String matchesSting = request.getParameter("matchesSting");

        request.setAttribute("items", parseFeedService.selectionOfItems(matchesSting, dbService.getListOfItems()));
        request.getRequestDispatcher("/WEB-INF/views/search_in_list_of_items.jsp").forward(
                request, response);
    }
}
