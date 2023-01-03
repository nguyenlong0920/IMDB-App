package vn.edu.usth.imdbapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import vn.edu.usth.imdbapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TypedArray imgID = getResources().obtainTypedArray(R.array.imgID);
        String[] Name = getResources().getStringArray(R.array.Name);
        String[] releaseDate = getResources().getStringArray(R.array.releaseDate);
        String[] ratePG = getResources().getStringArray(R.array.ratePG);
        String[] durationTime = getResources().getStringArray(R.array.durationTime);
        String[] storyLine = getResources().getStringArray(R.array.storyLine);
        String[] director = getResources().getStringArray(R.array.director);

        ArrayList<Movie> movieArrayList = new ArrayList<>();

        for(int i = 0;i < imgID.length();i++){

            Movie movie = new Movie(Name[i],releaseDate[i],ratePG[i],
                    durationTime[i],storyLine[i],director[i],imgID.getResourceId(i,0));
            movieArrayList.add(movie);

        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,movieArrayList);

        binding.listNowShowing.setAdapter(listAdapter);
        binding.listNowShowing.setClickable(true);
        binding.listNowShowing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,MovieActivity.class);
                i.putExtra("Name", Name[position]);
                i.putExtra("releaseDate", releaseDate[position]);
                i.putExtra("ratePG",ratePG[position]);
                i.putExtra("durationTime",durationTime[position]);
                i.putExtra("storyLine",storyLine[position]);
                i.putExtra("director",director[position]);
                i.putExtra("imgID",imgID.getResourceId(position,0));
                startActivity(i);

            }
        });

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