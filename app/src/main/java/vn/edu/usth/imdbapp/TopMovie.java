package vn.edu.usth.imdbapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.usth.imdbapp.databinding.ActivityMainBinding;

public class TopMovie extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_top_movie, container, false);
        ListView listView = view.findViewById(R.id.listTopMovie);

        TypedArray imgID = getResources().obtainTypedArray(R.array.imgID1);
        String[] Name = getResources().getStringArray(R.array.Name1);
        String[] releaseDate = getResources().getStringArray(R.array.releaseDate1);
        String[] ratePG = getResources().getStringArray(R.array.ratePG1);
        String[] durationTime = getResources().getStringArray(R.array.durationTime1);
        String[] storyLine = getResources().getStringArray(R.array.storyLine1);
        String[] director = getResources().getStringArray(R.array.director1);

        ArrayList<Movie> movieArrayList = new ArrayList<>();

        for(int i = 0;i < imgID.length();i++){

            Movie movie = new Movie(Name[i],releaseDate[i],ratePG[i],
                    durationTime[i],storyLine[i],director[i],imgID.getResourceId(i,0));
            movieArrayList.add(movie);

        }

        ListAdapter listAdapter = new ListAdapter(getActivity(),movieArrayList);

        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getActivity(),TopMovieActivity.class);
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
        return view;
    }
}