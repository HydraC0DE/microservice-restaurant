package hu.oe.yokudlela.rest;

import hu.oe.yokudlela.restaurant.generated.rest.api.DefaultApi;
import hu.oe.yokudlela.restaurant.generated.rest.model.MenuItem;
import hu.oe.yokudlela.restaurant.generated.rest.model.MenuItem.CategoryEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import hu.oe.yokudlela.restaurant.services.MenuService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
@Validated
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
    public ResponseEntity<MenuItem> menuIdPut(
            Integer id,
            @Valid @RequestBody MenuItem menuItem) {

        return ResponseEntity.ok(menuItem);
    }

    @Override
    public ResponseEntity<MenuItem> menuPost(
            @Valid @RequestBody MenuItem menuItem) {

        return ResponseEntity.ok(menuItem);
    }

    @Override
    public ResponseEntity<List<MenuItem>> menuGlutenFreeGet() {
        // Example stub using your current MenuService
        List<MenuItem> menu = MenuService.findAll(); // make findAll dummy
        List<MenuItem> glutenFree = menu.stream()
                .filter(MenuItem::getGlutenFree)
                .toList();
        return ResponseEntity.ok(glutenFree);
    }
}