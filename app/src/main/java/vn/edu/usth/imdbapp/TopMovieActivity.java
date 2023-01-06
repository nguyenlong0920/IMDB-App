package vn.edu.usth.imdbapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.imdbapp.databinding.ActivityTopmovieBinding;


public class TopMovieActivity extends AppCompatActivity {

    ActivityTopmovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTopmovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageButton btn = (ImageButton) findViewById(R.id.btnBack);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TopMovieActivity.this, PopularActivity.class));
            }
        });

        Intent intent= this.getIntent();

        if (intent != null) {

            String Name = intent.getStringExtra("Name");
            String releaseDate = intent.getStringExtra("releaseDate");
            String ratePG = intent.getStringExtra("ratePG");
            String durationTime = intent.getStringExtra("durationTime");
            String storyLine = intent.getStringExtra("storyLine");
            String director = intent.getStringExtra("director");
            int imgID = intent.getIntExtra("imgID",R.drawable.avatar);

            binding.movPic.setImageResource(imgID);
            binding.movName.setText(Name);
            binding.release.setText(releaseDate);
            binding.rate.setText(ratePG);
            binding.duration.setText(durationTime);
            binding.strLi.setText(storyLine);
            binding.dir.setText(director);

        }
    }
}
