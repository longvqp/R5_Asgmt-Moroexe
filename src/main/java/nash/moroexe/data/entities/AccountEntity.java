package nash.moroexe.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class AccountEntity {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long accountId;

    private String username;
    private String email;
    private String password;
    private Date createdDate;
    private Boolean isActive;
    private Boolean isAdmin;

    @OneToOne
    @JoinColumn(name = "user_ref",referencedColumnName = "userId")
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "account_ref")
    private List<CartEntity> cart;
}
