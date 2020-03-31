package edu.cque.jianxing.demosqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDataBaseHelper extends SQLiteOpenHelper {

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
    private Context mContext; //保存从UI传入的上下文对象，界面无素调用时需要

    public MyDataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;
    }

    /**
     * 当初始化DBHelper时，db文件不存在时被回调，若db文件已存在，则不会调用
     * @param db 底层传入的数据库对象
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BOOK);
        db.execSQL(CREATE_TABLE_CATEGORY);
        Toast.makeText(mContext, "Table has created", Toast.LENGTH_LONG).show();
    }

    /**
     * 当初始化DBHelper时，db文件存在，但version参数出现新号时回调
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
        Toast.makeText(mContext, "DB Version: " + newVersion, Toast.LENGTH_LONG).show();
    }
}
