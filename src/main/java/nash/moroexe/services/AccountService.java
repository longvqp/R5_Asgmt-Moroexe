package nash.moroexe.services;

import nash.moroexe.data.entities.AccountEntity;

import java.util.List;

public interface AccountService {

    public List<AccountEntity> getAllAccount();
    public AccountEntity addAccount(AccountEntity account);
    public AccountEntity findAccount(Long id);
    public AccountEntity editAccount(AccountEntity account, Long id);
    public void deleteAccount(long id);
    public String ping();
}
