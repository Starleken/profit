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
    private final ArrayList<Lesson> lessons;
    private final LayoutInflater inflater;

    public LessonAdapter(Context context, ArrayList<Lesson> lessons){
        this.lessons = lessons;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LessonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lessons, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonAdapter.ViewHolder holder, int position) {
        Lesson lesson = lessons.get(position);
        //holder.iconView.setImageIcon();
        holder.nameView.setText(lesson.Name);
        holder.durationView.setText(lesson.Duration);
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
            iconView = itemView.findViewById(R.id.IconLesson);
            nameView = itemView.findViewById(R.id.IconLesson);
            durationView = itemView.findViewById(R.id.DurationLesson);
        }
    }
}
