package org.factoriaf5.project_inside_out.mvc.contracts;

import java.util.Collection;
import org.factoriaf5.project_inside_out.mvc.models.Moment;

public interface InterfaceDatabase {
    void put(Integer id, Moment moment);
    Collection<Moment> getAll();
    void remove(Integer id);
}
