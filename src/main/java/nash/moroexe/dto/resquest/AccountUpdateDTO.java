package nash.moroexe.dto.resquest;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountUpdateDTO {
    public String email;
    public String password;
    public String avatar;
}
