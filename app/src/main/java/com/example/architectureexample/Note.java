package com.example.architectureexample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    @Setter
    private int id;
    private String title;
    private String description;
    private int priority;

    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

}
