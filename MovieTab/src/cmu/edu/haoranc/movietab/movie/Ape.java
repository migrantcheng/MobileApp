package cmu.edu.haoranc.movietab.movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.facebook.Session;
import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cmu.edu.haoranc.movietab.R;
import cmu.edu.haoranc.movietab.TopRatedFragment;
import cmu.edu.haoranc.movietab.liked.LikedInfoFragment;
import cmu.edu.haoranc.movietab.liked.LikedListAdapter;
import cmu.edu.haoranc.movietab.model.LikedListItem;

public class Ape extends Fragment {
	private ListView list;
	private MovieLikedAdapter adapter;
	private FragmentActivity context;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_ape_list, container, false);
        
        ImageView imgView = (ImageView) rootView.findViewById(R.id.apeImg);
        imgView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            	MovieDetailFragment fragment = new MovieDetailFragment();
	            
	        	FragmentTransaction transaction = context.getSupportFragmentManager().beginTransaction();

	        	// Replace whatever is in the fragment_container view with this fragment,
	        	// and add the transaction to the back stack so the user can navigate back
	        	transaction.replace(R.id.movie_fragment_container, fragment);
	        	transaction.addToBackStack(null);

	        	// Commit the transaction
	        	transaction.commit();

            }
        });
        
        list = (ListView) rootView.findViewById(R.id.apeList);
        
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("LikedList");
//		query.whereEqualTo("moviename", "Dawn of the planet of the apes");
//		query.whereNotEqualTo("username", "Haoran Cheng");
//		query.findInBackground(new FindCallback<ParseObject>() {
//		    public void done(List<ParseObject> resultList, ParseException e) {
//		        if (e == null) {
//		        	ArrayList<LikedListItem> result = new ArrayList<LikedListItem>();
//		        	for(ParseObject obj : resultList) {
//		        		LikedListItem item = new LikedListItem();
//		        		item.setMovieName(obj.getString("moviename"));
//		        		item.setShowtime(obj.getString("showtime"));
//		        		item.setTheater(obj.getString("theater"));
//		        		item.setUsername(obj.getString("username"));
//		        		item.setObjId(obj.getObjectId());
//		        		result.add(item);
//		        	}
//		        	
//		        	refreshListView(result);
//		        	
//		            Log.d("score", "Retrieved " + resultList.size() + " scores");
//		        } else {
//		            Log.d("score", "Error: " + e.getMessage());
//		        }
//		    }
//		});
       
        return rootView;
    }
    
    @Override
    public void onAttach(Activity activity) {
        context=(FragmentActivity) activity;
        super.onAttach(activity);
    }
    
    public void refreshListView (List<LikedListItem> objList) {
    	adapter = new MovieLikedAdapter(context, objList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new android.widget.ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int arg2,
                    long arg3) {
            	
//            	ParseUser currentUser = ParseUser.getCurrentUser();
//            	if (currentUser == null) {
//            		List<String> permissions = Arrays.asList("public_profile", "email");
//    				ParseFacebookUtils.logIn(permissions, context, new LogInCallback() {
//    					  @Override
//    					  public void done(ParseUser user, ParseException err) {
//    					    if (user == null) {
//    					      Log.d("MyApp", "Uh oh. The user cancelled the Facebook login.");
//    					    } else if (user.isNew()) {
//    					      Log.d("MyApp", "User signed up and logged in through Facebook!");
//    					    } else {
//    					      Log.d("MyApp", "User logged in through Facebook!");
//    					      Session session = ParseFacebookUtils.getSession();
//    					      if (session != null && session.isOpened()) {
////    					          makeMeRequest();
//    					      }
//    					      
//    					    }
//    					  }
//    					});
//    				return;
//            	}
            	
            	String liked_id = ((TextView) view.findViewById(R.id.liked_list_item_id)).getText().toString();
            	
            	System.out.println("the liked_id is " + liked_id);
            	
            	ParseQuery<ParseObject> query = ParseQuery.getQuery("LikedList");
        		query.whereEqualTo("objectId", liked_id);
        		query.findInBackground(new FindCallback<ParseObject>() {
        		    public void done(List<ParseObject> scoreList, ParseException e) {
        		        if (e == null) {
        		        	ArrayList<LikedListItem> result = new ArrayList<LikedListItem>();
        		        	for(ParseObject obj : scoreList) {
        		        		LikedListItem item = new LikedListItem();
        		        		item.setMovieName(obj.getString("moviename"));
        		        		item.setShowtime(obj.getString("showtime"));
        		        		item.setTheater(obj.getString("theater"));
        		        		item.setMessage(obj.getString("message"));
        		        		item.setObjId(obj.getObjectId());
        		        		item.setUsername(obj.getString("username"));
        		        		result.add(item);
        		        	}
        		        	
        		        	System.out.println("return size is " + result.size());
        		        	LikedListItem item = result.get(0);

        		        	MovieLikedInfoFragment fragment = new MovieLikedInfoFragment(item);
        		            
        		        	FragmentTransaction transaction = context.getSupportFragmentManager().beginTransaction();

        		        	// Replace whatever is in the fragment_container view with this fragment,
        		        	// and add the transaction to the back stack so the user can navigate back
        		        	transaction.replace(R.id.movie_fragment_container, fragment);
        		        	transaction.addToBackStack(null);

        		        	// Commit the transaction
        		        	transaction.commit();
        		        	
        		            Log.d("score", "Retrieved " + scoreList.size() + " scores");
        		        } else {
        		            Log.d("score", "Error: " + e.getMessage());
        		        }
        		    }
        		});
            	
            }
        });
    }
}
