package hu.oe.yokudlela.rdbms;

import hu.oe.yokudlela.restaurant.generated.entity.MenuItem;
import org.springframework.data.repository.CrudRepository;

public interface MenuItemRepository extends CrudRepository<MenuItem, Integer> {

    boolean existsByName(String name);

    MenuItem getById(Integer id);
}