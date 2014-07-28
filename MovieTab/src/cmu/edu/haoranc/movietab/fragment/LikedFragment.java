package cmu.edu.haoranc.movietab.fragment;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import cmu.edu.haoranc.movietab.R;

public class LikedFragment extends Fragment {
	
	private ListView list;
	private LikedListAdapter adapter;
	private Activity context;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_liked, container, false);
        
        list = (ListView) rootView.findViewById(R.id.likedList);
        String[] testArr = {"Hello", "123","Hello", "123","Hello", "123","Hello", "123","Hello", "123","Hello", "123","Hello", "123"};
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
