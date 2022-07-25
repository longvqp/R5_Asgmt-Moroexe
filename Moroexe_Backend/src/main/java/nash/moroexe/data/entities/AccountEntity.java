package nash.moroexe.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullname;
    @Column(name = "phone_number")
    private String phone;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "address")
    private String address;
    @Column(name = "gender")
    private String gender;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "is_active")
    private Boolean isActive = true;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<RoleEntity> roles = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "account_ref")
    private List<CartEntity> cart;

    public AccountEntity(String username,String email,String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
