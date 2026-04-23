package hu.oe.yokudlela.rest;

import hu.oe.yokudlela.restaurant.generated.rest.api.DefaultApi;
import hu.oe.yokudlela.restaurant.generated.rest.model.MenuItem;
import hu.oe.yokudlela.restaurant.generated.rest.model.MenuItem.CategoryEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import hu.oe.yokudlela.restaurant.services.MenuService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
@Validated
@RequiredArgsConstructor
public class RestaurantController implements DefaultApi {

    private final MenuService menuService;

    /**
     * POST /get
     * Add a new menu item.
     */
//    @Override
//    public ResponseEntity<MenuItem> getPost(
//            @Valid MenuItem menuItem,
//            @Valid Boolean sugarFree,
//            @Valid Boolean glutenFree
//    ) {
//        // TODO: add duplication check, throw BusinessException if already exists
//        MenuItem savedItem = menuService.save(menuItem); // implement save in MenuService
//        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
//    }

    /**
     * GET /menu/gluten-free
     * List only gluten-free items.
     */
    @Override
    public ResponseEntity<List<MenuItem>> menuGet(
            @RequestParam(value = "sugarFree", required = false) Boolean sugarFree,
            @RequestParam(value = "glutenFree", required = false) Boolean glutenFree
    ) {
        List<MenuItem> items = menuService.findAll(sugarFree, glutenFree);
        return ResponseEntity.ok(items);
    }

    @Override
    public ResponseEntity<List<MenuItem>> menuGlutenFreeGet() {
        List<MenuItem> items = menuService.findAll(null, true); // null = sugarFree ignored
        return ResponseEntity.ok(items);
    }

    /**
     * GET /menu/filtered
     * Custom endpoint for flexible filtering by sugarFree and glutenFree.
     */
    public ResponseEntity<List<MenuItem>> menuFilteredGet(
            Boolean sugarFree,
            Boolean glutenFree
    ) {
        List<MenuItem> filteredItems = menuService.findAll(sugarFree, glutenFree);
        return ResponseEntity.ok(filteredItems);
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
            @Valid @RequestBody MenuItem menuItem
    ) {
        MenuItem savedItem = menuService.save(menuItem);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    //@Override
    //public ResponseEntity<List<MenuItem>> menuGlutenFreeGet() {
        // Example stub using your current MenuService
        //List<MenuItem> menu = MenuService.findAll(); // make findAll dummy
        //List<MenuItem> glutenFree = menu.stream()
                //.filter(MenuItem::getGlutenFree)
                //.toList();
        //return ResponseEntity.ok(glutenFree);
    //}
}