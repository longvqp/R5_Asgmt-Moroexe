package nash.moroexe.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class UserEntity {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;

    private String fullname;
    private String phone;
    private Date birthday;
    private String address;
    private String gender;

    @OneToOne(mappedBy = "user")
    private AccountEntity account;
}
