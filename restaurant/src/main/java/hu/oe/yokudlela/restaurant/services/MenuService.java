package hu.oe.yokudlela.restaurant.services;

import hu.oe.yokudlela.restaurant.generated.rest.model.MenuItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MenuService {

    //private final MenuRepository menuRepository;

    public boolean existsByName(String name) {
       // return menuRepository.existsByName(name);
        return true; //force invalid
    }

    public List<MenuItem> findAll(Boolean sugarFree, Boolean glutenFree){
        return null;
        //return menuRepository.findAll().stream()
  //              .filter(item -> sugarFree == null || item.getSugarFree().equals(sugarFree))
    //            .filter(item -> glutenFree == null || item.getGlutenFree().equals(glutenFree))
      //          .toList();
    }

    public List<MenuItem> findAll() {
        return findAll(null, null); // no filtering
    }

    public MenuItem save(MenuItem menuItem) {
        // In a real app, you'd call menuRepository.save(menuItem)
        // For now, just return the item to satisfy the controller
        return menuItem;
    }
}


