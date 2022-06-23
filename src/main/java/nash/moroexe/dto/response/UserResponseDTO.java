package nash.moroexe.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nash.moroexe.data.entities.UserEntity;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private UserEntity.Gender gender;
    private String phone;
    private Date dob;
}
