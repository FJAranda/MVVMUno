package com.example.mvvmuno.data.model;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Category implements Serializable  {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
            this.name = name;
    }

    public Category(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    @Ignore
    public Category() {
    }
}
