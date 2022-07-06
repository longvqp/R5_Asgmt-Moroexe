package nash.moroexe.services;

import nash.moroexe.dto.request.SignInDTO;
import nash.moroexe.dto.request.SignUpDTO;
import org.springframework.http.ResponseEntity;

public interface AuthenticateServices {
    ResponseEntity<?> signIn(SignInDTO loginRequest);
    ResponseEntity<?> signUp(SignUpDTO signUpRequest);
    ResponseEntity<?> signOut();

}
