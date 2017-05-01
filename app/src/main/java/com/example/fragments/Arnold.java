package com.example.fragments;

import android.util.Log;

import java.util.ArrayList;

/**
 *  Dummy data class holding info for four of Arnie's movies;
 */

public class Arnold {
    private static Movie[] movies;

    public Arnold(){
        movies = new Movie[]{
                new Movie("Predator",
                        1987,
                        "A team of commandos on a mission in a Central American jungle find themselves hunted by " +
                                "an extraterrestrial warrior.",
                        "John McTiernan")
                ,

                new Movie("The Terminator",
                        1984,
                        "A seemingly indestructible humanoid cyborg is sent from 2029 to 1984 " +
                        "to assassinate a waitress, whose unborn son will lead humanity in a war " +
                                "against the machines, while a soldier from that war is sent to protect " +
                                "her at all costs.",
                        "James Cameron")
                ,

                new Movie("The Last Stand",
                        2013,
                        "The leader of a drug cartel busts out of a courthouse and speeds to the Mexican " +
                                "border, where the only thing in his path is a sheriff and his inexperienced staff.",
                        " Jee-woon Kim")
                ,

                new Movie("Total Recall",
                        1990,
                        "When a man goes for virtual vacation memories of the planet Mars, an unexpected and harrowing " +
                                "series of events forces him to go to the planet for real - or does he?",
                        "Paul Verhoeven")
        };
    }


    public String[] getTitles(){
        String[] titles = new String[movies.length];
        for (int i = 0; i < movies.length; i++) {
            titles[i] = movies[i].getTitle();
        }
        return titles;
    }

    public Movie[] getMovies(){
        return movies;
    }

}
