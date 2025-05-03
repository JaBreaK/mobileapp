package app.adetrifauzan.ui.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HomePagerAdapter extends FragmentStateAdapter {

    public HomePagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new app.adetrifauzan.ui.home.TabAFragment();
            case 1:
                return new TabBFragment();
            case 2:
                return new TabCFragment();
            case 3:
                return new TabDFragment();
            default:
                return new TabAFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4; // jumlah tab
    }
}
