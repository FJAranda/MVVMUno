package com.example.mvvmuno.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmuno.data.model.Category;
import com.example.mvvmuno.ui.CategoryManageViewModel;

public class CategoryManageViewModelFactory implements ViewModelProvider.Factory {
    private Category category;

    public CategoryManageViewModelFactory(Category category) {
        this.category = category;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CategoryManageViewModel(category);
    }
}
