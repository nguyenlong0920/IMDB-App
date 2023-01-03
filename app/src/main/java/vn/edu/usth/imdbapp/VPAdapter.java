package vn.edu.usth.imdbapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPAdapter extends FragmentStateAdapter {

    private String[] titles = new String[] {"Top Movies", "Top TV Series"};


    public VPAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new TopMovie();
            case 1:
                return new TopTvSeries();
        }
        return new TopMovie();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
