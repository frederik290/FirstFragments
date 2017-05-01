package com.example.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
    Arnold arnold = new Arnold();

    public static DetailsFragment newInstance(int index){
        DetailsFragment d = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        d.setArguments(args);
        return d;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Movie[] movies = arnold.getMovies();
        View temp = inflater.inflate(R.layout.details_fragment_layout, container, false);
        return updateDetailsLayout(temp);

    }

    public View updateDetailsLayout(View view){
        View v = view;
        TextView title = (TextView) view.findViewById(R.id.title_view);
        TextView productionYear = (TextView) view.findViewById(R.id.productionYear_view);
        TextView description = (TextView) view.findViewById(R.id.description_view);
        TextView director = (TextView) view.findViewById(R.id.director_view);

        Movie[] movies = arnold.getMovies();
        Movie current = movies[getShownIndex()];

        title.setText(current.getTitle());
        productionYear.setText(current.getProductionYearAsString());
        description.setText(current.getDescription());
        director.setText(current.getDirector());

        return v;
    }

    // have a method updateDetailsView which will be called from MainActivity. MainActvity will be a listener on OverviewFragment
    // so that OverviewFragment can call a method in MainActivity which will then call this (updateDetailsView) method.
}
