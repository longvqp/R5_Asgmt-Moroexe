package nash.moroexe.data.repositories;

import nash.moroexe.data.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<ProductEntity, Long> {
}
