package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private WebView webView;
    private EditText urlEditText;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        urlEditText = findViewById(R.id.editTextText);
        progressBar = findViewById(R.id.progressBar);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");
        webView.setWebViewClient(new MyWebViewClient(this));



    }

    public void loadWebPage(View view) {

        String unencodedHtml =
                "<html><body><input type=\"button\" value=\"Say hello\" " +
                        "onClick=\"showAndroidToast('Hello Android!')\" />\n" +
                        "\n" +
                        "<script type=\"text/javascript\">\n" +
                        "    function showAndroidToast(toast) {\n" +
                        "        Android.showToast(toast);\n" +
                        "    }\n" +
                        "</script>" +
                        "</body></html>";
        String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(),
                Base64.NO_PADDING);

        webView.loadData(encodedHtml, "text/html", "base64");
    }

    public void loadUrl(View view) {
        webView.loadUrl(urlEditText.getText().toString());


    }

    public void setUrlEditText(String string) {
        urlEditText.setText(string);
    }

    public void showLoading() {
        progressBar.setIndeterminate(true);
    }
    public void hideLoading() {
        progressBar.setIndeterminate(false);
    }

}