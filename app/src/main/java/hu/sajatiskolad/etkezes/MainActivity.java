package hu.sajatiskolad.etkezes;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.*;
import android.view.View;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        webView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_FULLSCREEN |
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setAllowContentAccess(true);
        s.setBuiltInZoomControls(false);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // DownloadListener: ez teszi lehetővé az Excel letöltést
        webView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                String contentDisposition, String mimeType, long contentLength) {
                // A base64 data URI letöltést a WebView natívan kezeli,
                // ez a fallback blob URL-ekhez
            }
        });
        setContentView(webView);
        webView.loadUrl("file:///android_asset/index.html");
    }
}
