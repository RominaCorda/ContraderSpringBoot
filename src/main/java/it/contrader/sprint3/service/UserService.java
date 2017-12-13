package it.contrader.sprint3.service;

import it.contrader.sprint3.dao.UserRepository;
import it.contrader.sprint3.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> findByRole (String role) {
        return this.userRepository.findByRole(role);
    }

    public  UserEntity insert (UserEntity user) {
        return this.userRepository.save(user);
    }
}


