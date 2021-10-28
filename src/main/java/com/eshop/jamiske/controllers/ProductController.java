package com.eshop.jamiske.controllers;


import com.eshop.jamiske.model.Products;
import com.eshop.jamiske.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController

public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @RequestMapping(value = "/search", method = RequestMethod.POST)

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
    List<Integer> getUp(@PathVariable final Integer id, HttpServletRequest request) {
        // This returns a JSON or XML with the users



        List <Integer> carts = (List<Integer>) request.getSession().getAttribute("cart");
        //check if notes is present in session or not
        if (carts == null) {
            carts = new ArrayList<>();
            // if notes object is not present in session, set notes in the request session
            request.getSession().setAttribute("cart", carts);
        }
        else {
            if (carts.contains(id))
            {


            }
            else {

                carts.add(id);
                request.getSession().setAttribute("cart", carts);


            }

        }
        return carts;
    }

    @GetMapping(path = "/addToCart==/{id}")
    public @ResponseBody
    List<Products> getUpp(@PathVariable final Integer id, HttpServletRequest request) {
        // This returns a JSON or XML with the users



        List <Products> carts = (List<Products>) request.getSession().getAttribute("cartss");
        Products productsList= (Products) productRepository.findById(id);

       carts.add(productsList);

        return carts;
    }


    @GetMapping(path="/getCart")
    public @ResponseBody
    Integer getcart(HttpServletRequest request) {
      //  List<Integer> carts = (List<Integer>)
       // Integer count = 0;
        List <Integer> carts = (List<Integer>) request.getSession().getAttribute("cart");
     int  count = carts.size();

        return count;
    }
    @GetMapping(path="/fetchCart")
    public @ResponseBody
    List<Products> fetchcart(HttpServletRequest request) {

int count = 0;
        List <Integer> carts = (List<Integer>) request.getSession().getAttribute("cart");
        List<Products> temp = new ArrayList<>(Arrays.asList());
        for (Integer cart : carts) {
     count++;
            Products productsList= (Products) productRepository.findById(cart);

            temp.add(productsList);
        }





        return  temp;
    }
    @PostMapping("/addNote")
    public List<String> addNote(@RequestParam("note") String note, HttpServletRequest request) {
        //get the notes from request session
        List<String> notes = (List<String>) request.getSession().getAttribute("NOTES_SESSION");
        //check if notes is present in session or not
        if (notes == null) {
            notes = new ArrayList<>();
            // if notes object is not present in session, set notes in the request session
            request.getSession().setAttribute("NOTES_SESSION", notes);
        }
        notes.add(note);
        request.getSession().setAttribute("NOTES_SESSION", notes);
        return notes ;
    }

}
