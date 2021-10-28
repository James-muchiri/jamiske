package com.eshop.jamiske.services;

import com.eshop.jamiske.model.Products;

import java.util.Collection;

public interface ProductService {


  public abstract void createProduct(Products product);
  public abstract void updateProduct(String id, Products product);
  public abstract void deleteProduct(String id);
  public abstract Collection<Products> getProducts();
}
