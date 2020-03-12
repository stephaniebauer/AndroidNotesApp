package com.example.architectureexample;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

import static androidx.room.ForeignKey.NO_ACTION;

@Getter
@Entity(tableName = "note_table",
        foreignKeys = @ForeignKey(entity = Category.class,
        parentColumns = "id",
        childColumns = "categoryId",
        onDelete = NO_ACTION))

public class Note {

    @PrimaryKey(autoGenerate = true)
    @Setter
    private int id;

    private String title;
    private String description;
    private int priority;
    public int categoryId;

    public Note(String title, String description, int priority, int categoryId) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.categoryId = categoryId;
    }

}
