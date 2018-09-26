package com.etisalat.foodmenuloader.data.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

/**
 * Item Model Entity Class used for creating Items table
 */
@Entity(tableName = "Items")
public class ItemModel {

    @PrimaryKey(autoGenerate = true)
    @NotNull
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "cost")
    private String cost;

    public ItemModel(int id, String name, String description, String cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}