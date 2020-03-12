package com.example.architectureexample;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;



@Database(entities = {Note.class, Category.class}, version = 4)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao getNoteDao();
    public abstract CategoryDao getCategoryDao();

    public static synchronized NoteDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate (@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask <Void, Void, Void> {
        private NoteDao noteDao;
        private CategoryDao categoryDao;

        private  PopulateDbAsyncTask (NoteDatabase db){
            noteDao = db.getNoteDao();
            categoryDao = db.getCategoryDao();

        }
        @Override
        protected Void doInBackground(Void... voids) {
            categoryDao.insert(new Category("Shopping", "blue",1));
            categoryDao.insert(new Category("Books", "yellow",2));
            categoryDao.insert(new Category("Movies", "orange",3));
            noteDao.insert(new Note ("Title1", "Description1", 1, 1));
            noteDao.insert(new Note ("Title2", "Description2", 2, 2));
            noteDao.insert(new Note ("Title3", "Description3", 3, 3));
            return null;
        }
    }
}
