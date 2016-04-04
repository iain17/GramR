package oose.dea.Photo;

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
@WebServlet(urlPatterns = "/photos")
public class PhotoViewPageController extends HttpServlet {
    @Inject
    private PhotoDAO photoDAO;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Photo> photos = photoDAO.findAll();
        request.setAttribute("photos", photos);
        request.getRequestDispatcher("Photo/PhotoView/show.jsp").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String username = request.getParameter("username");
////        String password = request.getParameter("password");
////        User user = userService.find(username, password);
////
////        if (user != null) {
////            request.getSession().setAttribute("user", user);
////            response.sendRedirect("home");
////        }
////        else {
////            request.setAttribute("error", "Unknown user, please try again");
////            request.getRequestDispatcher("/login.jsp").forward(request, response);
////        }
//    }
}
