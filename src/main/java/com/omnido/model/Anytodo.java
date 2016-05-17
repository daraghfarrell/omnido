package com.omnido.model;

/**
 * @author dfarrell on 16/05/2016.
 */
public class Anytodo {

    long id;
    String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Anytodo(long i, String anytodo) {
        this.id = i;
        this.name = anytodo;
    }
}
