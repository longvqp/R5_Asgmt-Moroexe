package nash.moroexe.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class AccountEntity {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long accountId;

    private String username;
    private String email;
    private String password;
    private Date createdDate;
    private Boolean isActive;
    private Boolean isReset;
    private Boolean isDisable;
    private Boolean isAdmin;

    @OneToOne
    @JoinColumn(name = "user_ref",referencedColumnName = "userId")
    private UserEntity user;

}
