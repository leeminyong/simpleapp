package com.aiden.andmodule.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aiden.andmodule.R;


public class RecycleGridAct extends AppCompatActivity {


    RecyclerView recyclerView;


    private int dotscount;
    private ImageView[] dots;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_main);


        setupGridRecyclerView();
    }

    private void setupGridRecyclerView() {

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new Adapter());
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
    }




    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        int id = getRequestedOrientation();
        Log.e("Test","id---->"+id);

        super.onRestoreInstanceState(savedInstanceState);
    }

    class Adapter extends RecyclerView.Adapter<ViewHolder>{
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.table_item,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 31;
        }
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
