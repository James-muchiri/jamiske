package com.eshop.jamiske.controllers;


import com.eshop.jamiske.model.Admi;
import com.eshop.jamiske.model.Categories;
import com.eshop.jamiske.model.Products;
import com.eshop.jamiske.repositories.AdmiRepository;
import com.eshop.jamiske.repositories.CategoryRepository;
import com.eshop.jamiske.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;

@RestController

public class JamisControler {


    @Autowired
    private AdmiRepository dept;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;


    @RequestMapping("/")
    public ModelAndView indexx () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        List<Categories> categoriesList= (List<Categories>) categoryRepository.findAll();
        List<Products> productsList= (List<Products>) productRepository.findAll();
        List<Products> productsListByCat= (List<Products>) productRepository.findAll();
        String[] catts = {};
        for (Products products : productsListByCat )
        {

            if ( ArrayUtils.contains( catts, products.getCategory()) ) {
                // Do some stuff.
            }
            else {
                catts= Arrays.copyOf(catts, catts.length + 1);
                catts[catts.length - 1] = products.getCategory();

            }


        }


        modelAndView.addObject("cat", categoriesList);
        modelAndView.addObject("products", productsList);

        modelAndView.addObject("productsbycat", catts);
        return modelAndView;
    }





    @PostMapping(path="/addd") // Map ONLY POST Requests
    public @ResponseBody
    String addNewAdmin (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Admi n = new Admi();
        n.setName(name);
        n.setEmail(email);
        dept.save(n);
        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Admi> getAllUsers() {
        // This returns a JSON or XML with the users
        return dept.findAll();
    }
@GetMapping(path = "/find/{id}")
public @ResponseBody Iterable<Admi> getUser(@PathVariable final Integer id) {
    // This returns a JSON or XML with the users
    return dept.findById(id);
}
}
