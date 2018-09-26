package com.etisalat.foodmenuloader.data.db.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.etisalat.foodmenuloader.data.db.dao.MenuItemDAO;
import com.etisalat.foodmenuloader.data.db.model.ItemModel;
import com.etisalat.foodmenuloader.data.db.utils.DBConstants;

/**
 * Old Room Database class with invalid schema
 * not used anymore MenuItemDatabase is the currently used one
 */
@Database(entities = {ItemModel.class}, version = 1, exportSchema = false)
public abstract class MenuDatabase extends RoomDatabase {

    public abstract MenuItemDAO getMenuItemDAO();

    private static MenuDatabase menuDatabase;

    public static MenuDatabase getInstance(Context context) {
        if (null == menuDatabase) {
            menuDatabase = buildDatabaseInstance(context);
        }
        return menuDatabase;
    }

    private static MenuDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                MenuDatabase.class,
                DBConstants.DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public void cleanUp() {
        menuDatabase = null;
    }

}