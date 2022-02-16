package com.example.mvvmuno.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmuno.data.model.Category;
import com.example.mvvmuno.data.repository.CategoryRepository;

public class CategoryManageViewModel extends ViewModel {
    private MutableLiveData<Category> category;

    public CategoryManageViewModel(){
        category = new MutableLiveData<>();
    }

    public MutableLiveData<Category> getCategoryObserver(){
        return category;
    }

    public void insertCategory(String name){
        Category mCategory = new Category();
        mCategory.setName(name);
        CategoryRepository.getInstance().add(mCategory);
    }

    public void updateCategory(Category category){
        CategoryRepository.getInstance().edit(category);
    }

    public void deleteCategory(Category category){
        CategoryRepository.getInstance().delete(category);
    }
}
