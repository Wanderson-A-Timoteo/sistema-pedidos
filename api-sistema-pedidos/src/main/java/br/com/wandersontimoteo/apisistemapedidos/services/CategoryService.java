package br.com.wandersontimoteo.apisistemapedidos.services;

import br.com.wandersontimoteo.apisistemapedidos.entities.Category;
import br.com.wandersontimoteo.apisistemapedidos.repositories.CategoryRepository;
import br.com.wandersontimoteo.apisistemapedidos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findByIdCategory(UUID id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Category insertCategory(Category obj) {
        return  categoryRepository.save(obj);
    }

}
