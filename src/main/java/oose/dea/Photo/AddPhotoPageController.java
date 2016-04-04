package oose.dea.Photo;

import oose.dea.Set.Set;

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
@WebServlet(urlPatterns = "/addPhoto")
public class AddPhotoPageController extends HttpServlet {
	@Inject
	private PhotoModel photoModel;

	private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Photo/AddPhotoView/show.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean result = photoModel.insertPhoto(
                request.getParameter("creator"),
                request.getParameter("title"),
                request.getParameter("url"),
                request.getParameter("description")
        );
        request.setAttribute("result", result);
        request.getRequestDispatcher("Photo/AddPhotoView/show.jsp").forward(request, response);

    }

}
