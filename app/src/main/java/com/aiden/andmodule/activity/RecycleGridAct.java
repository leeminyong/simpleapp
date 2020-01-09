package com.aiden.andmodule.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;


public class RecycleGridAct extends AppCompatActivity {

    String TAG = "RecycleGridAct";
    RecyclerView recyclerView;

    int spancount=6;
    int orient;
    android.content.res.Configuration  mConfig;
    int mNoOfColumns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_main);
         mNoOfColumns = calculateNoOfColumns(getApplicationContext(),120);
        recyclerView = findViewById(R.id.recyclerView);

    }

    private void setupGridRecyclerView(int spancount) {


        recyclerView.setLayoutManager(new GridLayoutManager(this, spancount));
        recyclerView.setAdapter(new MyAdapter(RecycleGridAct.this, day_img, day_num, dayTitleList));

    }

    public static int calculateNoOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }



    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtil.e(TAG,"회전값--->"+newConfig.orientation);


        orient =newConfig.orientation;
        if (newConfig.orientation == newConfig.ORIENTATION_PORTRAIT) {
            LogUtil.e(TAG,"세로:    Portrait");
        }
        else if (newConfig.orientation == newConfig.ORIENTATION_LANDSCAPE) {
            LogUtil.e(TAG,"가로:      landscape");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mConfig = getResources().getConfiguration();



        LogUtil.e(TAG,"컬럼 갯수-->"+mNoOfColumns);

        if (mConfig.orientation == mConfig.ORIENTATION_PORTRAIT) {
            LogUtil.e(TAG,"세로:    Portrait");
            spancount=mNoOfColumns;
        }
        else if (mConfig.orientation == mConfig.ORIENTATION_LANDSCAPE) {
            LogUtil.e(TAG,"가로:      landscape");
            spancount=mNoOfColumns;
        }
        setupGridRecyclerView(spancount);
        LogUtil.e(TAG,"onResume........--->"+mConfig.orientation);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        int id = getRequestedOrientation();
        Log.e("Test", "id---->" + ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onRestoreInstanceState(savedInstanceState);
    }

    private String dayTitleList[] = {
            "DAY01 채용", "Day2 규칙∙법률 ", "DAY03 일반사무(1)", "DAY04 일반사무(2)", "DAY05 일반사무(3)",
            "DAY6 여가∙공동체", "DAY7 마케팅(1)", "DAY8 마케팅(2)", "DAY9 경제", "DAY10 쇼핑",
            "DAY11 제품개발", "DAY12 생산", "DAY13 고객서비스", "DAY14 여행∙공항", "DAY15 계약",
            "DAY16 상거래", "DAY17 무역∙배송", "DAY18 숙박∙식당", "DAY19 수익", "DAY20 회계",
            "DAY21 회사동향", "DAY22 미팅", "DAY23 사원복지", "DAY24 인사이동", "DAY25 교통",
            "DAY26 은행", "DAY27 투자", "DAY28 건물∙주택", "DAY29 환경", "DAY30 건강",
    };

    private int day_img[] = {
            R.drawable.cartoon_1, R.drawable.cartoon_2, R.drawable.cartoon_3, R.drawable.cartoon_4, R.drawable.cartoon_5,
            R.drawable.cartoon_6, R.drawable.cartoon_7, R.drawable.cartoon_8, R.drawable.cartoon_9, R.drawable.cartoon_10,
            R.drawable.cartoon_11, R.drawable.cartoon_12, R.drawable.cartoon_13, R.drawable.cartoon_14, R.drawable.cartoon_15,
            R.drawable.cartoon_16, R.drawable.cartoon_17, R.drawable.cartoon_18, R.drawable.cartoon_19, R.drawable.cartoon_20,
            R.drawable.cartoon_21, R.drawable.cartoon_22, R.drawable.cartoon_23, R.drawable.cartoon_24, R.drawable.cartoon_25,
            R.drawable.cartoon_26, R.drawable.cartoon_27, R.drawable.cartoon_28, R.drawable.cartoon_29, R.drawable.cartoon_30

    };
    private int day_num[] = {
            R.drawable.stage_ing_num01, R.drawable.stage_ing_num02, R.drawable.stage_ing_num03, R.drawable.stage_ing_num04, R.drawable.stage_ing_num05,
            R.drawable.stage_ing_num06, R.drawable.stage_ing_num07, R.drawable.stage_ing_num08, R.drawable.stage_ing_num09, R.drawable.stage_ing_num10,
            R.drawable.stage_ing_num11, R.drawable.stage_ing_num12, R.drawable.stage_ing_num13, R.drawable.stage_ing_num14, R.drawable.stage_ing_num15,
            R.drawable.stage_ing_num16, R.drawable.stage_ing_num17, R.drawable.stage_ing_num18, R.drawable.stage_ing_num19, R.drawable.stage_ing_num20,
            R.drawable.stage_ing_num21, R.drawable.stage_ing_num22, R.drawable.stage_ing_num23, R.drawable.stage_ing_num24, R.drawable.stage_ing_num25,
            R.drawable.stage_ing_num26, R.drawable.stage_ing_num27, R.drawable.stage_ing_num28, R.drawable.stage_ing_num29, R.drawable.stage_ing_num30,

    };


    class MyAdapter extends RecyclerView.Adapter<MyHolder> {

        private Context context;
        private int imags[];
        private int imags_nums[];
        private String names[];

        public MyAdapter(Context context, int[] images, int[] imags_nums, String[] names) {
            this.context = context;
            this.imags = images;
            this.imags_nums = imags_nums;
            this.names = names;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.table_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.img.setImageResource(imags[position]);
            holder.img_num.setImageResource(imags_nums[position]);
            holder.title.setText(dayTitleList[position]);


        }

        @Override
        public int getItemCount() {
            return names.length;
        }
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        ImageView img;
        ImageView img_num;
        TextView title;

        public MyHolder(@NonNull View itemView) {

            super(itemView);
            img = itemView.findViewById(R.id.chapter_img);
            img_num = itemView.findViewById(R.id.chapter_no);
            title = itemView.findViewById(R.id.txt_title);

        }
    }
}
