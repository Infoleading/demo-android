package edu.cque.jianxing.demosharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnSave, btnRestore;
    private TextView tvName, tvAge, tvMarried;
    private EditText etName, etAge;
    private Spinner spMarried;
    private Boolean bMarried=true;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        spMarried = findViewById(R.id.spMarried);
        spMarried.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Adapter adapter = parent.getAdapter();
                String item = (String)adapter.getItem(position);
                if(item.compareTo("yes")==0)
                    bMarried = true;
                else
                    bMarried = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("user",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name", etName.getText().toString());
                editor.putInt("age", Integer.parseInt(etAge.getText().toString()));
                editor.putBoolean("married", bMarried);
                editor.apply();
                Toast.makeText(MainActivity.this,"Message have saved", Toast.LENGTH_SHORT).show();
            }
        });

        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvMarried = findViewById(R.id.tvMarried);

        btnRestore = findViewById(R.id.btnRestore);
        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("user", MODE_PRIVATE);
                String name = pref.getString("name","");
                int age = pref.getInt("age", 0);
                Boolean married = pref.getBoolean("married", false);

                tvName.setText(name);
                tvAge.setText(String.valueOf(age));
                tvMarried.setText(married?"yes":"no");
            }
        });
    }
}
