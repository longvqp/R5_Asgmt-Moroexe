package nash.moroexe.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AccountResponseDTO {
    private Long accountId;
    private String username;
    private String email;
    private String password;
    private Date createdDate;
}
