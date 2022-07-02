package nash.moroexe.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SignInDTO {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
