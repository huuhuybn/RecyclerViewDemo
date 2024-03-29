package com.dotplays.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {


    private List<Student> studentList;

    public void setMyOnItemClickListener(MyOnItemClickListener myOnItemClickListener) {
        this.myOnItemClickListener = myOnItemClickListener;
    }

    private MyOnItemClickListener myOnItemClickListener;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }


    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);

        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder studentHolder, final int i) {

        studentHolder.tvInfo.setText(studentList.get(i).name + " | " + studentList.get(i).phone);

        studentHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnItemClickListener.onClick(studentList.get(i));
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentHolder extends RecyclerView.ViewHolder {

        public TextView tvInfo;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            tvInfo = itemView.findViewById(R.id.tvInfo);
        }


    }
}
