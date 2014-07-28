package cmu.edu.haoranc.movietab;

import cmu.edu.haoranc.movietab.fragment.MovieContainer;
import cmu.edu.haoranc.movietab.movie.Ape;
import cmu.edu.haoranc.movietab.movie.Lucy;
import cmu.edu.haoranc.movietab.movie.Transformer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	
	public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new Lucy();
        case 1:
            // Games fragment activity
            return new MovieContainer();
        case 2:
            // Movies fragment activity
            return new Transformer();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
