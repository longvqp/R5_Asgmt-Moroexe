package nash.moroexe.services.implement;

import nash.moroexe.data.entities.UserEntity;
import nash.moroexe.data.repositories.UserRepository;
import nash.moroexe.dto.response.UserResponseDTO;
import nash.moroexe.exceptions.UserNotFoundException;
import nash.moroexe.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final ModelMapper modelMapper;
    @Autowired
    public UserServiceImpl(UserRepository repository,ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserEntity> getAllUser() {
        return this.repository.findAll();
    }

    @Override
    public UserResponseDTO findUserByIdDTO(Long id) {
        Optional<UserEntity> userEntityOptional = this.repository.findById(id);
        if (userEntityOptional.isPresent()) {
            UserEntity user =  userEntityOptional.get();
            UserResponseDTO dto = new UserResponseDTO();
            return modelMapper.map(userEntityOptional.get(), UserResponseDTO.class);
        }
         throw new UserNotFoundException(id);
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        return this.repository.save(user);
    }

    @Override
    public UserEntity editUser(UserEntity user, Long id) {
        return repository.findById(id)
                .map(UserEntity -> {
                    UserEntity.setAddress(user.getAddress());
                    UserEntity.setAge(user.getAge());
//                    ...
                    return repository.save(UserEntity);
                })
                .orElseGet(() -> {
                    user.setId(id);
                    return repository.save(user);
                });
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
