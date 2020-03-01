package com.primlook.memester.web.controller;

import com.primlook.memester.service.CategoryService;
import com.primlook.memester.web.model.CategoryDto;
import com.primlook.memester.web.model.CategoryPagedList;
import com.primlook.memester.web.model.ListResource;
import com.primlook.memester.web.model.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bernardo on 2/23/2020
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    private final CategoryService categoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListResource<List<CategoryDto>>> listBeers(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                                     @RequestParam(value = "pageSize", required = false) Integer pageSize){


        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        CategoryPagedList categoryPagedList = categoryService.listCategories(PageRequest.of(pageNumber,pageSize));

        return new ResponseEntity<>(new ListResource<>(categoryPagedList.getContent(), new PageInfo(categoryPagedList)), HttpStatus.OK);
    }

}
