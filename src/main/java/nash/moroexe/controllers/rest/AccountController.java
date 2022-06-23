package nash.moroexe.controllers.rest;

import nash.moroexe.data.entities.AccountEntity;
import nash.moroexe.dto.request.AccountRequestDTO;
import nash.moroexe.dto.response.AccountResponseDTO;
import nash.moroexe.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountServices accountServices;
    @Autowired
    public AccountController(AccountServices accountServices) {
        this.accountServices = accountServices;
    }
    @GetMapping("/ping")
    String pingServices(){
        return "Account Services is UP";
    }
    @GetMapping
    List<AccountEntity> getAllAccount(){
       return this.accountServices.getAllAccount();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AccountResponseDTO createAccount (@RequestBody AccountRequestDTO accountDTO){
        return this.accountServices.createAccount(accountDTO);
    }

}
