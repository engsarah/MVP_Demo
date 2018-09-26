package com.etisalat.foodmenuloader.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Model class for pizza items
 */
@Root(name = "item")
public class Item {


    @Element(name = "id")
    private String id;

    @Element(name = "name")
    private String name;
    @Element(name = "cost")
    private String cost;
    @Element(name = "description")
    private String description;

    public Item()
    {

    }

    public Item(String id, String name, String cost, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
