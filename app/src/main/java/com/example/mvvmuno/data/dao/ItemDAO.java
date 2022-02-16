package com.example.mvvmuno.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mvvmuno.data.model.Item;

import java.util.List;

@Dao
public interface ItemDAO {
    @Insert()
    long insert(Item item);

    @Update()
    void update(Item item);

    @Delete()
    void delete(Item item);

    @Query("SELECT * FROM item ORDER BY name ASC")
    List<Item> selectAll();

    @Query("SELECT * FROM item WHERE category=:categoryID")
    List<Item> selectByCategory(int categoryID);

    @Query("SELECT * FROM item WHERE name=:name")
    Item selectItem(String name);

}
