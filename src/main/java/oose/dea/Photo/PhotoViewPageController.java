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
import java.util.List;
import java.util.logging.Logger;

@Singleton
@WebServlet(urlPatterns = "/viewPhotos")
public class PhotoViewPageController extends HttpServlet {

    @Inject
    private PhotoDAO photoDAO;

	private Logger logger = Logger.getLogger(getClass().getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Photo> photos = photoDAO.findAll();
		System.out.print(photos);
		request.setAttribute("photos", photos);
		request.getRequestDispatcher("Photo/PhotoView/show.jsp").forward(request, response);
	}

}
