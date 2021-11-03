package com.eshop.jamiske.controllers;


import com.eshop.jamiske.model.Cart;
import com.eshop.jamiske.model.Products;
import com.eshop.jamiske.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.eshop.jamiske.services.ProductService;

@RestController

public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    ProductService productService;
// search engine
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Collection<Products> search (@RequestParam String categories, @RequestParam String search_text)
    {

            return productService.getProductByName(search_text, categories);
    }
// add cart
    @GetMapping(path = "/addToCart/{id}")
    public @ResponseBody
    List<Cart> getUp1(@PathVariable final Integer id, HttpSession request) {

         return productService.addcart(id, request);
     }

  // quantity
    @GetMapping(path="/addByOne/{id}")
    public List<Cart> quantity(@PathVariable final Integer id, HttpSession request) {

        return productService.addquantity(id, request);
    }
    // minus
    @GetMapping(path="/reduceByOne/{id}")
    public List<Cart> quantityRemove(@PathVariable final Integer id, HttpSession request) {

        return productService.subquantity(id, request);
    }
    //remove cart
    @GetMapping(path="/remove/{id}")
    public List<Cart> CartRemove(@PathVariable final Integer id, HttpSession request) {


        return productService.remmovecart(id, request);
    }
    //get cart
    @GetMapping(path="/getCart")
    public Integer getcart(HttpSession request) {

        return productService.getcart(request);



    }
    //fetch cart
    @GetMapping(path="/fetchCart")
    public @ResponseBody
    List<Cart> fetchcart(HttpSession request) {

        List<Cart> list = (List<Cart>) request.getAttribute("cart10");





        return  list;
    }

    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
}
