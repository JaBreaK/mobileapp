package app.adetrifauzan.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import app.adetrifauzan.R;

public class TabBFragment extends Fragment {

    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate layout yang tadi kita buat
        View view = inflater.inflate(R.layout.fragment_tab_b, container, false);

        webView = view.findViewById(R.id.webviewTabB);

        // Supaya link masih stay di WebView, bukan di browser eksternal
        webView.setWebViewClient(new WebViewClient());

        // Enable JavaScript kalau web kamu membutuhkannya
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true); // Tambahkan ini
        webSettings.setDatabaseEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        // Load URL websitemu
        webView.loadUrl("https://genesystech.web.id/"); // ganti dengan URL-mu

        return view;
    }
}
