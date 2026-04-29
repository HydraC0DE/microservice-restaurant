package hu.oe.yokudlela.restaurant.services;

import hu.oe.yokudlela.rdbms.MenuItemRepository;
import hu.oe.yokudlela.restaurant.generated.entity.MenuItem;
import hu.oe.yokudlela.restaurant.generated.rest.model.MenuItemRequest;
import hu.oe.yokudlela.restaurant.generated.rest.model.MenuItemResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuItemRepository repository;
    private final ModelMapper mapper;

    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    public List<MenuItemResponse> findAll(Boolean sugarFree, Boolean glutenFree) {
        return ((List<MenuItem>) repository.findAll()).stream()
                .filter(item -> sugarFree == null || item.isSugarFree() == sugarFree)
                .filter(item -> glutenFree == null || item.isGlutenFree() == glutenFree)
                .map(item -> mapper.map(item, MenuItemResponse.class))
                .toList();
    }

    public MenuItemResponse findById(Integer id) {
        return mapper.map(repository.getById(id), MenuItemResponse.class);
    }

    public MenuItemResponse save(MenuItemRequest request) {
        MenuItem entity = mapper.map(request, MenuItem.class);
        MenuItem saved = repository.save(entity);
        return mapper.map(saved, MenuItemResponse.class);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
