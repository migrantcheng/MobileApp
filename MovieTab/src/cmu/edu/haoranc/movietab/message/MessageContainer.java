package cmu.edu.haoranc.movietab.message;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cmu.edu.haoranc.movietab.R;

public class MessageContainer extends Fragment {
	
    private FragmentActivity myContext;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_message_container, container, false);
         
        if (rootView.findViewById(R.id.message_fragment_container) != null) {
        	if (savedInstanceState != null) {
        		return rootView;
        	}
        	
        	MessageFragment message = new MessageFragment();
        	
        	myContext.getSupportFragmentManager().beginTransaction()
            .add(R.id.message_fragment_container, message).commit();
        }
        return rootView;
    }
    
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}
