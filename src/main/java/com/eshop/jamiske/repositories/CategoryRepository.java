package com.eshop.jamiske.repositories;

import com.eshop.jamiske.model.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Categories, Long> {
    Iterable<Categories> findById(Integer id);
}
