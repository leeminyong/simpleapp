package com.aiden.andmodule.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    String TAG = "MyAdapter";

    private Context context;
    private int imags[];
    private int imags_nums[];
    private String names[];

    List<String> mdata;

    private SparseBooleanArray mSelectedItems = new SparseBooleanArray(0);

    private OnListItemSelectedInterface mListener;

    public interface OnListItemSelectedInterface {
        void onItemSelected(View v, int position);
    }

    public MyAdapter(Context context, int[] images, int[] imags_nums, String[] names ,OnListItemSelectedInterface listener) {
        this.context = context;
        this.imags = images;
        this.imags_nums = imags_nums;
        this.names = names;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.table_item, parent, false));
    }

    private boolean isItemSelected(int position) {
        return mSelectedItems.get(position, false);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.img.setImageResource(imags[position]);
        holder.img_num.setImageResource(imags_nums[position]);
        holder.title.setText(names[position]);

        if (isItemSelected(position)) {
            holder.img_select.setVisibility(View.VISIBLE);
            //holder.itemView.setBackgroundColor(Color.BLUE);
        } else {
            holder.img_select.setVisibility(View.INVISIBLE);
            //holder.itemView.setBackgroundColor(Color.WHITE);
        }


    }

    public void clearSelectedItem() {
        int position;

        for (int i = 0; i < mSelectedItems.size(); i++) {
            position = mSelectedItems.keyAt(i);
            mSelectedItems.put(position, false);
            LogUtil.e(TAG,"un selected--->"+position);
            notifyItemChanged(position);
        }

        mSelectedItems.clear();
    }

    private void toggleItemSelected(int position) {

        if (mSelectedItems.get(position, false) == true) {
            mSelectedItems.delete(position);
            notifyItemChanged(position);
        } else {
            mSelectedItems.put(position, true);
            notifyItemChanged(position);
        }
    }

    public int getCountItem(){
        return mSelectedItems.size();
    }

    public void setData(List<String> data) {
        mdata = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public  class MyHolder extends RecyclerView.ViewHolder {

        ImageView img;
        ImageView img_select;
        ImageView img_num;
        TextView title;

        public MyHolder(@NonNull View itemView) {

            super(itemView);
            img = itemView.findViewById(R.id.chapter_img);
            img_select = itemView.findViewById(R.id.chapter_img2);
            img_num = itemView.findViewById(R.id.chapter_no);
            title = itemView.findViewById(R.id.txt_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    toggleItemSelected(position);
                    mListener.onItemSelected(v,position);

                    LogUtil.e(TAG, "position = " + position);

                    LogUtil.e(TAG, "선택 갯수  = " + getCountItem());
                }
            });

        }


    }
}