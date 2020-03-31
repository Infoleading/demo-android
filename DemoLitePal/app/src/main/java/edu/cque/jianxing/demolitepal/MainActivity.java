package edu.cque.jianxing.demolitepal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

import edu.cque.jianxing.demolitepal.bean.Book;

public class MainActivity extends AppCompatActivity {

    private Button btnCreateDatabase, btnAddData, btnQueryData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateDatabase = findViewById(R.id.btnCreateDatabase);
        btnCreateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });

        btnAddData = findViewById(R.id.btnAddData);
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setAuthor("JianXing");
                book.setName("SOA Practice");
                book.setPages(690);
                book.setPress("Tinghua Univercity press");
                book.setPrice(126);
                book.save();
            }
        });

        btnQueryData = findViewById(R.id.btnQueryData);
        btnQueryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = LitePal.findAll(Book.class);
                for (Book book : books) {
                    Log.d("MainActivity", "name: " + book.getName());
                    Log.d("MainActivity", "author: " + book.getAuthor());
                    Log.d("MainActivity", "pages: " + book.getPages());
                    Log.d("MainActivity", "price: " + book.getPrice());
                    Log.d("MainActivity", "press: " + book.getPress());
                }
            }
        });

    }
}
