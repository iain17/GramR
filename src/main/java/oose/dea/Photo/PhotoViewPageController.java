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
@WebServlet(urlPatterns = {"/photos", "/photo/*"})
public class PhotoViewPageController extends HttpServlet {
    @Inject
    private PhotoModel photoModel;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Error betekent dat deze code dubbel wordt aangevoerd, terwijl dat maar een keer mag.x

        if (request.getRequestURI().equals("/photos")) {
            ArrayList<Photo> photos = photoModel.getAllPhotos();
            request.setAttribute("photos", photos);
            request.getRequestDispatcher("Photo/PhotoView/show.jsp").forward(request, response);
        } else {
            //We'll just assume that it is /photo/*

            request.getRequestDispatcher("Photo/PhotoView/applyFilter.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Photo/PhotoView/show.jsp").forward(request, response);
    }
}
