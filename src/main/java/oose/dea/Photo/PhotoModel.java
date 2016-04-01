package oose.dea.Photo;

import com.google.inject.Inject;
import oose.dea.Set.SetService;

import java.util.ArrayList;

public class PhotoModel {

//	private PhotoViewPageController photoViewPageController;
//
//	private AddPhotoPageController addPhotoPageController;

//	private SetService setService;

//	private PhotoService photoService;

	@Inject
	private PhotoDAO photoDAO;

	public void getPhotos(String searchTerm) {

	}

	public ArrayList<Photo> getAllPhotos() {
		return photoDAO.findAll();
	}

	public void readPhotosFromModel() {

	}

	public void applyFilter(int photoId, int filter, int filterArguments) {

	}

}
