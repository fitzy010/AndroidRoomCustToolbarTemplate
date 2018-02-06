package com.example.ryan.appone.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.ryan.appone.database.AppDatabase;
import com.example.ryan.appone.entity.User;

import java.util.List;

/**
 * Created by ryanfitz on 2/6/18.
 */

public class InitializeDatabase {

    private static final String TAG = InitializeDatabase.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateTestData(db);
    }

    private static User addUser(final AppDatabase db, User user) {
        db.userDao().insertAll(user);
        return user;
    }

    private static void populateTestData(AppDatabase db) {
        User user = new User();
        user.setFirstName("Ryan");
        addUser(db,user);

        List<User> userList = db.userDao().getAll();
        Log.d(InitializeDatabase.TAG, "Rows Count: " + userList.size());
        Log.d(InitializeDatabase.TAG, "First record's name: " + userList.get(0));
    }

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(Void... params) {
            populateTestData(mDb);

            return null;
        }
    }
}
