package oose.dea.StaticContent;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Singleton
@WebServlet(urlPatterns = "/")
public class IndexViewPageController extends HttpServlet {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Set session
        if(request.getParameter("owner") != null) {
            request.getSession().setAttribute("owner", request.getParameter("owner"));
        }

        request.setAttribute("setId", request.getSession().getValue("setId"));

        request.getRequestDispatcher("StaticContent/HomeView/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String owner = request.getParameter("owner");
        //Set session
        if(owner != null) {
            request.getSession().setAttribute("owner", owner);
        }

        if(owner != null) {
            response.sendRedirect("/home");
        } else {
            request.getRequestDispatcher("StaticContent/HomeView/index.jsp").forward(request, response);
        }

    }

}