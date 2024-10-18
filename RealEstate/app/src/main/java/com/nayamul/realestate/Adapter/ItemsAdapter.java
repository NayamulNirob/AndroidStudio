package com.nayamul.realestate.Adapter;

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
import com.nayamul.realestate.Domin.ItemsDomin;
import com.nayamul.realestate.R;
import com.nayamul.realestate.activittes.DetailActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.viewHolder> {

    ArrayList<ItemsDomin> items;

    public ItemsAdapter(ArrayList<ItemsDomin> items) {
        this.items = items;
        formatter = new DecimalFormat("###,###,###,###,##");
    }

    DecimalFormat formatter;
    Context context;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder, parent, false);
        context = parent.getContext();
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    holder.titleTxt.setText(items.get(position).getTitle());
    holder.addressTxt.setText(items.get(position).getAddress());
    holder.priceTxt.setText(String.format("$%s", formatter.format(items.get(position).getPrice())));

    int drawableResourceID=holder.itemView.getResources().getIdentifier(items.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceID)
                .into(holder.pic);
    holder.itemView.setOnClickListener(v -> {
      Intent intent =new Intent(context, DetailActivity.class);
              intent.putExtra("object",items.get(position));
              context.startActivity(intent);
    });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt, addressTxt, priceTxt;
        ImageView pic;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.titleText);
            addressTxt=itemView.findViewById(R.id.addressTxt);
            priceTxt=itemView.findViewById(R.id.priceTxt);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
