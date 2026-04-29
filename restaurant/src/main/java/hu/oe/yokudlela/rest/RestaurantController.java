package hu.oe.yokudlela.rest;

import hu.oe.yokudlela.restaurant.generated.entity.MenuItem;
import hu.oe.yokudlela.restaurant.generated.rest.api.DefaultApi;
import hu.oe.yokudlela.restaurant.generated.rest.model.*;
import hu.oe.yokudlela.rdbms.MenuItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("")
public class RestaurantController implements DefaultApi {

    private final MenuItemRepository menuItemRepository;
    private final ModelMapper modelMapper;

    public RestaurantController(MenuItemRepository menuItemRepository,
                                ModelMapper modelMapper) {
        this.menuItemRepository = menuItemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<List<MenuItemResponse>> menuGet(Boolean sugarFree, Boolean glutenFree) {

        List<MenuItemResponse> response = new ArrayList<>();

        menuItemRepository.findAll().forEach(entity -> {

            MenuItemResponse mapped = modelMapper.map(entity, MenuItemResponse.class);

            if (sugarFree != null && !mapped.getSugarFree().equals(sugarFree)) return;
            if (glutenFree != null && !mapped.getGlutenFree().equals(glutenFree)) return;

            response.add(mapped);
        });

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<MenuItemResponse>> menuGlutenFreeGet() {

        List<MenuItemResponse> response = new ArrayList<>();

        menuItemRepository.findAll().forEach(entity -> {
            if (Boolean.TRUE.equals(entity.isGlutenFree())) {
                response.add(modelMapper.map(entity, MenuItemResponse.class));
            }
        });

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<MenuItemResponse> menuIdGet(Integer id) {

        return ResponseEntity.ok(
                modelMapper.map(
                        menuItemRepository.getById(id),
                        MenuItemResponse.class
                )
        );
    }

    @Override
    public ResponseEntity<IdModel> menuPost(@Validated MenuItemRequest menuItemRequest) {

        return ResponseEntity.ok(
                modelMapper.map(
                        menuItemRepository.save(
                                modelMapper.map(menuItemRequest, MenuItem.class)
                        ),
                        IdModel.class
                )
        );
    }

    @Override
    public ResponseEntity<IdModel> menuIdPut(@Validated Integer id, MenuItemRequest menuItemRequest) {

        MenuItem entity = modelMapper.map(menuItemRequest, MenuItem.class);
        entity.setId(id);

        return ResponseEntity.ok(
                modelMapper.map(
                        menuItemRepository.save(entity),
                        IdModel.class
                )
        );
    }

    @Override
    public ResponseEntity<Void> menuIdDelete(Integer id) {

        menuItemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}