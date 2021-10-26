package com.eshop.jamiske.controllers;


import com.eshop.jamiske.model.Products;
import com.eshop.jamiske.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller

public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path="/search") // Map ONLY POST Requests
    public @ResponseBody
    Iterable<Products> search (@RequestParam String categories
            , @RequestParam String search_text) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        if (categories == "all"){

            List<Products> productsList= (List<Products>) productRepository.findByName(search_text);
            return productsList;
        }
        else {
            List<Products> productsList= (List<Products>) productRepository.findByName(search_text);
            return productsList;
        }


    }


    @GetMapping(path = "/addToCart/{id}")
    public @ResponseBody
    List<Products> getUp(@PathVariable final Integer id, HttpServletRequest request) {
        // This returns a JSON or XML with the users
        List<Products> productbyid= (List<Products>) productRepository.findById(id);

        //get the notes from request session
        List<Integer> carts = (List<Integer>) request.getSession().getAttribute("NOTES_SESSION");
        //check if notes is present in session or not
        if (carts == null) {
            carts = new ArrayList<>();
            // if notes object is not present in session, set notes in the request session
            request.getSession().setAttribute("NOTES_SESSION", carts
            );
        }
        carts.add(id);
        request.getSession().setAttribute("NOTES_SESSION", carts.toArray());
        return  productbyid;

    }

}
