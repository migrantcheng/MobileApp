package cmu.edu.haoranc.movietab.liked;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cmu.edu.haoranc.movietab.R;
import cmu.edu.haoranc.movietab.TabsPagerAdapter;

public class LikedContainer extends Fragment {
	
    private FragmentActivity myContext;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_liked_container, container, false);
         
        if (rootView.findViewById(R.id.liked_fragment_container) != null) {
        	if (savedInstanceState != null) {
        		return rootView;
        	}
        	
        	LikedFragment liked = new LikedFragment();
        	
        	myContext.getSupportFragmentManager().beginTransaction()
            .add(R.id.liked_fragment_container, liked).commit();
        }
        return rootView;
    }
    
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}
