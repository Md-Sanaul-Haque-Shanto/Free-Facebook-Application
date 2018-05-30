package com.example.shanto.freefbgprobi;

import android.app.Activity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class FreeFacebook extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_free_facebook);

        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                Window.PROGRESS_VISIBILITY_ON);

        Toast loadingmess = Toast.makeText(this, "MDSHS Says:Thank You Using My App", Toast.LENGTH_SHORT);
        loadingmess.show();

        WebView myWebView;

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("https://free.facebook.com");
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setInitialScale(150);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setUseWideViewPort(true);

        final Activity MyActivity = this;
        myWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                MyActivity.setTitle("Loading...");
                MyActivity.setProgress(progress * 100);

                if (progress == 100)
                    MyActivity.setTitle(R.string.app_name);
            }
        });
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_free_facebook, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
