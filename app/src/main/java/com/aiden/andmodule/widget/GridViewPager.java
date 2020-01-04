package com.aiden.andmodule.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.ViewPager;



import com.aiden.andmodule.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ucmed on 2016/10/19.
 */

public class GridViewPager extends RelativeLayout {
    private boolean hasCustomOval = false;
    private LayoutInflater inflater;
    private Context mContext;
    private ViewPager mPager;
    private LinearLayout mLlDot;
    private List<Model> mData;

    private List<GridView> mPagerList;
    private GridItemClickListener gridItemClickListener;
    private GridItemLongClickListener gridItemLongClickListener;

    /**
     * 총 페이지 수
     */
    private int pageCount;

    /**
     * 각 페이지에 표시되는 번호를 설정
     */
    private int pageSize = 10;

    /**
     * 현재 표시되는 페이지
     */
    private int curIndex = 0;

    public GridViewPager(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public GridViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public GridViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    private void initView() {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.view, this);
        mPager = view.findViewById(R.id.viewpager);
        mLlDot = view.findViewById(R.id.ll_dot);
    }

    /**
     * necessary
     *
     * @param list
     * @return
     */
    public GridViewPager init(List<Model> list) {
        mData = list;
        //총 페이지 수 = 총 페이지 수 및 반올림
        pageCount = (int) Math.ceil(mData.size() * 1.0 / pageSize);
        mPagerList = new ArrayList<>();

        for (int i = 0; i < pageCount; i++) {

            GridView gridView = (GridView) inflater.inflate(R.layout.gridview, mPager, false);
            gridView.setAdapter(new GridViewAdapter(mContext, mData, i, pageSize));
            mPagerList.add(gridView);

            gridView.setOnItemClickListener((parent, view, pos, id) -> {
                if (gridItemClickListener == null) return;
                int position = pos + curIndex * pageSize;
                gridItemClickListener.click(pos, position, mData.get(position).getName());
            });
            //true if the callback consumed the long click, false otherwise
            gridView.setOnItemLongClickListener((parent, view, pos, id) -> {
                if (gridItemLongClickListener == null) return false;
                else {
                    int position = pos + curIndex * pageSize;
                    gridItemLongClickListener.click(pos, position, mData.get(position).getName());
                    return true;
                }
            });
        }

        mPager.setAdapter(new ViewPagerAdapter<>(mPagerList));

        if (!hasCustomOval) setOvalLayout();
        return this;
    }

    /**
     * optional 커스텀 도트 설정
     */
    public void setOvalLayout(View view, ViewPager.OnPageChangeListener listener) {
        hasCustomOval = true;
        mLlDot.removeAllViews();
        mLlDot.addView(view);
        mPager.addOnPageChangeListener(listener);
    }

    /**
     * 점 설정
     */
    private void setOvalLayout() {
        for (int i = 0; i < pageCount; i++) {
            mLlDot.addView(inflater.inflate(R.layout.dot, null));
        }
        //기본적으로 첫 페이지 표시
        mLlDot.getChildAt(0).findViewById(R.id.v_dot)
                .setBackgroundResource(R.drawable.dot_selected);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int position) {
                // 점 선택 취소
                mLlDot.getChildAt(curIndex)
                        .findViewById(R.id.v_dot)
                        .setBackgroundResource(R.drawable.dot_normal);
                // 도트 선택
                mLlDot.getChildAt(position)
                        .findViewById(R.id.v_dot)
                        .setBackgroundResource(R.drawable.dot_selected);
                curIndex = position;
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    /**
     * optional 단위 클릭 이벤트 설정
     *
     * @param listener
     * @return
     */
    public GridViewPager setGridItemClickListener(GridItemClickListener listener) {
        gridItemClickListener = listener;
        return this;
    }

    /**
     * optional 设置单元长按事件
     *
     * @param listener
     * @return
     */
    public GridViewPager setGridItemLongClickListener(GridItemLongClickListener listener) {
        gridItemLongClickListener = listener;
        return this;
    }

    public List<GridView> getmPagerList() {
        return mPagerList;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public GridViewPager setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getCurIndex() {
        return curIndex;
    }
}
