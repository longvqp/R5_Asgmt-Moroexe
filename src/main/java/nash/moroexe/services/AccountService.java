package nash.moroexe.services;

import nash.moroexe.data.entities.AccountEntity;

import java.util.List;

public interface AccountService {

     List<AccountEntity> getAllAccount();
     AccountEntity addAccount(AccountEntity account);
     AccountEntity findAccount(Long id);
     AccountEntity editAccount(AccountEntity account, Long id);
     void deleteAccount(long id);
     String ping();
}
