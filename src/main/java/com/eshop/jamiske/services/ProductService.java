package com.eshop.jamiske.services;

import com.eshop.jamiske.model.Cart;
import com.eshop.jamiske.model.Products;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

public interface ProductService {


  public abstract List<Cart> addcart(Integer id, HttpSession request);
  public abstract Collection<Products> getProductByName(String search_text, String categories);
  public abstract Collection<Products> getProducts();


  public abstract Integer getcart(HttpSession request);

  public abstract List<Cart> addquantity(Integer id, HttpSession request);

  public abstract List<Cart> subquantity(Integer id, HttpSession request);

  public abstract  List<Cart> remmovecart(Integer id, HttpSession request);
}
