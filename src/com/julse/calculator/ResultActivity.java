package com.julse.calculator;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {
	private int[] expressions={R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView5};
	private Button btn_back;
	private Button btn_off;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		this.setTitle("计算结果");
		
		btn_back=(Button) findViewById(R.id.button1);
		btn_off=(Button) findViewById(R.id.button2);
		
		Bundle bundle=getIntent().getBundleExtra("bundle");
		ArrayList<String> str =bundle.getStringArrayList("opr");
		int i=0;
		for (String string : str) {
			TextView textView =(TextView)findViewById(expressions[i]);
			textView.setText(string);
			textView.setVisibility(View.VISIBLE);
			i++;
		}
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.i("Life", "result Activity is finishing...");
				Intent intent =new Intent(ResultActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
		
		btn_off.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder=new AlertDialog.Builder(ResultActivity.this);
				builder.setTitle("确认要退出么？");
				builder.setPositiveButton("退出",  new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			});
				builder.setNegativeButton("取消",null);
				builder.show();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
