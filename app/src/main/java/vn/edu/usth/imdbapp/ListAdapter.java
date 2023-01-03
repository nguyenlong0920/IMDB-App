package vn.edu.usth.imdbapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Movie> {

    public ListAdapter(Context context, ArrayList<Movie> movieArrayList) {

        super(context,R.layout.list_nowshowing,movieArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Movie movie = getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_nowshowing,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.movie_pic);
        TextView moveName = convertView.findViewById(R.id.movie_Name);
        TextView reDate = convertView.findViewById(R.id.release);
        TextView rPg = convertView.findViewById(R.id.rate);
        TextView dTime = convertView.findViewById(R.id.duration);

        imageView.setImageResource(movie.imgID);
        moveName.setText(movie.Name);
        reDate.setText(movie.releaseDate);
        rPg.setText(movie.ratePG);
        dTime.setText(movie.durationTime);

        return convertView;

    }
}
