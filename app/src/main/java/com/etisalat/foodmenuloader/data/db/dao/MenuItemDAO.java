package com.etisalat.foodmenuloader.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.etisalat.foodmenuloader.data.db.model.ItemModel;
import com.etisalat.foodmenuloader.data.db.utils.DBConstants;

import java.util.List;


/**
 * Dao class used with room database to facilitate the Crud
 * operation on database tables
 */

@Dao
public interface MenuItemDAO {
    /**
     *
     * @return all items in Items table
     */
    @Query("SELECT * FROM "+ DBConstants.TABLE_NAME_ITEMS)
    List<ItemModel> getAll();
    /*
     * Insert the object in database
     * @param item, object to be inserted
     */
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    long insert(ItemModel item);

    /*
     * Insert list of objects in database
     * @param items, object to be inserted
     */
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    long[]  insertAll(List<ItemModel> items);

    /*
     * update the object in database
     * @param item, object to be updated
     */
    @Update
    void update(ItemModel item);

    /*
     * delete the object from database
     * @param item, object to be deleted
     */
    @Delete
    void delete(ItemModel item);

    /*
     * delete list of objects from database
     * @param item, array of objects to be deleted
     */
    @Delete
    void delete(ItemModel... item);

}