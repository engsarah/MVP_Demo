package com.etisalat.foodmenuloader.data.db.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.etisalat.foodmenuloader.data.db.dao.MenuItemDAO;
import com.etisalat.foodmenuloader.data.db.model.ItemModel;
import com.etisalat.foodmenuloader.data.db.utils.DBConstants;

/**
 * This class is responsible for creating DB Schema as well
 * as manipulating any migrations
 */
@Database(entities = {ItemModel.class}, version = 1, exportSchema = false)
public abstract class MenuItemDatabase extends RoomDatabase {

    public abstract MenuItemDAO getMenuItemDAO();

    private static MenuItemDatabase menuDatabase;

    public static MenuItemDatabase getInstance(Context context) {
        if (null == menuDatabase) {
            menuDatabase = buildDatabaseInstance(context);
        }
        return menuDatabase;
    }

    private static MenuItemDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                MenuItemDatabase.class,
                DBConstants.DB_NEW_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public void cleanUp() {
        menuDatabase = null;
    }

}