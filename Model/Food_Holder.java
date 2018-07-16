package com.example.khan.food.Model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khan.food.Interface.Onclick;
import com.example.khan.food.R;

public class Food_Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mview;
    public TextView foodName;
    public ImageView foodimage;
    private Onclick onclick;
    public Food_Holder(View itemView) {
        super(itemView);
        mview=itemView;
        foodName=mview.findViewById(R.id.food_Text);
        foodimage=mview.findViewById(R.id.food_image);
        mview.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        onclick.onClick(v,getAdapterPosition(),false);

    }
    public void setOnclick(Onclick onclick) {
        this.onclick = onclick;
    }

}
