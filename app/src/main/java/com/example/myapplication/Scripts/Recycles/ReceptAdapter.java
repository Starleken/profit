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
import com.example.myapplication.Scripts.Model.Recept;

import java.util.ArrayList;

public class ReceptAdapter extends RecyclerView.Adapter<ReceptAdapter.ViewHolder>{
    private ArrayList<Recept> recepts;
    private Context context;

    public ReceptAdapter(Context context, ArrayList<Recept> recepts){
        this.recepts = recepts;
        this.context = context;
    }

    @NonNull
    @Override
    public ReceptAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lessons, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReceptAdapter.ViewHolder holder, int position) {
        Recept recept = recepts.get(position);
        //holder.iconView.setImageIcon();
        holder.nameView.setText(recept.Name);
    }

    @Override
    public int getItemCount() {
        return recepts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView iconView;
        final TextView nameView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconView = itemView.findViewById(R.id.IconView);
            nameView = itemView.findViewById(R.id.NameLesson);
        }
    }
}
