package com.aiden.andmodule.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;

import java.util.List;

public class StdRecyclerAdapter extends RecyclerView.Adapter<StdRecyclerAdapter.StdViewHolder> {

    String TAG = "StdRecyclerAdapter";



    public interface OnListItemSelectedInterface {
        void onItemSelected(View v, int position);
    }

    private OnListItemSelectedInterface mListener;
    private OnListItemLongSelectedInterface mLongListener;

    public interface OnListItemLongSelectedInterface {
        void onItemLongSelected(View v, int position);
    }


    private SparseBooleanArray mSelectedItems = new SparseBooleanArray(0);

    Context mContext;
    List<String> mdata;
    RecyclerView recyclerView;

    public StdRecyclerAdapter(Context context
            , RecyclerView recyclerView
            , OnListItemSelectedInterface listener
            , OnListItemLongSelectedInterface longListener) {
        this.mContext = context;
        this.mListener = listener;
        this.mLongListener = longListener;
        this.recyclerView = recyclerView;
    }


    public int getCountItem(){
        return mSelectedItems.size();
    }


    public void setData(List<String> data) {
        mdata = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(mContext);
        View view = inflate.inflate(R.layout.list_data, parent, false);

        StdViewHolder vh = new StdViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull StdViewHolder holder, int position) {
        holder.textView.setText(mdata.get(position));
        holder.itemView.setSelected(isItemSelected(position));

        if (isItemSelected(position)) {
            holder.itemView.setBackgroundColor(Color.BLUE);
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE);
        }



    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class StdViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public StdViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    toggleItemSelected(position);
                    mListener.onItemSelected(v,position);

                    LogUtil.e(TAG, "position = " + position);

                    LogUtil.e(TAG, "남은 갯수  = " + getCountItem());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mLongListener.onItemLongSelected(v, getAdapterPosition());
                    return false;
                }
            });
        }
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

    private boolean isItemSelected(int position) {
        return mSelectedItems.get(position, false);
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
    public void allSelectedItem() {


        for (int i = 0; i < mdata.size(); i++) {

            mSelectedItems.put(i, true);
            notifyItemChanged(i);
            LogUtil.e(TAG,"all selected--->"+i);

        }

       // mSelectedItems.clear();
    }
}

