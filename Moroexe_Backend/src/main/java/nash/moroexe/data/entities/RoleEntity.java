package nash.moroexe.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nash.moroexe.data.enums.ERole;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "roles")
@NoArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private  Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 20)
    private ERole name;



}
