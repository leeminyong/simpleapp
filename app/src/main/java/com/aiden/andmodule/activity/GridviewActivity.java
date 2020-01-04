package com.aiden.andmodule.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.aiden.andmodule.R;
import com.aiden.andmodule.widget.GridViewPager;
import com.aiden.andmodule.widget.Model;

import java.util.ArrayList;
import java.util.List;

public class GridviewActivity extends AppCompatActivity {

    private String[] titles = {"美食", "电影", "酒店住宿", "休闲娱乐", "外卖", "自助餐", "KTV", "机票/火车票", "周边游", "美甲美睫",
            "火锅", "生日蛋糕", "甜品饮品", "水上乐园", "汽车服务", "美发", "丽人", "景点", "足疗按摩", "运动健身", "健身", "超市", "买菜",
            "今日新单", "小吃快餐", "面膜", "洗浴/汗蒸", "母婴亲子", "生活服务", "婚纱摄影", "学习培训", "家装", "结婚", "全部分配"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        GridViewPager mGridViewPager = (GridViewPager) findViewById(R.id.mGridViewPager);
        //데이터 소스를 초기화
        mGridViewPager
                //각 페이지의 용량 설정
                .setPageSize(20)
                .setGridItemClickListener((pos, position, str) -> Log.d("123", pos + "/" + str))
                .setGridItemLongClickListener((pos, position, str) -> Log.d("456", pos + "/" + str))

                .init(initData());

    }

    /**
     * 데이터 소스를 초기화
     */
    private List<Model> initData() {
        List<Model> mData = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            //자원 ID를 동적으로 가져옵니다. 첫 번째 매개 변수는 자원 이름이고 두 번째 매개 변수는 드로어 블, 문자열 등과 같은 자원 유형입니다.
            // 세 번째 매개 변수는 패키지 이름입니다.
            int imageId = getResources().getIdentifier("ic_category_" + i, "mipmap", getPackageName());
            mData.add(new Model(titles[i], imageId));
        }
        return mData;
    }
}
