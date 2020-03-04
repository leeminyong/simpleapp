package com.aiden.andmodule.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiden.andmodule.R;

import java.util.List;

/**
 * Created by lijuan on 2016/9/12.
 */
public class GridViewAdapter extends BaseAdapter {
    private List<Model> mData;
    private LayoutInflater inflater;
    /**
     * 0부터 시작하는 페이지 번호 아래 첨자 (현재 페이지 번호)
     */
    private int curIndex;
    /**
     * 각 페이지에 표시되는 숫자
     */
    private int pageSize;

    public GridViewAdapter(Context context, List<Model> mData, int curIndex, int pageSize) {
        inflater = LayoutInflater.from(context);
        this.mData = mData;
        this.curIndex = curIndex;
        this.pageSize = pageSize;
    }

    /**
     *
     *  먼저 데이터 세트의 크기가 전체 페이지를 표시하기에 충분한 지 판별하십시오.？mData.size() > (curIndex+1)*pageSize,
     *   충분하면 각 페이지에 표시된 최대 항목 수를 직접 반환하십시오.pageSize,
     *  충분하지 않은 경우 여러 품목을 반품하고,(mData.size() - curIndex * pageSize);(즉, 나머지 항목이 마지막 페이지에 표시됩니다.)
     *
     */
    @Override
    public int getCount() {
        return mData.size() > (curIndex + 1) * pageSize ? pageSize : (mData.size() - curIndex * pageSize);

    }

    @Override
    public Model getItem(int position) {
        return mData.get(position + curIndex * pageSize);
    }

    @Override
    public long getItemId(int position) {
        return position + curIndex * pageSize;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_gridview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv = convertView.findViewById(R.id.textView);
            viewHolder.iv = convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        /**
         *
         * position = position + curIndex * pageSize，
         */
        int pos = position + curIndex * pageSize;
        viewHolder.tv.setText(mData.get(pos).getName());
        viewHolder.iv.setImageResource(mData.get(pos).getIconRes());
        return convertView;
    }

    private class ViewHolder {
        TextView tv;
        ImageView iv;
    }
}