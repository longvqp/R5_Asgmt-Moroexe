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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private String username;
    private String email;
    private String password;
    private String fullname;
    private String phone;
    private Date birthday;
    private String address;
    private String gender;
    private Date createdDate;
    private Boolean isActive = true;
    private Boolean isAdmin = false;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "account_ref")
    private List<CartEntity> cart;
}
