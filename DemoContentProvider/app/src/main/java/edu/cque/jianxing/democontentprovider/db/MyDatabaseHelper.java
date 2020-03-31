package edu.cque.jianxing.democontentprovider.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context mContext;

    public static final String CREATE_TABLE_BOOK =
            "create table Book("
                    +"_id integer primary key autoincrement,"
                    +"author text,"
                    +"price real,"
                    +"pages integer,"
                    +"name text)";
    public static final String CREATE_TABLE_CATEGORY =
            "create table Category("
                    +"id integer primary key autoincrement,"
                    +"category_name text,"
                    +"category_code integer)";

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BOOK);
        db.execSQL(CREATE_TABLE_CATEGORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
