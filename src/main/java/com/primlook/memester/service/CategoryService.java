package com.primlook.memester.service;

import com.primlook.memester.web.model.CategoryPagedList;
import org.springframework.data.domain.PageRequest;

/**
 * Created by Bernardo on 2/23/2020
 */
public interface CategoryService {

    CategoryPagedList listCategories(PageRequest pageRequest);
}
