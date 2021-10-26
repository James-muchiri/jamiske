package com.eshop.jamiske.repositories;

import com.eshop.jamiske.model.Categories;
import com.eshop.jamiske.model.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Products, Long> {


    Iterable<Products> findByName(String search_text);

    Iterable<Products> findById(Integer id);
}
