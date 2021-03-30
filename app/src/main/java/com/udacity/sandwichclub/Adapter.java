package com.udacity.sandwichclub;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<String> sandwiches;

    Adapter(Context context, List<String> sandwiches) {
        this.sandwiches = sandwiches;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        String sandwich = sandwiches.get(position);
        holder.sandwichName.setText(sandwich);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_POSITION, position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sandwiches.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView sandwichName;

        ViewHolder(View view){
            super(view);
            sandwichName = (TextView) view.findViewById(R.id.sandwich_name);
        }
    }
}
