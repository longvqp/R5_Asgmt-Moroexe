package nash.moroexe.controllers.user;

import nash.moroexe.dto.request.SignInDTO;
import nash.moroexe.dto.request.SignUpDTO;
import nash.moroexe.services.AuthenticateServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticateServices authenticateServices;


    public AuthController(AuthenticateServices authenticateServices) {
        this.authenticateServices = authenticateServices;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInDTO loginRequest) {
        return authenticateServices.signIn(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDTO signUpRequest){
        return authenticateServices.signUp(signUpRequest);
    }

    @PostMapping("/signout")
    public  ResponseEntity<?> signOut(){
        return authenticateServices.signOut();
    }
}
