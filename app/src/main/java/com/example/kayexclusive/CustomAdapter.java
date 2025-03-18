package com.example.kayexclusive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    List<CustomModel> mydata;
    Context context;
    SelectedItem selectedItem;


    public CustomAdapter(List<CustomModel> mydata, Context context, SelectedItem selectedItem) {
        this.mydata = mydata;
        this.context = context;
        this.selectedItem = selectedItem;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {

        CustomModel customData = mydata.get(position);

        holder.name.setText(customData.getName());
        holder.title.setText(customData.getTitle());
//        holder.image.setImageResource(customData.getImage());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedItem.onItemClick(customData);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,title;
//        ImageView image;
//        CardView cardView;

        public ViewHolder(@NonNull View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            title = (TextView) view.findViewById(R.id.title);
//            image = (ImageView) view.findViewById(R.id.CardView);
//            cardView = (CardView) view.findViewById(R.id.MyContainer);
        }
    }
}