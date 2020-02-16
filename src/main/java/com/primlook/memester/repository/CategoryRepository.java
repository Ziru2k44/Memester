package com.primlook.memester.repository;

import com.primlook.memester.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bernardo on 1/30/2020
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
