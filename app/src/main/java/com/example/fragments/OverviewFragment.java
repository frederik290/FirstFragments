package com.example.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import java.util.List;

public class OverviewFragment extends ListFragment {
    Arnold arnold = new Arnold();
    private boolean isDualPane;
    private int currentCheckedPos = 0;
    private OnMovieSelectedListener onMovieSelectedListener;

    public interface OnMovieSelectedListener{
        public void onMovieSelected(int index, ListView listView);
    }

    public void onAttach(Context context){
        super.onAttach(context);
        Activity activity;

        if(context instanceof Activity){
            activity = (Activity) context;
        } else  {
            activity = null;
        }
        try{
            onMovieSelectedListener = (OnMovieSelectedListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnMovieSelectedListener");
        }
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1, arnold.getTitles()));
    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id){
        onMovieSelectedListener.onMovieSelected(position, listView);
    }

}
