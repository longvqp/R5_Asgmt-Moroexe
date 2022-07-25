package nash.moroexe.controllers.user;

import nash.moroexe.dto.request.UserRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final ModelMapper modelMapper;

    public UserController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public UserRequestDTO getUserInformation(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return modelMapper.map(userDetails, UserRequestDTO.class);
    }

    @PostMapping
    public UserRequestDTO updateUserInformation(UserRequestDTO userInformation){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserRequestDTO user = modelMapper.map(userDetails, UserRequestDTO.class);
        user.setAddress(userInformation.getAddress());
        user.setBirthday(userInformation.getBirthday());
        user.setFullname(userInformation.getFullname());
        user.setGender(userInformation.getGender());
        user.setPhone(userInformation.getPhone());
        return user;
    }
}
