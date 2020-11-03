package com.vokasi.tabnavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private ArrayList <itemData> values;
    private Context context;
    private LayoutInflater inflater;

    public ItemAdapter(Context context, ArrayList<itemData> values){
        this.values = values;
        this.inflater = LayoutInflater.from(context);
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        TextView subText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText= itemView.findViewById(R.id.text1);
            subText= itemView.findViewById(R.id.text2);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final itemData data = values.get(position);
        holder.titleText.setText(data.itemTitle);
        holder.subText.setText(data.itemSubtitle);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Anda pilih data" + data.itemTitle,
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }


}
