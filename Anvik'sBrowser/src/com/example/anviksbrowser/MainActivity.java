package com.example.anviksbrowser;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends Activity {
	private WebView browse;
	private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        browse=(WebView) findViewById(R.id.webView1);
        et=(EditText) findViewById(R.id.editText1);
        browse.setWebViewClient(new MyBrowser());
    }
    public void open(View view)
    {
    	String url=et.getText().toString();
    	browse.getSettings().setLoadsImagesAutomatically(true);
    	browse.getSettings().setJavaScriptEnabled(true);
    	browse.setScrollBarStyle(view.SCROLLBARS_INSIDE_OVERLAY);
    	browse.loadUrl(url);
    	
    }
   private class MyBrowser extends WebViewClient
   {
	   @Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// TODO Auto-generated method stub
		   view.loadUrl(url);
		return (true);
	}
   
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
