package com.eshop.jamiske.controllers;


import com.eshop.jamiske.model.Admi;
import com.eshop.jamiske.repositories.AdmiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/demo")
public class JamisControler {


    @Autowired
    private AdmiRepository dept;

    @PostMapping(path="/addd") // Map ONLY POST Requests
    public @ResponseBody
    String addNewAdmin (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Admi n = new Admi();
        n.setName(name);
        n.setEmail(email);
        dept.save(n);
        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Admi> getAllUsers() {
        // This returns a JSON or XML with the users
        return dept.findAll();
    }
@GetMapping(path = "/find/{id}")
public @ResponseBody Iterable<Admi> getUser(@PathVariable final Integer id) {
    // This returns a JSON or XML with the users
    return dept.findById(id);
}
}
