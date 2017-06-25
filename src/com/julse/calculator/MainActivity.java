package com.julse.calculator;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {
	private EditText number1;
	private EditText number2;

	private int num1, num2;
//	private CheckBox add, minus, multiple, divid;
	private int[] oprs = { R.id.checkBox1, R.id.checkBox2, R.id.checkBox3,
			R.id.checkBox4 };
	private RadioGroup group;
	private Button btn_ok, btn_off;
	private Bundle bundle = new Bundle();
	private boolean flag;
//	private HashMap<String, String> map = new HashMap<String, String>();
//	private ArrayList<HashMap<String, String>> arrayList;
//	private Bundle map;
	private ArrayList<String> list=new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.setTitle("计算器");

		number1 = (EditText) findViewById(R.id.editText1);
		number2 = (EditText) findViewById(R.id.editText2);
		group = (RadioGroup) findViewById(R.id.radioGroup1);
		btn_ok = (Button) findViewById(R.id.button1);
		btn_off = (Button) findViewById(R.id.button2);
		btn_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				num1 = Integer.parseInt(number1.getText().toString());
				num2 = Integer.parseInt(number2.getText().toString());
				flag = group.getCheckedRadioButtonId() != R.id.radio0;
				for (int i = 0; i < 4; i++) {
					if (((CheckBox) findViewById(oprs[i])).isChecked()) {
						if (!flag) {
							new MyOpr(num1, num2, i);
						} else {
							new MyOpr(num1 * 1.0, num2 * 1.0, i);
						}
						

					}
				}
				Intent intent = new Intent(MainActivity.this,
						ResultActivity.class);
				
//				intent.putExtras(bundle);
//				bundle.putAll(arrayList);
//				bundle.putStringArrayList("opr", arrayList);
				
				bundle.putStringArrayList("opr", list);
				intent.putExtra("bundle", bundle);
				intent.putExtras(bundle);
				
				startActivity(intent);
				finish();

			}
		});

		btn_off.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class MyOpr {
		
		
		MyOpr(int a, int b, int opr) {
			Log.i("Life", "整数运算");
			switch (opr) {
			
			case 0:
				list.add(a + " + " + b + "=" + (a + b));
				break;
			case 1:
				list.add( a + " - " + b + "=" + (a - b));
				break;
			case 2:
				list.add( a + " * " + b + "=" + (a * b));
				break;
			case 3:
				list.add( a + " / " + b + "=" + (a / b));
				break;

			}
		}

		public MyOpr(double a, double b, int opr) {
			Log.i("Life", "小数运算");
			
			switch (opr) {
			
			case 0:
				list.add(a + " + " + b + "=" + (a + b));
				break;
			case 1:
				list.add( a + " - " + b + "=" + (a - b));
				break;
			case 2:
				list.add( a + " * " + b + "=" + (a * b));
				break;
			case 3:
				list.add( a + " / " + b + "=" + (a / b));
				break;

			}
		}
		
		
		

	}

}
