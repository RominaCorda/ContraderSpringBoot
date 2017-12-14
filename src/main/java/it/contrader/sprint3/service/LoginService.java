package it.contrader.sprint3.service;

import it.contrader.sprint3.dao.LoginRepository;
import it.contrader.sprint3.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService
{

    private LoginRepository loginRepository;

    @Autowired
    public LoginService (LoginRepository loginRepository)
    {
        this.loginRepository = loginRepository;
    }

    public UserEntity login(String username, String password)
    {
        return loginRepository.findByUsernameAndPassword(username, password);
    }
}
