package com.eshop.jamiske.repositories;




import com.eshop.jamiske.model.Admi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface AdmiRepository extends CrudRepository<Admi, Long> {





    Admi findById(Integer id);
    Admi findByEmail(String email);
    Admi findByName(String name);
}