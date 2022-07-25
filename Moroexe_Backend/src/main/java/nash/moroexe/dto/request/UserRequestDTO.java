package nash.moroexe.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserInformationDTO {
    private Long accountId;
    private String username;
    private String email;
    private String fullname;
    private String phone;
    private Date birthday;
    private String address;
    private String gender;
    private Date createdDate;
}
