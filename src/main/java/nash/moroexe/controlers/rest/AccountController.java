package nash.moroexe.controlers.rest;

import nash.moroexe.data.entities.AccountEntity;
import nash.moroexe.data.repositories.AccountRepository;
import nash.moroexe.exceptions.AccountNotFoundException;
import nash.moroexe.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/books")
public class AccountController {
    private AccountService accountService;


}
