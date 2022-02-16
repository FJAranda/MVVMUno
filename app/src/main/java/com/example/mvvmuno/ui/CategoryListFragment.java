package com.example.mvvmuno.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmuno.R;
import com.example.mvvmuno.data.model.Category;
import com.example.mvvmuno.databinding.FragmentCategoryListBinding;

import java.util.ArrayList;

public class CategoryListFragment extends Fragment implements CategoryAdapter.OnManageCategoryListener{
    FragmentCategoryListBinding binding;
    private CategoryListViewModel viewModel;
    private CategoryAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryListBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment


        binding.fabCategoryList.setOnClickListener( v ->{
            CategoryListFragmentDirections.ActionCategoryListFragmentToCategoryManageFragment action =
                    CategoryListFragmentDirections.actionCategoryListFragmentToCategoryManageFragment(null);
            NavHostFragment.findNavController(this).navigate(action);
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CategoryListViewModel.class);
        viewModel.getList().observe(getViewLifecycleOwner(), categories -> {
            adapter.update(categories);
        });
        binding.setViewmodel(viewModel);
        initRVCategories();
    }

    private void initRVCategories() {
        adapter = new CategoryAdapter(new ArrayList<>(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        binding.rvCategoryList.setLayoutManager(linearLayoutManager);
        binding.rvCategoryList.setAdapter(adapter);
    }


    @Override
    public void onEditCategory(Category category) {

    }

    @Override
    public void onDeleteCategory(Category category) {

    }
}