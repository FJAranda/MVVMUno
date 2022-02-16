package com.example.mvvmuno.data.repository;

import com.example.mvvmuno.data.dao.CategoryDAO;
import com.example.mvvmuno.data.database.MyDatabase;
import com.example.mvvmuno.data.model.Category;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CategoryRepository {
    private static CategoryRepository repository;
    private ArrayList<Category> list;
    private CategoryDAO dao;

    private CategoryRepository() {
        list = new ArrayList<>();
        dao = MyDatabase.getDatabase().categoryDAO();
    }

    public static CategoryRepository getInstance(){
        if (repository == null){
            repository = new CategoryRepository();
        }
        return repository;
    }

    public ArrayList<Category> getList(){
        try {
            return (ArrayList<Category>)MyDatabase.databaseWriteExecutor.submit(()->dao.selectAll()).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Category getCategory(String name){
        Category category = null;
        try {
            category = MyDatabase.databaseWriteExecutor.submit(()->dao.findCategory(name)).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return category;
    }

    public void add(Category category){
        MyDatabase.databaseWriteExecutor.submit(()-> dao.insert(category));
    }

    public void edit(Category category){
        MyDatabase.databaseWriteExecutor.submit(()->dao.update(category));
    }

    public void delete(Category category){
        MyDatabase.databaseWriteExecutor.submit(()-> dao.delete(category));
    }
}
