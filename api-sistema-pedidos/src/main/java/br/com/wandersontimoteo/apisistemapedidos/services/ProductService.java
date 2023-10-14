package br.com.wandersontimoteo.apisistemapedidos.services;

import br.com.wandersontimoteo.apisistemapedidos.entities.Product;
import br.com.wandersontimoteo.apisistemapedidos.entities.User;
import br.com.wandersontimoteo.apisistemapedidos.repositories.ProductRepository;
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
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findByIdProduct(UUID id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product insertProduct(Product obj) {
        return productRepository.save(obj);
    }

    public void deleteProduct(UUID id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException error) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException err) {
            throw new DatabaseException(err.getMessage());
        }
    }

    public Product updateProduct(UUID id, Product obj){
        try {
            Product updateProduct = productRepository.getReferenceById(id);
            updateData(updateProduct, obj);
            return productRepository.save(updateProduct);
        } catch (EntityNotFoundException erro) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product updateProduct, Product obj) {
        updateProduct.setName(obj.getName());
        updateProduct.setDescription(obj.getDescription());
        updateProduct.setPrice(obj.getPrice());
        updateProduct.setImgUrl(obj.getImgUrl());
    }
}
