package oose.dea.Set;

import java.util.ArrayList;

/**
 * Created by iain17 on 06/04/16.
 */
public interface SetDAO {

    ArrayList<Set> findByOwner(String owner);
    ArrayList<Set> findAll();
    Set findById(int setid);
    void delete(int setId);
    boolean save(Set set);

}
