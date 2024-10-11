package com.eco.adapters;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView main_list;
    ArrayAdapter<String> adapter;
    ArrayList<String> names;
    Button create;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        main_list=findViewById(R.id.main_list);
        create=findViewById(R.id.create);
        names=new ArrayList<>();
        editText = findViewById(R.id.userName);
        Collections.addAll(names,"Arman","Dina","Arlan");
        adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,names);
        main_list.setAdapter(adapter);
        
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= editText.getText().toString();
                if(!name.isEmpty()){
                    adapter.add(name);
                    editText.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });
        

        
    }
}