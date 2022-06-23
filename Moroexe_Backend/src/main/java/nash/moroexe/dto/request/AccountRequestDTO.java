package nash.moroexe.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class AccountRequestDTO {
    private Long accountId;
    private String username;
    private String email;
    private String password;
    private Date createdDate;
}
