package com.aiden.andmodule.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aiden.andmodule.R;

public class DialogActivity extends BaseActivity {


    private DialogBox dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_dialog);
    }

    public void onAlert(View view) {
        try{
            dialog = new DialogBox(this, R.style.AppTheme);
            dialog.show();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public class DialogBox extends Dialog {

        public DialogBox(Context context,int theme) {
            super(context,theme);
            setContentView(R.layout.dialog_alert);


            TextView btn_cancel = findViewById(R.id.btn_cancel);
            btn_cancel.setOnClickListener(v -> dialog.dismiss());
            TextView btn_ok = findViewById(R.id.btn_ok);
            btn_ok.setOnClickListener(v->dialog.dismiss());

        }
    }
}
