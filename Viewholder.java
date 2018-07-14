package com.example.khan.food;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.khan.food.Interface.Onclick;
import com.example.khan.food.Model.Category;
import com.squareup.picasso.Picasso;

public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mview;
    public TextView text;
    public ImageView imageView;
    private Onclick onclick;

    public Viewholder(View itemView) {
        super(itemView);
        mview=itemView;




    }

    public  void setDetailes(Context context,String Image_url,String Name){
        text=mview.findViewById(R.id.textView);
        imageView=mview.findViewById(R.id.my_image);
        text.setText(Name);

     Glide.with(context).load(Image_url).into(imageView);
        mview.setOnClickListener(this);


    }

    public void setOnclick(Onclick onclick) {
        this.onclick = onclick;
    }

    @Override
    public void onClick(View v) {
        onclick.onClick(v,getAdapterPosition(),false);
    }
}
