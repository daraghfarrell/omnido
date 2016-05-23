package com.omnido.model;

/**
 * @author dfarrell on 16/05/2016.
 */
public class Anytodo {

    long id;
    String name;
    String description;

    public Anytodo(long i, String anytodo, String desc) {
        this.id = i;
        this.name = anytodo;
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

}
