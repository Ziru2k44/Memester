package com.primlook.memester.service;

import com.primlook.memester.domain.Category;
import com.primlook.memester.repository.CategoryRepository;
import com.primlook.memester.web.mapper.MemeMapper;
import com.primlook.memester.web.model.CategoryPagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by Bernardo on 2/23/2020
 */
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final MemeMapper memeMapper;

    @Override
    public CategoryPagedList listCategories(PageRequest pageRequest) {
        Page<Category> categoryPage = categoryRepository.findAll(pageRequest);

        return new CategoryPagedList(categoryPage
                .getContent()
                .stream()
                .map(memeMapper::categoryToCategoryDto)
                .collect(Collectors.toList()),
                PageRequest
                        .of(categoryPage.getPageable().getPageNumber(),
                                categoryPage.getPageable().getPageSize()),
                categoryPage.getTotalElements());
    }
}
