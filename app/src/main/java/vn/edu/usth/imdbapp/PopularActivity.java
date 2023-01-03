package vn.edu.usth.imdbapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class PopularActivity extends AppCompatActivity {

    private String[] titles = new String[] {"Top Movies", "Top TV Series"};
    VPAdapter vpAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);

        viewPager2 = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);

        vpAdapter = new VPAdapter(this);
        viewPager2.setAdapter(vpAdapter);

        new TabLayoutMediator(tabLayout, viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.movie_menu, menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case  R.id.nowShowing:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                return true;
            case  R.id.popular:
                Intent intent2 = new Intent(this, PopularActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
