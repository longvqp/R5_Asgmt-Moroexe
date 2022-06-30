package nash.moroexe.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super
                ("Did not exist Account");
    }
}
