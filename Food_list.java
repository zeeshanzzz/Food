package com.example.khan.food;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.khan.food.Interface.Onclick;
import com.example.khan.food.Model.Category;
import com.example.khan.food.Model.Food;
import com.example.khan.food.Model.Food_Holder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Food_list extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference category;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        database = FirebaseDatabase.getInstance();
        category = database.getReference("Foods");
        recyclerView = findViewById(R.id.List);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        String categoryId="";
        if(getIntent()!=null)
            categoryId=getIntent().getStringExtra("CategoryId");
        if(!categoryId.isEmpty() && categoryId!=null){

            loadFood(categoryId);

        }
    }
    private  void loadFood(String categoryId){
        FirebaseRecyclerAdapter<Food, Food_Holder> adapter = new FirebaseRecyclerAdapter<Food, Food_Holder>(Food.class, R.layout.food_list, Food_Holder.class, category.orderByChild("MenuId").equalTo(categoryId)) {
            @Override
            protected void populateViewHolder(Food_Holder viewHolder, final Food model, int position) {
                viewHolder.foodName.setText(model.getName());
                Glide.with(Food_list.this).load(model.getImage()).into(viewHolder.foodimage);

                viewHolder.setOnclick(new Onclick() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(Food_list.this,""+model.getName(),Toast.LENGTH_LONG).show();
                    }
                });

            }


        };
        recyclerView.setAdapter(adapter);
    }
    }





