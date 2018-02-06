package com.example.ryan.appone.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.ryan.appone.entity.User;

import java.util.List;

/**
 * Created by ryanfitz on 2/6/18.
 *
 * four annotations @Query, @Insert, @Update, @Delete
 */

@Dao
public interface UserDao {

    @Query("SELECT * From user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE first_name like :firstName")
    User findByFirstName(String firstName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(User... users);

}
