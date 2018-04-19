package com.qiuyu.activity;

import com.qiuyu.mobilesafe.R;

import com.qiuyu.utils.ConstantValue;
import com.qiuyu.utils.SpUtils;
import com.qiuyu.view.SettingItemView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SettingActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		//1.初始化自动更新条目
		initUpdata();
	
	}

	/**
	 * //1.初始化自动更新条目
	 */
	private void initUpdata() {
	final SettingItemView siv_update=(SettingItemView)findViewById(R.id.item_update);
		//1.读取之前的sharedpreference存储的更新开关状态
		Boolean updata_state = SpUtils.readBoolean(getApplicationContext(), ConstantValue.UPDATA_STATE, false);
		//2.设置到条目中
		siv_update.setCheck(updata_state);
		
		siv_update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//1.判断当前item中的CheckBox的状态
				boolean check_state = siv_update.isCheck();
				
				siv_update.setCheck(!check_state);
				//2.将更改后的更新开关状态存储到sp中
				SpUtils.writeBoolean(getApplicationContext(), ConstantValue.UPDATA_STATE, !check_state);
			}
		});
	}
}
