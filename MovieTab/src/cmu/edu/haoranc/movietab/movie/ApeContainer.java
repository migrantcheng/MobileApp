package cmu.edu.haoranc.movietab.movie;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cmu.edu.haoranc.movietab.R;

public class ApeContainer extends Fragment {
	

    private FragmentActivity myContext;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_movie_container, container, false);
        
        if (rootView.findViewById(R.id.movie_fragment_container) != null) {
        	if (savedInstanceState != null) {
        		return rootView;
        	}
        	
        	Ape ape = new Ape();
        	
        	myContext.getSupportFragmentManager().beginTransaction()
            .replace(R.id.movie_fragment_container, ape).commit();
        }
        return rootView;
    }
    
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}

