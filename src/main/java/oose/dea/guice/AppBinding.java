package oose.dea.guice;

import com.google.inject.servlet.ServletModule;
import oose.dea.Filter.FilterDAO;
import oose.dea.Filter.FilterSQLDAO;
import oose.dea.Photo.*;
import oose.dea.Privacy.PrivacyDAO;
import oose.dea.Privacy.PrivacySQLDAO;
import oose.dea.Set.SetViewPageController;

public class AppBinding extends ServletModule {
    @Override
    protected void configureServlets() {
        super.configureServlets();
        serve("/sets").with(SetViewPageController.class);

        serve("/addPhoto").with(AddPhotoPageController.class);
        serve("/searchPhoto").with(SearchPhotoPageController.class);

        serve("/photos").with(PhotoViewPageController.class);

        bind(PrivacyDAO.class).to(PrivacySQLDAO.class);
        bind(FilterDAO.class).to(FilterSQLDAO.class);
        bind(PhotoDAO.class).to(PhotoSQLDAO.class);
    }
}