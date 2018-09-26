package com.etisalat.foodmenuloader.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Model class for Retrofit cient response
 */
@Root(name = "menu", strict = false)
public class MenuItemsResponse {
    @ElementList(inline = true)
    public List<Item> menuItems;

    public List<Item> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<Item> menuItems) {
        this.menuItems = menuItems;
    }
}

