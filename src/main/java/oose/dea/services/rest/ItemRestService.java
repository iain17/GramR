
package oose.dea.services.rest;

import oose.dea.datasource.ItemDao;
import oose.dea.domain.Item;
import oose.dea.services.ItemService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/items")
public class ItemRestService implements ItemService {

    @Inject
    private ItemDao itemDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> findAll() {
        return itemDao.list();
    }
}
