package com.example.jsonparser;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView tv;
	//    "info":[{"key1":"value1","key2":"value2"},{"key1":"value3","key2":"value4"}]
	String myJson,result;
	
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv=(TextView)findViewById(R.id.textView1);
		
		myJson = getResources().getString(R.string.my_string);
	}
	
	public void Parser(View v){
		
		try{
			StringBuffer sb=new StringBuffer();
			
			JSONObject jj = new JSONObject(myJson);
			JSONArray jsonArray = jj.getJSONArray("Info");
			
			for(int i = 0;i<jsonArray.length();i++)
			{
				JSONObject jr =jsonArray.getJSONObject(i);
				String Name = jr.getString("name");
				String City = jr.getString("city");
				String State = jr.getString("state");
				
				result = "Name:"+Name+"\nCity:"+City+"\nState:"+State+"\n";
				sb.append(result);
			}
			
			
			tv.setText(sb);
		}
		
		catch(Exception ex)
		{
			Toast.makeText(getApplicationContext(), ""+ex, 2000).show();
		}
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
