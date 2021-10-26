package com.eshop.jamiske.repositories;

import com.eshop.jamiske.model.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Products, Long> {



    Object findByName(String search_text);
}
