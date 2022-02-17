package com.example.mvvmuno.ui;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmuno.data.model.Category;
import com.example.mvvmuno.data.repository.CategoryRepository;

public class CategoryManageViewModel extends ViewModel {
    private MutableLiveData<Category> category;
    private MutableLiveData<String> name;
    private MutableLiveData<Boolean> isAdd;

    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(MutableLiveData<String> name) {
        this.name = name;
    }

    public MutableLiveData<Category> getCategory(){
        return category;
    }

    public MutableLiveData<Boolean> getIsAdd() {
        return isAdd;
    }

    public void setCategory(MutableLiveData<Category> category) {
        this.category = category;
    }

    public void setIsAdd(MutableLiveData<Boolean> isAdd) {
        this.isAdd = isAdd;
    }

    public CategoryManageViewModel(){
        category = new MutableLiveData<>();
    }

    public CategoryManageViewModel(Category category) {
        if (category == null){
            isAdd = new MutableLiveData<>(true);
            this.category = new MutableLiveData<>(new Category());
        }else{
            isAdd = new MutableLiveData<>(false);
            this.category = new MutableLiveData<>(category);
        }
    }

    public void insertCategory(){
        Log.d("CATEGORYMANAGEVIEWMODEL", "INSERT");
        //Log.d("CATEGORYVALUE", name.getValue());
        //this.category.getValue().setName(name.getValue());
        CategoryRepository.getInstance().add(category.getValue());
    }

    public void updateCategory(){
        Log.d("CATEGORYMANAGEVIEWMODEL", "INSERT");
        CategoryRepository.getInstance().edit(this.category.getValue());
    }
}
