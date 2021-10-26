package com.eshop.jamiske.controllers;


import com.eshop.jamiske.model.Products;
import com.eshop.jamiske.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path="/category")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/mjhbvg")
    public ModelAndView indexx () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("indexx");
        List<Products> productsList= (List<Products>) productRepository.findAll();

        modelAndView.addObject("cat", productsList);
        return modelAndView;
    }

}
