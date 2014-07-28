package cmu.edu.haoranc.movietab.movie;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import cmu.edu.haoranc.movietab.R;
import cmu.edu.haoranc.movietab.fragment.LikedListAdapter;

public class Lucy extends Fragment {
	private ListView list;
	private LikedListAdapter adapter;
	private Activity context;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_movie_list, container, false);
        
        list = (ListView) rootView.findViewById(R.id.lucyList);
        String[] testArr = {"Adele", "Adele","Adele", "Adele","Adele", "Adele","Adele", "Adele","Adele", "Adele","Adele", "Adele","Adele", "Adele"};
//        list.setAdapter(new ArrayAdapter<String>(this, R.layout.list_row, R.id.title, testArr));
        adapter = new LikedListAdapter(context, testArr);
        list.setAdapter(adapter);
        
        return rootView;
    }
    
    @Override
    public void onAttach(Activity activity) {
        context = activity;
        super.onAttach(activity);
    }


}
