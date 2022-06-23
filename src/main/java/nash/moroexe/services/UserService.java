package nash.moroexe.services;

import nash.moroexe.data.entities.UserEntity;
import nash.moroexe.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    public List<UserEntity> getAllUser();
    public UserResponseDTO findUserByIdDTO(Long id);
    public UserEntity addUser(UserEntity user);
    public UserEntity editUser(UserEntity user, Long id);
    public void deleteUser(Long id);
}
