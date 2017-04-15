package com.example.filehadling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText et1,et2;
	Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et1 = (EditText) findViewById(R.id.editText1); 
        et2 = (EditText) findViewById(R.id.editText2);
        
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try {
					FileOutputStream fout = openFileOutput("MyFile.txt", Context.MODE_APPEND);
					
					String name,city;
					
					name = et1.getText().toString();
					city = et2.getText().toString();
					
					fout.write(name.getBytes());
					fout.write(city.getBytes());
					
					et1.setText("");
					et2.setText("");
					et1.requestFocus();
					fout.close();
					
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
        
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try {
					FileInputStream fin = openFileInput("MyFile.txt");
					
					int r;
					StringBuffer str = new StringBuffer();
					
					while((r=fin.read())!=-1 ){
						str.append((char)r);
					}
					Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
