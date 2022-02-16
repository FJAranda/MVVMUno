package com.example.mvvmuno.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvvmuno.data.dao.CategoryDAO;
import com.example.mvvmuno.data.dao.ItemDAO;
import com.example.mvvmuno.data.model.Category;
import com.example.mvvmuno.data.model.Item;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Category.class, Item.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract CategoryDAO categoryDAO();
    public abstract ItemDAO ItemDAO();
    private static volatile MyDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MyDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyDatabase.class, "MVVMUno")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    public static void create(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyDatabase.class, "MVVMUno")
                            .build();
                }
            }
        }
    }

    public static MyDatabase getDatabase() {
        return INSTANCE;
    }
}
