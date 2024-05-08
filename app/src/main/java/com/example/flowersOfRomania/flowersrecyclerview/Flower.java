package com.example.flowersOfRomania.flowersrecyclerview;

import java.io.Serializable;
public class Flower implements Serializable{

    private String name, type, description, url, image;

    public Flower(String name, String type, String description, String url, String image) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.url = url;
        this.image = image;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
