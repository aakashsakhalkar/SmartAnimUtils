package com.aakash.smartanim;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class AnimAdapter extends RecyclerView.Adapter<AnimAdapter.ViewHolder> {
    private final String[] items;
    private final OnItemClick listener;

    interface OnItemClick {
        void onClick(String name);
    }

    AnimAdapter(String[] items, OnItemClick listener) {
        this.items = items;
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(android.R.id.text1);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = items[position];
        holder.text.setText((position+1)+") "+name);
        holder.itemView.setOnClickListener(v -> listener.onClick(name));
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}

