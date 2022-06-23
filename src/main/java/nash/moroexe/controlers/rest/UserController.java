package nash.moroexe.controlers.rest;

import nash.moroexe.data.entities.UserEntity;
import nash.moroexe.services.implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    List<UserEntity> getAllUser(){
        return this.userService.getAllUser();
    }

    @PostMapping
    UserEntity addUser(UserEntity user){
        return  this.userService.addUser(user);
    }

}
