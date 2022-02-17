package com.example.mvvmuno.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmuno.R;
import com.example.mvvmuno.data.CategoryManageViewModelFactory;
import com.example.mvvmuno.databinding.FragmentCategoryManageBinding;

public class CategoryManageFragment extends Fragment {
    FragmentCategoryManageBinding binding;
    CategoryManageViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryManageBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (CategoryManageFragmentArgs.fromBundle(getArguments()).getCategory() != null){
            viewModel = new ViewModelProvider(this, new CategoryManageViewModelFactory(CategoryManageFragmentArgs.fromBundle(getArguments()).getCategory())).get(CategoryManageViewModel.class);
        }else{
            viewModel = new ViewModelProvider(this).get(CategoryManageViewModel.class);
        }
        binding.setViewmodel(viewModel);
    }
}