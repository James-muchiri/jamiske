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


@Controller
@RequestMapping(path="/category")
public class CategoryController {

    @RequestMapping("/")
    public String index(){

        return "indexx.html";
    }
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
    @RequestMapping("/catt")
    public ModelAndView indexx () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("indexx");
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
    @GetMapping(path = "/searchbycat/{id}")
    public ModelAndView getUser(@PathVariable final Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        List<Categories> categoriesList= (List<Categories>) categoryRepository.findById(id);

        modelAndView.addObject("cat", categoriesList);
        return modelAndView;
    }
    @PostMapping(path="/search") // Map ONLY POST Requests
    public @ResponseBody
    Iterable<Products> search (@RequestParam String categories
            , @RequestParam String search_text) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

     if (categories == "all"){
         List<Products> productsList= (List<Products>) productRepository.findByName("%search_text%");
         return productsList;
     }
     else {
         List<Products> productsList= (List<Products>) productRepository.findByName("%search_text%");
         return productsList;
     }


    }
}
