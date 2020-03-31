package edu.cque.jianxing.democontentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.cque.jianxing.democontentprovider.db.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelpter;
    private Button btnCreateDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelpter = new MyDatabaseHelper(this, "BookStore.db", null, 1);

        btnCreateDatabase = findViewById(R.id.btnCreateButton);
        btnCreateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelpter.getWritableDatabase();
            }
        });
    }
}
