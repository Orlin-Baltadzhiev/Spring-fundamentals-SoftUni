package bg.softUni.mobilele.service.impl;

import bg.softUni.mobilele.model.entities.UserEntity;
import bg.softUni.mobilele.repository.UserRepository;
import bg.softUni.mobilele.security.CurrentUser;
import bg.softUni.mobilele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean authenticate(String userName, String password) {

        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(userName);

        if(userEntityOptional.isEmpty()){
            return false;
        } else {
            return passwordEncoder.matches(password,userEntityOptional.get().getPassword());
        }
    }

    @Override
    public void loginUser(String userName) {

        currentUser
                .setAnonymous(false)
                .setName(userName);
    }
}
