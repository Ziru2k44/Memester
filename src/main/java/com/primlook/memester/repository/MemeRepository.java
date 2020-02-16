package com.primlook.memester.repository;

import com.primlook.memester.domain.Meme;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Bernardo on 12/1/2019
 */
public interface MemeRepository extends PagingAndSortingRepository<Meme, String> {
}
