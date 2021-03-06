package com.et.testndk;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView helloText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		helloText = (TextView) findViewById(R.id.hello);
		NativeClass nativeClass = new NativeClass();
		helloText.setText(nativeClass.getResult());
		String result = nativeClass.getLine("从Java传字符串到C++");
		Log.i("result:", result);
	}
	static {
        System.loadLibrary("TestNDK");
   }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
	}
	
}
