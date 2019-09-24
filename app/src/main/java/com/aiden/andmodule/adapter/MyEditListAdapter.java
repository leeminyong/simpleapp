package com.aiden.andmodule.adapter;

import android.content.Context;
import android.graphics.Color;
import androidx.recyclerview.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.model.MyEditWord;
import com.aiden.andmodule.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *MY 단어
 */

public class MyEditListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    String TAG = "MyEditListAdapter";



    /**
     * 전체 선택하기 위한 설정
     */
    boolean[] isCheckedConfrim;


    public boolean b_Edit;

    public boolean is_allSell() {
        return b_allSell;
    }

    public void set_allSell(boolean b_allSell) {
        this.b_allSell = b_allSell;
    }

    private boolean b_allSell;

    MyViewHolder myViewHolder;
    private ArrayList<MyEditWord> datas;
    ArrayList<MyEditWord> selected = new ArrayList<MyEditWord>();
    Context context;
    int resId;
    private Set<Integer> countersToDelete = new HashSet<Integer>();
    private SparseBooleanArray mSelectedItems = new SparseBooleanArray(0);

    MyEditWord vo;
    // 생성자로부터 전달된 ListBtnClickListener  저장.

    public void selecteAll() {
        // datas.clear();
        selected.clear();
        //selected.addAll(datas);
        datas.addAll(selected);
        notifyDataSetChanged();
    }

    public Set<Integer> getCountersToDelete() {
        LogUtil.e(TAG, "countersToDelete----->" + countersToDelete);
        return countersToDelete;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lv_myedit_item, parent, false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String remin = "";
        myViewHolder = (MyViewHolder) holder;
        holder.itemView.setSelected(isItemSelected(position));

        final MyEditWord vo = datas.get(position);
        if(selected.contains(vo)){
            LogUtil.e(TAG,"선택된 아이템...");
        }else {
            LogUtil.e(TAG,"선택안된 아이템...");
        }
        myViewHolder.tx_no.setText(vo.id+"");//
        myViewHolder.tx_eng.setText(vo.word_eng);//
        myViewHolder.tx_kor.setText(vo.word_kor);//
        //[수정] 리스트뷰 클릭 이벤트

        myViewHolder.itemView.setOnClickListener(v -> {
            v.setBackgroundColor(Color.GRAY);
            LogUtil.e(TAG,"삭제모드 ...-->"+b_Edit);

            if ( mSelectedItems.get(position, false) ){
                LogUtil.e(TAG,"클릭 색상  ...흰색 ");
                mSelectedItems.put(position, false);
                v.setBackgroundColor(Color.WHITE);
                countersToDelete.remove(vo.id);
                LogUtil.e(TAG,"클릭 색상  ...해제--> "+position);
                LogUtil.e(TAG,"클릭 색상  ...해제vo.id--> "+vo.id);
            } else {
                LogUtil.e(TAG,"클릭 색상  ...선택--> "+position);
                LogUtil.e(TAG,"클릭 색상  ...선택 vo.id--> "+vo.id);
                mSelectedItems.put(position, true);
                v.setBackgroundColor(Color.GRAY);
                countersToDelete.add(vo.id);
            }
        });



        if (isCheckedConfrim[position]) {
            countersToDelete.add(vo.id);
            myViewHolder.linear_item.setBackgroundColor(Color.GRAY);
            LogUtil.e(TAG, "전체 선택한 포지션....-->" + position);
        } else {
            countersToDelete.remove(vo.id);
            myViewHolder.linear_item.setBackgroundColor(Color.WHITE);
            LogUtil.e(TAG, "전체 해지한 포지션 ....-->" + position);
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
    public void initConter() {
        countersToDelete.clear();
    }

    // 모두 선택하는 메서드

    public void setAllChecked(boolean ischeked) {
        int tempSize = isCheckedConfrim.length;
        for(int a=0 ; a<tempSize ; a++){
            isCheckedConfrim[a] = ischeked;
        }
    }
    public MyEditListAdapter(Context context, int resId, ArrayList<MyEditWord> datas) {
        this.context = context;
        this.datas = datas;
        this.resId = resId;
        this.isCheckedConfrim = new boolean[datas.size()];
    }
    private boolean isItemSelected(int position) {
        return mSelectedItems.get(position, false);
    }
    /**
     * 뷰홀더
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linear_item;
        private SparseBooleanArray mSelectedItems = new SparseBooleanArray(0);
        TextView tx_no;
        TextView tx_eng;
        TextView tx_kor;
        MyViewHolder(View itemView) {
            super(itemView);
            tx_eng = itemView.findViewById(R.id.txt_eng);
            tx_kor = itemView.findViewById(R.id.txt_kor);
            tx_no = itemView.findViewById(R.id.txt_no);
            linear_item = itemView.findViewById(R.id.linear);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if ( mSelectedItems.get(position, false) ){
                        mSelectedItems.put(position, false);
                        v.setBackgroundColor(Color.WHITE);
                    } else {
                        mSelectedItems.put(position, true);
                        v.setBackgroundColor(Color.BLUE);
                    }

                }
            });
        }
    }
}