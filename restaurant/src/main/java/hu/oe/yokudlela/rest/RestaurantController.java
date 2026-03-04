package hu.oe.yokudlela.rest;

import hu.oe.yokudlela.customer.generated.rest.api.DefaultApi;
import hu.oe.yokudlela.customer.generated.rest.model.MenuItem;
import hu.oe.yokudlela.customer.generated.rest.model.MenuItem.CategoryEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class RestaurantController implements DefaultApi {

    @Override
    public ResponseEntity<List<MenuItem>> menuGet() {

        List<MenuItem> menu = new ArrayList<>();

        menu.add(
                MenuItem.builder()
                        .id(1)
                        .name("Pizza")
                        .category(CategoryEnum.MAIN_COURSE)
                        .sugarFree(false)
                        .glutenFree(false)
                        .build()
        );

        return ResponseEntity.ok(menu);
    }

    @Override
    public ResponseEntity<Void> menuIdDelete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<MenuItem> menuIdGet(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<MenuItem> menuIdPut(Integer id, MenuItem menuItem) {
        return null;
    }

    @Override
    public ResponseEntity<MenuItem> menuPost(MenuItem menuItem) {
        return null;
    }
}