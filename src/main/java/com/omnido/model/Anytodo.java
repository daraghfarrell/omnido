package com.omnido.model;

import java.util.UUID;

/**
 * @author dfarrell on 16/05/2016.
 */
public class Anytodo {

    long id;
    UUID uuid;
    String name;
    String description;

    long numberOfLinks;

    public Anytodo(long id, UUID uuid, String anytodo, String desc, long numberOfLinks) {
        this.id = id;
        this.uuid = uuid;
        this.name = anytodo;
        this.description = desc;
        this.numberOfLinks = numberOfLinks;
    }

    public long getId() {
        return id;

    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfLinks() {
        return numberOfLinks;
    }

    public void setNumberOfLinks(long numberOfLinks) {
        this.numberOfLinks = numberOfLinks;
    }


}
