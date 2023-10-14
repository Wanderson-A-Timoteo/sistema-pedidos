package br.com.wandersontimoteo.apisistemapedidos.services;

import br.com.wandersontimoteo.apisistemapedidos.entities.Product;
import br.com.wandersontimoteo.apisistemapedidos.repositories.ProductRepository;
import br.com.wandersontimoteo.apisistemapedidos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
}
