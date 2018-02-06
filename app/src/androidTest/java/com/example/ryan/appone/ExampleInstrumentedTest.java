package com.example.ryan.appone;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.ryan.appone.dao.UserDao;
import com.example.ryan.appone.database.AppDatabase;
import com.example.ryan.appone.entity.User;
import com.example.ryan.appone.utils.InitializeDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private UserDao mUserDao;
    private AppDatabase mDb;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = mDb.getAppDatabase(context);
        mUserDao = mDb.userDao();

    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        User user = new User();
        user.setFirstName("Michael");
        mUserDao.insertAll(user);
        User byName = mUserDao.findByFirstName("Michael");
        assertThat(byName.getFirstName(), equalTo(user.getFirstName()));
    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.ryan.appone", appContext.getPackageName());
    }
}
