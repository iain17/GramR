package oose.dea.guice;

import com.google.inject.servlet.ServletModule;
import oose.dea.controller.ItemsView;
import oose.dea.datasource.ItemDao;
import oose.dea.datasource.SQLItemDao;
import oose.dea.services.ItemService;
import oose.dea.services.local.LocalItemService;

public class AppBinding extends ServletModule {
    @Override
    protected void configureServlets() {
        super.configureServlets();
        serve("/viewItems").with(ItemsView.class);
        bind(ItemService.class).to(LocalItemService.class);
        bind(ItemDao.class).to(SQLItemDao.class);
    }
}