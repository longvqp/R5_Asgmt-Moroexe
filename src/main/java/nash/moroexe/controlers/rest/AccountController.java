package nash.moroexe.controlers.rest;

import nash.moroexe.data.entities.Account;
import nash.moroexe.data.repositories.AccountRepository;
import nash.moroexe.exceptions.AccountNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AccountController {

    private final AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/account")
    List<Account> getAllAccount(){
        return repository.findAll();
    }

    @PostMapping("/account")
    Account addAccount(@RequestBody Account account){
        return repository.save(account);
    }

    @GetMapping("/account/{id}")
    Account one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    @PutMapping("/account/{id}")
    Account editAccount (@RequestBody Account newAccount, @PathVariable Long id) {

        return repository.findById(id)
                .map(Account -> {
                    Account.setAvatar(newAccount.getAvatar());
                    Account.setPassword(newAccount.getPassword());
                    return repository.save(Account);
                })
                .orElseGet(() -> {
                    newAccount.setId(id);
                    return repository.save(newAccount);
                });
    }

    @DeleteMapping("/account/{id}")
    void deleteAccount(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/testAPI")
    String apiResponse(){
        return "API Server is up and working";
    }
}
