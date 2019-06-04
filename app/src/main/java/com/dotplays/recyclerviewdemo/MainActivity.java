package com.dotplays.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvList;

    private List<Student> studentList;

    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = findViewById(R.id.rvList);


        studentList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.phone = "0913456789";
            student.name = "Huy Nguyen - Android A-Z";
            studentList.add(student);

        }

        rvList.setHasFixedSize(true);

        studentAdapter = new StudentAdapter(studentList);

        studentAdapter.setMyOnItemClickListener(new MyOnItemClickListener() {
            @Override
            public void onClick(Student student) {
                Toast.makeText(MainActivity.this,student.name,Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(studentAdapter);
    }
}
