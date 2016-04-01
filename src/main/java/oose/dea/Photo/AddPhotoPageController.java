package oose.dea.Photo;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
//@WebServlet(urlPatterns = "/viewPhotos")
public class AddPhotoPageController extends HttpServlet {

	@Inject
	private PhotoService photoService;

	private Logger logger = Logger.getLogger(getClass().getName());
//
//	@Inject
//	private PhotoModel photoModel;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Photo> photos = photoService.getAllPhotos();
		for(Photo photo:photos)
		{
			response.getWriter().print(photo.toString());
		}
	}

}
