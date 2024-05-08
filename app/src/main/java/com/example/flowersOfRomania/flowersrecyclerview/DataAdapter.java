package com.example.flowersOfRomania.flowersrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowersOfRomania.R;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private Flower[] flowers;

    public DataAdapter(Flower[] people) {
        this.flowers = people;
    }

    @NonNull
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flower_layout, parent, false);

        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // populate holder with data at position
        holder.populate(flowers[position]);
    }

    public int getItemCount() {
        return this.flowers.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView titleTextView, subtitleTextView;
        View rootView;
        Flower flower;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rootView = itemView;
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subtitleTextView = itemView.findViewById(R.id.subtitleTextView);

            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("flowerData", this.flower);

            Intent intent = new Intent(view.getContext(), FlowerActivity.class);
            intent.putExtras(bundle);
            view.getContext().startActivity(intent);
        }

        public void populate(Flower flower) {
            this.flower = flower;

            titleTextView.setText(flower.getName());
            subtitleTextView.setText(flower.getType());

            String iconName = flower.getImage();
            iconName = iconName.substring(0, iconName.indexOf('.'));

            int imageId = rootView.getResources()
                    .getIdentifier(iconName, "drawable", rootView.getContext().getPackageName());

            imageView.setImageResource(imageId);
        }
    }
}
