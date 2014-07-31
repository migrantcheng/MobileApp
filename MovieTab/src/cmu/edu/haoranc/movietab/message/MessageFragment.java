package cmu.edu.haoranc.movietab.message;

import java.util.ArrayList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import cmu.edu.haoranc.movietab.R;
import cmu.edu.haoranc.movietab.model.LikedListItem;

public class MessageFragment extends Fragment {
	
	private ListView list;
	private MessageListAdapter adapter;
	private FragmentActivity context;
	private View rootView;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        rootView = inflater.inflate(R.layout.fragment_message, container, false);
        
        
        ParseQuery<ParseObject> fromQuery = ParseQuery.getQuery("Message");
		fromQuery.whereEqualTo("fromuser", "Haoran Cheng");
		ParseQuery<ParseObject> toQuery = ParseQuery.getQuery("Message");
		toQuery.whereEqualTo("touser", "Haoran Cheng");
		List<ParseQuery<ParseObject>> queryList = new ArrayList<ParseQuery<ParseObject>>();
		queryList.add(fromQuery);
		queryList.add(toQuery);
		ParseQuery<ParseObject> query = ParseQuery.or(queryList);
		query.include("likedlist");
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> resultList, ParseException e) {
		        if (e == null) {
		        	
		        	refreshListView(resultList);
		        	
		            Log.d("score", "Retrieved " + resultList.size() + " scores");
		        } else {
		            Log.d("score", "Error: " + e.getMessage());
		        }
		    }

			
		});
        
        return rootView;
    }
    
    @Override
    public void onAttach(Activity activity) {
        context=(FragmentActivity) activity;
        super.onAttach(activity);
    }
    
    public void refreshListView(List<ParseObject> resultList) {
    	list = (ListView) rootView.findViewById(R.id.messageList);
        adapter = new MessageListAdapter(context, resultList);
        list.setAdapter(adapter);
	}

}
