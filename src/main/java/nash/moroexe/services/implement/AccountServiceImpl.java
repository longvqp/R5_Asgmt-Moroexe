package nash.moroexe.services.implement;

import nash.moroexe.data.entities.AccountEntity;
import nash.moroexe.data.repositories.AccountRepository;
import nash.moroexe.exceptions.AccountNotFoundException;
import nash.moroexe.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AccountEntity> getAllAccount(){
        return repository.findAll();
    }


    @Override
    public AccountEntity addAccount(AccountEntity account) {
        return repository.save(account);
    }

    @Override
    public AccountEntity findAccount(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    @Override
    public AccountEntity editAccount(AccountEntity account, Long id) {
        return repository.findById(id)
                .map(AccountEntity -> {
                    AccountEntity.setAvatar(account.getAvatar());
                    AccountEntity.setPassword(account.getPassword());
                    return repository.save(AccountEntity);
                })
                .orElseGet(() -> {
                    account.setId(id);
                    return repository.save(account);
                });
    }

    @Override
    public void deleteAccount(long id) {
        repository.deleteById(id);
    }

    @Override
    public String ping() {
        return "Account Service is Up";
    }


}
