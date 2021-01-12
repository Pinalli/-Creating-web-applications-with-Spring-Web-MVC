package com.pinalli.springwebmvc.service;

import java.util.List;
import java.util.Optional;

import com.pinalli.springwebmvc.exception.JediNotFoundException;
import com.pinalli.springwebmvc.model.Jedi;
import com.pinalli.springwebmvc.repositoryJedi.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class JediService {

    @Autowired
    private JediRepository repository;

    public List<Jedi> findAll() {

        return repository.findAll();

    }

    public Jedi findById(final Long id) {

       final Optional<Jedi> jedi =  repository.findById(id);

        if(jedi.isPresent()){
            return jedi.get();
        } else {
           throw new JediNotFoundException();
        }
    }

    public Jedi save(final Jedi jedi) {
        return repository.save(jedi);
    }

    public Jedi update(final Long id, final Jedi dto) {

        final Optional<Jedi> jediEntity = repository.findById();
        final Jedi jedi;

        if( jediEntity.isPresent()){
            jedi = jediEntity.get();
        }else {
           throw new JediNotFoundException();
        }

        jedi.setName(dto.getName());
        jedi.setLastName(dto.getLastName());

        return repository.save(jedi);
    }

    public void delete(Long id) {

       final Jedi jedi =  findById(id);
       repository.delete(jedi);
    }
}
