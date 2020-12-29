package com.pinalli.springwebmvc.model;

import org.springframework.lang.Nullable;

public class Jedi {
    @Nullable
    private String name;
    @Nullable
    private String lastName;

    public Jedi() {
    }
    public Jedi(final String name, final String lastName) {
        this.name = name;
        this.lastName = lastName;


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



}
