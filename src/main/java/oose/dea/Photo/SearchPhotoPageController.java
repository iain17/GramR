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
@WebServlet(urlPatterns = "/searchPhoto")
public class SearchPhotoPageController extends HttpServlet {

    @Inject
    private PhotoModel photoModel;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchTerm = request.getParameter("photo");
        ArrayList<Photo> photos = photoModel.getPhotos(searchTerm);
        request.setAttribute("photos", photos);

        request.getRequestDispatcher("Photo/AddPhotoView/searchPhoto.jsp").forward(request, response);
    }

}
