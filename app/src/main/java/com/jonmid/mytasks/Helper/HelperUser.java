package com.jonmid.mytasks.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by erickdavid on 05/06/2017.
 */

public class HelperUser extends SQLiteOpenHelper {

    private static final String LOGTAG = "LOGTAG";
    public static final String DATABASE_NAME = "users";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_STATUS = "status";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_EMAIL + " TEXT," +
                    COLUMN_USERNAME + " TEXT," +
                    COLUMN_PASSWORD + " TEXT," +
                    COLUMN_STATUS + " TEXT" +
                    ")";

    public static final String TABLE_BUSES = "buses";
    public static final String COLUMN_ROUTE = "route";
    public static final String COLUMN_NEIGHBORHOD = "neighborhood";

    public static final String TABLE_CREATE_BUSES =
            "CREATE TABLE " + TABLE_BUSES + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ROUTE + " TEXT, " +
                    COLUMN_NEIGHBORHOD + " TEXT" +
                    ")";

    public HelperUser(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE_BUSES);
        Log.i(LOGTAG, "Tabla de usuarios creada correctamente.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_BUSES);
        onCreate(db);
    }
}
