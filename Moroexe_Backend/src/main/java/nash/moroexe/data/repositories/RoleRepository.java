package nash.moroexe.data.repositories;


import java.util.Optional;

import nash.moroexe.data.entities.ERole;
import nash.moroexe.data.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {


    Optional<RoleEntity> findByName(ERole name);
}
