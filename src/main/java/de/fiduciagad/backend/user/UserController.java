package de.fiduciagad.backend.user;

import de.fiduciagad.backend.group.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"", "{userName}"})
    public List<User> getUsers(@PathVariable(required = false) String userName) {
        if (userName != null) {
            return List.of(userService.getUser(userName));
        } else {
            return userService.getUsers();
        }
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }



}
