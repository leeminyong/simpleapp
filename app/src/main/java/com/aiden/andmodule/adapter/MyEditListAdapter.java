package com.aiden.andmodule.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;

import androidx.recyclerview.widget.RecyclerView;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.db.MyEditDBHelper;
import com.aiden.andmodule.model.MyEditWord;
import com.aiden.andmodule.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * MY 단어
 */

public class MyEditListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    String TAG = "MyEditListAdapter";
    MyViewHolder myViewHolder;
    private ArrayList<MyEditWord> datas;

    Context context;
    int resId;

    private SparseBooleanArray mSelectedItems = new SparseBooleanArray(0);

    public interface OnListItemSelectedInterface {
        void onItemSelected(View v, int position);
    }

    private OnListItemSelectedInterface mListener;

    public boolean b_Edit;


    public void setData(ArrayList<MyEditWord> data) {
        datas = data;
        notifyDataSetChanged();
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


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lv_myedit_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        myViewHolder = (MyViewHolder) holder;
        myViewHolder.itemView.setSelected(isItemSelected(position));

        final MyEditWord vo = datas.get(position);
        myViewHolder.tx_no.setText(vo.id + "");//
        myViewHolder.tx_eng.setText(vo.word_eng);//
        myViewHolder.tx_kor.setText(vo.word_kor);//

        if (isItemSelected(position)) {
            holder.itemView.setBackgroundColor(Color.BLUE);
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE);
        }


    }

    public void setb_Edit(boolean b_Edit) {
        this.b_Edit = b_Edit;
    }

    // 아이템의 수
    @Override
    public int getItemCount() {
        return datas.size();
    }


    public int getCountItem() {
        return mSelectedItems.size();
    }


    public MyEditListAdapter(Context context, int resId, ArrayList<MyEditWord> datas, OnListItemSelectedInterface listener) {
        this.context = context;
        this.datas = datas;
        this.resId = resId;
        this.mListener = listener;


    }


    public void clearSelectedItem() {
        int position;
        for (int i = 0; i < mSelectedItems.size(); i++) {
            position = mSelectedItems.keyAt(i);
            mSelectedItems.put(position, false);
            LogUtil.e(TAG, "un selected--->" + datas.get(position).id);
            notifyItemChanged(position);
        }
        mSelectedItems.clear();
    }

    public void DeleteItem() {
        int position;

        for (int i = 0; i < mSelectedItems.size(); i++) {
            position = mSelectedItems.keyAt(i);
            mSelectedItems.put(position, false);

            LogUtil.e(TAG, "un selected--->" + datas.get(position).id);

            id_delete(datas.get(position).id);

            notifyItemChanged(position);
        }

        mSelectedItems.clear();
    }


    private void id_delete(int ids) {

        SQLiteDatabase db = null;

        LogUtil.e(TAG, "삭제할 id-->" + ids);
        MyEditDBHelper helper = new MyEditDBHelper(context);
        db = helper.getWritableDatabase();
        String sql = "delete from tb_myedit where _id = ?";
        Object[] params = {ids};

        db.execSQL(sql, params);
        if (db != null)
            db.close();
    }
    public void allSelectedItem() {
        for (int i = 0; i < datas.size(); i++) {
            mSelectedItems.put(i, true);
            notifyItemChanged(i);
            LogUtil.e(TAG, "all selected--->" + i);
        }
    }

    private boolean isItemSelected(int position) {
        return mSelectedItems.get(position, false);
    }

    /**
     * 뷰홀더
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linear_item;
        public TextView tx_no;
        TextView tx_eng;
        TextView tx_kor;
        MyViewHolder(View itemView) {
            super(itemView);
            tx_eng = itemView.findViewById(R.id.txt_eng);
            tx_kor = itemView.findViewById(R.id.txt_kor);
            tx_no = itemView.findViewById(R.id.txt_no);
            linear_item = itemView.findViewById(R.id.linear);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                toggleItemSelected(position);
                mListener.onItemSelected(v, position);
                LogUtil.e(TAG, "position = " + position);
                LogUtil.e(TAG, "남은 갯수  = " + getCountItem());
                Toast.makeText(context, "남은 갯수  = " + getCountItem(), Toast.LENGTH_SHORT).show();
            });
        }
    }
}