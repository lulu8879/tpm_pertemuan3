package com.example.heroesapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Heroes> heroesList = new ArrayList<>();

    public HeroesAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Heroes> getHeroesList() {
        return heroesList;
    }

    public void setHeroesList(ArrayList<Heroes> heroesList) {
        this.heroesList = heroesList;
    }

    @NonNull
    @Override
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.ViewHolder holder, int position) {
        final int index = position;
        holder.tvTitle.setText(getHeroesList().get(position).getHeroName());
        holder.tvContent.setText(getHeroesList().get(position).getHeroDetail());
        Glide.with(context).load(getHeroesList().get(position).getHeroImage()).into(holder.ivHero);

        holder.tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_content = new Intent(context, DetailActivity.class);
                intent_content.putExtra("name",getHeroesList().get(index).getHeroName());
                intent_content.putExtra("content",getHeroesList().get(index).getHeroDetail());
                context.startActivity(intent_content);
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivHero;
        TextView tvTitle, tvContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivHero = itemView.findViewById(R.id.itemhero_iv);
            tvTitle = itemView.findViewById(R.id.itemhero_tv_title);
            tvContent = itemView.findViewById(R.id.itemhero_tv_content);
        }
    }
}
