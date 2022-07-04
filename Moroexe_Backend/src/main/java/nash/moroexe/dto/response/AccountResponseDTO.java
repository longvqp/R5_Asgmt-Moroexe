package nash.moroexe.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AccountResponseDTO {
    private Long accountId;
    private String username;
    private String email;
    private String password;

    private List<String> roles;
    private Date createdDate;

    public AccountResponseDTO(Long id, String username, String email, List<String> roles) {
        this.accountId = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
