package com.example.mvvmuno.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmuno.R;
import com.example.mvvmuno.data.model.Category;
import com.example.mvvmuno.databinding.ItemCategoryBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<Category> list;
    private OnManageCategoryListener listener;
    private ItemCategoryBinding mBinding;

    public interface OnManageCategoryListener{
        void onEditCategory(Category category);
        void onDeleteCategory(Category category);
    }

    public CategoryAdapter(ArrayList<Category> list, OnManageCategoryListener listener) {
        //mBinding = binding;
        this.list = list;
        this.listener = listener;
    }

    public void update(List<Category> categories) {
        this.list.clear();
        this.list.addAll(categories);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_category, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Category category, OnManageCategoryListener listener){
            mBinding.setCategory(category);
            itemView.setOnClickListener(v->{
                listener.onEditCategory(category);
            });
            itemView.setOnLongClickListener(v->{
                listener.onDeleteCategory(category);
                return true;
            });
        }
    }
}
