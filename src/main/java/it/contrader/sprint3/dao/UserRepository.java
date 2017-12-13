package it.contrader.sprint3.dao;

import it.contrader.sprint3.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface  UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findByRole (String role);


}
