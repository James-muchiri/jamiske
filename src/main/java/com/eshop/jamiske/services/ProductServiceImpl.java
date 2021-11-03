package com.eshop.jamiske.services;


import com.eshop.jamiske.model.Cart;
import com.eshop.jamiske.model.Products;
import com.eshop.jamiske.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;



    @Override
    public List<Cart> addcart(Integer id, HttpSession request) {
        Products book = productRepository.findById(id);
        Cart cart = new Cart();
        List<Cart> list = (List<Cart>) request.getAttribute("cart10");

        if (list == null) {
            list = new ArrayList<Cart>();
        }
        cart.toProduct(book);
        if (list.contains(cart)) {
            return list;
        } else {


            list.add(cart);

            request.setAttribute("cart10", list);
            return list;
        }
    }
    @Override
    public Collection<Products> getProductByName(String search_text, String categories) {


        List<Products> books = new ArrayList<Products>();
        productRepository.findByName(search_text).forEach(books1 -> books.add(books1));
        return books;
    }

    @Override
    public Collection<Products> getProducts() {

        List<Products> books = new ArrayList<Products>();
        productRepository.findAll().forEach(books1 -> books.add(books1));
        return books;
    }

    @Override
    public Integer getcart(HttpSession request) {
        List<Cart> list = (List<Cart>) request.getAttribute("cart10");

        if (list == null) {
            list = new ArrayList<Cart>();
            request.setAttribute("cart10", list);
        }
       return list.size();
    }

    @Override
    public List<Cart> addquantity(Integer id, HttpSession request) {

        Cart cart = new Cart();
        List<Cart> list = (List<Cart>) request.getAttribute("cart10");

        for (Cart c : list) {
            if (id == c.getId()) {

                c.setQuantity(c.getQuantity() + 1);

            }

        }


        request.setAttribute("cart10", list);
        return list;
    }

    @Override
    public List<Cart> subquantity(Integer id, HttpSession request) {
        Cart cart = new Cart();
        List<Cart> list = (List<Cart>) request.getAttribute("cart10");

        for (Cart c : list) {
            if (id == c.getId()) {
if (c.getQuantity() < 1) {
    c.setQuantity(c.getQuantity() - 1);
}
            }

        }


        request.setAttribute("cart10", list);
        return list;
    }

    @Override
    public List<Cart> remmovecart(Integer id, HttpSession request) {
        Cart cart = new Cart();
        List<Cart> list = (List<Cart>) request.getAttribute("cart10");
        Cart temp = null;
        for (Cart c : list) {
            if (id == c.getId()) {

                temp = c;

            }

        }
        if (temp != null)
        {
            list.remove(temp);

        }

        request.setAttribute("cart10", list);
        return list;
    }

}
