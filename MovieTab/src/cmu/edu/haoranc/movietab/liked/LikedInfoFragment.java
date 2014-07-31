package cmu.edu.haoranc.movietab.liked;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cmu.edu.haoranc.movietab.R;
import cmu.edu.haoranc.movietab.model.LikedListItem;

public class LikedInfoFragment extends Fragment {
	
	private LikedListItem item;
	
	public LikedInfoFragment(LikedListItem item2) {
		super();
		item = item2;
	}

 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_liked_info, container, false);
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
        area.setVisibility(View.GONE);
        return rootView;
    }

}
