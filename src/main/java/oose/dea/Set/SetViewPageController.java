package oose.dea.Set;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

@Singleton
@WebServlet(urlPatterns = "/sets")
public class SetViewPageController extends HttpServlet {
    @Inject
    private SetDAO setDAO;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Set> photos = setDAO.findAll();
        request.setAttribute("sets", photos);
        request.getRequestDispatcher("Set/SetView/show.jsp").forward(request, response);
    }
}
