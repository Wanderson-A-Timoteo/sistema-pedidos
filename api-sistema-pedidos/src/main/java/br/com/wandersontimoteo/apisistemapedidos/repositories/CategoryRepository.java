package br.com.wandersontimoteo.apisistemapedidos.repositories;

import br.com.wandersontimoteo.apisistemapedidos.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
