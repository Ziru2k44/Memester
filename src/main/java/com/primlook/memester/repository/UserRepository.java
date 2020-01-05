package com.primlook.memester.repository;

import com.primlook.memester.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Bernardo on 12/1/2019
 */
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByEmail(String email);


}
