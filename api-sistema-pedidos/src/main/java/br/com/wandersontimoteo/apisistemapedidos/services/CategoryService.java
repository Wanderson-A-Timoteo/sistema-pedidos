package br.com.wandersontimoteo.apisistemapedidos.services;

import br.com.wandersontimoteo.apisistemapedidos.entities.Category;
import br.com.wandersontimoteo.apisistemapedidos.repositories.CategoryRepository;
import br.com.wandersontimoteo.apisistemapedidos.services.exceptions.DatabaseException;
import br.com.wandersontimoteo.apisistemapedidos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public void deleteCategory(UUID id) {
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException error) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException err) {
            throw new DatabaseException(err.getMessage());
        }
    }

    public Category updateCategory(UUID id, Category obj){
        try {
            Category updateCategory = categoryRepository.getReferenceById(id);
            updateData(updateCategory, obj);
            return categoryRepository.save(updateCategory);
        } catch (EntityNotFoundException erro) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Category updateCategory, Category obj) {
        updateCategory.setName(obj.getName());
    }
}
