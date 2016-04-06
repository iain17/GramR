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
@WebServlet(urlPatterns = {"/photos", "/photo/{id}"})
public class PhotoViewPageController extends HttpServlet {
    @Inject
    private PhotoModel photoModel;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*if (request.getRequestURI().equals("/photos")) {
            ArrayList<Photo> photos = photoModel.getAllPhotos();
            request.setAttribute("photos", photos);
            request.getRequestDispatcher("Photo/PhotoView/show.jsp").forward(request, response);
        } else {*/
            //We'll just assume that it is /photo/*

            request.getRequestDispatcher("Photo/PhotoView/applyFilter.jsp").forward(request, response);
        //}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filter = request.getParameter("filter");

        System.out.println(request.getParameter("filter"));
        System.out.println(request.getParameter("grayPercentage"));
        System.out.println(request.getParameter("vintageUpperLeftX"));
        System.out.println(request.getParameter("vintageUpperLeftY"));
        System.out.println(request.getParameter("vintageUpperRightX"));
        System.out.println(request.getParameter("vintageUpperRightY"));

        int photoId = 18;

        //photoId = request.getParameter("");

        ArrayList<String> filterArguments = new ArrayList<String>();

        if (filter.equals("gray")) {
            filterArguments.add(request.getParameter("grayPercentage"));
        } else if (filter.equals("vintage")) {
            filterArguments.add(request.getParameter("vintageUpperLeftX"));
            filterArguments.add(request.getParameter("vintageUpperLeftY"));
            filterArguments.add(request.getParameter("vintageUpperRightX"));
            filterArguments.add(request.getParameter("vintageUpperRightY"));
        }

        photoModel.applyFilter(photoId, filter, filterArguments);

        request.getRequestDispatcher("Photo/PhotoView/show.jsp").forward(request, response);
    }
}
