package com.aiden.andmodule.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.aiden.andmodule.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

/**
 * Created by charlie on 2019.09.15

 */


public class BottomSheetDialog extends BottomSheetDialogFragment implements View.OnClickListener{

    private RadioButton r_btn1, r_btn2;
    private RadioGroup radioGroup;

    Button confirm;
    int sortIdx;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    private static String PREF_SORT = "PREF_SORT";
    int nSort=0;

    public static BottomSheetDialog getInstance() { return new BottomSheetDialog(); }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_dialog, container,false);

         prefs =getActivity().getPreferences(Context.MODE_PRIVATE);
         editor = prefs.edit();
        confirm = view.findViewById(R.id.confirm);

        r_btn1 = (RadioButton) view.findViewById(R.id.rg_btn1);
        r_btn2 = (RadioButton) view.findViewById(R.id.rg_btn2);

        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);

        confirm.setOnClickListener(this);
        return view;
    }
    public void pref_Save_Sort(int sort) {

        this.nSort = sort;
        editor.putInt(PREF_SORT, nSort);
        editor.commit();
    }

    public int pref_Load_Sort() {
        return prefs.getInt(PREF_SORT, nSort);
    }

    //라디오 그룹 클릭 리스너
    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int position) {

            if (position == R.id.rg_btn1) {
                sortIdx = 1;
                pref_Save_Sort(sortIdx);
                Toast.makeText(getActivity(), "라디오 그룹 버튼1 눌렸습니다.", Toast.LENGTH_SHORT).show();
            } else if (position == R.id.rg_btn2) {
                sortIdx = 2;
                pref_Save_Sort(sortIdx);
                Toast.makeText(getActivity(), "라디오 그룹 버튼2 눌렸습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.confirm:
                Toast.makeText(getContext(),"Confirm--->"+sortIdx, Toast.LENGTH_SHORT).show();
                break;
        }
        dismiss();
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();
        if(pref_Load_Sort()==0)
            r_btn1.setChecked(true);
        switch (pref_Load_Sort()){
            case 1:
                r_btn1.setChecked(true);
                break;
            case 2:
                r_btn2.setChecked(true);
                break;
        }
     }
}
