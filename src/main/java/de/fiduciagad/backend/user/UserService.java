package de.fiduciagad.backend.user;

import de.fiduciagad.backend.group.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);

    }

    public User getUser(String userName) {
        List<User> allusers = getUsers();

        List<User> user = allusers.stream().filter(u ->u.getUserKennung().equals(userName)).collect(Collectors.toList());
        if (user.size() == 0) {
            userRepository.save(new User(userName,"",""));
            Optional<User> optUser = userRepository.findUserByUserKennung(userName);
            if (optUser.isPresent()) {
                return optUser.get();
            }
        }
        return user.get(0);

    }
}
