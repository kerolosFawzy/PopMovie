package com.massive.popmovie.model;

import java.io.Serializable;

/**
 * Created by minafaw on 10/12/2017.
 */

public class Trailer implements Serializable {
    private String key;
    private String id;
    private String name;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
