package cmu.edu.haoranc.movietab.movie;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cmu.edu.haoranc.movietab.R;
import cmu.edu.haoranc.movietab.model.LikedListItem;

public class MovieLikedAdapter extends BaseAdapter{
	
	private Activity activity;
    private List<LikedListItem> data;
    private static LayoutInflater inflater=null;
    
    public MovieLikedAdapter(Activity a, List<LikedListItem> d) {
    	activity = a;
    	data = d;
    	inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.liked_list_row, null);
 
        TextView moviename = (TextView)vi.findViewById(R.id.liked_list_moviename); 
        moviename.setText(data.get(position).getUsername());
        TextView showtime = (TextView)vi.findViewById(R.id.liked_list_movieshowtime); 
        showtime.setText(data.get(position).getShowtime() + " - " + data.get(position).getTheater());
        TextView likedId = (TextView)vi.findViewById(R.id.liked_list_item_id); 
        likedId.setText(data.get(position).getObjId());
        System.out.println("In adpater " + likedId.getText());
        

        return vi;
	}

}

