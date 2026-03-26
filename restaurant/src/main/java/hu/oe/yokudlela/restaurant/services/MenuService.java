package hu.oe.yokudlela.restaurant.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MenuService {

    //private final MenuRepository menuRepository;

    public boolean existsByName(String name) {
       // return menuRepository.existsByName(name);
        return true; //force invalid
    }
}

@Service
@RequiredArgsConstructor
public class findAll {

    //private final MenuRepository menuRepository;

    public boolean existsByName(String name) {
        // return menuRepository.existsByName(name);
        return true; //force invalid
    }
}
