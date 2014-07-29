package cmu.edu.haoranc.movietab.movie;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cmu.edu.haoranc.movietab.R;
import cmu.edu.haoranc.movietab.fragment.MovieFragment;

public class MovieContainer extends Fragment {
	
    private FragmentActivity myContext;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_movie_tab, container, false);
         
        if (rootView.findViewById(R.id.movie_tab_container) != null) {
        	if (savedInstanceState != null) {
        		return rootView;
        	}
        	
        	MovieFragment movie = new MovieFragment();
        	
        	myContext.getSupportFragmentManager().beginTransaction()
            .add(R.id.movie_tab_container, movie).commit();
        }
        return rootView;
    }
    
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}
