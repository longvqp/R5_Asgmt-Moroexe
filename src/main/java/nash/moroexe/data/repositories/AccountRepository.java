package nash.moroexe.data.repositories;

import nash.moroexe.data.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
