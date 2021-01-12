package com.pinalli.springwebmvc.rest;


import javax.validation.Valid;
import com.pinalli.springwebmvc.model.Jedi;
import com.pinalli.springwebmvc.repositoryJedi.JediRepository;

import com.pinalli.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class JediResource {


    @Autowired
    private JediService service;

    @GetMapping("/api/jedi") //retorna um Jason no browser
    public List<Jedi> getAllJedi() {

        return service.findAll();
    }

    @GetMapping("/api/jedi/{id}") //retorna um Jason no browser com id
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {
        final Jedi jedi = service.findById(id);

            return ResponseEntity.ok(jedi);
    }

    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@RequestBody Jedi jedi){

        return service.save(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @RequestBody Jedi dto) {

        final Jedi jedi = service.update(id, dto);
        return ResponseEntity.ok(jedi);
    }

    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}