package edu.cque.jianxing.demosqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.cque.jianxing.demosqlite.db.MyDataBaseHelper;

public class MainActivity extends AppCompatActivity {

    private MyDataBaseHelper dbHelper;
    private Button btnCreateDatabase, btnUpdateDatabase, btnAddData, btnUpdateData, btnDeleteData, btnQueryData;
    private EditText etVersion;
    private ListView lvCursor;
    private SimpleCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDataBaseHelper(this, "BookStore.db", null, 1);

        etVersion = findViewById(R.id.etVersion);

        btnCreateDatabase = findViewById(R.id.btnCreateTable);
        btnCreateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

        btnUpdateDatabase = findViewById(R.id.btnUpdateTable);
        btnUpdateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int versionNumber=1;
                try {
                    versionNumber = Integer.parseInt(etVersion.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                dbHelper = new MyDataBaseHelper(MainActivity.this, "BookStore.db", null, versionNumber);
                dbHelper.getWritableDatabase();
            }
        });

        btnAddData = findViewById(R.id.btnAddData);
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put("name","Thinking in Java");
                values.put("author", "Bruce Eke");
                values.put("pages", 300);
                values.put("price", 10.99);
                db.insert("Book", null, values);

                values.put("name", "第一行代码");
                values.put("author", "郭霖");
                values.put("pages", 240);
                values.put("price", 24.6);
                db.insert("Book", null, values);

                values.put("name", "Raspberry Pi Creatation");
                values.put("author", "Jianxing");
                values.put("pages", 420);
                values.put("price", 78.8);
                db.insert("Book", null, values);
            }
        });

        btnUpdateData = findViewById(R.id.btnUpdateData);
        btnUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", "100");
                db.update("Book", values, "author=?", new String[]{"Jianxing"});
            }
        });

        btnDeleteData = findViewById(R.id.btnDeleteData);
        btnDeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                int num = db.delete("Book", "price>?", new String[]{"50"});
                Toast.makeText(MainActivity.this, num+" records has been deleted", Toast.LENGTH_LONG).show();
            }
        });

        btnQueryData = findViewById(R.id.btnQueryData);
        btnQueryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                if(cursor.moveToFirst()){
                    do{
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double prices = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity", "name: " + name);
                        Log.d("MainActivity", "author: " + author);
                        Log.d("MainActivity", "pages: " + pages);
                        Log.d("MainActivity", "price: " + prices);
                    }while(cursor.moveToNext());
                }
                cursor.moveToFirst();
                //使用 SimpleCursorAdatper 在 ListView 中显示数据的案例
                lvCursor = findViewById(R.id.lvCursor);
                mCursorAdapter = new SimpleCursorAdapter(
                        MainActivity.this,
                        R.layout.item_book,
                        cursor,
                        new String[]{"name", "author", "pages", "price"},
                        new int[]{R.id.tvName, R.id.tvAuthor, R.id.tvPages, R.id.tvPrice},
                        CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
                );
                lvCursor.setAdapter(mCursorAdapter);
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //当cursor用于Adapter时，生命周期中不可关闭，否则会没显示。在生命周期结束时关闭cursor
        if(mCursorAdapter !=null && mCursorAdapter.getCursor()!=null)
            mCursorAdapter.getCursor().close();
    }
}
