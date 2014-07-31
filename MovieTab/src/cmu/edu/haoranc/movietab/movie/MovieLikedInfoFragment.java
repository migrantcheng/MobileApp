package cmu.edu.haoranc.movietab.movie;

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
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cmu.edu.haoranc.movietab.R;
import cmu.edu.haoranc.movietab.model.LikedListItem;

public class MovieLikedInfoFragment extends Fragment implements OnClickListener{
	
	private LikedListItem item;
	private Activity context;
	private View rootView;
	
	public MovieLikedInfoFragment(LikedListItem item2) {
		super();
		item = item2;
	}

 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        rootView = inflater.inflate(R.layout.fragment_liked_info, container, false);
        TextView moviename = (TextView)rootView.findViewById(R.id.liked_info_moviename); 
        moviename.setText(item.getMovieName());
        TextView username = (TextView)rootView.findViewById(R.id.liked_info_username); 
        username.setText(item.getUsername());
        TextView sex = (TextView)rootView.findViewById(R.id.liked_info_sex); 
        sex.setText("Female");
        TextView showtime = (TextView)rootView.findViewById(R.id.liked_info_showtime); 
        showtime.setText(item.getShowtime());
        TextView theater = (TextView)rootView.findViewById(R.id.liked_info_theater); 
        theater.setText(item.getTheater());
        TextView message = (TextView)rootView.findViewById(R.id.liked_info_message); 
        message.setText(item.getMessage());
        View area = rootView.findViewById(R.id.liked_info_buttonArea); 
        area.setVisibility(View.VISIBLE);
        TextView likedid = (TextView)rootView.findViewById(R.id.liked_info_likedid); 
        likedid.setText(item.getObjId());
        Button button= (Button) rootView.findViewById(R.id.liked_info_invite_button);
        button.setOnClickListener(this);
        return rootView;
    }
    
    public void sendMessage(View view) {
    	TextView tView = (TextView) rootView.findViewById(R.id.liked_info_likedid);
    	String likedid = tView.getText().toString();
    	System.out.println("in send Message " + likedid);
    	
    	ParseQuery<ParseObject> query = ParseQuery.getQuery("LikedList");
		query.whereEqualTo("objectId", likedid);
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> resultList, ParseException e) {
		        if (e == null) {
		        	ParseObject obj = new ParseObject("Message");
		        	ParseObject liked = resultList.get(0);
		        	obj.put("likedlist", liked);
		        	obj.put("fromuser", "Haoran Cheng");
		        	obj.put("touser", liked.getString("username"));
		        	obj.put("likedid", liked.getObjectId());
		        	obj.put("time", "2014-07-30 12:20:00");
		        	obj.put("status", "PENDING");
		        	
		        	obj.saveInBackground();
		        	Toast.makeText(context, "Message sent", Toast.LENGTH_SHORT).show();
		        	
		            Log.d("score", "Retrieved " + resultList.size() + " scores");
		        } else {
		            Log.d("score", "Error: " + e.getMessage());
		        }
		    }
		});
    }
    
    @Override
    public void onAttach(Activity activity) {
        context= activity;
        super.onAttach(activity);
    }


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
        case R.id.liked_info_invite_button:

        	sendMessage(v);
            break;
        }
		
	}

}
