package cmu.edu.haoranc.movietab.movie;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import cmu.edu.haoranc.movietab.R;
import cmu.edu.haoranc.movietab.TopRatedFragment;
import cmu.edu.haoranc.movietab.fragment.LikedListAdapter;

public class Ape extends Fragment {
	private ListView list;
	private LikedListAdapter adapter;
	private FragmentActivity context;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_ape_list, container, false);
        
        list = (ListView) rootView.findViewById(R.id.apeList);
        String[] testArr = {"Adele", "Adele","Adele", "Adele","Adele", "Adele","Adele", "Adele","Adele", "Adele","Adele", "Adele","Adele", "Adele"};
//        list.setAdapter(new ArrayAdapter<String>(this, R.layout.list_row, R.id.title, testArr));
        adapter = new LikedListAdapter(context, testArr);
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new android.widget.ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int arg2,
                    long arg3) {
            	Toast.makeText(context, "event in click", Toast.LENGTH_SHORT).show();
            	TopRatedFragment newFragment = new TopRatedFragment();
            	
            	FragmentTransaction transaction = context.getSupportFragmentManager().beginTransaction();

            	// Replace whatever is in the fragment_container view with this fragment,
            	// and add the transaction to the back stack so the user can navigate back
            	transaction.replace(R.id.movie_fragment_container, newFragment);
            	transaction.addToBackStack(null);

            	// Commit the transaction
            	transaction.commit();
            }
        });
         
        return rootView;
    }
    
    @Override
    public void onAttach(Activity activity) {
        context=(FragmentActivity) activity;
        super.onAttach(activity);
    }
}
