package edu.cque.jianxing.democontentproviderresolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd, btnQuery, btnUpdate, btnDelete;
    private ListView lvBook;
    private String newId;
    private CursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvBook = findViewById(R.id.lvBook);
        lvBook.setAdapter();

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://edu.cque.jianxing.democontentprovider.provider/book");
                ContentValues values = new ContentValues();
                values.put("name", "Thinking in Java");
                values.put("author", "Bruce Ecke");
                values.put("pages", 968);
                values.put("price", 98);
                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
            }
        });

        btnQuery = findViewById(R.id.btnQuery);
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://edu.cque.jianxing.democontentprovider.provider/book");
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);

            }
        });
    }
}
