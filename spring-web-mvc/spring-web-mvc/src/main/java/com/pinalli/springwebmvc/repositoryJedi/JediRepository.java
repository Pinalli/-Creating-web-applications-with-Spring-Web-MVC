package com.pinalli.springwebmvc.repositoryJedi;

import com.pinalli.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/*@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

    List<Jedi> findByNameContainingIgnoreCase(final String name);*/



@Repository
public class JediRepository {

    private  List<Jedi> jedi;

    public JediRepository() {

        jedi = new ArrayList<>();
        jedi.add(new Jedi("Luke", "Skywalker"));


    }

    public  List<Jedi> getAllJedi(){

        return this.jedi;

    }

    public void add(final Jedi jedi) {

        this.jedi.add(jedi);
    }


    public Object findByNameContainingIgnoreCase(String name) {
    }
}
