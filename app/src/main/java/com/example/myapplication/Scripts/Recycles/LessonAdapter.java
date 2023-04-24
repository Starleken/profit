package com.example.myapplication.Scripts.Recycles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Scripts.Model.Lesson;

import java.util.ArrayList;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {

    public interface OnLessonClickListener{
        void onStateClick(Lesson lesson, int position);
    }

    private final OnLessonClickListener onClickListener;

    private ArrayList<Lesson> lessons;
    private Context context;

    public LessonAdapter(Context context, ArrayList<Lesson> lessons, OnLessonClickListener onClickListener){
        this.lessons = lessons;
        this.onClickListener = onClickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public LessonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lessons, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonAdapter.ViewHolder holder, int position) {
        Lesson lesson = lessons.get(position);
        //holder.iconView.setImageIcon();
        holder.nameView.setText(lesson.Name);
        holder.durationView.setText(String.format("Длительность: %s", lesson.Duration));

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onClickListener.onStateClick(lesson, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView iconView;
        final TextView nameView;
        final TextView durationView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconView = itemView.findViewById(R.id.IconView);
            nameView = itemView.findViewById(R.id.NameLesson);
            durationView = itemView.findViewById(R.id.DurationLesson);
        }
    }
}
