package cmu.edu.haoranc.movietab.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.util.Log;
import cmu.edu.haoranc.movietab.model.LikedListItem;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;

public class ParseUtil {
	public static List<ParseObject> tempObjList;

	public static void logToParse(String action) {
		ParseObject testObject = new ParseObject("MovieAppLog");
//		testObject.put("name", "Dawn of the planet of the apes");
		testObject.put("action", action);
		testObject.put("time", new Date());
		testObject.saveInBackground();
	}
	
	public static ArrayList<LikedListItem> getLikedList(String username) {
		ArrayList<LikedListItem> result = new ArrayList<LikedListItem>();
		System.out.println(username);
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("LikedList");
		query.whereEqualTo("username", username);
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		        	System.out.println("in callback function " + scoreList.size());
		        	tempObjList = scoreList;
		        	
		            Log.d("score", "Retrieved " + scoreList.size() + " scores");
		        } else {
		            Log.d("score", "Error: " + e.getMessage());
		        }
		    }
		});
		
//		for(ParseObject obj : tempObjList) {
//    		LikedListItem item = new LikedListItem();
//    		item.setMovieName(obj.getString("moviename"));
//    		item.setShowtime(obj.getString("showtime"));
//    		item.setTheater(obj.getString("theater"));
//    		result.add(item);
//    	}
//		
//		System.out.println(tempObjList.size());
//		
		return result;
	}
}
