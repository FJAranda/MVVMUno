package com.example.mvvmuno.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmuno.data.model.Category;
import com.example.mvvmuno.data.repository.CategoryRepository;

import java.util.List;

public class CategoryListViewModel extends ViewModel {
    private MutableLiveData<List<Category>> list;


    public CategoryListViewModel() {
        list = new MutableLiveData<>(CategoryRepository.getInstance().getList());
    }

    public MutableLiveData<List<Category>> getList(){
        return list;
    }

    public void delete(Category category){
        CategoryRepository.getInstance().delete(category);
    }


}
