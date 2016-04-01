package oose.dea.guice;

import com.google.inject.servlet.ServletModule;
import oose.dea.Photo.AddPhotoPageController;

public class AppBinding extends ServletModule {
    @Override
    protected void configureServlets() {
        super.configureServlets();
        serve("/viewPhotos").with(AddPhotoPageController.class);
//        bind(ItemService.class).to(LocalItemService.class);
//        bind(ItemDao.class).to(SQLItemDao.class);
    }
}