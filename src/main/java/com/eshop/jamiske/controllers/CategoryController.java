package com.eshop.jamiske.controllers;

import com.eshop.jamiske.model.Categories;
import com.eshop.jamiske.model.Products;
import com.eshop.jamiske.repositories.CategoryRepository;
import com.eshop.jamiske.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(path="/category")
public class CategoryController {


    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path="/cat")
    public @ResponseBody
    Iterable<Categories> getAllUsers() {
        // This returns a JSON or XML with the users
        List<Categories> categoriesList= (List<Categories>) categoryRepository.findAll();

        return categoriesList;
    }

    @GetMapping(path = "/searchbycat/{id}")
    public ModelAndView getUser(@PathVariable final Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        List<Categories> categoriesList= (List<Categories>) categoryRepository.findById(id);

        modelAndView.addObject("cat", categoriesList);
        return modelAndView;
    }

}
