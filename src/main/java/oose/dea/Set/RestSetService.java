package oose.dea.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/sets")
public class RestSetService implements SetService {
    private SetDAO setDAO;

    @Inject
    public RestSetService(SetDAO setDAO) {
        this.setDAO = setDAO;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Set> getAllSets(int owner) {
        return setDAO.findAll();
    }
}
