package oose.dea.guice;

import com.google.inject.servlet.ServletModule;
import oose.dea.Photo.AddPhotoPageController;
import oose.dea.Photo.PhotoViewPageController;
import oose.dea.Photo.SearchPhotoPageController;
import oose.dea.Set.SetViewPageController;

public class AppBinding extends ServletModule {
    @Override
    protected void configureServlets() {
        super.configureServlets();
        serve("/sets").with(SetViewPageController.class);

        serve("/addPhoto").with(AddPhotoPageController.class);
        serve("/searchPhoto").with(SearchPhotoPageController.class);

        serve("/photos").with(PhotoViewPageController.class);
        serve("/photo/*").with(PhotoViewPageController.class);

//        serve("/addPhoto").with(AddPhotoPageController.class);
//        bind(PhotoService.class).to(RestPhotoService.class);
//        bind(ItemDao.class).to(SQLItemDao.class);
    }
}