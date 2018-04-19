package com.qiuyu.activity;

import com.qiuyu.mobilesafe.R;
import com.qiuyu.utils.ConstantValue;
import com.qiuyu.utils.SpUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SetOverActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//1.得到是否完成设置的判断符
		Boolean setup_over = SpUtils.readBoolean(getApplicationContext(), ConstantValue.SETUP_OVER, false);
		if(setup_over){
			//设置完成,进入设置完成界面
			setContentView(R.layout.activity_setover);
		}else {
			//设置未完成,进入设置导航界面
			Intent intent = new Intent(getApplicationContext(),Setup1Activity.class);
			startActivity(intent);
			finish();
		}
		
	}
}
