package com.hui.customdialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
    TextView tv_bottom_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_bottom_dialog = (TextView) findViewById(R.id.tv_bottom_dialog);
        tv_bottom_dialog.setOnClickListener(this);
    }

    public void showBottomDialog(){
        Dialog dialog = new Dialog(this,R.style.dialog);
        // 性别选择的dialog，以及其上的控件
        View viewSex = getLayoutInflater().inflate(R.layout.dialog_bottom, null);
        // 设置dialog没有title
        dialog.setContentView(
                viewSex,
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        // 可以在此设置显示动画
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = getWindowManager().getDefaultDisplay().getHeight();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 设置显示位置
        dialog.onWindowAttributesChanged(wl);
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_bottom_dialog:
                showBottomDialog();
                break;
        }
    }
}
