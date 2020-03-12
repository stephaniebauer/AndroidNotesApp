package com.example.architectureexample;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;


@Getter
@Entity(tableName = "category_table")
public class Category {

    @PrimaryKey(autoGenerate = false)
    @Setter
    private int id;
    private String name;
    private String color;

    public Category(String name, String color, int id) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
}
