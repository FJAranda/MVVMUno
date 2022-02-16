package com.example.mvvmuno.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mvvmuno.data.model.Category;

import java.util.List;

@Dao
public interface CategoryDAO {
    @Insert()
    long insert(Category category);

    @Update()
    void update(Category category);

    @Delete()
    void delete(Category category);

    @Query("SELECT * FROM category ORDER BY name ASC")
    List<Category> selectAll();

    @Query("SELECT * FROM category WHERE name=:name")
    Category findCategory(String name);
}
