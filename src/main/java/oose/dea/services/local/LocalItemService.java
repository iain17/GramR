package oose.dea.services.local;

import oose.dea.datasource.ItemDao;
import oose.dea.domain.Item;
import oose.dea.services.ItemService;

import javax.inject.Inject;
import java.util.List;

public class LocalItemService implements ItemService {
    @Inject
    private ItemDao itemDao;

    @Override
    public List<Item> findAll() {
        return itemDao.list();
    }
}
