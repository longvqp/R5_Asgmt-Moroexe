package nash.moroexe.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super
                ("Did not exist User with ID: " + id);
    }
}
