package oose.dea.Photo;

import oose.dea.Set.Set;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.ext.ExceptionMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

@Singleton
//"/photos",
@WebServlet()
public class PhotoViewPageController extends HttpServlet {
    @Inject
    private PhotoModel photoModel;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int photoId = 0;
        try {
            photoId = Integer.parseInt(request.getParameter("photoId"));
        }catch(Exception e) {

        }

        if(photoId != 0) {
            Photo photo = photoModel.getByPhoto(photoId);
            request.setAttribute("photo", photo);
            request.getRequestDispatcher("/Photo/PhotoView/applyFilter.jsp").forward(request, response);
        } else {
            ArrayList<Photo> photos = photoModel.getAllPhotos();
            request.setAttribute("photos", photos);
            request.getRequestDispatcher("/Photo/PhotoView/show.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int photoId = 0;
        try {
            photoId = Integer.parseInt(request.getParameter("photoId"));
        }catch(Exception e) {

        }

        String filter = request.getParameter("filter");

        ArrayList<String> filterArguments = new ArrayList<String>();

        if (filter.equals("gray")) {
            filterArguments.add(request.getParameter("grayPercentage"));
        } else if (filter.equals("vintage")) {
            filterArguments.add(request.getParameter("vintageUpperLeftX"));
            filterArguments.add(request.getParameter("vintageUpperLeftY"));
            filterArguments.add(request.getParameter("vintageUpperRightX"));
            filterArguments.add(request.getParameter("vintageUpperRightY"));
        }

        boolean result = photoModel.applyFilter(photoId, filter, filterArguments);
        request.setAttribute("result", result);
        request.setAttribute("applied", true);
        request.getRequestDispatcher("/Photo/PhotoView/applyFilter.jsp").forward(request, response);
    }
}
