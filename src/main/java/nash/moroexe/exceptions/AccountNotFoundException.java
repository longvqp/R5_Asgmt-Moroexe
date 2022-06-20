package nash.moroexe.exceptions;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(Long id){
        super
                ("Did not exist Account with ID: " + id);
    }
}
