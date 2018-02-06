package com.example.ryan.appone.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ryanfitz on 2/6/18.
 */

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "first_name")
    private String firstName;

    public int getUid(){
        return uid;

    }

    public void setUid(int uid1) {
        this.uid = uid1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName1) {
        this.firstName = firstName1;
    }
}
