package com.example.mvvmuno.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmuno.R;
import com.example.mvvmuno.databinding.FragmentItemListBinding;

public class ItemListFragment extends Fragment {
    FragmentItemListBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_order:
                //TODO: ENVIAR ORDENAR AL ADAPTER
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentItemListBinding.inflate(getLayoutInflater());

        binding.fabItemList.setOnClickListener( v ->{
            ItemListFragmentDirections.ActionItemListFragmentToItemManageFragment action =
                    ItemListFragmentDirections.actionItemListFragmentToItemManageFragment(null);
            NavHostFragment.findNavController(this).navigate(action);
        });
        return binding.getRoot();
    }
}