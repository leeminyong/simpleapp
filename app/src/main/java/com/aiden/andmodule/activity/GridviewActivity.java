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

    private String[] titles = {"DAY01 채용", "DAY02 법률", "DAY03 사무(1)", "DAY04 사무(2)", "DAY05 사무(3)", "DAY06 공동체",
            "DAY07 마케팅", "DAY09 경제", "DAY10 쇼핑", "DAY11 제품개발","DAY12 생산", "DAY13 고객서비스", "DAY14 공항", "DAY15 계약",
            "DAY16 상거래", "DAY17 무역.배송", "DAY18 숙박.식당", "DAY19 수익", "DAY20 회계", "DAY21 회사동향", "DAY22 미팅", "DAY23 사원복지",
            "DAY24 인사이동", "DAY25 교통", "DAY26 은행", "DAY27 투자", "DAY28 건물.주택", "DAY29 환경", "DAY30 건강"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        GridViewPager mGridViewPager = findViewById(R.id.mGridViewPager);
        //데이터 소스를 초기화
        mGridViewPager
                //각 페이지의 용량 설정
                .setPageSize(20)
                .setGridItemClickListener((pos, position, str) -> Log.e("123", pos + "/" + str))
                .setGridItemLongClickListener((pos, position, str) -> Log.e("456", pos + "/" + str))

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
            int imageId = getResources().getIdentifier("cartoon_" + i, "drawable", getPackageName());
            mData.add(new Model(titles[i], imageId));
        }
        return mData;
    }
}
