package gianmarte.u5w1d5.services;

import gianmarte.u5w1d5.entities.User;
import gianmarte.u5w1d5.exceptions.ValidationException;
import gianmarte.u5w1d5.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
}
    public void saveUser(User user){
        if (userRepository.existsByEmail(user.getEmail()) || userRepository.existsByUsername(user.getSurname()) )throw new ValidationException("L'utente e' gia esistente");
        this.userRepository.save(user);
        log.info("L'utente e' stato salvato correttamente");
    }
}
