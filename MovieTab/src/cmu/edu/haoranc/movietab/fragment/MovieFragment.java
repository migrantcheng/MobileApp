package cmu.edu.haoranc.movietab.fragment;


import cmu.edu.haoranc.movietab.R;
import cmu.edu.haoranc.movietab.TabsPagerAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MovieFragment extends Fragment {
	

	private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private FragmentActivity myContext;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);
         

		viewPager = (ViewPager) rootView.findViewById(R.id.pager);
		mAdapter = new TabsPagerAdapter(getChildFragmentManager());

		viewPager.setAdapter(mAdapter);
        return rootView;
    }
    
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}
