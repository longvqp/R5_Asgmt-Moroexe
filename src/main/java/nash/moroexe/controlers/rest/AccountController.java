package nash.moroexe.controlers.rest;

//Testing all Querrry from repo and controller
import nash.moroexe.data.entities.AccountEntity;
import nash.moroexe.services.implement.AccountServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AccountController {
    private AccountServiceImpl accountService;

    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/test")
    String pingServer(){
        return this.accountService.ping();
    }
    @GetMapping("/account")
    List<AccountEntity> getAllAccount(){
        return this.accountService.getAllAccount();
    }

    @PostMapping("/account")
    AccountEntity addAccount(@RequestBody AccountEntity account){
        return this.accountService.addAccount(account);
    }

    @GetMapping("/account/{id}")
    AccountEntity findAccount(@PathVariable Long id){
        return this.accountService.findAccount(id);
    }

    @PutMapping("/account/{id}")
    AccountEntity editAccount(@RequestBody AccountEntity account,@PathVariable  Long id){
        return this.accountService.editAccount(account,id);
    }

    @DeleteMapping("/account/{id}")
    void deleteAccount(@PathVariable Long id){
        this.accountService.deleteAccount(id);
    }

}
