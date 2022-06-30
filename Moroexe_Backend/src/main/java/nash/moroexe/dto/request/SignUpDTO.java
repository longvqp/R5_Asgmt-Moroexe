package nash.moroexe.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SignUpDTO {
    private String username;
    private String email;
    private String password;
    private String fullname;
    private String phone;
    private Date birthday;
    private String address;
    private String gender;
}
