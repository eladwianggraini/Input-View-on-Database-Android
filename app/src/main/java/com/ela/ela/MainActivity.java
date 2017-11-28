package com.ela.ela;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private Button tambah, tampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.innama);
        tambah = (Button)findViewById(R.id.tambah);
        tampil = (Button)findViewById(R.id.tampil);

        final Database db = new Database(this);


        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = input.getText().toString();
                db.tambahdata(nama);
                Toast.makeText(MainActivity.this, "tambah  data berhasil", Toast.LENGTH_SHORT).show();
                input.setText("");
            }
        });

        tampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ListView list=(ListView) findViewById(R.id.list);
                List<String> datanama= db.tampildata();
                ArrayAdapter<String> listadapter = new ArrayAdapter<String> (MainActivity.this, R.layout.support_simple_spinner_dropdown_item,datanama);

                list.setAdapter(listadapter);

            }
        });



    }
}
