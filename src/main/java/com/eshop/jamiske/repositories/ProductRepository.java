package com.eshop.jamiske.repositories;

import com.eshop.jamiske.model.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ProductRepository extends CrudRepository<Products, Long> {


    Iterable<Products> findByName(String search_text);

    Products findById(Integer id);


}
