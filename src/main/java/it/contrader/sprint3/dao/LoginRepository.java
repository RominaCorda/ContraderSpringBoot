package it.contrader.sprint3.dao;

import it.contrader.sprint3.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LoginRepository  extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsernameAndPassword(String username, String password);
}
