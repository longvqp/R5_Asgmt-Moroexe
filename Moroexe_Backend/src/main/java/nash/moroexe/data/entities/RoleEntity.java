package nash.moroexe.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class RoleEntity {
    public enum ERole {
        ROLE_USER,
        ROLE_MODERATOR,
        ROLE_ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 20)
    private ERole name;

    @JsonIgnore
    @OneToMany(mappedBy = "role",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AccountEntity> accounts;

}
