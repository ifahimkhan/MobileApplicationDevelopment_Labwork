package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    private Context context;
    private List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        super(context, 0, students);
        this.context = context;
        this.students = students;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_item, parent, false);
        }

        TextView tvSAP = convertView.findViewById(R.id.tvSAP);
        TextView tvRoll = convertView.findViewById(R.id.tvRoll);
        TextView tvName = convertView.findViewById(R.id.tvName);

        tvSAP.setText("SAP: " + student.getSapNumber());
        tvRoll.setText("Roll No: " + student.getRollNumber());
        tvName.setText("Name: " + student.getStudentName());

        return convertView;
    }
}
