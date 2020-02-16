package com.aiden.andmodule.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.aiden.andmodule.LogUtil;
import com.aiden.andmodule.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WebActivity extends AppCompatActivity {
    String TAG = "WebActivity";
    private WebView webView;
    private String URL = "https://m.edu2080.co.kr/review?isapp=y";

    SwipeRefreshLayout swipe;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        progressBar = (ProgressBar) findViewById(R.id.awv_progressBar);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        LoadWeb();
        progressBar.setMax(100);
        progressBar.setProgress(1);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
            }
        });

        // WebView의 설정
      webView.setWebChromeClient(new CustomWebChromelient());
      webView.setWebViewClient(new CustomWebViewClient());
    }

    public void LoadWeb() {
        webView = (WebView) findViewById(R.id.web_veiw);
        WebSettings set = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.clearHistory();
        webView.clearCache(true);
        set.setMediaPlaybackRequiresUserGesture(true);
        set.setCacheMode(WebSettings.LOAD_NO_CACHE);
        set.setSupportMultipleWindows(true);
        set.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.loadUrl(URL);
        swipe.setRefreshing(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        callHiddenWebViewMethod("onPause");
        if (webView != null) {
            LogUtil.e(TAG, "it is call Destory of WebView ");
            webView.destroy();
            webView = null;
        }
    }



    //key down
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            Toast.makeText(this, "뒤로가기  이벤트", Toast.LENGTH_SHORT).show();
            webView.goBack();
            return true;
        }
        //백할 페이가 없다면
        if ((keyCode == KeyEvent.KEYCODE_BACK) && (webView.canGoBack() == false)) {
            Toast.makeText(this, "버튼 클릭 이벤트", Toast.LENGTH_SHORT).show();
            //다이아로그박스 출력
            new AlertDialog.Builder(this)
                    .setTitle("프로그램 종료")
                    .setMessage("프로그램을 종료하시겠습니까?")
                    .setPositiveButton("예", (dialog, which) -> android.os.Process.killProcess(android.os.Process.myPid()))
                    .setNegativeButton("아니오", null).show();
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onResume() {
        super.onResume();
        callHiddenWebViewMethod("onResume");
    }
    private void callHiddenWebViewMethod(String name) {
        if (webView != null) {
            try {
                Method method = WebView.class.getMethod(name);
                method.invoke(webView);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
    protected class CustomWebChromelient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            new android.app.AlertDialog.Builder(WebActivity.this).setTitle("")
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok,
                            (dialog, which) -> result.confirm()).setNegativeButton(android.R.string.cancel,
                            (dialog, which) -> result.cancel()).setCancelable(false).create().show();
            return true;
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
            new android.app.AlertDialog.Builder(WebActivity.this)
                    .setTitle("")
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok,
                            (dialog, which) -> result.confirm()).setNegativeButton(android.R.string.cancel,
                            (dialog, which) -> result.cancel()).setCancelable(false).create().show();

                    return true;
        }

  String userAgent;

   @Override
   public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            WebView newWebView = new WebView(WebActivity.this);
            WebSettings webSettings = newWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            final Dialog dialog = new Dialog(WebActivity.this);
            dialog.setContentView(newWebView);
            dialog.show();


            userAgent = newWebView.getSettings().getUserAgentString();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                newWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            }
            newWebView.setWebChromeClient(new WebChromeClient(){
                @Override
                public void onCloseWindow(WebView window) {
                    Log.e(TAG,"------------------------------1");
                    dialog.dismiss();
                }
            });
            newWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return false;
                }
                @Override
                public void onLoadResource(WebView view, String url) {
                    super.onLoadResource(view, url);
                    LogUtil.e(TAG, "-----------------------2");
                }
            });
            return true;
        }
    }


    // 14.10.24
    protected class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            LogUtil.e(TAG, "(WebViewClient)should ---->" + url);
            return  false;
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            webView.loadUrl("file:///android_asset/error.html");
        }
        public void onLoadResource(WebView view, String url) {
        }
        public void onPageFinished(WebView view, String url) {
            //Hide the SwipeReefreshLayout
            progressBar.setVisibility(View.GONE);
            swipe.setRefreshing(false);
        }
    }
}
