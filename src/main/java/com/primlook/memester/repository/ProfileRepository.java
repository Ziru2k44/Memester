package com.primlook.memester.repository;

import com.primlook.memester.domain.Profile;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bernardo on 1/28/2020
 */
public interface ProfileRepository extends CrudRepository<Profile, String> {
}
