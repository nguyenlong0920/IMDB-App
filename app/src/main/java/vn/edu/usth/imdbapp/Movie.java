package vn.edu.usth.imdbapp;

public class Movie {

    String Name, releaseDate, ratePG, durationTime, storyLine, director;
    int imgID;

    public Movie(String Name, String releaseDate, String ratePG, String durationTime, String storyLine, String director, int imgID) {
        this.Name = Name;
        this.releaseDate = releaseDate;
        this.ratePG = ratePG;
        this.durationTime = durationTime;
        this.storyLine = storyLine;
        this.director = director;
        this.imgID = imgID;
    }
}
