package app.adetrifauzan.ui.slideshow;

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

import app.adetrifauzan.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // inflate dengan ViewBinding
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setupWebView();

        return root;
    }

    private void setupWebView() {
        WebView webView = binding.webviewSlideshow;
        // Supaya link tetap di WebView
        webView.setWebViewClient(new WebViewClient());
        // Enable JS jika diperlukan
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        // Jika butuh media playback tanpa user gesture:
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setDomStorageEnabled(true); // Tambahkan ini
        settings.setDatabaseEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);

        // Load URL
        webView.loadUrl("https://github.com/jabreak/"); // ganti dengan URL mu
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
