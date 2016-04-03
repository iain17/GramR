package oose.dea.guice;

import com.google.inject.servlet.ServletModule;
import oose.dea.Photo.PhotoService;
import oose.dea.Photo.PhotoViewPageController;

public class AppBinding extends ServletModule {
    @Override
    protected void configureServlets() {
        super.configureServlets();
        serve("/viewPhotos").with(PhotoViewPageController.class);
//        serve("/addPhoto").with(AddPhotoPageController.class);
//        bind(PhotoService.class).to(RestPhotoService.class);
//        bind(ItemDao.class).to(SQLItemDao.class);
    }
}