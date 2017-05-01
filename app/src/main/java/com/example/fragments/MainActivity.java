package com.example.fragments;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.fragments.OverviewFragment.OnMovieSelectedListener;

public class MainActivity extends FragmentActivity implements OnMovieSelectedListener {
    private int checkedPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_layout);

        if(findViewById(R.id.fragment_container) != null){ // we are in single-pane mode
            OverviewFragment overviewFragment = new OverviewFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, overviewFragment).commit();

        }else{ // we are in dual-pane mode
            DetailsFragment detailsFragment;
            if(savedInstanceState != null) { // we have some state and should act:
                checkedPos = savedInstanceState.getInt("checkedPos", 2);
                detailsFragment = DetailsFragment.newInstance(checkedPos);
                getSupportFragmentManager().beginTransaction().replace(R.id.detailsFrame, detailsFragment).commit();

            }else{
                detailsFragment = DetailsFragment.newInstance(0);
                getSupportFragmentManager().beginTransaction().replace(R.id.detailsFrame, detailsFragment).commit();
            }
        }
    }

    @Override
    public void onMovieSelected(int index, ListView listView) {
        checkedPos = index;
        FrameLayout frame = (FrameLayout) findViewById(R.id.detailsFrame);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        DetailsFragment detailsFragment = DetailsFragment.newInstance(index);

        if (frame != null) { // we are in dual-pane mode
            listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
            listView.setItemChecked(index, true);
            transaction.replace(R.id.detailsFrame, detailsFragment);

        } else { // we are in single-pane mode, and the
            transaction.replace(R.id.fragment_container, detailsFragment);

        }
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("checkedPos", checkedPos);

    }
}
