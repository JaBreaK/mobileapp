package app.adetrifauzan.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayoutMediator;

import app.adetrifauzan.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setupViewPagerWithTabs();

        return root;
    }

    private void setupViewPagerWithTabs() {
        // 1. Buat adapter
        HomePagerAdapter adapter = new HomePagerAdapter(this);
        binding.viewPager.setAdapter(adapter);

        // 2. Sambungkan TabLayout + ViewPager2
        new TabLayoutMediator(
                binding.tabLayout,
                binding.viewPager,
                (tab, position) -> {
                    // atur judul tab berdasarkan posisi
                    if (position == 0) tab.setText("Bellonime");
                    else if (position == 1) tab.setText("Blog");
                    else if (position == 2) tab.setText("Portofolio");
                    else if (position == 3) tab.setText("KP");

                }
        ).attach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}