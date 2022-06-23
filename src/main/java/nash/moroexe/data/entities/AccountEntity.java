package nash.moroexe.data.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "accounts")
public class AccountEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true)
    private String email;
    private String password;
    private String avatar;
    private boolean admin;
    @Column(name = "create_date")
    @CreatedDate
    private Date createdDate;
    @Column(name = "modified_date")
    @LastModifiedDate
    private Date modifiedDate;


    @OneToOne(mappedBy = "account")
    @JoinColumn(referencedColumnName = "id")
    private UserEntity user;

    @OneToMany(mappedBy = "account")
    private List<CartEntity> cart;


}
